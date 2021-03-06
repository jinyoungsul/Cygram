<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script>
	$('#refresh').click(function(){
// 		location.reload(true);
// 		location.href = location.href;
		history.go(-1);
	})
	</script>
<title>글 읽기 화면</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
div#read {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>
<Button id="refresh">홈</Button>
<div id="read">
<table>
	<tr>
		<td>제목:</td>
		<td>${gallery.title}</td>
	</tr>
	<tr>
		<td>작성자:</td>
		<td>${gallery.id}</td>
	</tr>
	<tr>
		<td>작성권한:</td>
		<td>${gallery.authorityCode}</td>
	</tr>
	<tr>
		<td>작성일:</td>
		<td>${gallery.writeDate}</td>
	</tr>
	<tr>
		<td>내용:</td>
		<td>${gallery.content}</td>
	</tr>
		<tr>
		<td>사진:</td>
		<td>
		${gallery.photoList}</td>
	</tr>
</table>
<a href="galleryList.do">[목록으로]</a>
</div>
</body>
</html>