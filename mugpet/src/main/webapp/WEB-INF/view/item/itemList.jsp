<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

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