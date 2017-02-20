<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ���</title>
</head>
<body>



	<div id='galleryList'>
		<c:choose>
			<c:when test="${empty galleryPage.galleryList}">
					<p>�Խñ��� ���� �������� �ʽ��ϴ�.<p>
			</c:when>

			<c:otherwise>
				<c:forEach var="gallery" items="${galleryPage.galleryList}">
				<div>
						<p>${gallery.id}                            ${gallery.writeDate}</p>
						<p>${gallery.content}/<p>
							<c:forEach var="galleryImg" items="${gallery.galleryImgList}">
								<p><img src="${galleryImg.galleryPath}" width="50sp" height="50sp">/<p>
							</c:forEach>
						<p>���� ${gallery.authorityCode}</p>
				</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>	
	</div>
<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<th>�۹�ȣ</th> -->
<!-- 			<th>����</th> -->
<!-- 			<th>�ۼ���</th> -->
<!-- 			<th>�ۼ���</th> -->
<!-- 			<th>����</th> -->
<!-- 			<th>����</th> -->
<!-- 			<th>����</th> -->
<!-- 		</tr> -->

<%-- 		<c:choose> --%>
<%-- 			<c:when test="${empty galleryPage.galleryList}"> --%>
<!-- 				<tr> -->
<!-- 					<td colspan="7">�Խñ��� ���� �������� �ʽ��ϴ�.</td> -->
<!-- 				</tr> -->
<%-- 			</c:when> --%>

<%-- 			<c:otherwise> --%>
<%-- 				<c:forEach var="gallery" items="${galleryPage.galleryList}"> --%>
<!-- 					<tr> -->
<%-- 						<td>${gallery.galleryNo}</td> --%>
<%-- 						<td><a href="read.do?galleryNo=${gallery.galleryNo}"> --%>
<%-- 								${gallery.title} </a></td> --%>
<%-- 						<td>${gallery.id}</td> --%>
<%-- 						<td>${gallery.writeDate}</td> --%>
<%-- 						<td>${gallery.content}</td> --%>
<!-- 						<td> -->
<%-- 							<c:forEach var="galleryImg" items="${gallery.photoList}"> --%>
<%-- 								<img src="${gallery.galleryPath}" width="50sp" height="50sp"> --%>
<%-- 							</c:forEach> --%>
<!-- 						</td> -->
<%-- 						<td>${gallery.authorityCode}</td> --%>
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<%-- 			</c:otherwise> --%>
<%-- 		</c:choose> --%>

		<c:forEach begin="${galleryPage.startPage}" end="${galleryPage.endPage}" var="i">
			<a href="galleryList.do?page=${i}">[${i}]</a>
		</c:forEach>

<a href="writeForm.do"><button>�۾���</button></a>


</body>
</html>