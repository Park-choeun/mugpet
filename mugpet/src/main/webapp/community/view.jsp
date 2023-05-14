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
<script>
	function userRemove(){
   		return confirm("정말 삭제하시겠습니까?");   
	}
	var myModal = document.getElementById('myModal')
	var myInput = document.getElementById('myInput')

	myModal.addEventListener('shown.bs.modal', function () {
   		myInput.focus()
	})

	$(document).on("click", ".modify", function(){
 	
 	$(".replyModal").fadeIn(200);
 
 	var repNum = $(this).attr("data-repNum");
 	var repCon = $(this).parent().parent().children(".replyContent").text();
 
 	$(".modal_repCon").val(repCon);
 	$(".modal_modify_btn").attr("data-repNum", repNum);
	});
</script>
</head>
<body>
<div>
	<%@include file="/main.jsp" %>
</div>
<div style="padding: 10px;">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	
	<h4 class="card-title" id="text1">제목:${community.title }</h4>
	
	<hr style="color:#BDBDBD; size: 2px;">
	
	<h6 style="color:#FFD1FF; font-weight: bold;">
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  	<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
	</svg>${community.u_id }</h6>
	
	<h6 style="font-weight: bold;">
	<svg enable-background="new 0 0 32 32" id="Editable-line" version="1.1" viewBox="0 0 32 32" width="16" height="16" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
	<path d="  M16,7C9.934,7,4.798,10.776,3,16c1.798,5.224,6.934,9,13,9s11.202-3.776,13-9C27.202,10.776,22.066,7,16,7z" fill="none" id="XMLID_10_" stroke="#000000" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="2"/>
	<circle cx="16" cy="16" fill="none" id="XMLID_12_" r="5" stroke="#000000" stroke-linecap="round" stroke-linejoin="round" stroke-miterlimit="10" stroke-width="2"/></svg>
	조회수: ${community.comCnt } &nbsp;
	
	<svg viewBox="0 0 32 32" width="16" height="16" xmlns="http://www.w3.org/2000/svg">
	<defs><style>.cls-1{fill:#101820;}</style></defs><title/><g data-name="Layer 54" id="Layer_54">
	<path class="cls-1" d="M16,28.72a3,3,0,0,1-2.13-.88L3.57,17.54a8.72,8.72,0,0,1-2.52-6.25,8.06,8.06,0,0,1,8.14-8A8.06,8.06,0,0,1,15,5.68l1,1,.82-.82h0a8.39,8.39,0,0,1,11-.89,8.25,8.25,0,0,1,.81,12.36L18.13,27.84A3,3,0,0,1,16,28.72ZM9.15,5.28A6.12,6.12,0,0,0,4.89,7a6,6,0,0,0-1.84,4.33A6.72,6.72,0,0,0,5,16.13l10.3,10.3a1,1,0,0,0,1.42,0L27.23,15.91A6.25,6.25,0,0,0,29,11.11a6.18,6.18,0,0,0-2.43-4.55,6.37,6.37,0,0,0-8.37.71L16.71,8.8a1,1,0,0,1-1.42,0l-1.7-1.7a6.28,6.28,0,0,0-4.4-1.82Z"/></g></svg>
	좋아요:${community.likes }</h6>
   
  	<p class="card-text">${community.content }</p>
   
   	<img width="200" src="<c:url value='/upload/${community.imageURL }'/>" class="card-img-bottom" alt=""><br>
	
	<small class="text-muted">${community.enrollDt}에 올라옴</small>
	
	<hr style="color: #BDBDBD; size: 2px;">
	<br><br>

 <!-- 세션 u_id와 community의 u_id가 같으면 글 내용 하단 버튼을 수정, 삭제로 보여줌 -->
	<c:choose>
   		<c:when test="${sessionScope.u_id eq community.u_id }">
      		<div class="button_box" style="float: left;">
      		<a class="btn btn-danger" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF;" " href="<c:url value='/community/update/form' >
                                    <c:param name='com_id' value='${community.com_id }' />
                                    </c:url>" >수정</a>
      		<a class="btn btn-danger" role="button" style="background-color: #FFD1FF; border-color: #FFD1FF;" href="<c:url value='/community/delete' >
                                    <c:param name='com_id' value='${community.com_id }' />
                                    </c:url>" onclick="return userRemove();">삭제</a>
      		</div>
   		</c:when>
   
   		<c:when test="${sessionScope.u_id ne null }">
   			<div class="button_box" style="float: left;">
      			<button type="button" class="btn btn-danger" style="background-color: #FFD1FF; border-color: #FFD1FF;" data-bs-toggle="modal" data-bs-target="#staticBackdrop2">
       				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
        			<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
      				</svg> 위시리스트 추가
      			</button>
      		</div>
   		</c:when>
	</c:choose>   

 <!-- 목록버튼 누르면 게시글 목록으로 이동 -->
   <div class="button_box" style="float: right;">
   		<a class="btn btn-light" style="border-color: #FFFF8F; background-color: #FFFF8F;"role="button" href="<c:url value='/community/list'></c:url>" >목록</a>
   </div>
   
   <br><br><br>
   
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
             	
                	<div class="input-group" style="width: 60%;">
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
                                
                                <!-- 댓글 삭제버튼 -->
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
   </div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>