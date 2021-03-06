<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<style>
/* 말 줄임표 처리 */
.ellipsis {
    width: 250px;
    text-overflow: ellipsis;
    -o-text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
    word-wrap: normal !important;
    display: block;
}
</style>

<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> 장소 리스트
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th width="60" align="center">No</th>
						<th width="120">카테고리</th>
						<th width="120">상호명</th>
						<th>지번 주소</th>
						<th>도로명 주소</th>
						<th width="120">위도</th>
						<th width="120">경도</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }"	var="vo" varStatus="status">
					<tr>
						<td>${vo.locationNo}</td>
						<td>${vo.category}</td>
						<td name="shopname]">${vo.businessName}</td>
						<td name="oldaddress">${vo.oldAddress}</td>
						<td name="newaddress">${vo.newAddress}</td>
						<td name="lat">${vo.latitude}</td>
						<td name="lon">${vo.longitude}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-5">
				<form class="form-inline my-2 my-lg-0 mr-lg-2" id="formSearch">
					<input type="hidden" id="optParam" value="${pageParam.optParam}"/>
					<input type="hidden" id="nowPage" value="${pageParam.nowPage} }"/>
					<input type="hidden" id="pageSize" value="${pageParam.pageSize}"/>
					<select class="form-control" name="searchOption" id="searchOption">
						<option value="">= 선택 =</option>
						<option value="businessName">상호명</option>
						<option value="oldAddress">구주소</option>
						<option value="newAddress">신주소</option>
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
		// 페이징
		var totalPage = ${(pageParam.totalCount / pageParam.pageSize) + (1-((pageParam.totalCount / pageParam.pageSize) % 1) ) % 1};
		var nowPage = ${pageParam.nowPage};
		paging.init(totalPage, nowPage);
		// 말줄이기
		var rowLen = $("td[name='oldaddress']").length;
		var colNewAddr = $("td[name='newaddress']");
		var colOldAddr = $("td[name='oldaddress']");
		var colShopname = $("td[name='shopname']");
		var colLat = $("td[name='lat']");
		var colLon = $("td[name='lon']");
		
		for(var i=0; i<rowLen; i++)
		{
			colShopname.eq(i).text( cutByte(colShopname.eq(i).text(), 16) );
			colNewAddr.eq(i).text( cutByte(colNewAddr.eq(i).text(), 36) );
			colOldAddr.eq(i).text( cutByte(colOldAddr.eq(i).text(), 36) );
			colLat.eq(i).text( cutByte(colLat.eq(i).text(), 7) );
			colLon.eq(i).text( cutByte(colLon.eq(i).text(), 7) );
		}
	});
</script>