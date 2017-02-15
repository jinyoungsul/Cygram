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
})
</script>
<title>Insert title here</title>
</head>
<body>
<img src="${miniHomepage.minihomepage_img_path}" width="50" height="50">
${miniHomepage.id }<br>
TODAY ${miniHomepage.today } / TOTAL ${miniHomepage.total }<br> 

타이틀 : ${miniHomepage.title }<br>
소개글 : ${miniHomepage.introduce }<br>

<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<input type="hidden" id="myId" value="${sessionScope.loginId}">
	<input type="hidden" id="friendId" value="${miniHomepage.id}">
	<a href="#" id="goFriend">일촌신청</a>
</c:if>
</body>
</html>