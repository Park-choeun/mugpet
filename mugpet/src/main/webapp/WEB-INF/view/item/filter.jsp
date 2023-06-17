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
<title>필터링</title>
<style>
#filterLabel {
	font-size:25px;
	text-align:center;
	font-weight:bold;
	border-bottom:3px solid #FFE593;
}

#ftable {
	width:450px;
	height:550px;
	margin:20px auto;
}

.filterName {
	padding:3px 7px;
	background-color:#FFD1FF;
	color:white;
	border-radius: 30px;
	margin-left:25px;
	font-size:14px;
}

.val {
	padding-left:35px;
	font-size:15px;
}

#btnBox {
	text-align:center;
	vertical-align : top;
}

#submitBtn {
	height: 35px;
	width: 75px;
	background-color: #FFE593;
	border-color: #FFE593;
	color: white;
	font-weight: bold;
}

#resetBtn {
	width:35px;
	height:35px;
}

td{
	border-bottom:1.5px solid #FFE593;
}
</style>
</head>
<body>
	<form:form modelAttribute="filtering" method="post" class="validation-form" action="${contextPath}/item/filter?spe_id=${spe_id}&category_id=${category_id}">
		<table id="ftable">
			<tr><th id="filterLabel">필터</th></tr>
  			<tr>
				<td>
					<span class="filterName">연령</span><br/>
					<span class="val"><form:radiobuttons path="age" items="${ageVal}" /></span>
					<form:errors path="age" />
				</td>
			</tr>
			<tr>
				<td>
					<span class="filterName">주원료</span><br/>
					<span class="val"><form:checkboxes path="stuffs" items="${stuffVal}" /></span>
				</td>
			</tr>
			<tr>
				<td>
					<span class="filterName">특징/기능</span><br/>
					<span class="val"><form:checkboxes path="features" items="${featureVal}" /></span>
				</td>
			</tr>
			<tr>
				<th id="btnBox" colspan="3">
					<input type="submit" value="필터링" id="submitBtn" class="btn btn-primary btn-sm" onclick="closeFilter()"/>
				</th>
			<tr>
		</table>
	</form:form>
	
	<script>
		/* 주석 */
		function closeFilter() {
			window.opener.name="parentPage";
			document.filterForm.target="parentPage";
			self.close();
		}
	</script>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>