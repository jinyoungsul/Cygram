<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>게시판</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
div#list {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>

<Button id="refresh">홈</Button>
<div id="list">
	<div id='galleryList'>
		<c:choose>
			<c:when test="${empty galleryPage.galleryList}">
					<p>게시글이 아직 존재하지 않습니다.<p>
			</c:when>

			<c:otherwise>
				<c:forEach var="gallery" items="${galleryPage.galleryList}">
				<div>
						<p>${gallery.id}                            ${gallery.writeDate}</p>
						<p>${gallery.content}/<p>
							<c:forEach var="galleryImg" items="${gallery.galleryImgList}">
								<p><img src="${galleryImg.galleryPath}" width="50sp" height="50sp">/<p>
							</c:forEach>
						<p>권한 ${gallery.authorityCode}</p>
				</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>	
	</div>

		<c:forEach begin="${galleryPage.startPage}" end="${galleryPage.endPage}" var="i">
			<a href="galleryList.do?page=${i}">[${i}]</a>
		</c:forEach>

<a href="writeForm.do"><button>글쓰기</button></a>
</div>
</body>
</html>