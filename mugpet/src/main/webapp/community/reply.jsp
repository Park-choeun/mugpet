<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

<title>mugpet</title>
</head>
<body>
	<!-- 댓글 기능 따로 구현 후 view.jsp에 include -->
	<div class="clearfix"></div>
    <div class="col-md-12 col-sm-12">
        <div class="comment-wrapper">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong>댓글 창</strong>
                </div>
                <!-- 댓글 입력 -->
                <div class="panel-body">
                <!-- 나머지 파라미터 넘겨주기 -->
                <input type="hidden" name="com_id" value='${community.com_id}' />
                <form name="form" method="POST" action="<c:url value='/reply/insert' > <c:param name='com_id' value='${community.com_id }'/></c:url>">
             	
                	<div class="input-group" style="width: 90%;">
  						<span class="input-group-text">댓글</span>
 						<textarea name="content" class="form-control" rows="3"  placeholder="댓글을 작성해주세요" aria-label="With textarea"></textarea>
					</div>

                    <br>
                    
                    <!-- 댓글 등록 버튼 -->
                    <button type="submit" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF;" type="submit">등록</button>
                
                    </form>
                    
                    <div class="clearfix"></div>
                    <hr>
                    <ul class="media-list">
                    
                    <!-- 댓글 작성된 리스트 출력 -->
                    <c:forEach var="reply" items="${reply}">
                    
                        <li class="media">
                            <div class="media-body">
                                <span class="text-muted pull-right">
                                    <strong class="text-success"> ${reply.u_id}</strong>
                                </span>
                                <small class="text-muted"> ${reply.enrollDt}</small>
                               
								<c:if test="${sessionScope.u_id eq reply.u_id }">
								<div class="button_box" style="float: right;">								
								<a class="btn btn-danger btn-sm" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF;" href="<c:url value='/reply/delete' >
								<c:param name='rp_id' value='${reply.rp_id }' />
								</c:url>" onclick="return userRemove();">삭제</a>
								</div>
								</c:if>
                                
                                <p>
                                    ${reply.content}
                                </p>
                            
  
                      		 </div>
                        </li>
                        
                        </c:forEach>
                        
                    </ul>
                </div>
            </div>
        </div>

    </div>
  	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
  
</body>
</html>