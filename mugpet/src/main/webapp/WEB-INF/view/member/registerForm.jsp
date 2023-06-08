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

    .input-form {
      max-width: 680px;

      margin-top: 40px;
      margin-bottom: 40px;
        display: flex;
 	 	flex-direction: column;
  		justify-content: center;
      padding: 32px;
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

	<form:form modelAttribute="registerForm" method="post" enctype="multipart/form-data" class="validation-form" action="${contextPath }/member/register">
 
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
	</form:form>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


</body>
</html>