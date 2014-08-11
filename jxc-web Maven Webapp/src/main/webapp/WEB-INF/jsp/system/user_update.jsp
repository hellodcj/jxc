<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="widget-box">
		<div class="widget-header header-color-pink">
			<h5><i class="icon-pencil"></i>编辑用户</h5>

			<div class="widget-toolbar no-border">
				<button id="back" class="btn btn-xs btn-yellow bigger">
					<i class="icon-arrow-left"></i>
					返回
				</button>
			</div>
		</div>

		<div class="widget-body">
			<div class="widget-main">
				
				<form class="form-horizontal" id="addUser" action="/system/user_saveOrupdate" method="post" role="form">
	
					<div class="space-4"></div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 用户名 </label>
				
						<div class="col-sm-4">
							<input type="text" name="username" id="username" placeholder="用户名 必填 " class="col-xs-10 col-sm-12" value="${user.username}"/>
							
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 姓名 </label>
				
						<div class="col-sm-4">
							<input type="text" name="nickname" id="nickname" placeholder="姓名" class="col-xs-10 col-sm-12" value="${user.nickname} "/>
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 邮箱 </label>
				
						<div class="col-sm-4">
							<input type="text" name="email" id="email" placeholder="邮箱必填" class="col-xs-10 col-sm-12" value="${user.email}"/>
						</div>
					</div>
				
					<div class="space-4"></div>
				
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 密码 </label>
				
						<div class="col-sm-4">
							<input type="password" name="password" id="password" placeholder="密码 必填" class="col-xs-10 col-sm-12" />
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 确认密码 </label>
				
						<div class="col-sm-4">
							<input type="password" name="password2" id="password2" placeholder="确认密码 必填" class="col-xs-10 col-sm-12" />
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 电话号码 </label>
				
						<div class="col-sm-4">
							<input type="text" id="phone" name="phone" placeholder="电话号码 必填" class="col-xs-10 col-sm-12" value="${user.phone }"/>
						</div>
					</div>
					
					<!-- 修改用户的id -->
					<input id="userId" type="hidden" name="id" value="${user.id}" />
					
					<div class="space-4"></div>
				
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button id="save" class="btn btn-info" type="button">
								<i class="icon-ok bigger-110"></i>
								保存
							</button>
				
							&nbsp; &nbsp; &nbsp;
							<button id="cancel" class="btn" type="reset">
								<i class="icon-undo bigger-110"></i>
								取消
							</button>
						</div>
					</div>

				</form>
				
			</div>
			
		</div>
	</div>


<script type="text/javascript">
	
$('#addUser').validate(
	{
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		rules : {
			username : {
				required : true,
				remote: {
					url: root+"/system/check_username",
                    type: "get",
                    data: { "username":function(){return $("#username").val();}}
				}
			},
			email:{
				email:true,
			},
			nickname : {
				required : true,
			},
			password : {
				required : true,
				minlength : 6
			},
			password2 : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			},
			phone : {
				required : true,
				number : true
			}
		},

		messages : {
			username : {
				required : "用户名不能为空！",
				remote: "用户名已存在!"
			},
			nickname : {
				required : "姓名不能为空！",
			},
			password : {
				required : "密码不能为空！",
				minlength : "密码长度不能小于6！"
			},
			password2 : {
				required : "密码不能为空!",
				minlength : "密码长度不能小于6！",
				equalTo : "两次输入的密码不一致！"
			},
			phone : {
				required : "电话号码不能为空！",
				number : "电话号码只能输入数字！"
			},email:{
				email:"请输入正确的邮箱地址!",
			}
		},

		invalidHandler : function(event, validator) { //display error alert on form submit   
			$('.alert-danger', $('.login-form')).show();
		},

		highlight : function(e) {
			$(e).closest('.form-group').removeClass('has-info')
					.addClass('has-error');
		},

		success : function(e) {
			$(e).closest('.form-group')
					.removeClass('has-error').addClass(
							'has-info');
			$(e).remove();
		},

		errorPlacement : function(error, element) {
			if (element.is(':checkbox') || element.is(':radio')) {
				var controls = element
						.closest('div[class*="col-"]');
				if (controls.find(':checkbox,:radio').length > 1)
					controls.append(error);
				else
					error.insertAfter(element.nextAll(
							'.lbl:eq(0)').eq(0));
			} else if (element.is('.select2')) {
				error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
			} else if (element.is('.chosen-select')) {
				error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
			} else
				error.insertAfter(element.parent());
		},

		submitHandler : function(form) {
		},
		invalidHandler : function(form) {
		}
	});

	$("#save").click(function() {
		
		if (!$('#addUser').valid()) {
			return;
		}
		
		var param = $("#addUser").serialize(); // 获取表单数据
		var url = "/system/user_saveOrUpdate"; // 入库并跳转到用户列表
		console.log(param);
		trans2(url, '系统管理-用户管理', param);
	});
	$("#cancel").click(function() {
		trans2('/system/userList', '系统管理-用户管理', null);
	});
	$("#back").click(function() {
		trans2('/system/userList', '系统管理-用户管理', null);
	});
</script>

