<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script>
	$('#refresh').click(function(){
// 		location.reload(true);
// 		location.href = location.href;
		history.go(-1);
	})
	</script>
<title>다이어리 리스트</title>
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
		<div id='visitorList'>
			<c:choose>
				<c:when test="${empty visitorPage.visitorList}">
					<p>게시글이 아직 존재하지 않습니다.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="visitor" items="${visitorPage.visitorList}">
						<div>
							<p>${visitor.myId}${visitor.writeDate}</p>
							<p>${visitor.content}	</p>
							<p>권한 ${visitor.authorityCode}</p>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
<!-- 		<tr> -->
<!-- 			<td>제목:</td> -->
<%-- 			<td>${visitor.title}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>작성자:</td> -->
<%-- 			<td>${visitor.id}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>작성일:</td> -->
<%-- 			<td>${visitor.writeDate}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>내용:</td> -->
<%-- 			<td>${visitor.content}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>작성권한:</td> -->
<%-- 			<td>${visitor.authorityCode}</td> --%>
<!-- 		</tr> -->

			<c:forEach
					begin="${visitorPage.startPage}" end="${visitorPage.endPage}" var="i">
					<a href="visitorList.do?page=${i}&id=${sessionScope.loginId}">[${i}]</a>
				</c:forEach>


		<a href="writeVisitorForm.do?id=${sessionScope.loginId}"><button>방명록 쓰기</button></a>
	</div>
</body>
</html>

