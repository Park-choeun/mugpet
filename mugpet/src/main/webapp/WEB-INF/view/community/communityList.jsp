<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="cardList">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<input type="hidden"/>
		<c:forEach var="community" items="${comList }" varStatus="status">
  				<div class="col">
    				<div class="card h-100" id="subCard" style="width: 330px;">
    				<c:if test="${community.imageUrl ne null }">
    					<img style="heigth: 200px; width: 200px;" src="<c:url value='/upload/${community.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      				</c:if>	
     						<div class="card-body">
        						<h6 style="font-weight: bold;" class="card-title">${community.title }</h6>
        						<p class="card-text">닉네임 : ${nicknameList[status.index] }</p>
        						<a href="<c:url value='/community/view'>
						   			<c:param name='com_id' value='${community.com_id}'/>
				 				 	</c:url>" id="btn_detail" class="btn btn-outline-danger">자세히보기</a>
      						</div>
    					</div>
  				</div>	
  		</c:forEach>
	</div>
<br>

	<div class="button_box">
		<a href="<c:url value='/community/writeForm' />" type="button" id="btn_write" style="color: white;" class="btn btn-danger">글쓰기</a>
	</div> 
</div>