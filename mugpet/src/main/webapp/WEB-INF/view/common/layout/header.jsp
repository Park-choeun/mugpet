<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="top">
		<div id="inline">
			<div id="title">
				<a href="main">MugPet <img id="logoImg" src="${contextPath}/resources/images/foot.png" /></a>
			</div>
			<div id="menu"><a href="${contextPath }/member/register">회원가입</a> | <a href="${contextPath }/member/login">로그인</a></div>
		</div>
		<div id="search">
			<%-- <input id="searchInput" type="text" name="searchInput" value="${searchItemCommand.searchInput}" /> --%>
			<input type="submit" value="필터링" class="btn btn-primary btn-sm" id="searchBtn" />
		</div>
	</div>
</body>
</html>