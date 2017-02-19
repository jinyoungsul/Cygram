<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#form').submit();
	})
</script>
<title>Insert title here</title>
</head>
<body>
<form id="form" action="friends.do" method="post">
<input type="hidden" name="id" value="${sessionScope.loginId }">
</form>
</body>
</html>