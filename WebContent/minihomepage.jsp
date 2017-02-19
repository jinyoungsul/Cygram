<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
$(function(){
	
	$('#goFriend').click(function(){
		window.open('friendsPlusForm.do?myId='+$('#myId').val()+'&friendId='+$('#friendId').val(),"","width=400, height=300");
	})
	$('#editTitle').click(function(){
		alert('수정 클릭');
		$('#title').attr("readonly" ,false);
		$('#editTitleOk').show();
	})
	$('#editIntoduceAndImg').click(function(){
		alert('메인사진, 소개글 수정 클릭');
		 var status = "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=300, top=0,left=20";
		 var popup = window.open('editIntoduceAndImgForm.do','editIntoduceAndImg',status);
	})
	
	$('#editTitleOk').click(function(){
		$.ajax({
			url : "homepageTitleUpdate.do",
			method : "post",
			data : {"title" : $('#title').val(),
					"id" : 	$('#myId').val()
			},
			success : function(data){
				$('#title').attr("readonly" ,true);
				$('#editTitleOk').hide();
			},
			error : function() {
				alert("error");
			}
			
		})
	})
	$('#friendsCommentBtn').click(function(){
		$.ajax({
			url : "friendsCommentUpdate.do",
			method : "post",
			data : {
					content : $('#friendsCotent').val(),
					myId : $('#myId').val(),
					friendId : $('#friendId').val()
					
			},
			success : function(data){
				$.each(data,function(index,value){
					var friendComment = value;
					var result = "<p>"+friendComment.myId+" ("+friendComment.friend.myNickname+") "+friendComment.content+" "+friendComment.writeDate+"</p>";
					$('#friendsSayList').prepend(result);
				})
			},
			error : function(){
				alert('error');
			}
		})
	})
	
})
	
</script>
<title>Insert title here</title>
</head>
<body>
<img src="${miniHomepage.minihomepage_img_path}" width="50" height="50">
${miniHomepage.id }<br>
TODAY ${miniHomepage.today } / TOTAL ${miniHomepage.total }<br> 

타이틀 : <input type="text" name="title" id="title" style="border:none;" value="${miniHomepage.title }" readonly>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editTitle">수정</a>
	<a href="#" id="editTitleOk" style="display:none;">수정완료</a>
</c:if>
<br>
소개글 : ${miniHomepage.introduce }<br>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editIntoduceAndImg">수정</a>
</c:if>
<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<c:if test="${empty friend}">
		<a href="#" id="goFriend">일촌신청</a>
	</c:if>
</c:if>
<p>Friends Say : <input type="text" id="friendsCotent" placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!"><a href="#" id="friendsCommentBtn">확인</a></p>
<div id='friendsSayList'>

</div>
<input type="hidden" id="myId" value="${sessionScope.loginId}">
<input type="hidden" id="friendId" value="${miniHomepage.id}">
</body>
</html>