<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>naver_success</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(function(){
		$('#naverJoinForm').attr('action','naverJoin.do').submit();
	})
</script>
</head>
<body>


<form id="naverJoinForm" action="naverJoin.do" method="post">
	<input type="hidden" name="id" value="${email }"><br>
	<input type="hidden" name="name" value="${name }"><br>
	<input type="hidden" name="naver" value="T"><br>
</form>
</body>
</html>