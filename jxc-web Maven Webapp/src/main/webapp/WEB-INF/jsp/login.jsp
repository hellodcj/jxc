<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录 - 安全生产监测监控</title>

		<%-- <meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="${root }/resources/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${root }/resources/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/google-fonts.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace-rtl.min.css" /> --%>
		<!-- Bootstrap core CSS -->
	    <link href="${root}/resources/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="${root}/resources/css/login.css" rel="stylesheet">
	</head>

	<body>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" placeholder="Email address" required="" autofocus="">
        <input type="password" class="form-control" placeholder="Password" required="">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
		<script src="${root}/resources/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${root}/resources/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${root}/resources/js/bootstrap.min.js"></script>
		<script src="${root}/resources/myjs/my_noty.js"></script>
		<script type="text/javascript">
			function login(){
				$('#loginbutton').popover('destroy');
				$.ajax({
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					type : 'post',
					data:$('#myform').serialize(),
					url : '${root}/letsgo?se='+ new Date().getTime(),
					success : function(data){
						if(data=='0'){
							window.location.href = "${root}/";
						} else if (data=='1') {
							_noty($('#loginbutton'),'用户名或密码错误！','left',2000);
						} else if (data == '2') {
							window.location.href = "${root}/register";
						}
					},
					error : function(req) {
						_noty($('#loginbutton'),'服务器异常！！','left',2000);
					},complete: function (XHR, TS) { XHR = null }
				});
			}
			$(document).on('keyup',function(e){
		          if(e.keyCode === 13){
		        	  login();
		          }
		    });
		</script>
	</body>
</html>
