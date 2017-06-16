<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>다이어리 게시글 수정 화면</title>
<style type="text/css">
body{
background-image: url("img/background2.png");
}
div#modify_diary {
	margin-left: 270px;
	margin-top: 120px;
}
</style>
</head>
<body>
<Button id="refresh">홈</Button>
<div id="modify_diary">
	<form action="modifyDiary.do" method="post" >
		<table border="1">
			<tr>
				<td>글번호:</td>
				<td><input type="text" value="${diary.diaryNo}" name="diaryNo" readonly="readonly"></td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" value="${diary.title}" name="title"></td>
			</tr>
			
			<tr>
				<td>내용:</td>
				<td><textarea cols="20" rows="5" name="content">${diary.content}</textarea></td>
			</tr>
			<tr>
				<td>작성권한:</td>
				<td><input type="text" name="authorityCode" value="${diary.authorityCode}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
			<input type="hidden" name="id" value="${sessionScope.loginId}">
	</form>
	
	<a href="diaryList.do?id=${sessionScope.loginId}">[다이어리 화면으로]</a>
	</div>
</body>
</html>