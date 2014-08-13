<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="widget-box">
		<div class="widget-header header-color-pink">
			<h5><i class="icon-pencil"></i>添加采购</h5>

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
					
					<div class="panel panel-default">
					   <div class="panel-heading">采购单表头</div>
					      <div class="panel-body">
					         <div class="form-group">
					            <label class="col-sm-1"> 供应商: </label>
								<div class="col-sm-3">
									<input type="text" name="username" id="username" placeholder="采购名 必填 " class="col-xs-10 col-sm-12" />
								</div>
								<label class="col-sm-1"> 进货时间: </label>
								<div class="col-sm-3">
									<input name="ordertime" placeholder="选择进货时间" type="text"  id="ordertime" class="ol-xs-10 col-sm-12"  >
								</div>
								<div class="col-sm-1">
									<button id="query" type="button" class="btn btn-sm btn-grey">
										<i class="glyphicon glyphicon-plus bigger-110"></i> 添加明细
									</button>
								</div>
							 </div>
					   	</div>
					</div>
					
					<div class="panel panel-default">
					   <div class="panel-heading">采购单明细</div>
					   <table class="table table-striped">
						   <thead>
						      <tr>
						         <th>货物</th>
						         <th>数量</th>
						         <th>单价</th>
						      </tr>
						   </thead>
						   <tbody>
						      <tr>
						         <td>Tanmay</td>
						         <td>
						         	<select>
						         		<option value="11">11</option>
						         		<option value="11">11</option>
						         		<option value="11">11</option>
						         		<option value="11">11</option>
						         	</select>
						         </td>
						         <td>560001</td>
						      </tr>
						      <tr>
						         <td>Sachin</td>
						         <td>Mumbai</td>
						         <td>400003</td>
						      </tr>
						      <tr>
						         <td>Uma</td>
						         <td>Pune</td>
						         <td>411027</td>
						      </tr>
						   </tbody>
						</table>
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
		
		if (!$('#addUser').valid()) {
			return;
		}
		
		var param = $("#addUser").serialize(); // 获取表单数据
		var url = "/system/user_saveOrUpdate"; // 入库并跳转到采购列表
		console.log(param);
		trans2(url, '系统管理-采购管理', param);
	});
	$("#cancel").click(function() {
		trans2('/system/userList', '系统管理-采购管理', null);
	});
	$("#back").click(function() {
		trans2('/system/userList', '系统管理-采购管理', null);
	});
	
	$("#ordertime").datetimepicker({
		format: 'yyyy-mm-dd',
	    autoclose: true,
	    todayBtn: true,
	    pickerPosition: "bottom-right"
	});
</script>

