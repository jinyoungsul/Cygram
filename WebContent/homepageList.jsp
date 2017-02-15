<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).on('click','#goMini',function(){
			var id = $(this).attr('value');
			window.open('miniHomepage.do?id='+id,"","width=400, height=300");
		})
</script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty homepageList }">
		검색된 홈페이지가 없다.
	</c:when>
	<c:otherwise>
		<table>
			<tr><td colspan="4">미니홈피 리스트</td></tr>
			<c:forEach var="homepage" items="${homepageList }">
				<tr>
					<td><img src="${homepage.minihomepage_img_path}"></td>
					<td>${homepage.member.id} ${homepage.member.name }</td>
					<td>방문자수 : ${homepage.total }</td>
					<td><Button id="goMini" value="${homepage.member.id}">미니홈피</Button> </td>
					
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>