<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />

<%--위시 리스트 창 --%>
<div class="content">
   <h5>위시 리스트</h5><br/>
   <hr>
   <p class="wish">상품</p>
   <table>
      <tr>
         <c:forEach var="wishItem" items="${wishItemsInfo}" varStatus="status">   
         <td>
            <div class="item">
               <div>
                  <a href="${contextPath}/wish/deleteWish?item_id=${wishItem.item_id}">
                     <button type="button" class="wishImg">
                        <img src="${contextPath}/resources/images/wished.png" name="wishImg" width="20" height="20" alt="찜" /> 
                     </button>
                  </a>
               </div>
               
               <a href="${contextPath}/item/itemDetail?item_id=${wishItem.item_id}">
                  <img src="${wishItem.imageUrl}"  width="150" height="150" alt="상품이미지" class="productImg"/>
                  <br/><br/>
                  <span class="productName"><c:out value="${wishItem.itemName}"/></span>
                  <br/>
                  <span class="productPrice"><fmt:formatNumber value="${wishItem.price}" pattern="#,###"/></span>
               </a>
               </div>
            </td>
            <c:if test="${status.count % 3 == 0}">
               <c:out value="</tr><tr>" escapeXml="false"/>
            </c:if>
         </c:forEach>
      </tr>
   </table>
</div>