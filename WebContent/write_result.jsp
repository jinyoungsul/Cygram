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
<title>글쓰기 완료</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
</style>
</head>
<body>
<Button id="refresh">홈</Button>
<h2>글쓰기를 완료하였습니다.</h2>
	<a href="galleryList.do">[게시판으로]</a>
	<a href="read.do?galleryNo=${gallery_No}"> 
		[내가 쓴 글 확인하기] 
	</a>
</body>
</html>