<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
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
<title>상품정보</title>
<style>
.itemInfoTable {
	margin: auto;
	margin-top: 30px;
}

#itemImgBox {
	width: 450px;
	height: 450px;
}

#itemImg {
	width:370px;
	height:370px;
}

#info1 {
	width:500px;
	height:140px;
	line-height: 150%;
	vertical-align : top;
}

#spe {
	padding:2px 6px;
	background-color:#FFD1FF;
	color:white;
	font-size:13px;
	border-radius: 30px;
}

#brand {
	font-size:13px;
}

#itemName {
	font-size:27px;
	font-weight:bold;
}

#price {
	font-size:20px;
	font-weight:bold;
	vertical-align : top;
	height:30px;
}

#comments {
	font-size:17px;
	width:500px;
	padding-top:7px;
	vertical-align : top;
	line-height:120%;
}

#btnBox {
	text-align:right;
}

#wishBtn {
	width:40px;
	height:40px;
	margin-right: 10px;
}

#cartBtn {
	background-color:white;
	color:black;
	font-weight:bold;
	border-color: black;
	margin-right: 10px;
	padding:8px 35px;
}

#buyBtn {
	background-color:#FFE593;
	font-weight:bold;
	border-color: #FFE593;
	padding:8px 35px;
	margin-right:10px;
}

a {
	text-decoration: none;
	color: inherit;
}
/* link, visited, hover, active 순서대로 맞춰 쓸 것 */
a:visited, a:hover, a:active {
	color: black;
}
</style>
</head>
<body>
	<table class="itemInfoTable">
		<tr>
			<td rowspan="4" id="itemImgBox">
				<img src="${item.imageUrl}" class="card-img-top" id="itemImg">
			</td>
			<td colspan="2" style="height:60px;"></td>
		</tr>
		<tr>
			<td id="info1">
				<span id="spe">${spe}</span><br/>
				<span id="brand">${item.brand}</span><br/>
				<span id="itemName">${item.itemName}</span><br/>
			</td>
		</tr>
		<tr>
			<td id="price">
				<fmt:formatNumber value="${item.price}" pattern="#,###"/>원
			</td>
		</tr>
		<tr>
			<td id="comments">${item.comments}</td>
		</tr>
		<tr>
			<td colspan="2" id="btnBox">
				<img id="wishBtn" src="${contextPath}/resources/images/wish.png" />
				<input type="button" value="장바구니" class="btn btn-primary" id="cartBtn" />
				<input type="button" value="구매하기" class="btn btn-primary" id="buyBtn" />
			</td>
		</tr>
	</table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>