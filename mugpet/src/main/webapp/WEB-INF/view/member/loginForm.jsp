<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
	#top {
		border-bottom:1px solid black;
	}
	#inline {
		display:flex;
	}
	#title {
		text-align:center;
		font-size:40px;
		font-weight:bold;
		width:50%;
		display:inline-block;
		margin:1% 20% 0 35%;
	}
	#logo {
		width:40px;
		height:40px;
	}
	#menu {
		text-align:right;
		font-size:15px;
		width:15%;
		display:inline-block;
		float:right;
		margin:10px;
	}
	#search {
		text-align:right;
		padding:0 10px 5px 0;
		width:400px;
		margin-left:auto;
	}
	#searchInput {
		width:300px;
		height:33px;
		margin-top:2px;
	}
	#searchbtn {
		height:35px;
		width:50px;
		background-color:#FFFF53;
		border-color:black;
		color:black;
	}
	#category {
		width:15%;
		height:200vh;
		text-align:center;
		padding:10px 0;
		float:left;
		border-right:1px solid black;
	}
    body {

      background: -webkit-gradient(linear, left bottom, right top, from(#ffe9f4), to(#f9c6cf));
      background: -webkit-linear-gradient(bottom left, #ffe9f4 0%, #f9c6cf 100%);
      background: -moz-linear-gradient(bottom left, #ffe9f4 0%, #f9c6cf 100%);
      background: -o-linear-gradient(bottom left, #ffe9f4 0%, #f9c6cf 100%);
      background: linear-gradient(to top right, #ffe9f4 0%, #f9c6cf 100%);
    }

    .input-form {
      max-width: 680px;

      margin-top: 40px;
      margin-bottom: 40px;
      
      padding: 32px;
	  float:right;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
      
	}
     .profileplace{
    	display: flex;
     	justify-content: center;
		height:200px; 
		margin:0; 
		padding:0;
	}
    
   
	a {
		text-decoration: none;
		color: inherit;
	}
</style>

</head>
<body>

	<div id="top">
		<div id="inline">
			<div id="title">
				<a href="main.jsp">MugPet <img id="logo" src="${contextPath }/resources/images/foot.png" /></a>
			</div>
			<div id="menu">
				회원가입 | 로그인
			</div>
		</div>
		<div id="search">
			<input id="searchInput" type="text" name="searchInput" value="${searchItemCommand.searchInput}" />
			<input type="submit" value="검색" class="btn btn-primary btn-sm" id="searchbtn"/>
				<%-- <form:form modelAttribute="searchItemCommand">
				<form:label path="searchInput">검색</form:label>
				<form:input path="searchInput" />
				<input type="submit" value="검색" />
			</form:form> --%>
		</div>
	</div>
	<div id="category">
		<div class="btn-group">
  		<button type="button" class="btn btn-danger dropdown-toggle" 
  			style="background-color:#FFD1FF; border-color:#FFD1FF;"
  			data-bs-toggle="dropdown" aria-expanded="false">
  		강아지
   		<%-- 	${pet.species}  --%> 		 
   		</button>
   		<!-- 강아지 고양이 그 외 소동물 li에 넣기 -->
  		<!-- <ul class="dropdown-menu">
    		<li><a class="dropdown-item" href="#">Action</a></li>
    		<li><a class="dropdown-item" href="#">Another action</a></li>
	   		<li><a class="dropdown-item" href="#">Something else here</a></li>
	   	 	<li><hr class="dropdown-divider"></li>
   	 		<li><a class="dropdown-item" href="#">Separated link</a></li>
  		</ul> -->
		</div>
	</div>

	<form:form modelAttribute="registerForm" method="post" enctype="multipart/form-data" class="validation-form" action="${contextPath}/member/login">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
		<h1>LOGIN</h1>
	   	 <c:if test="${!empty signonForwardAction}">
	      	<input type="hidden" name="forwardAction"
	        	value='<c:url value="${signonForwardAction}"/>' />
	    	</c:if>
			email : <input type="text" id="email" name="email"><br>
			PASSWORD : <input type="password" id="pwd" name="pwd"><br>
			<input type="submit" value="Login">
		</div>
	  </div>
	</form:form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
</body>
</html>