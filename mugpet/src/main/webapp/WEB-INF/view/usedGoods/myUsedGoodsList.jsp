<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="cardList">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<input type="hidden"/>
		<c:forEach var="usedGoods" items="${myGoodsList }" varStatus="status">
  				<div class="col">
    				<div class="card h-100" style="width: 330px;">
      					<c:if test="${usedGoods.imageUrl ne null }">
      						<img style="height: 200px; width: 200px;" src="<c:url value='/upload/${usedGoods.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      					</c:if>	
      						<div class="card-body">
        						<h6 style="font-weight: bold;" class="card-title">${usedGoods.title }</h6>
        						<p class="card-text">${nickname }</p>
        						<p class="card-text"><fmt:formatNumber value="${usedGoods.price }" pattern="#,###"/>원</p>
        						<a href="<c:url value='/usedGoods/view'>
						   			<c:param name='g_id' value='${usedGoods.g_id}'/>
				 				 	</c:url>" class="btn btn-outline-danger" style="background-color: #FFE593; border-color: #FFE593; color:white;">자세히보기</a>
      						</div>
    					</div>
  				</div>	
  		</c:forEach>
	</div>
<br>

	<div class="button_box">
		<a href="<c:url value='/community/writeForm' />" type="button" class="btn btn-danger" style="background-color: #FFE593; border-color: #FFE593; color: white;">글쓰기</a>
	</div> 
</div>