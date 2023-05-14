<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.spring.mugpet.domain.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="UTF-8">
<title>MugPet</title>
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
		height:100vh;
		text-align:center;
		padding:10px 0;
		float:left;
		border-right:1px solid black;
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
				<a href="main.jsp">MugPet <img id="logo" src="images/foot.png" /></a>
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
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>