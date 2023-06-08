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