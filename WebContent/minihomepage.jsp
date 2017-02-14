<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${miniHomepage.minihomepage_img_path}" width="50" height="50">
${miniHomepage.id }<br>
TODAY ${miniHomepage.today } / TOTAL ${miniHomepage.total }<br> 

타이틀 : ${miniHomepage.title }<br>
소개글 : ${miniHomepage.introduce }<br>


</body>
</html>