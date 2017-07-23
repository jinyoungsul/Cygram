<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 리스트</title>
<style type="text/css">
body {
	background-image: url("img/background2.png");
}
div#list {
	margin-left: 250px;
	margin-top: 120px;
}
div#commentVisitorList {
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

.btn_del {
	background-color : #f8f8f8;
	border : none;
	outline : none;
	
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/date.format.js"></script>

<script type="text/javascript">
//댓글쓰기 버튼
	$(document).ready(function(){
		
		$(document).on('click','#btnCommentVisitor',function(){
			var visitorNo=$(this).val();
			loadVisitorList(visitorNo);	
		});	
		$(document).on('click','#deleteCommentVisitor',function(){
			var btn_val=$(this).val();
			var arr = btn_val.split("+");
			var visitorCommentNo = arr[0];
			var visitorNo = arr[1];
			deleteCommentVisitor(visitorNo,visitorCommentNo);
		})
		function loadVisitorList(visitorNo){
			var result = '<div id="commentList'+visitorNo+'" style="background-color :#f8f8f8;">';
			var visitorNo=visitorNo;
			var content = $('#save_content'+visitorNo).val();
			var myId = $('#myId').val();
			$.ajax({
				url :"writeCommentVisitor.do",
				type : "post",
				data : {
					"visitorNo" : visitorNo,
					"content" : content,
					"myId" : myId
				},
				success : function(data){
					$('#commentList'+visitorNo).remove();
					$.each(data,function(index,value){
						var commentVisitor = value;
						var JsonDate = "/Date("+commentVisitor.writeDate+")/";
						var date = new Date(parseInt(JsonDate.substr(6)));
						var writeDate = date.format("yyyy/mm/dd h:MM:ss");		
						
						result += '<div id="commentParentText" style="padding-left:5px; white-space:nowarp;"><span class="c_name">'+commentVisitor.myId +'('+ commentVisitor.member.name+')</span>&nbsp;:&nbsp';
						result += '<span class="comment">'+commentVisitor.content+'</span>&nbsp;';
						result += '<span class="c_date">+'+writeDate+'+</span>&nbsp;';
						if(myId==commentVisitor.myId){
							result += '<button id="deleteCommentVisitor" value="'+commentVisitor.visitorCommentNo+'+' +commentVisitor.visitorNo+'" class="btn_del"><img src="img/btn_del.gif"/></button></div>';
						} else {
							result += '</div>';
						}
					})
					result += '</div>';
					$('#save_content'+visitorNo).val("");
					$('#commentListStart'+visitorNo).append(result);
				},
				error : function(){
					alert('ajax통신에러');
				}
				
			});
		}
		
		function deleteCommentVisitor(visitorNo,visitorCommmentNo){
			var result = '<div id="commentList'+visitorNo+'" style="background-color :#f8f8f8;">';
			var visitorNo = visitorNo;
			var visitorCommentNo = visitorCommentNo;
			var myId = $('#myId').val();
			if(confirm("삭제 하시겠습니까?")){
				$.ajax({
					url :"deleteCommentVisitor.do",
					type : "post",
					data : {
						"visitorNo" : visitorNo,
						"visitorCommentNo" : visitorCommmentNo
					},
					success : function(data){
						$('#commentList'+visitorNo).remove();
						$.each(data,function(index,value){
							var commentVisitor = value;
							var JsonDate = "/Date("+commentVisitor.writeDate+")/";
							var date = new Date(parseInt(JsonDate.substr(6)));
							var writeDate = date.format("yyyy/mm/dd h:MM:ss");		
							
							result += '<div id="commentParentText" style="padding-left:5px; white-space:nowarp;"><span class="c_name">'+commentVisitor.myId +'('+ commentVisitor.member.name+')</span>&nbsp;:&nbsp';
							result += '<span class="comment">'+commentVisitor.content+'</span>&nbsp;';
							result += '<span class="c_date">+'+writeDate+'+</span>&nbsp;';
							if(myId==commentVisitor.myId){
								result += '<button id="deleteCommentVisitor" value="'+commentVisitor.visitorCommentNo+'+' +commentVisitor.visitorNo+'" class="btn_del"><img src="img/btn_del.gif"/></button></div>';
							} else {
								result += '</div>';
							}
						})
						result += '</div>';
						$('#commentListStart'+visitorNo).append(result);
					},
					error : function(){
						alert('ajax통신에러');
					}
					
				});
			} else {
				alert("삭제 취소되었습니다.");
				return false;
			}
		}
	})
</script>

</head>
<body>
	<div id="list">
		<div id='visitorList'>
			<c:choose>
				<c:when test="${empty visitorPage.visitorList}">
					<p>게시글이 아직 존재하지 않습니다.
					<p>
				</c:when>

				<c:otherwise>
					<c:forEach var="visitor" items="${visitorPage.visitorList}">

						<!-- 게시판 리스트 시작 -->
						<table width="63%" border="0" cellspacing="0" cellpadding="0">

							<tr>
								<td colspan="6" class="bbs_lineo">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="6" class="bbs_linei"></td>
							</tr>

							<tr bgColor="#f1f1f1">
								<td height="25" colspan="5" style="padding-left: 5px;"><span
									class=num>NO.<b>${visitor.visitorNo}</b></span>&nbsp; <span
									class=name>${visitor.id}</span> <span class=date>(${visitor.writeDate})</span>&nbsp;
								</td>
								<td align="right" style="padding-right: 5px;"><a
									href="javascript:list_box('<${visitor.id}>', 'r');"
									class="comment" title="댓글">댓글</a> <? if (($member[mb_id] && ($member[mb_id] == $list[$i][mb_id])) || $is_admin) { ?>
									| <a href="javascript:list_box('<?=$list_id?>', 'u');"
									class="edit">수정</a> | <a
									href="javascript:if (confirm('삭제하시겠습니까?')) { location='./delete.php?w=d&bo_table=<?=$bo_table?>&wr_id=<?=$list[$i][wr_id]?>&page=<?=$page?>';}"
									class="delete">삭제</a> <? } ?></td>
							</tr>

							<!-- 다이어리 게시글이 보이는 부분 -->
							<tr style="cursor: hand;" title="클릭하시면 댓글을 쓸 수 있습니다.">
								<td colspan="6" style="padding-left: 5px; height: 100px;">
									<div>${visitor.content}</div>
								</td>
							</tr>

							<!-- 댓글이 달아졌을 때 보이는 부분 -->
							<tr>
								<td colspan="6">
									<div id="commentListStart${visitor.visitorNo }"></div>
									<div id="commentList${visitor.visitorNo }"
										style="background-color: #f8f8f8;">
										<c:forEach var="commentVisitor"
											items="${visitor.visitorCommentList }">
											<div id="commentParentText"
												style="padding-left: 5px; white-space: nowrap;">
												<span class="c_name">${commentVisitor.myId}
													(${commentVisitor.member.name})</span>&nbsp;:&nbsp; <span
													class="comment">${commentVisitor.content}</span>&nbsp; <span
													class="c_date">+${commentVisitor.writeDate}+</span>&nbsp;
												<c:if test="${sessionScope.loginId==commentVisitor.myId }">
													<button id="deleteCommentVisitor" value="${commentVisitor.visitorCommentNo }+${commentVisitor.visitorNo}" class="btn_del"><img src="img/btn_del.gif"/></button>
												</c:if>
											</div>
										</c:forEach>
									</div>
								</td>
							</tr>


							<!-- 댓글 수정 삭제 부분     -->

							<tr bgColor="#f8f8f8">
								<td colspan="6" class="bbs_pp"><img id='save_comment'
									style='display:<?= $Display ?>;' border="0"> <textarea
										class="bbs_ft" id="save_content${visitor.visitorNo}"
										style="width: 63%; height: 40; padding: 4;"
										placeholder="댓글을 작성하세요"></textarea> <c:if
										test="${sessionScope.loginId != '' }">
										<button type="button" id="btnCommentVisitor"
											value="${visitor.visitorNo}"
											style="border: none; background-color: #f8f8f8">
											<img src="img/btn_write_comment.gif">
										</button>
									</c:if> <span id='reply_<?=$list_id?>'
									style='display:<?= $Display ?>; width:100%; padding:5;'></span>
								<!-- 답변 --> <span id='edit_<?=$list_id?>'
									style='display:<?= $Display ?>; width:100%; padding:5;'></span>
								<!-- 수정 --></td>
							</tr>
						</table>

					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>

		<c:forEach begin="${visitorPage.startPage}" end="${visitorPage.endPage}" var="i">
			<a href="visitorList.do?page=${i}&id=${friendId}">[${i}]</a>
		</c:forEach>

		<a href="writeVisitorForm.do?id=${friendId}"><button>방명록 쓰기</button></a>
		</div>
		<input type="hidden" id="myId" value="${sessionScope.loginId}">
</body>
</html>

