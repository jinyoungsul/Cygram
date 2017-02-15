<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${friendInfo.minihomepage_img_path}"> 
${friendInfo.member.name }님께 일촌을 신청합니다.
<form action="friendsPlus.do" method="post">
	<input type="hidden" name="friendId" value="${friendInfo.id }">
	<input type="hidden" name="myId" value="${myInfo.id }">
	${friendInfo.member.name }님을 ${myInfo.member.name }님의 <input type="text" name="friendNickname">으로<br>
	${myInfo.member.name }님을 ${friendInfo.member.name }님의 <input type="text" name="myNickname">으로<br>
	<input type="submit" value="신청하기">
</form>
</body>
</html>