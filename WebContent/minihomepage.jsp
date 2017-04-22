<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="js/date.format.js"></script>
<script>
$(function(){
	
	$('#refresh').click(function(){
		location.reload(true);
// 		location.href = location.href;
// 		history.go(-1);
	})
	
	$('#goFriend').click(function(){
		window.open('friendsPlusForm.do?myId='+$('#myId').val()+'&friendId='+$('#friendId').val(),"","width=1050, height=350,top=250,left=200");
	})
	$('#editTitle').click(function(){
		$('#title').attr("readonly" ,false);
		$('#editTitleOk').show();
	})
	$('#editIntoduceAndImg').click(function(){
		 var status = "toolbar=no,scrollbars=no,resizable=no,status=no,menubar=no,width=400, height=300, top=0,left=20";
		 var popup = window.open('editIntoduceAndImgForm.do','editIntoduceAndImg',status);
	})
	
	$('#editTitleOk').click(function(){
		$.ajax({
			url : "homepageTitleUpdate.do",
			method : "post",
			data : {"title" : $('#title').val(),
					"id" : 	$('#myId').val()
			},
			success : function(data){
				$('#title').attr("readonly" ,true);
				$('#editTitleOk').hide();
			},
			error : function() {
				alert("error");
			}
			
		})
	})
	$('#friendsCommentBtn').click(function(){
		loadFriendsSay();	
	})
	function loadFriendsSay(){
		$.ajax({
			url : "friendsCommentUpdate.do",
			method : "post",
			data : {
					content : $('#friendsCotent').val(),
					myId : $('#myId').val(),
					friendId : $('#friendId').val()
					
			},
			success : function(data){
				$('#friendsSayList').empty();
				$.each(data,function(index,value){
					var friendComment = value;
					var JsonDate = "/Date("+friendComment.writeDate+")/";
					var date = new Date(parseInt(JsonDate.substr(6)));
					var writeDate = date.format("yyyy/mm/dd h:MM:ss");
					var result = "<p>"+friendComment.myId+" ("+friendComment.friend.myNickname+") "+friendComment.content+" "+writeDate+"</p>";
					$('#friendsSayList').append(result);
				})
			},
			error : function(){
				alert('error');
			}
		})
	}
	loadFriendsSay();
	
	//파도타기 시작
	$("select").on("change",function(){
		var id = $(this).val();
		var frm = document.frmPopup;
		var url    = "miniHomepage.do";
		var name  = id;
		var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=950, height=600, top=130,left=180";
		window.open("",id,status);
		frm.target = name;
		frm.action = url;
		frm.method = "POST";
		frm.id.value = id;
		frm.submit();
	})
	//파도타기 끝
	
	//bgm 시작
	init();
	function init(){
	    var current = 0;
	    var audio = $('#audio');
	    var playlist = $('#playlist');
	    var tracks = playlist.find('li a');
	    var len = tracks.length - 1;
	    audio[0].volume = 0.5;
	    audio[0].src = $(playlist.find('a')[0]).attr('href');
	    audio[0].play();
	    playlist.find('a').click(function(e){
	        e.preventDefault();
	        link = $(this);
	        current = link.parent().index();
	        run(link, audio[0]);
	    });
	    audio[0].addEventListener('ended',function(e){
	        //len = 마지막 음악 리스트 인덱스
	    	if(current == len){
	            current = 0;
	            link = playlist.find('a')[0];
	        }else{
	        	current++;
	            link = playlist.find('a')[current];    
	        }
	        run($(link),audio[0]);
	    });
	}
	function run(link, player){
	        player.src = link.attr('href');
	        par = link.parent();
	        par.addClass('active').siblings().removeClass('active');
	        player.load();
	        player.play();
	}
	//bgm 끝
})
	
</script>
<title>Insert title here</title>
<style type="text/css">
body{
background-image: url("img/background.PNG");
}

div#title1{
margin-left:30px;

}

div#title2{
margin-left:60px;


}

div#profile{
margin-left: 710px;
margin-top: 20px;

}

div#diary{
margin-left: 710px;
margin-top: 10px;

}

div#gallery{
margin-left: 710px;
margin-top: -140px;

}

div#visitor{
margin-left: 710px;
margin-top: 158px;

}

