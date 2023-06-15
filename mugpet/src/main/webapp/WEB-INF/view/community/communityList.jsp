<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">

<title>mugpet</title>
</head>
<body>
<div style="width:1318px; float: left; padding: 30px 60px 20px 20px; border:1px solid blue; ">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<input type="hidden"/>
		<c:forEach var="community" items="${comList }">
  				<div class="col">
    				<div class="card h-100">
      					<img src="<c:url value='/upload/${community.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      						<div class="card-body">
        						<h6 style="font-weight: bold;" class="card-title">${community.title }</h6>
        						<p class="card-text">u_id 확인용: ${community.u_id }</p>
        						<p class="card-text">com_id 확인용: ${community.com_id }</p>
        						<a href="<c:url value='/community/view'>
						   			<c:param name='com_id' value='${community.com_id}'/>
				 				 	</c:url>" class="btn btn-outline-danger" style="background-color: #FFD1FF; border-color: #FFD1FF; color:white;">자세히보기</a>
      						</div>
    					</div>
  				</div>	
  		</c:forEach>
	</div>
<br>

	<div class="button_box">
		<a href="<c:url value='/community/writeForm' />" type="button" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF;">글쓰기</a>
	</div> 
</div>
</body>
</html>