<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> 포스팅 리스트
	</div>
	<div class="card-body">

		<table class="table table-bordered" cellspacing="0">
			<thead>
				<tr>
					<th width="70">No</th>
					<th width="150">태그</th>
					<th width="150">카운트</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="count" value="${fn:length(tagList) }" />
				<c:forEach items="${tagList }" var="vo" varStatus="status">
					<tr>
						<td>${count - status.index }</td>
						<td>${vo.tag}</td>
						<td>${vo.count}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="${pageContext.request.contextPath }/redis/init" method="post">
			<input type="submit" value="초기화">
		</form>
	</div>
</div>
