<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script>
	$('#refresh').click(function(){
// 		location.reload(true);
// 		location.href = location.href;
		history.go(-1);
	})
	</script>
<title>방명록 글쓰기 화면</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
div#write_visitor {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>
	<Button id="refresh">홈</Button>
	<div id="write_visitor">
	<form action="writeVisitor.do" method="post" >
		<input type="hidden" name="friendId" value=${friendId }>
		<input type="hidden" name="myId" value="${sessionScope.loginId}">
		<table border="1">
			<tr>
				<td>내용:</td>
				<td><textarea cols="20" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td>작성권한:</td>
				<td><input type="text" name="authorityCode"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>
	
	<a href="visitorList.do?id=${friendId}">[방명록 화면으로]</a>
	</div>
</body>
</html>