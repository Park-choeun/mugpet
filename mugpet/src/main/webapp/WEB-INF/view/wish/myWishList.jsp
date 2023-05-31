<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
   integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<meta charset="UTF-8">
<title>위시 리스트</title>
<style>
	.wish{
		text-size: 15px;
	}
	.item {
		text-align:center;
		float:left;
		margin: 0px 10px;
		width: 300px;
		height: 300px;
	}
	.productImg {
		margin:10px 20px;
		border: 1px solid #A6A6A6
		
	}
	.productName{
		display:inline-block; 
		width:150px;
	}
	.productPrice{
		margin-top:50px;
	}
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
   a {
      text-decoration: none;
      color: inherit;
   }
   	.content{
   		display: inline-block;
		width:80%;			/*padding값 고려해서 %추가*/
		padding-top:30px;
		padding-left:50px;
	}
	h5{
		text-color: #5D5D5D;
	}
    .product{
		text-align:center;
	}
</style>
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
<%--위시 리스트 창 --%>
<div class="content">
	<h5>위시 리스트</h5><br/>
	<hr>
	<p class="wish">상품</p>
	<table>
		<tr>
		<c:forEach var="wishItem" items="${wishItemsInfo}" varStatus="status"> <%-- foreach문으로 item 목록을 가져와서 출력 --%>	
			<td>
				<div class="item">
					<span class="product">
						<img src="${wishItem.imageUrl}"  width="150" height="150" alt="상품이미지" class="productImg"/>
						<br/>
					</span>
					<br/>
					<span class="productName">
						<c:out value="${wishItem.itemName}"/>
					</span>
					<br/>
					<span class="productPrice">
						<c:out value="${wishItem.price}원" />
					</span>
				</div>
			</td>
			<c:if test="${status.count % 3 == 0}">
				<c:out value="</tr><tr>" escapeXml="false"/>
			</c:if>
		</c:forEach>
	</table>
	<hr>
	<p>중고거래</p>
</div>
</body>
</html>