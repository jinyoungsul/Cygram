<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다이어리 리스트</title>
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
	font-size: 8pt;
}

.delete {
	font-family: tahoma;
	font-size: 8pt;
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
					        
					//테이블의 tr자식이 있으면 tr 뒤에 붙인다. 없으면 테이블 안에 tr을 붙인다.
// 					if($('#commentParentText').contents().size()==0){
// 					 $('#commentParentText').append(result);
// 					}else{
// 					 $('#commentParentText span:last').after(result);
// 					}
					$("#save_comment").val("");

					})
					alert("ajax통신");
				},
				error : function(){
					alert('ajax통신에러');
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
// 					alert("ajax통신");
					
// 				},
// 				error : function(data){
// 					alert("ajax통신에러");
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
					<p>게시글이 아직 존재하지 않습니다.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="diary" items="${diaryPage.diaryList}">
					<!-- 게시판 리스트 시작 -->
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
<a href="javascript:list_box('<${diary.id}>', 'r');" class="comment" title="댓글">댓글</a>
<? if (($member[mb_id] && ($member[mb_id] == $list[$i][mb_id])) || $is_admin) { ?>
         | 
<a href="javascript:list_box('<?=$list_id?>', 'u');" class="edit">수정</a> | 
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
<%--         <span class="comment">댓글 내용이 길다면 어떻게 될까? !</span> &nbsp;<span class="c_date">(${diary.writeDate})</span>&nbsp; --%>
            
            
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
			<a href="diaryList.do?page=${i}&id=${sessionScope.loginId}">[${i}]</a>
		</c:forEach>

		<a href="writeDiaryForm.do?id=${sessionScope.loginId}"><button>다이어리쓰기</button></a>
	</div>
	<div id='commentDiaryList'></div>

	<input type="hidden" id="myId" value="${sessionScope.loginId}">
</body>
</html>

