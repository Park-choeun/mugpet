<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
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

    
   
	a {
		text-decoration: none;
		color: inherit;
	}
	
	button {
 	 margin: 20px;
 	 outline: none;
	}
	.custom-btn {
	  width: 130px;
	  height: 40px;
	  padding: 10px 25px;
	  border: 2px solid #f9c6cf;
	  font-family: 'Lato', sans-serif;
	  font-weight: 500;
	  background: transparent;
	  cursor: pointer;
	  transition: all 0.3s ease;
	  position: relative;
	  display: inline-block;
	}
	
	.btn-1 {
  transition: all 0.3s ease;
	}
	.btn-1:hover {
	   box-shadow:
	   -7px -7px 20px 0px #fff9,
	   -4px -4px 5px 0px #fff9,
	   7px 7px 20px 0px #0002,
	   4px 4px 5px 0px #0001;
	}
	
	.frame {
  	width: 90%;
  	margin-top: 40px;
     margin-bottom: 40px;
  	text-align: center;
	}

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
	
	<form:form modelAttribute="petRegisterForm" method="post" enctype="" class="validation-form" action="${contextPath }/pet/petRegister">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">펫 등록</h4>
   
        <div class="frame">
			<input type="radio" name="species" value="1" />강아지
			<input type="radio" name="species" value="2" />고양이 
			<input type="radio" name="species" value="3" />소동물
		</div>

          <div class="mb-3">
            <label for="name">이름</label>
            <form:input path="pet.name" class="form-control" placeholder="이름을 입력해주세요." value="" required="true" />
            <div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="birth">생년월일</label>
            <form:input path="pet.birth" class="form-control" placeholder="생년월일을 입력해주세요." required="true" />
            <div class="invalid-feedback">
              생년월일을 입력해주세요.
            </div>
          </div>
<!--           <div class="mb-3">
            <label for="species">종류</label>
            <input id="species" class="form-control" placeholder="종류를 입력해주세요." required="true" />
			</div> -->
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">회원가입 완료</button>
      </div>
	</div>
	</form:form>



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</body>
</html>