<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>

		<!-- Bootstrap core CSS -->
	    <link href="${root}/resources/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="${root}/resources/css/login.css" rel="stylesheet">
	</head>

	<body>

    <div class="container">

      <form class="form-signin" role="form" action="login" method="post" id="loginform">
        <h4 class="form-signin-heading">铁燕公司进销存管理系统--登陆界面</h4>
        <input class="form-control" placeholder="Username" required="" autofocus="" name="username">
        <input type="password" class="form-control" placeholder="Password" required="" name="password">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        <span style="color:red">${error}</span>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
		<script src="${root}/resources/js/jquery-1.7.2.min.js"></script>
		<script src="${root}/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$(document).on('keyup',function(e){
		          if(e.keyCode === 13){
		        	  $('#loginform').submit();
		          }
		    });
		</script>
	</body>
</html>
