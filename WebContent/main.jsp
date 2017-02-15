<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#goMini').click(function(){
		window.open('miniHomepage.do?id='+$('#id').val(),"","width=400, height=300");
	})
})
</script>
<title>Insert title here</title>
</head>
<body>

	로그인 보여주는 화면<br>
	<c:choose>
		<c:when test="${member.naver == 'T'}">
			<img src="img/naver_badge.png" width="15" height="15">
		</c:when>
	</c:choose>
		${member.id }<br>
		${member.name }<br>
	<input type="hidden" id="id" value="${member.id}">
	<a href="#" id="goMini">미니홈피</a>
	<a href="friends.do?id=${member.id }">일촌</a> 
	<a href="minihomepageSearch.do">미니홈피 리스트</a>
</body>
</html>