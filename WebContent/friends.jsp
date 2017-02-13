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
			<th>�۹�ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
		<c:choose>
			<c:when test="${empty sendFriendsList}">
			<tr>
				<td colspan="5">
					�Խñ��� ���� �������� �ʽ��ϴ�.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="friend" items="${sendFriendsList}">
					<tr>
						<td>${friend.friendNo}</td>
						<td>�� : ${friend.myId} ���̸� : ${friend.myNickname}</td>
						<td>���� : ${friend.friendId} ���̸� : ${friend.friendNickname}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>