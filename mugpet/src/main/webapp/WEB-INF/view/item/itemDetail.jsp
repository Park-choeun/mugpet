<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

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
			<a href="${contextPath}/wish/updateWish?item_id=${item.item_id}&isWish=${isWish}">
				<c:if test="${isWish eq 0}">
					<img id="wishBtn" src="${contextPath}/resources/images/wish.png" />
				</c:if>
				<c:if test="${isWish eq 1}">
					<img id="wishBtn" src="${contextPath}/resources/images/wished.png" />
				</c:if>
			</a>
			<input type="button" value="장바구니" class="btn btn-primary" id="cartBtn" />
			<input type="button" value="구매하기" class="btn btn-primary" id="buyBtn" />
		</td>
	</tr>
</table>