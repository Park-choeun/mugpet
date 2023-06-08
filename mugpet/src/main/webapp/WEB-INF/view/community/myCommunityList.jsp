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

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>mugpet</title>
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<div style=" width: 75%; float: right; padding: 30px 60px 20px 20px;">
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<input type="hidden"/>
		<c:forEach var="community" items="${myComList }">
  				<div class="col">
    				<div class="card h-100">
      					<img src="<c:url value='/upload/${community.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      						<div class="card-body">
        						<h6 style="font-weight: bold;" class="card-title">${community.title }</h6>
        						<p class="card-text">${community.u_id }</p>
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>