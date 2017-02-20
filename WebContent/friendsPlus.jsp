<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
   <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="friendsPlus.do" method="post" class="form-horizontal">
     <input type="hidden" name="friendId" value="${friendInfo.id }">
<input type="hidden" name="myId" value="${myInfo.id }">
	<div class="form-group">
	<label for="friendNickname" class="col-sm-2 control-label"><img src="${friendInfo.minihomepage_img_path}"></label>
    <div class="col-sm-5">
        <h3>${friendInfo.member.name }님께 일촌을 신청합니다.</h3>
    </div>
  </div>
  <div class="form-group">
    <label for="friendNickname" class="col-sm-2 control-label">${friendInfo.member.name }님을 ${myInfo.member.name }님의</label>
    <div class="col-sm-5">
      <input type="text" name="friendNickname" id="friendNickname" class="form-control" placeholder="친구 일촌명" required autofocus>
    </div>
  </div>
  <div class="form-group">
    <label for="myNickname" class="col-sm-2 control-label">${myInfo.member.name }님을 ${friendInfo.member.name }님의</label>
    <div class="col-sm-5">
      <input type="text" name="myNickname" id="myNickname" class="form-control" placeholder="일촌명" required autofocus>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">신청</button>
    </div>
  </div>
</form>


	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>