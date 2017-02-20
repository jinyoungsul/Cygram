<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>프로필 글 읽기 화면</title>
</head>
<body>
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
</body>
</html>