<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>���̾ ����Ʈ</title>
<style type="text/css">
body {
	background-image: url("img/background2.png");
}

div#list {
	margin-left: 250px;
	margin-top: 120px;
}

div#commentDiaryList {
	margin-left: 10px;
	margin-top: 10px;
}

/*  ------------ �Խ��� ���� ��Ÿ�� ���� ------------ */
.bbs_form {
	margin: 0;
}

.bbs_linei {
	background-color: #D6D2C7;
	height: 1px;
}

//
�Խ��� �� ���� �ٲٱ�
.bbs_lineo {
	background-color: #FFFFFF;
	height: 10px;
}

//
�Խ��� �� ���� �ٲٱ�
.bbs_no {
	background-color: blue;
	height: 30px;
}

//
�Խ��� ���� �۾�
.bbs_fs {
	color: gray;
	font-size: 11px;
}

//
�Խ��� ��¥

.bbs_ft {
	font-size: 9pt;
	width: 100%;
	font-family: "����", "����", "seoul", "verdana", "arial";
	background-color: #FFFFFF;
	color: #000000;
	border: 1 solid cccccc;
	color: #000000;
	overflow: auto
}

.bbs_tt {
	CURSOR: pointer;
}

.num {
	color: 333333;
	margin-right: 10;
	font-family: tahoma;
	font-size: 7pt;
}

.name {
	color: #000000;
	text-decoration: none font-size:7pt;
}

.date {
	color: #aaaaaa;
	font-family: tahoma;
	font-size: 7pt;
}

.c_name {
	color: #aaaaaa;
	text-decoration: none font-size:8pt;
}

.c_date {
	color: #aaaaaa;
	font-family: tahoma;
	font-size: 7pt;
}

a.bbs:link, a.bbs:visited, a.bbs:active {
	text-decoration: none;
}

a.bbs:hover {
	text-decoration: none;
	color: #3366cc;
}

.comment {
	font-family: tahoma;
	font-size: 9pt;
}

.edit {
	font-family: tahoma;
	font-size: 8pt;
}

