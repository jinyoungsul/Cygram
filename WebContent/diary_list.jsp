<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다이어리 리스트</title>
<style type="text/css">
/* div#list { */
/* 	margin-left: 250px; */
/* 	margin-top: 120px; */
/* } */
/* div#commentDiaryList { */
/* 	margin-left: 10px; */
/* 	margin-top: 10px; */
/* } */
/*  ------------ 게시판 관련 스타일 적용 ------------ */
.bbs_form {
	margin: 0;
}
.bbs_linei {
	background-color: #D6D2C7;
	height: 1px;
}
//
게시판 줄 색깔 바꾸기
.bbs_lineo {
	background-color: #FFFFFF;
	height: 10px;
}
//
게시판 줄 색깔 바꾸기
.bbs_no {
	background-color: blue;
	height: 30px;
}
//
게시판 내용 글씨
.bbs_fs {
	color: gray;
	font-size: 11px;
}
//
게시판 날짜
.bbs_ft {
	font-size: 9pt;
	width: 100%;
	font-family: "돋움", "굴림", "seoul", "verdana", "arial";
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
	font-family: "돋움", "굴림", "seoul", "verdana", "arial";
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
//댓글쓰기 버튼
	$(document).ready(function(){
		
		$(document).on('click','#btnCommentDiary',function(){
			var diaryNo=$(this).val();
			loadCommentList(diaryNo);	
		});	
		
		function loadCommentList(diaryNo){
			var result = '<div id="commentList'+diaryNo+'" style="background-color :#f8f8f8;">';
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
					$('#commentList'+diaryNo).remove();
					$.each(data,function(index,value){
						var commentDiary = value;
						var JsonDate = "/Date("+commentDiary.writeDate+")/";
						var date = new Date(parseInt(JsonDate.substr(6)));
						var writeDate = date.format("yyyy/mm/dd h:MM:ss");		
						
						result += '<div id="commentParentText" style="padding-left:5px; white-space:nowarp;"><span class="c_name">'+commentDiary.myId +'('+ commentDiary.member.name+')</span>&nbsp;:&nbsp';
						result += '<span class="comment">'+commentDiary.content+'</span>&nbsp;';
						result += '<span class="c_date">+'+writeDate+'+</span>&nbsp;</div>';
					})
					result += '</div>';
					$('#save_content'+diaryNo).val("");
					$('#commentListStart'+diaryNo).append(result);
				},
				error : function(){
					alert('ajax통신에러');
				}
				
			});
		}
	})
</script>
</head>
<body>
	<div id="list">
		<div id='diaryList'>
			<c:choose>
				<c:when test="${empty diaryPage.diaryList}">
					<p>게시글이 아직 존재하지 않습니다.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="diary" items="${diaryPage.diaryList}">
					<!-- 게시판 리스트 시작 -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
	
					<tr><td colspan="6" class="bbs_lineo">&nbsp;</td></tr>
					<tr><td colspan="6" class="bbs_linei"></td></tr>
					
					<tr bgColor="#f1f1f1">    
						<td height="25" colspan="5" style="padding-left : 5px;">
		    			<span class=num>NO.<b>${diary.diaryNo}</b></span>&nbsp;
						<span class=name>${diary.title}</span>
		    			<span class=date>(${diary.writeDate})</span>&nbsp;
	   				    </td>
    
						<td align="right" style="padding-right:5px;">
						<c:if test="${minihomepageId == sessionScope.loginId}">
						<a href="modifyDiaryForm.do?diaryNo=${diary.diaryNo}" class="edit">수정</a> | 
						</c:if>
						
						<a href="javascript:if (confirm('삭제하시겠습니까?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}" class="delete">삭제</a>		
						<? } ?>
						</td>
					</tr>

<!-- 다이어리 게시글이 보이는 부분 -->
<tr style="cursor:hand; " title="클릭하시면 댓글을 쓸 수 있습니다." >
    <td colspan="6" style="padding-left : 5px; height:100px; ">
    <div>${diary.content}</div>
    </td>	
</tr>	

<!-- 댓글이 달아졌을 때 보이는 부분 -->
<tr>
 	<td colspan="6">
 		<div id="commentListStart${diary.diaryNo }"></div>
 		<div id="commentList${diary.diaryNo }" style="background-color :#f8f8f8;"> 
 			<c:forEach var="commentDiary" items="${diary.commentDiaryList }">
 				<div id="commentParentText" style="padding-left: 5px; white-space: nowrap;">
 					<span class="c_name">${commentDiary.myId} (${commentDiary.member.name})</span>&nbsp;:&nbsp; 
 					<span class="comment">${commentDiary.content}</span>&nbsp; 
 					<span class="c_date">+${commentDiary.writeDate}+</span>&nbsp;
 				</div>
 			</c:forEach>
 		</div>
 	</td>
</tr>

                 
<!-- 댓글 수정 삭제 부분     -->

<%--         <a href="javascript:list_box('<?=$list_id?>', 'r');" title="이 댓글에 댓글달기" class="bbs"> --%>
<!--             <img src="img/btn_reply.gif" title="이 댓글에 댓글달기" border="0" align="absmiddle"> -->
<!--         </a> -->
        <? if (($member[mb_id] && ($member[mb_id] == $list[$i][mb_id])) || $is_admin) { ?>
<%-- 	    <a href="javascript:list_box('<?=$list_id?>', 'u');" style="padding-right:2px; "> --%>
<!-- 	        <img src="img/btn_edit.gif" title="수정" border="0" align="absmiddle"> -->
<!-- 	    </a> -->
<%-- 		<a href="javascript:if (confirm('삭제하시겠습니까?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}"> --%>
<!-- 		    <img src="img/btn_del.gif" title="삭제" border="0" align="absmiddle"> -->
<!-- 		</a> -->
 


<?
    $Display = "none";
?>
<tr bgColor="#f8f8f8"> 
	<td colspan="6" class="bbs_pp">
		<img id='save_comment' style='display:<?= $Display ?>;' border="0" >
		<textarea class="bbs_ft" id="save_content${diary.diaryNo}" style="width:63%; height:40; padding:4;" placeholder="댓글을 작성하세요"></textarea>
			<c:if test="${sessionScope.loginId != '' }">
			<button type="button" id="btnCommentDiary" value="${diary.diaryNo}" style="border:none; background-color:#f8f8f8"><img src="img/btn_write_comment.gif"></button>
			</c:if>
		
		
		<span id='reply_<?=$list_id?>' style='display:<?= $Display ?>; width:100%; padding:5;'></span><!-- 답변 -->
		<span id='edit_<?=$list_id?>' style='display:<?= $Display ?>; width:100%; padding:5;'></span><!-- 수정 -->
	</td>
</tr> 
</table>
			
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<c:forEach begin="${diaryPage.startPage}" end="${diaryPage.endPage}"
			var="i">
			
			<a href="diaryList.do?page=${i}&id=${minihomepageId}">[${i}]</a>
		</c:forEach>

		<c:if test="${minihomepageId == sessionScope.loginId}">
		<a href="writeDiaryForm.do?id=${sessionScope.loginId}"><button>다이어리쓰기</button></a>
		</c:if>
	</div>

	<input type="hidden" id="myId" value="${sessionScope.loginId}">
</body>
</html>