<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#cbx_chkAll").click(function() {
		if($("#cbx_chkAll").is(":checked")) $("input[name=item]").prop("checked", true);
		else $("input[name=item]").prop("checked", false);
	});
	
	$("input[name=item]").click(function() {
		var total = $("input[name=item]").length;
		var checked = $("input[name=item]:checked").length;
		
		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});
});
//전체 선택
function selectAll(selectAll)  {
	  const checkboxes 
	     = document.querySelectorAll('input[type="checkbox"]');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	   })
	  
	  getCheckedCnt()
}
//체크된 개수만큼 가져오기
function getCheckedCnt()  {

	  // 선택된 목록 가져오기
	  const query = 'input[name="item"]:checked';
	  const selectedElements = 
	      document.querySelectorAll(query);
	  
	  // 선택된 목록의 갯수 세기
	  const selectedElementsCnt =
	        selectedElements.length;
	  
	  // 출력
	  document.getElementById('result').innerText
	    = selectedElementsCnt;
}
</script>
<!------------------------장바구니 창-------------------->  
<div class="content">
	<h5>장바구니</h5><br/>
	<div>
		<input type='checkbox'
		       name='selectAll' 
		       value='selectAll'
		       id="cbx_chkAll" onclick='selectAll(this)' checked='true'/> 전체 선택 (<span id='result'>${cartItemSize}</span>/${cartItemSize}) 
	      <span class="remove">
	      		선택 삭제
	      </span>
	</div>	       
	<hr>
	<table>
		<form name="cart" action='<c:url value="/cart/updateCartQuantities"/>' method="post">
			<c:forEach var="item" items="${cartItemsInfo}" varStatus="status"> <%-- foreach문으로 item 목록을 가져와서 출력 --%>
				<tr>
					<td>
						<br/>
						<a href='<c:url value="/cart/removeItemFromCart"><c:param name="item_id" value="${item.item_id}"/></c:url>'>
							<button type="button" class="remove">
								<label for="remove">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-square" viewBox="0 0 16 16">
								  		<path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
								  		<path d="M4 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 4 8z"/>
									</svg>
								</label>
							</button>
						</a>
						<div> <%--나중에 cart_id값 가져와서 해야함 --%>
							<div class="item">
								<input type='checkbox'
								       name='item' 
								       value='item' onclick='getCheckedCnt()' checked='true'/>
								<div class="productQty">
									<img src="${item.imageUrl}"  width="150" height="150" alt="상품이미지" class="productImg"/>
									<br/>
									개수 :
									<input type="text" name="${status.index}" value="${cartItemsQty[status.index]}" style="text-align:center; width:50px;"/>
								</div>
									<span class="productName">
										<c:out value="${item.itemName}" />
									</span>
									<span class="productPrice">
										<fmt:formatNumber value="${cartItemsPrice[status.index]}" pattern="#,###"/>원
									</span>
									<br/>
							</div>
						</div>
						<br />
					</td>
				</tr>
			</c:forEach>
		</table>
	<div class="bottom">
	  <div>
	  	<button type="submit" class="btn btn-light order updateBtn">카트 업데이트</button>
	  </div>
</form>	
	 <br/>
		<div class="spacing">
			<fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원 + 배송비 무료 = <fmt:formatNumber value="${totalPrice}" pattern="#,###"/>원
		</div>
		<br /><br />
		<a href='<c:url value="/cart/order"/>'>
			<button type="button" class="btn btn-light order orderBtn">주문하기</button>
		</a>
		<br /><br />
	</div>
</div>