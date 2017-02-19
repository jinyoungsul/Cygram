<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>
	$(document).on('click','#cancel',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsCancel.do?friendNo="+friendNo;	
	})
	$(document).on('click','#accept',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsAccept.do?friendNo="+friendNo;		
	})
	$(document).on('click','#accept_cancel',function(){
		var friendNo = $(this).attr('value');
		location.href="friendsCancel.do?friendNo="+friendNo;
	})
	$(document).on('click','#deleteFriend',function(){
		var friendNo = $(this).attr('value');
		var con_delete = confirm("일촌 삭제를 하시겠습니까?");
		if(con_delete == true){
// 			location.href="friendsCancel.do?friendNo="+friendNo;
			$.ajax({
				url : "friendsDelete.do",
				method : "post",
				data : {"friendNo" : friendNo},
				success : function(data){
					$('table#friendsList').empty();
					viewFriendsList();
				},
				error : function() {
					alert("error");
				}
				
			})
		} else {
			alert('취소');
		}

	})
	$(function(){
		viewFriendsList();
	})
	function viewFriendsList(){
		var id = $('#id').val();
		$.ajax({
			url : "friendsJson.do",
			method : "post",
			data : {"id" : id},
			success : function(json){
				$.each(json,function(index,value){
					var friend = value;
					var result = "<tr>";
					result += "<td><img src='" + friend.miniHomepage.minihomepage_img_path + "' width='100' heigth='100'></td>"
					result += "<td>" + friend.miniHomepage.member.name				
					result += "<br>("+friend.friendNickname+ ")</td>"
					result += "<td><Button id='deleteFriend' value='"+friend.friendNo+"'>삭제</Button></td>"
					result += "</tr>"
					
					$('table#friendsList').append(result);
						
				})
			},
			error : function() {
				alert("error");
			}
			
		})
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:choose>
			<c:when test="${empty sendFriendsList}">
			<tr>
				<td colspan="5">
					게시글이 아직 존재하지 않습니다.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr><td colspan=5>내가 신청한 일촌현황</td></tr>
				<c:forEach var="friend" items="${sendFriendsList}">
					<tr>
						<td>${friend.friendNo}</td>
						<td>나 : ${friend.myId} 일촌명 : ${friend.myNickname}</td>
						<td>상대방 : ${friend.friendId} 일촌명 : ${friend.friendNickname}</td>
						<td><Button id="cancel" value="${friend.friendNo}">취소하기</Button></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty receiveFriendsList}">
			<tr>
				<td colspan="5">
					게시글이 아직 존재하지 않습니다.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr><td colspan=5>내가 받은 일촌현황</td></tr>
				<c:forEach var="friend" items="${receiveFriendsList}">
					<tr>
						<td>${friend.friendNo}</td>
						<td>나 : ${friend.myId} 일촌명 : ${friend.myNickname}</td>
						<td>상대방 : ${friend.friendId} 일촌명 : ${friend.friendNickname}</td>
						<td><Button id="accept" value="${friend.friendNo}">수락하기</Button></td>
						<td><Button id="accept_cancel" value="${friend.friendNo}">거절하기</Button></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</table>
		<table id="friendsList">
						
		</table>
		<input type="hidden" id="id" value="${sessionScope.loginId }">
</body>
</html>