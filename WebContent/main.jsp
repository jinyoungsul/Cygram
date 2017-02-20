<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#goMini').click(function(){
// 		window.open('miniHomepage.do?id='+$('#id').val(),"","width=1400, height=1300");
		 var frm = document.frmPopup; 
		 var url    ="miniHomepage.do";
		 var title  = 'minihomepage';
  	     var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=1400, height=1300, top=0,left=20"; 
		 window.open("", title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
		                                            //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
		                                            //가능합니다.
		  frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
		  frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
		  frm.method = "post";
		  frm.id.value = $('#id').val();
		  frm.submit();     
	})
})
</script>
<title>Insert title here</title>
</head>
<body>

	로그인 보여주는 화면<br>
	<c:choose>
		<c:when test="${member.naver == 'T'}">
			<img src="img/naver_badge.png" width="15" height="15">
		</c:when>
	</c:choose>
		${member.id }<br>
		${member.name }<br>
	
	<form name="frmPopup">
		<input type="hidden" name="id" id="id" value="${member.id}">
	</form>
	<a href="#" id="goMini">미니홈피</a>
	<a href="friends.do?id=${member.id }">일촌</a> 
	<a href="minihomepageSearch.do">미니홈피 리스트</a>
</body>
</html>