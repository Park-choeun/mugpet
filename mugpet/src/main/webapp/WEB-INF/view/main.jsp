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
		background-color:#FFE593;
		border-color:#FFE593;
		color:white;
		font-weight:bold;
	}
	#category {
		width:15%;
		height:100vh;
		text-align:center;
		padding:10px 0;
		float:left;
		border-right:1px solid black;
	}
	#category_name {
		line-height:250%;
		font-weight:bold;
	}
	#body {
		display:flex;
	}
	#banner {
		display:inline-block;
		display:flex;
		background-color:#FDFCE4;
		height:275px;
		width:85%;
		border-bottom:1px solid black;
	}
	#comment {
		font-size:18px;
		line-height:230%;
		display:inline-block;
		padding:70px 60px 0 60px;
		border:1px solid black;
	}
	#comment_big {
		font-size:30px;
		font-weight:bold;
	}
	#bannerImg {
		display:inline-block;
	}
	#walk {
		width:250px;
		height:250px;
		border:1px solid black;
		margin: 10px 0 0 500px;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	/* link, visited, hover, active 순서대로 맞춰 쓸 것 */
	a:visited, a:hover, a:active {
		color:black;
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
	
	<div id="body">
		<div id="category">
			<div class="btn-group">
  				<button type="button" class="btn btn-danger dropdown-toggle" 
  					style="background-color:#FFD1FF; border-color:#FFD1FF; font-weight:bold;"
  					data-bs-toggle="dropdown" aria-expanded="false">
  				강아지
   				<%-- 	${pet.species}  --%> 	
   				<%-- 비로그인시 spe_id를 어떻게 참조할 것인지 경로로 참조한다면 변수 이름을 어떻게 해야할지!!!! --%>	 
   				</button>
  				<ul class="dropdown-menu">
    				<li><a class="dropdown-item" href="/main?species=<%=1%>">강아지</a></li>
    				<li><a class="dropdown-item" href="/main?species=<%=2%>">고양이</a></li>
	   				<li><a class="dropdown-item" href="/main?species=<%=3%>">기타</a></li>
  				</ul>
			</div>
			<div id=category_name> <%-- jsp연결하기!!! --%>
				<a href="main.jsp">사료</a><br/>
				<a href="main.jsp">간식</a><br/>
				<a href="main.jsp">건강관리</a><br/>
				<a href="main.jsp">하우스/이동장</a><br/>
				<a href="main.jsp">화장실/위생</a><br/>
				<a href="main.jsp">의류/리드줄</a><br/>
				<a href="main.jsp">장난감</a><br/>
				<a href="main.jsp">커뮤니티</a><br/>
				<a href="main.jsp">중고거래</a><br/>
			</div>
		</div>
		<div id="banner">
			<div id="comment">
				<span id="comment_big">
					반려동물과 함께만드는<br/>
					건강한 펫티켓 문화!<br/>
				</span>
				모두 함께 지켜나가요!
			</div>
			<div id="bannerImg">
				<img id="walk" src="images/walk.png" />
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>