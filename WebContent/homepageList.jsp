<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script type="text/javascript">
$(document).on('click','#goMini',function() {
	var id = $(this).attr('value');
	var frm = document.frmPopup
	 var url    ="miniHomepage.do";
	 var title  = 'minihomepage';
	 var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=300, top=0,left=20"; 
	 window.open("", title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
	                                            //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
	                                            //가능합니다.
	  frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
	  frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
	  frm.method = "post";
	  frm.id.value = id;
	  frm.submit();    
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
					<td>
						<Button id="goMini" value="${homepage.member.id}">미니홈피</Button>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<form name="frmPopup">
	<input type="hidden" name="id" id="id" >
</form>
</body>
</html>