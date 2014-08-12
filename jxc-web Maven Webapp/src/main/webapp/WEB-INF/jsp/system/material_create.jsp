<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="widget-box">
		<div class="widget-header header-color-pink">
			<h5><i class="icon-pencil"></i>添加物料</h5>

			<div class="widget-toolbar no-border">
				<button id="back" class="btn btn-xs btn-yellow bigger">
					<i class="icon-arrow-left"></i>
					返回
				</button>
			</div>
		</div>

		<div class="widget-body">
			<div class="widget-main">
				
				<form class="form-horizontal" id="addmaterial" action="/system/material_saveOrupdate" method="post" role="form">
	
					<div class="space-4"></div>
					
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"> 物料名 </label>
				
						<div class="col-sm-4">
							<input type="text" name="name" id="name" placeholder="物料名 必填 " class="col-xs-10 col-sm-12" />
							
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 单位 </label>
				
						<div class="col-sm-4">
							<input type="text" name="unit" id="unit" placeholder="单位" class="col-xs-10 col-sm-12" />
						</div>
					</div>
				
					<div class="space-4"></div>
				
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" > 类别 </label>
				
						<div class="col-sm-4">
							<div class="input-group">
							<div class="input-group-btn">
								<button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown">选择已存在：<span class="caret"></span></button>
					            <ul class="dropdown-menu" role="menu" id="selectButtonUl">
					              <c:forEach var="category" items="${categoryList}">
						              <li><a href="#" onclick="selectCategory(this);">${category}</a></li>
					              </c:forEach>
					            </ul>
					        </div>
					        <input type="text" class="col-sm-12" name="category" id="category" placeholder="可以自己输入，也可以选择已有">
					        </div>
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
	$(function(){
		initSelectButton();
	});
	
	//初始化下拉按钮
	function initSelectButton(){
		
	}
	
	//选择下拉按钮后，将值赋值给input
	function selectCategory(obj){
		$('#category').val($(obj).text());
	}

	$("#save").click(function() {
		
		var param = $("#addmaterial").serialize(); // 获取表单数据
		var url = "/system/material_saveOrUpdate"; // 入库并跳转到物料列表
		console.log(param);
		trans2(url, '系统管理-物料管理', param);
	});
	$("#cancel").click(function() {
		trans2('/system/material_list', '系统管理-物料管理', null);
	});
	$("#back").click(function() {
		trans2('/system/material_list', '系统管理-物料管理', null);
	});
</script>

