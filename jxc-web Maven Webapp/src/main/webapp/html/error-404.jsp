<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>404 Error Page - Ace Admin</title>

		<meta name="description" content="404 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${root}/resources/css/bootstrap.min.css" />

		<!-- page specific plugin styles -->


		<!-- ace styles -->
		<link rel="stylesheet" href="${root}/resources/css/ace.min.css" />

		<link rel="stylesheet" href="${root}/resources/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace-rtl.min.css" />

		<!-- ace settings handler -->
		<script src="${root}/resources/js/ace-extra.min.js"></script>

	</head>

	<body class="no-skin">
		

		<div class="error-container">
								<div class="well">
									<h1 class="grey lighter smaller">
										<span class="blue bigger-125">
											<i class="ace-icon fa fa-sitemap"></i>
											404
										</span>
										Page Not Found
									</h1>

									<hr>
									<h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>

									<div>
										<form class="form-search">
											<span class="input-icon align-middle">
												<i class="ace-icon fa fa-search"></i>

												<input type="text" class="search-query" placeholder="Give it a search...">
											</span>
											<button class="btn btn-sm" type="button">Go!</button>
										</form>

										<div class="space"></div>
										<h4 class="smaller">Try one of the following:</h4>

										<ul class="list-unstyled spaced inline bigger-110 margin-15">
											<li>
												<i class="ace-icon fa fa-hand-o-right blue"></i>
												Re-check the url for typos
											</li>

											<li>
												<i class="ace-icon fa fa-hand-o-right blue"></i>
												Read the faq
											</li>

											<li>
												<i class="ace-icon fa fa-hand-o-right blue"></i>
												Tell us about it
											</li>
										</ul>
									</div>

									<hr>
									<div class="space"></div>

									<div class="center">
										<a href="javascript:history.back()" class="btn btn-grey">
											<i class="ace-icon fa fa-arrow-left"></i>
											Go Back
										</a>

										<a href="#" class="btn btn-primary">
											<i class="ace-icon fa fa-tachometer"></i>
											Dashboard
										</a>
									</div>
								</div>
							</div>

		<!-- basic scripts -->

		<script src="${root}/resources/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->

		<!-- ace scripts -->
		<script src="${root}/resources/js/ace-elements.min.js"></script>
		<script src="${root}/resources/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
	</body>
</html>

