<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
</script>
<title>프로필 글 읽기 화면</title>
<style type="text/css">
</style>
</head>
<body>
	<div id="list">
		<table>
			<tr>
				<td>제목:</td>
				<td>${profile.title}</td>
			</tr>
			<tr>
				<td>작성자:</td>
				<td>${profile.id}</td>
			</tr>
			<tr>
				<td>작성일:</td>
				<td>${profile.writeDate}</td>
			</tr>
			<tr>
				<td>내용:</td>
				<td>${profile.content}</td>
			</tr>
		</table>
		<a href="modifyProfileForm.do?id=${sessionScope.loginId}">[프로필 수정하기]</a>

	</div>
</body>
</html>