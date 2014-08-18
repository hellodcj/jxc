<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="widget-box">
		<div class="widget-header header-color-pink">
			<h5><i class="icon-pencil"></i>添加供应商</h5>

			<div class="widget-toolbar no-border">
				<button id="back" class="btn btn-xs btn-yellow bigger">
					<i class="icon-arrow-left"></i>
					返回
				</button>
			</div>
		</div>

		<div class="widget-body">
			<div class="widget-main">
				
				<form class="form-horizontal" id="addvendor" action="/system/vendor_saveOrupdate" method="post" role="form">
	
					<div class="space-4"></div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 供应商名 </label>
				
						<div class="col-sm-4">
							<input type="text" name="name" id="name" placeholder="供应商名 必填 " class="col-xs-10 col-sm-12" />
							
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 地址 </label>
				
						<div class="col-sm-4">
							<input type="text" name="address" id="address" placeholder="地址 " class="col-xs-10 col-sm-12" />
						</div>
					</div>
				
					
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
	

	$("#save").click(function() {
		
		var param = $("#addvendor").serialize(); // 获取表单数据
		var url = "/system/vendor_saveOrUpdate"; // 入库并跳转到供应商列表
		console.log(param);
		trans2(url, '系统管理-供应商管理', param);
	});
	$("#cancel").click(function() {
		trans2('/system/vendor_list', '系统管理-供应商管理', null);
	});
	$("#back").click(function() {
		trans2('/system/vendor_list', '系统管理-供应商管理', null);
	});
</script>

