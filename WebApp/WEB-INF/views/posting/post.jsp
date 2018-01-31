<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> 포스팅 리스트
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th width="70">No</th>
						<th width="150">상호명</th>
						<th width="120">작성자</th>
						<th>내용</th>
						<th width="110">작성일자</th>
						<th width="75">좋아요</th>
						<th width="75">댓글수</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }"	var="vo" varStatus="status">
					<tr>
						<td>${vo.postNo}</td>
						<td name="shopname">${vo.businessName}</td>
						<td name="nickname">${vo.nickname}</td>
						<td name="content">${vo.content}</td>
						<td>${vo.postDate}                                                                                                                                   </td>
						<td>${vo.poststatus}</td>
						<td>${vo.likeCnt}</td>
						<td>${vo.commentCnt}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-5">
				<form class="form-inline my-2 my-lg-0 mr-lg-2" id="formSearch">
					<input type="hidden" id="nowPage" value="${pageParam.nowPage} }"/>
					<input type="hidden" id="pageSize" value="${pageParam.pageSize}"/>
					<select class="form-control" name="searchOption" id="searchOption">
						<option value="">==선택==</option>
						<option value="li.businessName">상호명</option>
						<option value="p.content">내용</option>
						<option value="u.nickname">작성자</option>
					</select>
					<div class="input-group">
						<input class="form-control" type="text" placeholder="Search for..." id="searchText" name="searchText" />
						<span class="input-group-btn">
							<button class="btn btn-primary" type="button" id="btnSearch">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</div>
			<div class="col-sm-12 col-md-7">
				<p id="pager"></p>
			</div>
		</div>
	</div>
	<div class="card-footer small text-muted">Total count - ${pageParam.totalCount }</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){

		var rowLen = $("td[name='nickname']").length;
		var colNickname = $("td[name='nickname']");
		var colShopname = $("td[name='shopname']");
		var colContent = $("td[name='content']");
		
		for(var i=0; i<rowLen; i++)
		{
			colNickname.eq(i).text( cutByte(colNickname.eq(i).text(), 10) );
			colShopname.eq(i).text( cutByte(colShopname.eq(i).text(), 15) );
			colContent.eq(i).text( cutByte(colContent.eq(i).text(), 40) );
		}
		
		var totalPage = ${(pageParam.totalCount / pageParam.pageSize) + (1-((pageParam.totalCount / pageParam.pageSize) % 1) ) % 1};
		var nowPage = ${pageParam.nowPage};
		paging.init(totalPage, nowPage);
	});

</script>