.delete {
	font-family: tahoma;
	font-size: 8pt;
}
textarea {
	font-size: 9pt;
	width: 100%;
	font-family: "����", "����", "seoul", "verdana", "arial";
	background-color: #FFFFFF;
	color: #000000;
	border: 1 solid cccccc;
	color: #000000;
	overflow: auto
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/date.format.js"></script>
<script type="text/javascript">
//��۾��� ��ư
	$(document).ready(function(){
		
		$(document).on('click','#btnCommentDiary',function(){
			var diaryNo=$(this).val();
			loadCommentList(diaryNo);	
		});	
		
		function loadCommentList(diaryNo){
			var diaryNo=diaryNo;
			var content = $('#save_content'+diaryNo).val();
			var myId = $('#myId').val();
			alert(content);
			$.ajax({
				url :"writeCommentDiary.do",
				type : "post",
				data : {
					"diaryNo" : diaryNo,
					"content" : content,
					"myId" : myId
				},
				success : function(data){
					$('#commentList'+diaryNo).empty();
					$.each(data,function(index,value){
						var commentDiary = value;
						var JsonDate = "/Date("+commentDiary.writeDate+")/";
						var date = new Date(parseInt(JsonDate.substr(6)));
						var writeDate = date.format("yyyy/mm/dd h:MM:ss");						
						var result = '<tr><td id="commentParentText" colspan="6" style="padding-left : 5px; white-space: nowrap; class="c_name">'+myId+'&nbsp;'+':'+'&nbsp;'+
					        '<span class="comment">'+content+'</span>'+ '&nbsp;'+'<span class="c_date">'+writeDate+'</span>'+'&nbsp;</td></tr>'
					   
	 				 	$('#commentList'+diaryNo).append(result);
					        
					//���̺��� tr�ڽ��� ������ tr �ڿ� ���δ�. ������ ���̺� �ȿ� tr�� ���δ�.
// 					if($('#commentParentText').contents().size()==0){
// 					 $('#commentParentText').append(result);
// 					}else{
// 					 $('#commentParentText span:last').after(result);
// 					}
					$("#save_comment").val("");

					})
					alert("ajax���");
				},
				error : function(){
					alert('ajax��ſ���');
				}
				
			});
		}
	})
 	
// 	$(document).ready(function(){
// 		$(document).on("click","#btnComment",function(){
// 			var commentText=$("#commentText").val();
// 			var diaryNo=$(this).val();
// 			$.ajax({
// 				type:"post",
// 				url:"writeCommentDiary.do",
// 				data:{
// 					"commentText" : commentText,
// 					"diaryNo" : diaryNo

// 				},
// 				success:function(data){
// 					$('#commentDiaryList').empty();
// 					$.each(data,function(index,value){
// 						var commentDiary = value;
// 						var JsonDate = "/Date("+commentDiary.commentDate+")/";
// 						var date = new Date(parseInt(JsonDate.substr(6)));
// 						var commentDate = date.format("yyyy/mm/dd h:MM:ss");
// 						var result = "<p>"+friendComment.myId+" ("+friendComment.friend.myNickname+") "+friendComment.content+" "+writeDate+"</p>";
// 						$('#commentDiaryList').append(result);
// 					})
// 					alert("ajax���");
					
// 				},
// 				error : function(data){
// 					alert("ajax��ſ���");
// 				}
// 		});
// 	})
// 	})

</script>
</head>
<body>
	<div id="list">
		<div id='diaryList'>
			<c:choose>
				<c:when test="${empty diaryPage.diaryList}">
					<p>�Խñ��� ���� �������� �ʽ��ϴ�.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="diary" items="${diaryPage.diaryList}">
					<!-- �Խ��� ����Ʈ ���� -->
					<table width="63%" border="0" cellspacing="0" cellpadding="0">
	
					<tr><td colspan="6" class="bbs_lineo">&nbsp;</td></tr>
					<tr><td colspan="6" class="bbs_linei"></td></tr>
					
					<tr bgColor="#f1f1f1">    
					<td height="25" colspan="5" style="padding-left : 5px;">

	    			<span class=num>NO.<b>${diary.diaryNo}</b></span>&nbsp;
	    			<span class=name>${diary.id}</span>
	    			<span class=date>(${diary.writeDate})</span>&nbsp;
   				    </td>
    
<td align="right" style="padding-right:5px;">
<a href="javascript:list_box('<${diary.id}>', 'r');" class="comment" title="���">���</a>
<? if (($member[mb_id] && ($member[mb_id] == $list[$i][mb_id])) || $is_admin) { ?>
         | 
<a href="javascript:list_box('<?=$list_id?>', 'u');" class="edit">����</a> | 
<a href="javascript:if (confirm('�����Ͻðڽ��ϱ�?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}" class="delete">����</a>		
<? } ?>
</td>
</tr>

<!-- ���̾ �Խñ��� ���̴� �κ� -->
<tr style="cursor:hand; " title="Ŭ���Ͻø� ����� �� �� �ֽ��ϴ�." >
    <td colspan="6" style="padding-left : 5px; height:100px; ">
    <div>${diary.content}</div>
    </td>	
</tr>	

<!-- ����� �޾����� �� ���̴� �κ� -->
<table id="commentList${diary.diaryNo}" width="63%" border="0" cellspacing="0" cellpadding="0">
<%-- 							<tr id="commentList${diary.diaryNo}" height="50"> --%>

								<c:forEach var="commentDiary" items="${diary.commentDiaryList }">
									<tr bgColor="#f8f8f8"  >
										<td id="commentParentText" colspan="6"
											style="padding-left: 5px; white-space: nowrap;"><span
											class="c_name">${commentDiary.myId}</span>&nbsp;:&nbsp; <span
											class="comment">${commentDiary.content}</span>&nbsp; <span
											class="c_date">+${commentDiary.writeDate}+</span>&nbsp;
										</td>
									</tr>
								</c:forEach>
<!-- 							</tr> -->
</table>

							<%-- 		<span class="c_name" style="white-space: nowrap">${diary.id}</span>&nbsp;:&nbsp; --%>
<%--         <span class="comment">��� ������ ��ٸ� ��� �ɱ�? !</span> &nbsp;<span class="c_date">(${diary.writeDate})</span>&nbsp; --%>
            
            
<!-- ��� ���� ���� �κ�     -->

<%--         <a href="javascript:list_box('<?=$list_id?>', 'r');" title="�� ��ۿ� ��۴ޱ�" class="bbs"> --%>
<!--             <img src="img/btn_reply.gif" title="�� ��ۿ� ��۴ޱ�" border="0" align="absmiddle"> -->
<!--         </a> -->
        <? if (($member[mb_id] && ($member[mb_id] == $list[$i][mb_id])) || $is_admin) { ?>
<%-- 	    <a href="javascript:list_box('<?=$list_id?>', 'u');" style="padding-right:2px; "> --%>
<!-- 	        <img src="img/btn_edit.gif" title="����" border="0" align="absmiddle"> -->
<!-- 	    </a> -->
<%-- 		<a href="javascript:if (confirm('�����Ͻðڽ��ϱ�?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}"> --%>
<!-- 		    <img src="img/btn_del.gif" title="����" border="0" align="absmiddle"> -->
<!-- 		</a> -->
 


<?
    $Display = "none";
?>
<tr bgColor="#f8f8f8"> 
	<td colspan="6" class="bbs_pp">
		<img id='save_comment' style='display:<?= $Display ?>;' border="0" >
		<textarea class="bbs_ft" id="save_content${diary.diaryNo}" style="width:63%; height:40; padding:4;" placeholder="����� �ۼ��ϼ���"></textarea>
			<c:if test="${sessionScope.loginId != '' }">
			<button type="button" id="btnCommentDiary" value="${diary.diaryNo}" style="border:none; background-color:#f8f8f8"><img src="img/btn_write_comment.gif"></button>
			</c:if>
		
		
		<span id='reply_<?=$list_id?>' style='display:<?= $Display ?>; width:100%; padding:5;'></span><!-- �亯 -->
		<span id='edit_<?=$list_id?>' style='display:<?= $Display ?>; width:100%; padding:5;'></span><!-- ���� -->
	</td>
</tr>
</table>
			
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<c:forEach begin="${diaryPage.startPage}" end="${diaryPage.endPage}"
			var="i">
			<a href="diaryList.do?page=${i}&id=${sessionScope.loginId}">[${i}]</a>
		</c:forEach>

		<a href="writeDiaryForm.do?id=${sessionScope.loginId}"><button>���̾����</button></a>
	</div>
	<div id='commentDiaryList'></div>

	<input type="hidden" id="myId" value="${sessionScope.loginId}">
</body>
</html>

