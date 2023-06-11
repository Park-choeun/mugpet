<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
   integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>주문 결제</title>
<style>
	#top {
	     display:flex;
	     vertical-align:top;
	     padding-bottom: 50px;
	     padding-top: 40px; /*추가*/
	     border-bottom: 1px solid #8C8C8C; /*추가*/
	  }
	  #title {
	     text-align:center;
	     font-size:40px;
	     font-weight:bold;
	     width:50%;
	     display:inline-block;
	     margin:0 25% 0 35%;
	     
	  }
	  #logo {
	     width:40px;
	     height:40px;
	  }
	  #menu {
	     text-align:right;
	     font-size:13px;
	     width:15%;
	     display:inline-block;
	     float:right;
	     
	  }
	  #category {
	     width:15%; /*width를 %로 주기*/
	     height:100vh;
	     text-align:center;
	     padding:10px 0;
	     float:left; /*추가*/
	     border-right: 1px solid #8C8C8C; /*추가*/
	  }
	   .content{
	  		display: inline-block;
			width:80%;			/*padding값 고려해서 %추가*/
			padding-top:30px;
			padding-left:50px;
		}
	 	a {
		    text-decoration: none;
		    color: inherit;
	 	}
		.title{
			font-size:20px;
		}
		 .semiTitle{
			font-size:16px; 
		}
		 .userInfo{
			font-size:13px;
		}
		.detail{
			float:right;
		}
		.btnSubmit{
	 		width:200px;
	       	margin:auto;
	       	display:block;
		}
		.productImg {
			margin:10px 20px;
			border: 1px solid #A6A6A6;
		}
		
		table{
			width: 100%;
		}
		
		tr{
			border-bottom: 1px solid #A6A6A6;
			width: 100%;
		}
</style>
<script>
	function check(){
		if(document.querySelector('input[name="allowPermission"]').checked){
			return true;
		} 
		else{
			alert('정보 동의 항목을 체크해주세요.\n 확인을 누르면 결제페이지로 이동합니다.');
			return false;
		}
	}
</script>
</head>
<body>
<div id="top">
      <div id="title">
         <a href="/main">MugPet <img id="logo" src="../images/foot.png" /></a>
      </div>
      <div id="menu">
         회원가입 | 로그인
      </div>
</div>
<div id="category">
   <div class="btn-group">
     <button type="button" class="btn btn-danger dropdown-toggle" 
        style="background-color:#FFD1FF; border-color:#FFD1FF;"
        data-bs-toggle="dropdown" aria-expanded="false">
     강아지
      <%--    ${pet.species}  --%>        
      </button>
     <!-- <ul class="dropdown-menu">
       <li><a class="dropdown-item" href="#">Action</a></li>
       <li><a class="dropdown-item" href="#">Another action</a></li>
         <li><a class="dropdown-item" href="#">Something else here</a></li>
          <li><hr class="dropdown-divider"></li>
          <li><a class="dropdown-item" href="#">Separated link</a></li>
     </ul> -->
   </div>
</div>
<form name="orderForm" action='<c:url value="/cart/ordering"/>' method="post" >
	<div class="content">
		<p class="title">주문 결제</p>
		<p class="semiTitle">주문 고객 정보</p>
		<p class="userInfo">${memberInfo.name}, ${memberInfo.phoneNum}</p> <%-- memberService에서 전달받아 사용 --%>
		<hr>
		<p class="semiTitle">배송지</p>
		${memberInfo.address} <br /><%-- memberService에서 전달받아 사용 --%>
		<input type="text" placeholder=" 상세주소 입력란" value="${command.addrDetail}" class="userInfo" name="addrDetail" style="margin-Top:10px; width:300px;" /> <%--왜 width 속성이 안먹는가 --%>
		<br/>
		<br/>
		<hr>
		<p class="semiTitle">배송 요청사항</p>
		<input type="radio" name="req" value="문 앞에 놔주세요."/><span class="userInfo"> 문 앞에 놔주세요.</span><br />
		<input type="radio" name="req" value="배송 전 연락주세요."/><span class="userInfo"> 배송 전 연락주세요.</span><br />
		<input type="radio" name="req" value="부재 시 경비실에 맡겨주세요."/><span class="userInfo"> 부재 시 경비실에 맡겨주세요.</span><br />
		<input type="text" name="req" placeholder=" 직접 입력" value="${command.req}" class="userInfo" style="width:200px"/><br />
		<br/>
		<hr>
		<p class="semiTitle">주문 상품</p>
		<table>
			<c:forEach var="item" items="${cartItemsInfo}" varStatus="status"> 
				<tr>
					<td>
						<img src="${item.imageUrl}"  width="90" height="90" alt="상품이미지" class="productImg"/>
					</td>
					<td>
						${item.itemName}
					</td>
					<td>
						수량 : ${cartItemsQty[status.index]}개
					</td>
					<td>
						금액 : <fmt:formatNumber value="${cartItemsPrice[status.index]}" pattern="#,###"/>원
					</td>
				</tr>
			</c:forEach>
		</table>
		<br/>		
		<p class="semiTitle">적립금 적용</p>
<%-- 		<form name="point" action='<c:url value="/cart/updatePoints"/>' method="post"> --%>
			<input type="text" name="point" placeholder=" 직접 입력" class="userInfo" value="${applyPoints}" style="width:200px"/>
				<button type="submit" formaction="order" name="apply" style="margin-Left:30px">적용</button>
			<span class="userInfo detail">총 적립금: <fmt:formatNumber value="${memberInfo.point}" pattern="#,###"/>원</span> <%-- memberService에서 전달받아 사용 --%>
			<br/>
			<span class="userInfo detail">
				적용 후 남은 적립금: <fmt:formatNumber value="${resetPoints}" pattern="#,###"/>원
			</span> 
			 <%--button 클릭하면 모든 적립금이 text에 나타나도록 --%>
		<br/>
		<hr>
		<p class="semiTitle">결제 금액</p>
		<span class="userInfo">총 상품액</span><span class="userInfo detail"><fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원</span><br/>
		<span class="userInfo">배송비</span><span class="userInfo detail">0원 </span><br/>
		<span class="userInfo">적립금 적용</span><span class="userInfo detail">- <fmt:formatNumber value="${applyPoints}" pattern="#,###"/>원 </span><br/> <%-- memberService에서 전달받아 사용 --%>
		<br/>
		<hr>
		<span class="userInfo">총 결제 금액</span><span class="userInfo detail"><fmt:formatNumber value="${totalPrice - applyPoints}" pattern="#,###"/>원</span><br/>
		<span class="userInfo">포인트 적립: <fmt:formatNumber  value="${100}" pattern="#,###"/>원</span>
		<br/>
		<br/>
		<input type="checkbox" name="allowPermission"/>주문상품 및 결제대행 이용약관에 모두 동의합니다.<br/><br/>
		<button class="btnSubmit" onclick="check()">결제하기</button>
</form>
		<br/><br/>
	</div>
</body>
</html>