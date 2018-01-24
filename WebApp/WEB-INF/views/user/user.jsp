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
		<i class="fa fa-table"></i> 사용자 리스트
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<form id="formhidden">
				
			</form>
			<table class="table table-bordered" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th width="70" align="center">No</th>
						<th>닉네임</th>
						<th>e-mail</th>
						<th width="90">권한</th>
						<th width="110">가입일자</th>
						<th width="110">최근접속일</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }"	var="vo" varStatus="status">
					<tr>
						<td>${vo.userNo}</td>
						<td name="nickname">${vo.nickname}</td>
						<td name="email">${vo.email}</td>
						<td>${vo.role}</td>
						<td>${vo.joindate}</td>
						<td>${vo.lastlogin}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-5">
				<form class="form-inline my-2 my-lg-0 mr-lg-2" id="formSearch">
					<input type="hidden" id="optParam" value="${pageParam.optParam}"/>
					<input type="hidden" id="nowPage" value="${pageParam.nowPage}"/>
					<input type="hidden" id="pageSize" value="${pageParam.pageSize}"/>
					<select class="form-control" name="searchOption" id="searchOption">
						<option value="">==선택==</option>
						<option value="email">이메일</option>
						<option value="nickname">닉네임</option>
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
		var colEmail = $("td[name='email']");
		
		for(var i=0; i<rowLen; i++)
		{
			colNickname.eq(i).text( cutByte(colNickname.eq(i).text(), 20) );
			colEmail.eq(i).text( cutByte(colEmail.eq(i).text(), 25) );
		}
		
		var totalPage = ${(pageParam.totalCount / pageParam.pageSize) + (1-((pageParam.totalCount / pageParam.pageSize) % 1) ) % 1};
		var nowPage = ${pageParam.nowPage};
		paging.init(totalPage, nowPage);
	});
</script>