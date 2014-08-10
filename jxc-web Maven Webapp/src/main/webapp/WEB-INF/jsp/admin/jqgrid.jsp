<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
	<head>
		<title>jqGrid</title>

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${root}/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" /> 
		<link rel="stylesheet" href="${root}/resources/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/google-fonts.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${root}/resources/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/datepicker.css" />
		<link rel="stylesheet" href="${root}/resources/css/ui.jqgrid.css" />

		<!-- text fonts -->
		<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" /> --> 
	
		<!-- ace styles -->
		<link rel="stylesheet" href="${root}/resources/css/ace.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${root}/resources/css/ace-rtl.min.css" />


		<!-- ace settings handler -->
		<script src="${root}/resources/js/ace-extra.min.js"></script>

	</head>

	<body class="no-skin">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<jsp:include page="menu.jsp"></jsp:include>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#">Home</a>
						</li>

						<li>
							<a href="#">Tables</a>
						</li>
						<li class="active">jqGrid plugin</li>
					</ul><!-- /.breadcrumb -->

				</div>

				<div class="page-content">
				

					<div class="page-header">
						<h1>
							jqGrid
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>
								Dynamic tables and grids using jqGrid plugin
							</small>
						</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">

							<table id="grid-table"></table>

							<div id="grid-pager"></div>

							<script type="text/javascript">
								var $path_base = "..";//this will be used for editurl parameter
							</script>

							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->

			<jsp:include page="footer.jsp"></jsp:include>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<script src="${root}/resources/js/jquery-2.0.3.min.js"></script>
		<script src="${root}/resources/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="${root}/resources/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${root}/resources/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="${root}/resources/js/jqGrid/i18n/grid.locale-en.js"></script>

		<!-- ace scripts -->
		<script src="${root}/resources/js/ace-elements.min.js"></script>
		<script src="${root}/resources/js/ace.min.js"></script>
		
		
		
		
		
		</body>
</html>
