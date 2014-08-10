<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="<%=request.getContextPath()%>" />
<c:set var="sn" value="<%=request.getServerName()%>" />
<c:set var="sp" value="<%=request.getServerPort()%>" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>管理系统-</title>
<script type="text/javascript">
	var root = "${root}";
</script>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="${root}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${root}/resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="${root}/resources/css/google-fonts.css" />
<link rel="stylesheet" href="${root}/resources/css/ace.min.css" />
<link rel="stylesheet" href="${root}/resources/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${root}/resources/css/ace-skins.min.css" />
<link rel="stylesheet" href="${root}/resources/css/timeline.css" />
<link rel="stylesheet" href="${root}/resources/css/datepicker.css" />
<link rel="stylesheet" href="${root}/resources/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${root}/resources/css/jquery.gritter.css" />
<link rel="stylesheet" href="${root}/resources/css/jquery-ui-1.10.3.custom.min.css" />
<script src="${root}/resources/js/ace-extra.min.js"></script>

<link rel="shortcut icon" href="${root }/resources/avatars/favicon.ico">

</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="javascript:void(0);" class="navbar-brand" style="cursor: default"> <small> <img src="${root }/resources/avatars/logo.png" height="25"> 进销存管理系统
						${config.factoryname }
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue"><a data-toggle="dropdown" href="javascript:void(0);" class="dropdown-toggle"><img class="nav-user-photo" src="${root}/resources/avatars/avatar2.png"
							alt="Jason's Photo" /><span class="user-info"><small>欢迎您,</small> ${sessionScope['ABKJ-PT-ACCOUNT'].name} </span><i class="icon-caret-down"></i> </a>
						<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="javascript:headChangePwdShow();"><i class="icon-cog"></i> 修改密码 </a></li>
							<li class="divider"></li>
							<li><a href="${root}/logout"><i class="icon-off"></i> 离开 </a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<script src='${root }/resources/js/jquery-1.10.2.min.js'>

		</script>
		<div class="main-container-inner">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="javascript:void(0);" onclick="javascript:$('#nav01').trigger('click');">首页</a></li>
						<li id="breadcrumb"></li>
					</ul>
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12" id="content-container"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="changePwdDiv">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3>密码修改</h3>
					</div>
					<div class="modal-body">
						<fieldset>
							<div class="control-group">
								<label class="control-label" for="selectError">原始密码：</label>
								<div class="controls">
									<input class="input-xlarge focused" style="height: 28px" id="oldpwd" type="password" value=""> <span class="help-inline"> *必填项</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="focusedInput">新密码</label>
								<div class="controls">
									<input class="input-xlarge focused" style="height: 28px" id="newpwd" type="password" value=""><span class="help-inline"> *必填项</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="focusedInput">确认新密码</label>
								<div class="controls">
									<input class="input-xlarge focused" style="height: 28px" id="newpwd2" type="password" value=""><span class="help-inline"> *必填项</span>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="modal-footer">
						<button type="button" id="changePwdOk" onclick="headChangePwd();" class="btn btn-primary">确定</button>
						<button type="button" onclick="javascript:$('#changePwdDiv').modal('hide');" data-dismiss="modal" class="btn btn-primary">取消</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 状态控制弹出框结束 -->
	</div>

	<div class="modal fade" id="the-main-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="the-main-modal-title"></h4>
				</div>
				<div class="modal-body">
					<h3 id="the-main-modal-body" class="header smaller lighter grey"></h3>
				</div>
				<div class="modal-footer"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="${root }/resources/js/bootstrap.min.js"></script>
	<script src="${root }/resources/js/typeahead-bs2.min.js"></script>

	<script src="${root }/resources/js/ace-elements.min.js"></script>
	<script src="${root }/resources/js/ace.min.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript" src="${root }/resources/js/jquery.form.js"></script>
	<script type="text/javascript" src="${root }/resources/js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${root }/resources/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="${root}/resources/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${root}/resources/js/print.js"></script>
	<script type="text/javascript" src="${root}/resources/js/bootbox.min.js"></script>
	<script type="text/javascript" src="${root}/resources/js/highstock/highstock.js"></script>
	<script type="text/javascript" src="${root}/resources/js/highstock/modules/exporting.js"></script>
	<script type="text/javascript" src="${root}/resources/myjs/my-StockChart.js"></script>
	<script type="text/javascript" src="${root}/resources/myjs/clear.js"></script>
	<script type="text/javascript" src="${root}/resources/js/jquery.gritter.min.js"></script>
	<script type="text/javascript" src="${root}/resources/myjs/my_noty.js"></script>
	<script type="text/javascript" src="${root}/resources/myjs/websocket.js"></script>
	<script type="text/javascript" src="${root}/resources/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${root}/resources/js/go.js"></script>
	<script type="text/javascript">
		function printDataAlarm() {
			/* if ($('#value').val() == '') {
				alert('请先执行查询操作！');
				return;
			} */
			var newWindow = window.open("打印窗口", "_blank");
			newWindow.document.write("123132");
			newWindow.document.close();
			newWindow.print();
			newWindow.close();

		}
		$.fn.datepicker.dates['en'] = {
			days : [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" ],
			daysShort : [ "周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日" ],
			daysMin : [ "日", "一", "二", "三", "四", "五", "六", "日" ],
			months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
			monthsShort : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
			today : "今日",
			suffix : [],
			meridiem : []
		};

		$.fn.datetimepicker.dates['en'] = {
			days : [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" ],
			daysShort : [ "周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日" ],
			daysMin : [ "日", "一", "二", "三", "四", "五", "六", "日" ],
			months : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
			monthsShort : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ],
			today : "今日",
			suffix : [],
			meridiem : []
		};

		$('body').delegate(".date-picker", "click", function(event) {
			$('.date-picker').datepicker({
				startView : 3,
				minView : 2,
				autoclose : true
			}).next().on(ace.click_event, function() {
				$(this).prev().focus();
			});
		});

		function headChangePwdShow() {
			resetCPModal();
			$('#changePwdDiv').modal('show');
		}

		function resetCPModal() {
			$('#oldpwd').val('');
			$('#newpwd').val('');
			$('#newpwd2').val('');
		}
		function headChangePwd() {
			if ($('#oldpwd').val() == '' || $('#oldpwd').val() == null) {
				//alert("请输入原始密码！");
				_noty($('#oldpwd'), '请输入原始密码！', 'right', 2000);
				return;
			}
			if ($('#newpwd').val() == '' || $('#newpwd').val() == null) {
				//alert("请输入新密码！");
				_noty($('#newpwd'), '请输入新密码！', 'right', 2000);
				return;
			}
			if ($('#newpwd').val() != $('#newpwd2').val()) {
				//alert("两次输入的新密码不相同！");
				_noty($('#newpwd2'), '两次输入的新密码不相同！', 'right', 2000);
				return;
			}

			ajaxSubmit('/pwd', {
				se : new Date().getTime(),
				pwd : $('#oldpwd').val(),
				newPwd : $('#newpwd').val()
			}, 'post', function(data) {
				if (data == "0") {
					//alert('修改成功!');
					_my_alert('提示', '修改成功！');
					//_noty($('#changePwdOk'),'修改成功！','top',2000);
					$('#changePwdDiv').modal('hide');
				} else {
					_noty($('#changePwdOk'), '修改失败，原始密码输入错误！', 'top', 2000);
				}
			});
		}
		var theMainModal = {
			show : function(options) {
				$('#the-main-modal-title').text(options.title);
				$('#the-main-modal-body').html(options.body);
				$('#the-main-modal').modal({
					backdrop : 'static',
					show : true,
					keyboard : false
				});
			},
			hide : function() {
				$('#the-main-modal').modal('hide');
			}
		};
		trans('/main', '', '', this);

		function serialOpen() {
			var state = $('#registerModal')[0].style.display;
			if (state == '' || state == 'none') {
				$('#serialNumber').val('');
				$('#registerModal').modal('show');
			}
		}

		function serialAjax() {
			$.getJSON(root + "/auth"+'?random='+Math.random(), function(result) {
				//	console.log(result);
				if (result.ret == 0) {
					$('#days').empty();
					$('#days').append(result.day);
					serialOpen();
				}
			});
		}

		var serialIntervalId = setInterval(serialAjax, 1000 * 60);

		function serialEnterAjax() {
			var url = "/authReset";
			var param = "serio=" + $('#serialNumber').val();
			ajaxSubmit(url, param, 'post', function(data) {
				//	console.log('newdata===>>>>' + data);
				if (data == 0) {// 过期
					alert('激活码验证失败，格式有误！');
				} else {
					$('#registerModal').modal('hide');
				}
			});
		}
		/*// set the menu always show on left.
		window.onscroll = function() {
			var _top = document.body.scrollTop, _menu = $('#sidebar');
			if(_top > 450) {
				_menu.addClass('menu-min');
				_menu.css({
					position: 'fixed',
					'z-index': 999
				});
				$('#sidebar-collapse').children().eq(0).removeClass('icon-double-angle-left').addClass('icon-double-angle-right');
			} else if(_top < 50) {
				_menu.removeClass('menu-min');
				_menu.css('position', '');
				$('#sidebar-collapse').children().eq(0).removeClass('icon-double-angle-right').addClass('icon-double-angle-left');
			}
		};*/
		function logtimeToDate(logd) {
			if (logd) {
				logd = logd + '';
				return logd.substr(0, 4) + '-' + logd.substr(4, 2) + '-' + logd.substr(6, 2) + '-' + logd.substr(8, 2) + ':' + logd.substr(10, 2) + ':' + logd.substr(12);
			}
			return '--';
		}
	</script>
</body>
</html>