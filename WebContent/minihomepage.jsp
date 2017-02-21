<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/date.format.js"></script>
<script>
$(function(){
	
	$('#refresh').click(function(){
		location.reload(true);
// 		location.href = location.href;
// 		history.go(-1);
	})
	
	$('#goFriend').click(function(){
		window.open('friendsPlusForm.do?myId='+$('#myId').val()+'&friendId='+$('#friendId').val(),"","width=1050, height=350,top=250,left=200");
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
		loadFriendsSay();	
	})
	function loadFriendsSay(){
		$.ajax({
			url : "friendsCommentUpdate.do",
			method : "post",
			data : {
					content : $('#friendsCotent').val(),
					myId : $('#myId').val(),
					friendId : $('#friendId').val()
					
			},
			success : function(data){
				$('#friendsSayList').empty();
				$.each(data,function(index,value){
					var friendComment = value;
					var JsonDate = "/Date("+friendComment.writeDate+")/";
					var date = new Date(parseInt(JsonDate.substr(6)));
					var writeDate = date.format("yyyy/mm/dd h:MM:ss");
					var result = "<p>"+friendComment.myId+" ("+friendComment.friend.myNickname+") "+friendComment.content+" "+writeDate+"</p>";
					$('#friendsSayList').append(result);
				})
			},
			error : function(){
				alert('error');
			}
		})
	}
	loadFriendsSay();
})
	
</script>
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url("img/background.PNG");
}

div#title1{
margin-left:30px;

}

div#title2{
margin-left:60px;


}

div#profile{
margin-left: 680px;
margin-top: 45px;

}

div#diary{
margin-left: 680px;
margin-top: 10px;

}

div#gallery{
margin-left: 680px;
margin-top: -140px;

}

div#visitor{
margin-left: 680px;
margin-top: 158px;

}


</style>
</head>
<body>
<Button id="refresh">홈</Button>
<div id="title1">
<img src="${miniHomepage.minihomepage_img_path }" width="50" height="50">
${miniHomepage.id }<br>
TODAY ${miniHomepage.today } / TOTAL ${miniHomepage.total }<br> 

타이틀 : <input type="text" name="title" id="title" style="border:none;" value="${miniHomepage.title }" readonly>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editTitle">수정</a>
	<a href="#" id="editTitleOk" style="display:none;">수정완료</a>
</c:if>
<br>

</div>

<div id="profile">
	<a href="readProfile.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="diary">
	<a href="diaryList.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="visitor">
	<a href="visitorList.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="gallery">
	<a href="galleryList.do?id=${miniHomepage.id}">____</a>
	</div>

<br>

<div id="title2">

소개글 : ${miniHomepage.introduce }<br>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editIntoduceAndImg">수정</a>
</c:if>
</div>

<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<c:if test="${empty friend}">
		<a href="#" id="goFriend">일촌신청</a>
	</c:if>
</c:if>
<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<p>Friends Say : <input type="text" id="friendsCotent" placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!"><a href="#" id="friendsCommentBtn">확인</a></p>
</c:if>

<div id='friendsSayList'>

</div>
<input type="hidden" id="myId" value="${sessionScope.loginId}">
<input type="hidden" id="friendId" value="${miniHomepage.id}">
</body>
</html>