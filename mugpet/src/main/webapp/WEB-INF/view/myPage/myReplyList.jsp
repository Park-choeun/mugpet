<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 댓글목록</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${replyList}" var="reply">
			<tr>
				<td>${reply.rp_id}</td>
				<td>
					<a href="/board/view?bno=${reply.rp_id}">${reply.content}</a>
				</td>
				<td>
					<fmt:formatDate value="${reply.enrollDt}" pattern="yyyy-MM-dd" />				
				</td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>

</body>
</html>