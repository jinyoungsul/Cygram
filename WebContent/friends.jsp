<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty sendFriendsList}">
			<tr>
				<td colspan="5">
					게시글이 아직 존재하지 않습니다.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="friend" items="${sendFriendsList}">
					<tr>
						<td>${friend.friendNo}</td>
						<td>나 : ${friend.myId} 일촌명 : ${friend.myNickname}</td>
						<td>상대방 : ${friend.friendId} 일촌명 : ${friend.friendNickname}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>