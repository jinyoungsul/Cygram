<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����ø �Խ���</title>
<style>
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
	font-size: 9pt;
}
.delete {
	font-family: tahoma;
	font-size: 9pt;
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
		
		$(document).on('click','#btnGalleryComment',function(){
			var galleryNo=$(this).val();
			loadCommentList(galleryNo);	
		});	
		
		function loadCommentList(galleryNo){
			var result = '<div id="commentList'+galleryNo+'" style="background-color :#f8f8f8;">';
			var galleryNo=galleryNo;
			var content = $('#save_content'+galleryNo).val();
			var myId = $('#myId').val();
			alert(content);
			$.ajax({
				url :"writeGalleryComment.do",
				type : "post",
				data : {
					"galleryNo" : galleryNo,
					"content" : content,
					"myId" : myId
				},
				success : function(data){
					$('#commentList'+galleryNo).remove();
					$.each(data,function(index,value){
						var galleryComment = value;
						var JsonDate = "/Date("+galleryComment.writeDate+")/";
						var date = new Date(parseInt(JsonDate.substr(6)));
						var writeDate = date.format("yyyy/mm/dd h:MM:ss");		
						
						result += '<div id="commentParentText" style="padding-left:5px; white-space:nowarp;"><span class="c_name">'+galleryComment.myId +'('+ galleryComment.member.name+')</span>&nbsp;:&nbsp';
						result += '<span class="comment">'+galleryComment.content+'</span>&nbsp;';
						result += '<span class="c_date">+'+writeDate+'+</span>&nbsp;</div>';
					})
					result += '</div>';
					$('#save_content'+galleryNo).val("");
					$('#commentListStart'+galleryNo).append(result);
				},
				error : function(){
					alert('ajax��ſ���');
				}
				
			});
		}
	})
</script>
</head>
<body>
<div>
	<div>
		<c:choose>
			<c:when test="${empty galleryPage.galleryList}">
					<p>�Խñ��� ���� �������� �ʽ��ϴ�.<p>
			</c:when>

		<c:otherwise>
			<c:forEach var="gallery" items="${galleryPage.galleryList}">
			<!-- �Խ��� ����Ʈ ���� -->
			<table width="63%" border="0" cellspacing="0" cellpadding="0">
	
			<tr><td colspan="6" class="bbs_lineo">&nbsp;</td></tr>
			<tr><td colspan="6" class="bbs_linei"></td></tr>
					
			<tr bgColor="#f1f1f1">    
			<td height="25" colspan="5" style="padding-left : 5px;">

	    	<span class=num>NO.<b>${gallery.galleryNo}</b></span>&nbsp;
	    	<span class=name>${gallery.id}</span>
	    	<span class=date>(${gallery.writeDate})</span>&nbsp;
   			</td>
    
    		<!--	�Խñ� ���� �� ����	 -->
    
			<td align="right" style="padding-right:5px;">
			<c:if test="${minihomepageId == sessionScope.loginId}">
					         
			<a href="modifyGalleryForm.do?galleryNo=${gallery.galleryNo}" class="edit">����</a> | 
			<a href="javascript:if (confirm('�����Ͻðڽ��ϱ�?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}" class="delete">����</a>		
			
			</c:if>
			</td>
			</tr>

			<!-- ���̾ �Խñ��� ���̴� �κ� -->
			<tr style="cursor:hand; " title="Ŭ���Ͻø� ����� �� �� �ֽ��ϴ�." >
			    <td colspan="6" style="padding-left : 5px; height:100px; ">
			    <div>${gallery.content}</div>
			    	<c:forEach var="galleryImg" items="${gallery.galleryImgList}">
						<img src="${galleryImg.galleryPath}" width="130sp" height="130sp">
					</c:forEach>
			    </td>	
			</tr>	

			<!-- ����� �޾����� �� ���̴� �κ� -->
			<tr>
			 	<td colspan="6">
			 		<div id="commentListStart${gallery.galleryNo }"></div>
			 		<div id="commentList${gallery.galleryNo }" style="background-color :#f8f8f8;"> 
			 			<c:forEach var="galleryComment" items="${gallery.galleryCommentList }">
			 				<div id="commentParentText" style="padding-left: 5px; white-space: nowrap;">
			 					<span class="c_name">${galleryComment.myId} (${galleryComment.member.name})</span>&nbsp;:&nbsp; 
			 					<span class="comment">${galleryComment.content}</span>&nbsp; 
			 					<span class="c_date">+${galleryComment.writeDate}+</span>&nbsp;
			 				</div>
			 			</c:forEach>
			 		</div>
			 	</td>
			</tr>

                 
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
					<textarea class="bbs_ft" id="save_content${gallery.galleryNo}" style="width:63%; height:40; padding:4;" placeholder="����� �ۼ��ϼ���"></textarea>
						<c:if test="${sessionScope.loginId != '' }">
						<button type="button" id="btnGalleryComment" value="${gallery.galleryNo}" style="border:none; background-color:#f8f8f8"><img src="img/btn_write_comment.gif"></button>
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

		<c:forEach begin="${galleryPage.startPage}" end="${galleryPage.endPage}" var="i">
			<a href="galleryList.do?page=${i}&id=${minihomepageId}">[${i}]</a>
		</c:forEach>
		
		<c:if test="${minihomepageId == sessionScope.loginId}">
  		<a href="writeForm.do?id=${sessionScope.loginId}"><button>����ø �۾���</button></a>
 		</c:if>
		
		</div>
		<input type="hidden" id="myId" value="${sessionScope.loginId}">
</body>
</html>