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
#orderBy {
	text-align:right;
	padding:4px 28px 0 0;
}

#orderBtn {
	background-color:white;
	border-color:white;
	color:black;
}

#itemList {
	padding:0 45px;
	display:flex;	
}

#itemCards {
	width: 1228px;
}

#itemCard {
	display:inline-block;
	width:200px; 
	height:350px;
	margin:20px;
}

#itemImg {
	width:198px;
	height:198px;
}

#itemName {
	font-weight: bold;
	font-size: 15px;
}

#brand {
	font-size: 10px;
}

#price {
	font-size: 13px;
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
	<div id="orderBy">
		<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="orderBtn" 
				data-bs-toggle="dropdown" aria-expanded="false">
    		${standard}
 		</button>
 		<ul class="dropdown-menu" style="font-size:14px;">
 			<li><a class="dropdown-item" href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=${category_id}">기본순</a></li>
			<li><a class="dropdown-item" href="${contextPath}/item/orderItem?spe_id=${spe_id}&category_id=${category_id}&stand=itemName&od=ASC">이름순</a></li>
			<li><a class="dropdown-item" href="${contextPath}/item/orderItem?spe_id=${spe_id}&category_id=${category_id}&stand=price&od=ASC">가격낮은순</a></li>
			<li><a class="dropdown-item" href="${contextPath}/item/orderItem?spe_id=${spe_id}&category_id=${category_id}&stand=price&od=DESC">가격높은순</a></li>
		</ul>
	</div>
			
	<div id="itemList">
		<div id="itemCards">
			<c:forEach var="item" items="${itemList}" varStatus="i">
				<a href="itemDetail?item_id=${item.item_id}">
				<div class="card" id="itemCard">
					<img src="${item.imageUrl}" class="card-img-top" id="itemImg">
					<div class="card-body">
						<p class="card-text">
							<span id="itemName">
								<c:choose>
									<c:when test="${fn:length(item.itemName) > 26}">
										<c:out value="${fn:substring(item.itemName,0,25)}" />...
									</c:when>
									<c:otherwise>
										${item.itemName}
									</c:otherwise>
								</c:choose>
							</span><br/>
  							<span id="brand">${item.brand}</span><br/>
  							<span id="price"><fmt:formatNumber value="${item.price}" pattern="#,###"/>원</span>
						</p>
					</div>
				</div>
				</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>