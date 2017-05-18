<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
   <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->  
<meta charset="EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
$(document).on('click','#goMini',function() {
	var id = $(this).attr('value');
	var frm = document.frmPopup
	 var url    ="miniHomepage.do";
	 var name  = id;
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=950, height=600, top=130,left=180"; 
	 window.open("", name,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                            //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                            //가능합니다.
	  frm.target = name;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	  frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	  frm.method = "post";
	  frm.id.value = id;
	  frm.submit();    
})
	$(document).on('click','#cancel',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsCancel.do?friendNo="+friendNo;	
	})
	$(document).on('click','#accept',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsAccept.do?friendNo="+friendNo;		
	})
	$(document).on('click','#accept_cancel',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsCancel.do?friendNo="+friendNo;
	})
	$(document).on('click','#deleteFriend',function(){
		var friendNo = $(this).attr('value');
		var con_delete = confirm("일촌 삭제를 하시겠습니까?");
		if(con_delete == true){
// 			location.href="friendsCancel.do?friendNo="+friendNo;
			$.ajax({
				url : "friendsDelete.do",
				method : "post",
				data : {"friendNo" : friendNo},
				success : function(data){
					$('table#friendsList').empty();
					viewFriendsList();
				},
				error : function() {
					alert("error");
				}
				
			})
		} else {
			alert('취소');
		}

	})
	$(function(){
		viewFriendsList();
	})
	function viewFriendsList(){
		var id = $('#id').val();
		$.ajax({
			url : "friendsJson.do",
			method : "post",
			data : {"id" : id},
			success : function(json){
				$.each(json,function(index,value){
					var friend = value;
					var result = "<tr>";
					result += "<td><img src='" + friend.miniHomepage.minihomepage_img_path + "' width='100' heigth='100'></td>"
					result += "<td>" + friend.miniHomepage.member.name				
					result += "<br>("+friend.friendNickname+ ")</td>"
					result += "<td><button type='button' class='btn btn-default btn-lg' id='goMini' value='"+friend.friendId+"'>"
					result += "<span class='glyphicon glyphicon-home' aria-hidden='true' id='goMini' value='"+friend.friendId+"'></span> 미니홈피 </button>"
					result += "<td><Button id='deleteFriend' value='"+friend.friendNo+"'>삭제</Button></td>"
					result += "</tr>"
					
					$('table#friendsList').append(result);
						
				})
			},
			error : function() {
				alert("error");
			}
			
		})
	}
	
</script>
<title>Insert title here</title>
<style type="text/css">
  .form-signin {
 		width: 200px;
  }
  .jumbotron {
  		background-color : white;
  }
  </style>
</head>
<body>
		<input type="hidden" id="id" value="${sessionScope.loginId }">
		
		
		<form name="frmPopup">
		<input type="hidden" name="id" id="id" value="${member.id}">
		</form>
	<jsp:include page="/common/top.jsp"/>
    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <img src="/Cygram/img/main.png">
          </div>
          <div class="row">
            <div class=".col-md-4">
            <h2>보낸 일촌 신청</h2>
              <c:choose>
			<c:when test="${empty sendFriendsList}">
					
			</c:when>
			<c:otherwise>
				
					<table class="table">
						<c:forEach var="friend" items="${sendFriendsList}">
							<tr>
							<td>나 : ${friend.myId} 일촌명 : ${friend.myNickname}</td>
							<td>상대방 : ${friend.friendId} 일촌명 : ${friend.friendNickname}</td>
							<td><Button id="cancel" value="${friend.friendNo}">취소하기</Button></td>
							</tr>
						</c:forEach>
					</table>
			</c:otherwise>
		</c:choose>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class=".col-md-4">
              <h2>보낸 일촌 신청</h2>
              <c:choose>
			<c:when test="${empty receiveFriendsList}">
					
			</c:when>
			<c:otherwise>
				
					<table class="table">
						<c:forEach var="friend" items="${receiveFriendsList}">
						<tr>
							<td>나 : ${friend.myId} 일촌명 : ${friend.myNickname}</td>
							<td>상대방 : ${friend.friendId} 일촌명 : ${friend.friendNickname}</td>
							<td><Button id="accept" value="${friend.friendNo}">수락하기</Button></td>
							<td><Button id="accept_cancel" value="${friend.friendNo}">거절하기</Button></td>
						</tr>
				</c:forEach>
					</table>
			</c:otherwise>
		</c:choose>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class=".col-md-4">
               <h2>일촌 목록</h2>
              <table class="table" id="friendsList">
            	
              </table>
             
            </div><!--/.col-xs-6.col-lg-4-->
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
		
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				
			       <c:choose>
					<c:when test="${member.naver == 'T'}">
						<h3>${member.id } (${member.name }) <img src="img/naver_badge.png" width="25" height="25"></h3><br>
					</c:when>	
					<c:otherwise>
						<h3>${member.id } (${member.name })</h3><br>
					</c:otherwise>	
				   </c:choose>	
					<button type="button" class="btn btn-default btn-lg" id="goMini" value="${sessionScope.loginId }">
  						<span class="glyphicon glyphicon-home" aria-hidden="true" id="goMini"></span> 미니홈피
					</button>
					<a href="friends.do?id=${member.id }">
					<button type="button" class="btn btn-default btn-lg" >
  						<span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 일촌
					</button>
					</a>
					<a href="minihomepageSearch.do">
					<button type="button" class="btn btn-default btn-lg" >
  						<span class="glyphicon glyphicon-th-list" aria-hidden="true" ></span> 미니홈피 리스트
					</button>
					</a>
				  <br>
      			<br>
        </div><!--/.sidebar-offcanvas-->
       </div>

      <hr>
	  <jsp:include page="/common/footer.jsp"/>
    </div><!--/.container-->
		<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>