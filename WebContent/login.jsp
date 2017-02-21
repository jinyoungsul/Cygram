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
  <title>Insert title here</title>
  <style type="text/css">
  .form-signin {
 		width: 200px;
  }
  .jumbotron {
  		background-color : white;
  }
  </style>
</head>
<body>
	
<div class="jumbotron">
	<h4>어제 담은 당신의 일상, 오늘은 선물이 되어 돌아옵니다.<img src="/Cygram/img/newlogo.png"></h4>
</div>

<nav class="navbar navbar-fixed-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          
          <a class="navbar-brand" href="index.jsp">Cygram</a>
        </div>
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

    <div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <img src="/Cygram/img/main.png">
          </div>
          <div class="row">
            <div class="col-xs-6 col-lg-4">
              <h2></h2>
              <p></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2></h2>
              <p></p>
            </div><!--/.col-xs-6.col-lg-4-->
            <div class="col-xs-6 col-lg-4">
              <h2></h2>
              <p></p>
            </div><!--/.col-xs-6.col-lg-4-->
          </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->
		
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<br>
				<br>
				<br>
				 <form class="form-signin" action="join.do" method="post">
     			   <a href="${apiURL}"><img src="img/login.PNG" width="200" height="50"></a>
     			   <label for="email" class="sr-only">이메일</label>
			       <input type="email" name="email" id="email" class="form-control" placeholder="Email address" required autofocus>
			       <label for="name" class="sr-only">성명</label>
			       <input type="text" name="name" id="name" class="form-control" placeholder="name" required autofocus>
			       <label for="phone" class="sr-only">휴대폰번호</label>
			       <input type="text" name="phone" id="phone" class="form-control" placeholder="phone" required autofocus>
			       <label for="id" class="sr-only">아이디</label>
			       <input type="text" name="id" id="id" class="form-control" placeholder="id" required>
			       <label for="password" class="sr-only">비밀번호</label>
			       <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
			       <label for="naver" class="sr-only">비밀번호</label>
			       <input type="hidden" name="naver" id="naver" class="form-control" value="F">
			       <button class="btn btn-lg btn-primary btn-block" type="submit">가입</button>
      			</form>
      			<br>
      			 
      			 <h3 class="form-signin-heading">계정이 있으신가요?</h3>
				 <form class="form-signin" action="login.do" method="post">
			       <label for="id" class="sr-only">아이디</label>
			       <input type="text" name="id" id="id" class="form-control" placeholder="id" required>
			       <label for="password" class="sr-only">아이디</label>
			       <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
			       <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      			</form>
        </div><!--/.sidebar-offcanvas-->
       </div>

      <hr>

      <footer>
        <p>&copy; Company 2017</p>
      </footer>

    </div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>