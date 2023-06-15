<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>필터 선택</title>
<style>
#filter {
	font-size:25px;
	text-align:center;
	font-weight:bold;
	margin: 5px auto;
}

#ftable {
	width:400px;
	margin:15px auto;
	border:1px solid black;
}

#filterName {
	font-weight:bold;
}
</style>
</head>
<body>
	<div id=filter>
		필터
	</div>
	<form:form method="post" class="validation-form" action="${contextPath}/item/filterItem?spe_id=${spe_id}">
		<table class="table table-striped-columns" id="ftable">
  			<tr id="filterName">
				<td>연령</td>
				<td>주원료</td>
				<td>특정/기능</td>
			</tr>
			<tr>
				<td><form:radiobuttons path="age" items="${ages}" /></td>
				<td><form:checkboxes path="stuff" items="${stuffs}" /></td>
				<td><form:checkboxes path="feature" items="${features}" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>