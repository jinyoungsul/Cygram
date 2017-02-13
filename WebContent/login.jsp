<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${apiURL}"><img src="img/login.PNG" width="200" height="50"></a><br>
	<form action="join.do" method="post">
	이메일<input type="text" name="email"><br>
	성명<input type="text" name="name"><br>
	휴대폰번호<input type="text" name="phone"><br>
	아이디<input type="text" name="id"><br>
	비밀번호<input type="text" name="password"><br>
	<input type="hidden" name="naver" value="F">
	<input type="submit" value="가입">
	</form>
	계정이 있으신가요?
	<form action="login.do" action="post">
		아이디<input type="text" name="id"><br>
		비밀번호<input type="text" name="password">
		<input type="submit" value="로그인">
	</form>
</body>
</html>