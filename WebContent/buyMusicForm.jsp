<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
$(function(){
	$("#buyMusicBtn").click(function(){
		location.href="buyMusic.do?musicNo="+$(this).val();
	})
})
</script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty music }">
		<h1>음악이 없다</h1>
	</c:when>
	<c:otherwise>
		
			<div>
				${music.musicName } ${music.artist } <img src="${music.albumImgPath }" width="100" height="100"> <audio controls><source src="${music.musicFilePath }"></audio> 
			</div>
			<div>이 음악을 정말 구매하시겠습니까?</div>
			<div><Button id="buyMusicBtn" value="${music.musicNo }">음악구매</Button></div>
	</c:otherwise>
</c:choose>

</body>
</html>