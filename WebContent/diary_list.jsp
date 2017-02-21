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
<title>���̾ ����Ʈ</title>
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
<Button id="refresh">Ȩ</Button>
<div id="list">
		<div id='diaryList'>
			<c:choose>
				<c:when test="${empty diaryPage.diaryList}">
					<p>�Խñ��� ���� �������� �ʽ��ϴ�.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="diary" items="${diaryPage.diaryList}">
						<div>
							<p>${diary.id}${diary.writeDate}</p>
							<p>${diary.content}	</p>
							<p>���� ${diary.authorityCode}</p>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
<!-- 		<tr> -->
<!-- 			<td>����:</td> -->
<%-- 			<td>${diary.title}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>�ۼ���:</td> -->
<%-- 			<td>${diary.id}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>�ۼ���:</td> -->
<%-- 			<td>${diary.writeDate}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>����:</td> -->
<%-- 			<td>${diary.content}</td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>�ۼ�����:</td> -->
<%-- 			<td>${diary.authorityCode}</td> --%>
<!-- 		</tr> -->

			<c:forEach
					begin="${diaryPage.startPage}" end="${diaryPage.endPage}" var="i">
					<a href="diaryList.do?page=${i}&id=${sessionScope.loginId}">[${i}]</a>
				</c:forEach>


		<a href="writeDiaryForm.do?id=${sessionScope.loginId}"><button>���̾����</button></a>
	</div>
</body>
</html>

