<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
$(function(){
	$('#refresh').click(function(){
// 		location.reload(true);
// 		location.href = location.href;
		history.go(-1);
	})
})
</script>
<title>프로필 글 읽기 화면</title>
<style type="text/css">
body {
	background-image: url("img/background2.png");
}

div#list {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>
<Button id="refresh">홈</Button>
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

		<a href="writeProfileForm.do?id=${sessionScope.loginId}">[프로필
			작성하기]</a><br> <a
			href="modifyProfileForm.do?id=${sessionScope.loginId}">[프로필 수정하기]</a>

	</div>
</body>
</html>