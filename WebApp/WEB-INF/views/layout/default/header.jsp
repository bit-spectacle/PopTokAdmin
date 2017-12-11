<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:importAttribute name="leftMenu"/>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	id="mainNav">
	<a class="navbar-brand" href="/admin/">Poptok Admin</a>
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarResponsive"
		aria-controls="navbarResponsive" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<!-- side Menu-->
		<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">					
			<c:forEach var="i" items="${leftMenu }">
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="${i.caption }">
				<c:choose>
					<c:when test="${empty i.subMenu }">
						<a class="nav-link" href="${i.url }">
							<i class="fa fa-fw ${i.iconClass }"></i> <span class="nav-link-text">${i.caption }</span>
						</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#${i.urlNick }" data-parent="#exampleAccordion">
							<i class="fa fa-fw ${i.iconClass }"></i> <span class="nav-link-text">${i.caption }</span>
						</a>
						<ul class="sidenav-second-level collapse" id="${i.urlNick }">
							<c:forEach var="j" items="${i.subMenu }">
								<li><a href="${j.url}">${j.caption }</a></li>
							</c:forEach>
						</ul>
					</c:otherwise>
				</c:choose>	
				</li>
			</c:forEach>
		</ul>
		<!-- side Menu toggle button-->
		<ul class="navbar-nav sidenav-toggler">
			<li class="nav-item"><a class="nav-link text-center"
				id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
			</a></li>
		</ul>
		<!-- logout button-->
		<ul class="navbar-nav ml-auto">
			<li class="nav-item">
					<a class="nav-link" href="javascript:modal.show('exampleModal', 'Logout 하시겠습니까?', '세션에서 로그아웃 하시려면 아래 Logout 버튼을 누르세요.', '/admin/user/logout');">
					<i class="fa fa-fw fa-sign-out"></i>Logout
				</a>
			</li>
		</ul>
	</div>
</nav>
