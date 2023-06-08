<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>

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
    				기본순
 				</button>
 				<ul class="dropdown-menu" style="font-size:14px;">
 					<li><a class="dropdown-item" href="main?spe_id=${spe_id}">기본순</a></li>
					<li><a class="dropdown-item" href="main/orderItem?spe_id=${spe_id}&standard=itemName&order=ASC">이름순</a></li>
					<li><a class="dropdown-item" href="main/orderItem?spe_id=${spe_id}&standard=price&order=ASC">가격낮은순</a></li>
					<li><a class="dropdown-item" href="main/orderItem?spe_id=${spe_id}&standard=price&order=DESC">가격높은순</a></li>
				</ul>
			</div>
			
			<div id="itemList">
				<div id="itemCards">
					<c:forEach var="item" items="${itemList}" varStatus="i">
						<a href="item/itemDetail?item_id=${item.item_id}">
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

</body>
</html>