div#friendsSayList{ 
 margin-left: 280px; 
margin-top: 120px; 

 } 

#playlist,audio{background:#666;width:400px;padding:20px;}
.active a{color:#5DB0E6;text-decoration:none;}
li a{color:#eeeedd;background:#333;padding:5px;display:block;}
li a:hover{text-decoration:none;}
ul#playlist {
	list-style-type: none;
}

</style>
</head>
<body>
<Button id="refresh">홈</Button>

<img src="${miniHomepage.minihomepage_img_path }" width="50" height="50">

<div id="title1">
${miniHomepage.id }<br>
TODAY ${miniHomepage.today } / TOTAL ${miniHomepage.total }<br> 

타이틀 : <input type="text" name="title" id="title" style="border:none;" value="${miniHomepage.title }" readonly>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editTitle">수정</a>
	<a href="#" id="editTitleOk" style="display:none;">수정완료</a>
</c:if>
<br>

</div>

<div id="profile">
	<a href="readProfile.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="diary">
	<a href="diaryList.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="visitor">
	<a href="visitorList.do?id=${miniHomepage.id}">____</a>
	</div>
	
	<div id="gallery">
	<a href="galleryList.do?id=${miniHomepage.id}">____</a>
	</div>
	<!-- 배경음악  플레이어 시작 -->
	<audio id="audio" controls >
		Your browser does not support the audio element.
	</audio>
	<!-- 배경음악 플레이어 끝 -->
	
	<!-- 배경음악 플레이 리스트-->
	<ul id="playlist">
<!--         <li class="active"> -->
<!--             <a href="music/Beethoven-MoonlightSonata.mp3"> -->
<!--                 Beethoven-MoonlightSonata.mp3 -->
<!--             </a> -->
<!--         </li> -->
<!--         <li> -->
<!--             <a href="music/Bolero.mp3"> -->
<!--                 Bolero.mp3 -->
<!--             </a> -->
<!--         </li> -->
<!--         <li> -->
<!--             <a href="music/CanoninD.mp3"> -->
<!--                 CanoninD.mp3 -->
<!--             </a> -->
<!--         </li> -->
		<c:forEach var="music" items="${bgmList }" varStatus="status" begin="0">
				<c:choose>
					<c:when test="${status.index==0 }">
						<li class="active"> 
							<a href="${music.musicFilePath}">
								${music.musicName}  ${music.artist }
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${music.musicFilePath}">
								${music.musicName}  ${music.artist }
						</a>
					</li>	
					</c:otherwise>
				</c:choose>
		</c:forEach>
    </ul>
	<!-- 배경음악 플레이 리스트 끝 -->
<br>

<div id="title2">

소개글 : ${miniHomepage.introduce }<br>
<c:if test="${sessionScope.loginId==miniHomepage.id}">
	<a href="#" id="editIntoduceAndImg">수정</a>
</c:if>
</div>

<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<c:if test="${empty friend}">
		<a href="#" id="goFriend">일촌신청</a>
	</c:if>
</c:if>
<c:if test="${sessionScope.loginId!=miniHomepage.id}">
	<p>Friends Say : <input type="text" id="friendsCotent" placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!"><a href="#" id="friendsCommentBtn">확인</a></p>
</c:if>

<!-- 일촌 파도타기 시작 -->
<div>
	<select name="friendsList">
		<option value="파도타기" selected>파도타기</option>
		<c:choose>
				<c:when test="${empty friendsList }">
				</c:when>
				
				<c:otherwise>
						<c:forEach var="friend" items="${friendsList }">
							<option value="${friend.friendId }">${friend.miniHomepage. member.name} (${friend.friendNickname})</option>
						</c:forEach>
				</c:otherwise>
		</c:choose>
	</select>	
</div>
<!-- 일촌 파도타기 끝 -->

<!-- 미니홈페이지 이동 시작 -->
<form name="frmPopup">
	<input type="hidden" name="id">
</form>
<!-- 미니홈페이지 이동 끝 -->

<div id='friendsSayList'>

</div>

<input type="hidden" id="myId" value="${sessionScope.loginId}">
<input type="hidden" id="friendId" value="${miniHomepage.id}">
</body>
</html>