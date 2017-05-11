<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="musicUpload.do" method="post" enctype="multipart/form-data">
	<label for="musicName">음악 타이틀</label>
	<input type="text" id="musicName" name="musicName"/><br>
	<label for="artist">아티스트</label>
	<input type="text" id="artist" name="artist"/><br>
	<label for="albumImg">앨범 이미지</label>
	<input type="file" id="albumImg" name="albumImg"/><br>
	<label for="musicFile">음악 파일</label>
	<input type="file" id="musicFile" name="musicFile"/><br>
	<input type="submit" value="업로드">
</form>
</body>
</html>