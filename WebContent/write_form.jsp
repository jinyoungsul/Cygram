<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾��� ȭ��</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$('#addFile').click(function(){
		var inputElement ='<p>���� : ';
		inputElement += '<input type="file"a name="photoList">';
		inputElement += '<a href="#" class="btn" name="delete">����</a><p>';
		$("#fileDiv").append(inputElement);
		$('a[name=delete]').click(function(){
			$(this).parent().remove();
		})
	})
	$('a[name=delete]').click(function(){
		$(this).parent().remove();
	})
})
</script>

</head>
<body>
	<form action="write.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>����:</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>�ۼ���:</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><textarea cols="20" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td>�ۼ�����:</td>
				<td><input type="text" name="authorityCode"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�ۼ��Ϸ�"></td>
			</tr>
		</table>
		<div id="fileDiv">
			<p>
				���� : <input type="file" id="file" name="photoList"> <a
					href="#this" class="btn" id="delete" name="delete">����</a>
			</p>
		</div>
	</form>
	<a href="#" class="btn" id="addFile">�����߰�</a>
</body>
</html>