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
<title>�۾��� �Ϸ�</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}

div#result{
margin-left: 280px;
margin-top: 120px;
}
</style>
</head>
<body>
<div id="result">
<Button id="refresh">Ȩ</Button>
<h2>�۾��⸦ �Ϸ��Ͽ����ϴ�.</h2>
<%
response.sendRedirect("gallery_list.jsp?galleryNo=${gallery_No}");
%>

<!-- 	<a href="galleryList.do">[�Խ�������]</a> -->
<%-- 	<a href="read.do?galleryNo=${gallery_No}">  --%>
<!-- 		[���� �� �� Ȯ���ϱ�]  -->
<!-- 	</a> -->
	</div>
</body>
</html>