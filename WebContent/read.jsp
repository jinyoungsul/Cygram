<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� �б� ȭ��</title>
</head>
<body>
<table>
	<tr>
		<td>����:</td>
		<td>${gallery.title}</td>
	</tr>
	<tr>
		<td>�ۼ���:</td>
		<td>${gallery.id}</td>
	</tr>
	<tr>
		<td>�ۼ�����:</td>
		<td>${gallery.authorityCode}</td>
	</tr>
	<tr>
		<td>�ۼ���:</td>
		<td>${gallery.writeDate}</td>
	</tr>
	<tr>
		<td>����:</td>
		<td>${gallery.content}</td>
	</tr>
		<tr>
		<td>����:</td>
		<td>
		${gallery.galleryPath}</td>
	</tr>
</table>
<a href="galleryList.do">[�������]</a>
</body>
</html>