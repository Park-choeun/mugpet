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
<style>
#top {
	border-bottom: 1px solid black;
}

#inline {
	display: flex;
}

#title {
	text-align: center;
	font-size: 40px;
	font-weight: bold;
	width: 50%;
	display: inline-block;
	margin: 1% 20% 0 35%;
}

#logoImg {
	width: 50px;
	height: 50px;
}

#menu {
	text-align: right;
	font-size: 15px;
	width: 15%;
	display: inline-block;
	float: right;
	margin: 10px;
}

#search {
	text-align: right;
	padding: 0 10px 5px 0;
	width: 400px;
	margin-left: auto;
}

#searchBtn {
	height: 35px;
	width: 75px;
	background-color: #FFE593;
	border-color: #FFE593;
	color: white;
	font-weight: bold;
}

#body {
	display: flex;
}

#category {
	display: inline-block;
	position: fixed;
	width: 200px;
	height:628px;
	text-align: center;
	padding: 10px 0;
	float: left;
}

#categoryBtn {
	background-color: #FFD1FF; 
	border-color: #FFD1FF; 
	font-weight: bold; 
	margin-top: 20px;
}

#category_name {
	posigion: flex;
	width: 200px;
	line-height: 300%;
	font-weight: bold;
}
#subBody {
	/*display: inline-block;*/
	margin-left:20px;
	border-left:1px solid black;
}
a {
	text-decoration: none;
	color: inherit;
}
/* link, visited, hover, active 순서대로 맞춰 쓸 것 */
a:visited, a:hover, a:active {
	color: black;
}
</style>
<title>mugpet</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<div id="top">
		<div id="inline">
			<div id="title">
				<a href="/mugpet/main">MugPet <img id="logoImg" src="${contextPath}/resources/images/foot.png" /></a>
			</div>
			<div id="menu">회원가입 | 로그인</div>
		</div>
		<div id="search">
			<%-- <input id="searchInput" type="text" name="searchInput" value="${searchItemCommand.searchInput}" /> --%>
			<input type="submit" value="필터링" class="btn btn-primary btn-sm" id="searchBtn" />
		</div>
</div>

	<div id="body">
		<div id="category">
			<div class="btn-group">
				<button type="button" class="btn btn-danger dropdown-toggle" id="categoryBtn"
						data-bs-toggle="dropdown" aria-expanded="false">
					${spe}
				</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="main?spe_id=<%=1%>">강아지</a></li>
					<li><a class="dropdown-item" href="main?spe_id=<%=2%>">고양이</a></li>
					<li><a class="dropdown-item" href="main?spe_id=<%=3%>">소동물</a></li>
				</ul>
			</div>
			<div id=category_name>
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=1%>">사료</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=2%>">간식</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=3%>">건강관리</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=4%>">하우스/이동장</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=5%>">화장실/위생</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=6%>">의류/리드줄</a><br /> 
				<a href="item/itemList?spe_id=${spe_id}&category_id=<%=7%>">장난감</a><br />
				 
				<%-- jsp연결하기!!!!!!!!!!!!!!!!!!! --%>
				<a href="item">커뮤니티</a><br /> 
				<a href="main">중고거래</a><br />
			</div>
		</div>
		</div>
		<div id="subBody">
		<div style=" width: 75%; float: right; padding: 60px 60px 20px 20px;">
		<div class="row row-cols-1 row-cols-md-3 g-4">
			<input type="hidden"/>
				<c:forEach var="community" items="${comList }">
  					<div class="col">
    					<div class="card h-100">
      						<img src="<c:url value='/upload/${community.imageUrl}'/>" class="card-img-top" alt="" onerror="">
      							<div class="card-body">
        							<h6 style="font-weight: bold;" class="card-title">${community.title }</h6>
        							<h6 style="font-weight: bold;" class="card-title">${community.com_id }</h6>
        							<p class="card-text">${nickname }</p>
        							<a href='<c:url value="/community/view">
						   				<c:param name="com_id" value="${community.getCom_id()}"/>
				 				 		</c:url>' class="btn btn-outline-danger" style="background-color: #FFD1FF; border-color: #FFD1FF; color:white;">자세히보기</a>
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
	</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>