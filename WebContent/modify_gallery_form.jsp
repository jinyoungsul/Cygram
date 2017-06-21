<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#addFile').click(function(){
		var inputElement ='<p>사진 : ';
		inputElement += '<input type="file"a name="photoList">';
		inputElement += '<a href="#" class="btn" name="delete">삭제</a><p>';
		$("#fileDiv").append(inputElement);
		$('a[name=delete]').click(function(){
			$(this).parent().remove();
		})
	})
	$('a[name=delete]').click(function(){
		$(this).parent().remove();
	})
		$('#refresh').click(function(){
		history.go(-1);
	})
})
</script>
<title>사진첩 게시글 수정 화면</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
div#modify_gallery {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>
<Button id="refresh">홈</Button>
<div id="modify_gallery">
	<form action="modifyGallery.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>글번호:</td>
				<td><input type="text" value="${gallery.galleryNo}" name="galleryNo" readonly="readonly"></td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" value="${gallery.title}" name="title"></td>
			</tr>
			
			<tr>
				<td>내용:</td>
				<td><textarea cols="20" rows="5" name="content">${gallery.content}</textarea></td>
			</tr>
		
			<tr>
				<td>작성권한:</td>
				<td><input type="text" name="authorityCode" value="${gallery.authorityCode}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
			<div id="fileDiv">
				<c:forEach var="galleryImg" items="${gallery.galleryImgList }">
						
						<p>${galleryImg.originalFileName }
						<input type="hidden" name="galleryImgNo" value="${galleryImg.galleryImgNo }">
						사진 : <input type="file" id="file" name="photoList"> <a
						href="#this" class="btn" id="delete" name="delete">삭제</a></p>
				</c:forEach>
			</div>
			<input type="hidden" name="id" value="${sessionScope.loginId}">
	</form>
	
	<a href="#" class="btn" id="addFile">파일추가</a><br>
	<a href="galleryList.do?id=${sessionScope.loginId}">[사진첩 화면으로]</a>
	</div>
</body>
</html>