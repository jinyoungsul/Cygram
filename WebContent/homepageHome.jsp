<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/date.format.js"></script>
<script>
</script>
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>

갤러리 ${contentCountMap.newGalleryCount } <c:if test="${contentCountMap.newGalleryCount >0 }"><img src="img/new.jpg" width="10" height="10"></c:if>  / ${contentCountMap.totalGalleryCount }
다이어리 ${contentCountMap.newDiaryCount } <c:if test="${contentCountMap.newDiaryCount >0 }"><img src="img/new.jpg" width="10" height="10"></c:if> / ${contentCountMap.totalDiaryCount }

<!-- 미니홈페이지 이동 시작 -->
<form name="frmPopup">
	<input type="hidden" name="id">
</form>
<!-- 미니홈페이지 이동 끝 -->

<input type="hidden" id="myId" value="${sessionScope.loginId}">
<input type="hidden" id="friendId" value="${miniHomepage.id}">
</body>
</html>