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
		<form id="redisForm" action="${pageContext.request.contextPath }/redis/init" method="post">
			<input type="button" class="btn" id="btn_reset" value="초기화" />&nbsp;
			<input type="button" class="btn" id="btn_reload" value="새로고침" />&nbsp;
			<input type="button" class="btn" id="btn_blank" value="메모리 비우기" />&nbsp;
			<input type="button" class="btn" id="btn_delete" value="임의데이터 삭제" />&nbsp;
			<input type="hidden" id="deleteResult" value="${deleteResult}" />
		</form>
		<br/>
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
		
	</div>
</div>

<script type="text/javascript">

$(document).ready(function(){
	resultMsg = $("#deleteResult").val();
	if(resultMsg != "") alert($("#deleteResult").val());
	
	// 초기화 버튼 클릭 시
	$("#btn_reset").click(function() {
		$("#redisForm").attr("action", "${pageContext.request.contextPath }/redis/init").submit();
	})
	
	// 새로고침 버튼 클릭 시
	$("#btn_reload").on('click', function() {
		location.reload();		
	})
	
	// 비우기 버튼 클릭 시
	$("#btn_blank").on('click', function() {
		$("#redisForm").attr("action", "${pageContext.request.contextPath }/redis/blank").submit();
	})
	
	// 임의데이터삭제 버튼 클릭 시
	$("#btn_delete").on('click', function() {
		$("#redisForm").attr("action", "${pageContext.request.contextPath }/redis/delete").submit();
	})
})
</script>
