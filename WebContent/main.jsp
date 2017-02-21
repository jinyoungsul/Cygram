<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<script type="text/javascript">
$(function(){
	$('#goMini').click(function(){
// 		window.open('miniHomepage.do?id='+$('#id').val(),"","width=1400, height=1300");
		 var frm = document.frmPopup; 
		 var url    ="miniHomepage.do";
		 var title  = 'minihomepage';
  	     var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width=950, height=600, top=130,left=180"; 
		 window.open("", title,status); //window.open(url,title,status); window.open 함수에 url을 앞에와 같이
		                                            //인수로  넣어도 동작에는 지장이 없으나 form.action에서 적용하므로 생략
		                                            //가능합니다.
		  frm.target = title;                    //form.target 이 부분이 빠지면 form값 전송이 되지 않습니다. 
		  frm.action = url;                    //form.action 이 부분이 빠지면 action값을 찾지 못해서 제대로 된 팝업이 뜨질 않습니다.
		  frm.method = "post";
		  frm.id.value = $('#id').val();
		  frm.submit();     
	})
})
</script>
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
	<form name="frmPopup">
		<input type="hidden" name="id" id="id" value="${member.id}">
	</form>
	
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
				
			       <c:choose>
					<c:when test="${member.naver == 'T'}">
						<h3>${member.id } (${member.name }) <img src="img/naver_badge.png" width="25" height="25"></h3><br>
					</c:when>	
					<c:otherwise>
						<h3>${member.id } (${member.name })</h3><br>
					</c:otherwise>	
				   </c:choose>	
					<button type="button" class="btn btn-default btn-lg" id="goMini">
  						<span class="glyphicon glyphicon-home" aria-hidden="true" id="goMini"></span> 미니홈피
					</button>
					<a href="friends.do?id=${member.id }">
					<button type="button" class="btn btn-default btn-lg" >
  						<span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 일촌
					</button>
					</a>
					<a href="minihomepageSearch.do">
					<button type="button" class="btn btn-default btn-lg" >
  						<span class="glyphicon glyphicon-th-list" aria-hidden="true" ></span> 미니홈피 리스트
					</button>
					</a>
				  <br>
      			<br>
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