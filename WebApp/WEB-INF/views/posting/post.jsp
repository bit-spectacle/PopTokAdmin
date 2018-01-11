<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<th>No</th>
						<th>상호명</th>
						<th>작성자</th>
						<th>좋아요</th>
						<th>댓글수</th>
						<th>내용</th>
						<th>이미지</th>
						<th>카카오와<br/>연결</th>
						<th>작성일자</th>
						<th>해시태그</th>
						<th>위도</th>
						<th>경도</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }"	var="vo" varStatus="status">
					<tr>
						<td>${vo.postNo}</td>
						<td>${vo.businessName}</td>
						<td>${vo.nickname}</td>
						<td>${vo.viewsCnt}</td>
						<td>${vo.likeCnt}</td>
						<td>${vo.commentCnt}</td>
						<td>${vo.content}</td>
						<td>${vo.image}</td>
						<td>${vo.kakaoLink}</td>
						<td>${vo.postDate}</td>
						<td>${vo.tag}</td>
						<td>${vo.latitude}</td>
						<td>${vo.longitude}</td>
						<td>${vo.poststatus}</td>
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
						<option value="oldAddress">구(지번)주소</option>
						<option value="newAddress">신(도로명)주소</option>
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
		var totalPage = ${(pageParam.totalCount / pageParam.pageSize) + (1-((pageParam.totalCount / pageParam.pageSize) % 1) ) % 1};
		var nowPage = ${pageParam.nowPage};
		paging.init(totalPage, nowPage);
	});
</script>