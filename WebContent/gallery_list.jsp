<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>내용</th>
			<th>사진</th>
			<th>권한</th>
		</tr>

		<c:choose>
			<c:when test="${empty galleryPage.galleryList}">
				<tr>
					<td colspan="7">게시글이 아직 존재하지 않습니다.</td>
				</tr>
			</c:when>

			<c:otherwise>
				<c:forEach var="gallery" items="${galleryPage.galleryList}">
					<tr>
						<td>${gallery.galleryNo}</td>
						<td><a href="read.do?galleryNo=${gallery.galleryNo}">
								${gallery.title} </a></td>
						<td>${gallery.id}</td>
						<td>${gallery.writeDate}</td>
						<td>${gallery.content}</td>
						<td>
<%-- 						<img src="${gallery.galleryPath}" width="50sp" height="50sp"> --%>
							<c:forEach var="galleryImg" items="${gallery.photoList}">
<%-- 								path:${galleryImg.galleryPath}<br> --%>
								<img src="${gallery.galleryPath}" width="50sp" height="50sp">
							</c:forEach>
						</td>
						<td>${gallery.authorityCode}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<tr>
			<td colspan="7" align="center"><c:forEach begin="${galleryPage.startPage}"
					end="${galleryPage.endPage}" var="i">
					<a href="galleryList.do?page=${i}">[${i}]</a>
				</c:forEach></td>
		</tr>
		
		<tr>
			<td colspan="7" align="center"><a href="writeForm.do"><button>글쓰기</button></a>
			</td>
		</tr>
	</table>
</body>
</html>