<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>登录 - 安全生产监测监控</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="${root }/resources/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${root }/resources/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/google-fonts.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace-rtl.min.css" />
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
							<h4 class="blue">&nbsp;</h4>
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">安全生产监测监控</span>
								</h1>
								<h4 class="blue">&nbsp;</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入用户名,密码
											</h4>

											<div class="space-6"></div>

											<form id="myform">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="username" value="" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="password" value="" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">

														<button id="loginbutton" type="button" onclick="login();" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登 录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>


										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="javascript:void(0);" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
												</a>
											</div>

											<div>
												<a href="javascript:void(0);" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													&copy; 重庆安标科技有限公司
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->

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
