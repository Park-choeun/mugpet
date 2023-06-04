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
<title>MugPet</title>
<style>
#top {
	border-bottom: 1px solid black;
}

#inline {
	display: flex;
}

#title {
	text-align: center;
	font-size: 40px;
	font-weight: bold;
	width: 50%;
	display: inline-block;
	margin: 1% 20% 0 35%;
}

#logoImg {
	width: 50px;
	height: 50px;
}

#menu {
	text-align: right;
	font-size: 15px;
	width: 15%;
	display: inline-block;
	float: right;
	margin: 10px;
}

#search {
	text-align: right;
	padding: 0 10px 5px 0;
	width: 400px;
	margin-left: auto;
}

#searchBtn {
	height: 35px;
	width: 75px;
	background-color: #FFE593;
	border-color: #FFE593;
	color: white;
	font-weight: bold;
}

#body {
	display: flex;
}

#category {
	display: inline-block;
	position: fixed;
	width: 200px;
	height:628px;
	text-align: center;
	padding: 10px 0;
	float: left;
}

#categoryBtn {
	background-color: #FFD1FF; 
	border-color: #FFD1FF; 
	font-weight: bold; 
	margin-top: 20px;
}

#category_name {
	posigion: flex;
	width: 200px;
	line-height: 300%;
	font-weight: bold;
}

#subBody {
	display: inline-block;
	margin-left:200px;
	border-left:1px solid black;
}

#banner {
	display: flex;
	background-color: #FDFCE4;
	height: 275px;
	border-bottom: 1px solid black;
}

#comment {
	width: 400px;
	font-size: 18px;
	line-height: 230%;
	display: inline-block;
	padding: 70px 0 0 60px;
}

#comment_big {
	font-size: 30px;
	font-weight: bold;
}

#walk {
	width:250px;
	height:250px;
	margin: 10px 120px 0 auto;
}

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
	<div id="top">
		<div id="inline">
			<div id="title">
				<a href="${contextPath}/main">MugPet <img id="logoImg" src="${contextPath}/resources/images/foot.png" /></a>
			</div>
			<div id="menu">
				<a href="${contextPath}/member/register">회원가입</a> | 
				<a href="${contextPath}/member/login">로그인</a></div>
		</div>
		<div id="search">
			<%-- <input id="searchInput" type="text" name="searchInput" value="${searchItemCommand.searchInput}" /> --%>
			<input type="submit" value="필터링" class="btn btn-primary btn-sm" id="searchBtn" />
		</div>
	</div>

	<div id="body">
		<div id="category">
			<div class="btn-group">
				<button type="button" class="btn btn-danger dropdown-toggle" id="categoryBtn"
						data-bs-toggle="dropdown" aria-expanded="false">
					${spe}
				</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="${contextPath}/main?spe_id=<%=1%>">강아지</a></li>
					<li><a class="dropdown-item" href="${contextPath}/main?spe_id=<%=2%>">고양이</a></li>
					<li><a class="dropdown-item" href="${contextPath}/main?spe_id=<%=3%>">소동물</a></li>
				</ul>
			</div>
			<div id=category_name>
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=1%>">사료</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=2%>">간식</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=3%>">건강관리</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=4%>">하우스/이동장</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=5%>">화장실/위생</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=6%>">의류/리드줄</a><br /> 
				<a href="${contextPath}/item/itemList?spe_id=${spe_id}&category_id=<%=7%>">장난감</a><br />
				<a href="${contextPath}/community/communityList?spe_id=${spe_id}">커뮤니티</a><br /> 
				<a href="${contextPath}/usedGoods/usedGoodsList?spe_id=${spe_id}">중고거래</a><br />
			</div>
		</div>
		<div id="subBody">
			<div id="banner">
				<div id="comment">
					<span id="comment_big"> 
						반려동물과 함께만드는<br/> 
						건강한 펫티켓 문화!<br/>
					</span>
					모두 함께 지켜나가요!
				</div>
				<img id="walk" src="${contextPath}/resources/images/walk.png" />
			</div>
			
			<div id="orderBy">
				<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="orderBtn" 
						data-bs-toggle="dropdown" aria-expanded="false">
    				${standard}
 				</button>
 				<ul class="dropdown-menu" style="font-size:14px;">
 					<li><a class="dropdown-item" href="${contextPath}/main?spe_id=${spe_id}">기본순</a></li>
					<li><a class="dropdown-item" href="${contextPath}/main/orderItem?spe_id=${spe_id}&stand=itemName&od=ASC">이름순</a></li>
					<li><a class="dropdown-item" href="${contextPath}/main/orderItem?spe_id=${spe_id}&stand=price&od=ASC">가격낮은순</a></li>
					<li><a class="dropdown-item" href="${contextPath}/main/orderItem?spe_id=${spe_id}&stand=price&od=DESC">가격높은순</a></li>
				</ul>
			</div>
			
			<div id="itemList">
				<div id="itemCards">
					<c:forEach var="item" items="${itemList}" varStatus="i">
						<a href="${contextPath}/item/itemDetail?item_id=${item.item_id}">
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
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>