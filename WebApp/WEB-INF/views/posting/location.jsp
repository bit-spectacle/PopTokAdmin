<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!-- Example DataTables Card-->
<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> Data Table Example
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>locationNo</th>
						<th>code</th>
						<th>businessName</th>
						<th>oldAddress</th>
						<th>newAddress</th>
						<th>latitude</th>
						<th>longitude</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }"	var="vo" varStatus="status">
					<tr>
						<td>${vo.locationNo}</td>
						<td>${vo.code}</td>
						<td>${vo.businessName}</td>
						<td>${vo.oldAddress}</td>
						<td>${vo.newAddress}</td>
						<td>${vo.latitude}</td>
						<td>${vo.longitude}</td>
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
						<option value="businessName">제목</option>
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
		var totalPage = ${(pageParam.totalCount / pageParam.pageSize) + (1-((pageParam.totalCount / pageParam.pageSize) % 1)) % 1};
		var nowPage = ${pageParam.nowPage};
		paging.init(totalPage, nowPage);
	});
</script>