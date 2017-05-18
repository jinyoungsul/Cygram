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
	
	<jsp:include page="/common/top.jsp"/>
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
					<a href="musicList.do">
					<button type="button" class="btn btn-default btn-lg" >
  						<span class="glyphicon glyphicon-th-list" aria-hidden="true" ></span> 음악
					</button>
					</a>
				  <br>
      			<br>
        </div><!--/.sidebar-offcanvas-->
       </div>

      <hr>
	  <jsp:include page="/common/footer.jsp"/>
    </div><!--/.container-->
	
	
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>