<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />


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