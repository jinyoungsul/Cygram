<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(function(){
		$(document).on("click","#buyMusicBtn",function(){
			var status = "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=300, top=0,left=20";
			window.open("buyMusicForm.do?musicNo="+$(this).val(),"buyMusicForm",status);
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty musicList }">
		<h1>음악이 없다</h1>
	</c:when>
	<c:otherwise>
		<c:forEach var="music" items="${musicList }">
			<div>
				${music.musicName } ${music.artist } <img src="${music.albumImgPath }" width="100" height="100"> <audio controls><source src="${music.musicFilePath }"></audio> <Button id="buyMusicBtn" value="${music.musicNo }">음악구매</Button>
			</div> 
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>