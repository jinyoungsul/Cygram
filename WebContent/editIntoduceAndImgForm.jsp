<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="homepageIntroduceAndImgUpdate.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${sessionScope.loginId}">
	소개글 <br><textarea cols="20" rows="5" name="introduce"></textarea>
	<input type="hidden" name="name" value="jysul8230">
	<div>이미지 <input type="file" name="minihomepage_img" ></div>
	<input type="submit" value="수정">
</form>
</body>
</html>