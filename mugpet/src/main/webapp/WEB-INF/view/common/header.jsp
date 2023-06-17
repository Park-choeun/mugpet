<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div id="top">
	<div id="inline">
		<div id="title">
			<a href="${contextPath}/main">MugPet <img id="logoImg" src="${contextPath}/resources/images/foot.png" /></a>
		</div>
		<div id="menu">
		<c:choose>
			<c:when test="${userSession.u_id == 0}">
				<a href="${contextPath}/member/register">회원가입</a> | 
				<a href="${contextPath}/member/login">로그인</a>
			</c:when>
			<c:otherwise>
				<span id="petName">${petName}</span>님 |
				마이페이지 |
				<a href="${contextPath}/cart/myCartList?spe_id=${spe_id}">장바구니</a> |
				<a href="${contextPath}/member/logout">로그아웃</a>
			</c:otherwise>
		</c:choose>
		</div>
		</div>
	<div id="search">
		<a href="javascript:void(window.open('${contextPath}/item/filter?spe_id=${spe_id}', '_blank', 'width=500, height=650, left=530, top=50'))">
			<input type="button" value="필터링" class="btn btn-primary btn-sm" id="searchBtn" />
		</a>
	</div>
</div>