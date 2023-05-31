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
	<form:form modelAttribute="registerForm" method="post" enctype="multipart/form-data" class="validation-form" action="${contextPath }/member/register">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">

        <h4 class="mb-3">회원가입</h4>
        <div class="col-xs-6 profileplace">
			<img class="img-responsive center-block" id="default_photo" name="m_photo" src="${contextPath }/resources/images/person.png">
			<input type = "file" name = "imgFile" multiple="multiple" accept=".jpg, .png"/><br>
		</div>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <form:input path="account.name" class="form-control" id="name" placeholder="" value="" required="true" />
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="nickname">별명</label>
              <form:input path="account.nickname" class="form-control" id="nickname" placeholder="" value="" required="true" />
              <div class="invalid-feedback">
                별명을 입력해주세요.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <form:input path="account.email" class="form-control" id="email" placeholder="you@example.com" required="true" />
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="pwd">비밀번호</label>
            <form:password path="account.pwd" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요" required="true" />
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="checkPwd">비밀번호 확인</label>
            <form:password path="repeatedPassword" class="form-control" id="checkPwd" placeholder="비밀번호를 입력하세요" required="true" />
            <div class="invalid-feedback">
           		비밀번호를 입력해주세요.
            </div>
          </div>
          
          <div class="mb-3">
            <label for="address">핸드폰 번호</label>
            <form:input path="account.phoneNum" class="form-control" id="address" placeholder="핸드폰 번를 입력해주세요." required="true" />
            <div class="invalid-feedback">
              핸드폰번호를 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="address">주소</label>
            <form:input path="account.address" class="form-control" id="address" placeholder="주소를 입력해주세요." required="true" />
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>

          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required="true">
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">펫 등록</button>
      </div>
  </div>
	</form:form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


</body>
</html>