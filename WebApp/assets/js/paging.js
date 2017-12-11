/** jquery 페이징 모듈
 * http://botmonster.com/jquery-bootpag/#docs
 */
paging = {
	pagerId: "pager",
	
		
	init: function(totalPage, nowPage) {
		 
		var searchOption = $.urlParam("searchOption");
		var searchText = decodeURI($.urlParam("searchText"));
		$("#searchOption").val(searchOption).change();
		$("#searchText").val(searchText);
		
		// 페이징 그리기
		$('#' + this.pagerId).bootpag({
		    total: totalPage,
		    page: nowPage,
		    maxVisible: 5,
		    leaps: true,
		    firstLastUse: true,
		    first: 'First',
		    last: 'Last',
		    prev: 'Previous',
		    next: 'Next',
		    wrapClass: 'pagination',
		    activeClass: 'active',
		    disabledClass: 'disabled',
		    nextClass: 'next',
		    prevClass: 'previous',
		    lastClass: 'last',
		    firstClass: 'first'
		}).on("page", function(event, num){
		    // or some ajax content loading...
			paging.go(num);
		}); 
		 
		$('#' + this.pagerId + ' li').addClass("paginate_button page-item");
		$('#' + this.pagerId + ' li a').addClass("page-link");
		
		$("#btnSearch").click(function(){
			paging.go(1);
		});
		
		$("#formSearch").submit(function(event) {
			event.preventDefault();
			paging.go(1);
		});
	},		
		
	go : function(num) {
		var pageSize = $("#pageSize").val();
		var searchOption = $("#searchOption").val();
		var searchText = $("#searchText").val();
		if(searchText.length > 0 && searchOption.length == 0) {
			alert('검색조건을 선택해주세요.');
			$("#searchOption").focus();
			return;
		}
		
		var parameter = "?nowPage=" + num + "&pageSize=" + pageSize + "&searchOption=" + searchOption + "&searchText=" + searchText;
		location.href = $(location).attr('pathname') + parameter;
	}
}

