<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾��� ȭ��</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var fileCount=1;
		
		$('button').click(function(){
			var inputElement ='<tr><td>���� :</td>';
			inputElement += '<td><input type="file" ';
			inputElement += 'name="photoList"></td></tr>';
			fileCount++;
			
			$('input[type="submit"]').before(inputElement);
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
				<td>
				<textarea cols="20" rows="5" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>�ۼ�����:</td>
				<td><input type="text" name="authorityCode"></td>
			</tr>
			<tr>
				<td>����:</td>
				<td><input type="file" name="photoList"></td>
			</tr>
			<tr>
				<td><button>�����߰�</button></td>
			</tr><br>
			<tr>
				<td colspan="2">
					<input type="submit" value="�ۼ��Ϸ�">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>