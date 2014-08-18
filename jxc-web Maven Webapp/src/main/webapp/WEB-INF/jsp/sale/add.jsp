<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="widget-box">
		<div class="widget-header header-color-pink">
			<h5><i class="icon-pencil"></i>添加销售</h5>
		</div>

		<div class="widget-body">
			<div class="widget-main">
				
				<form class="form-horizontal" id="addForm" role="form"> 
	
					<div class="space-4"></div>
					
					<div class="panel panel-default">
					   <div class="panel-heading">销售单表头</div>
					      <div class="panel-body">
					         <div class="form-group">
					            <label class="col-sm-1"> 客户: </label>
								<div class="col-sm-3">
									<select name="custom_id">
						         		<c:forEach items="${vl }" var="custom">
						         			<option value="${custom.id}">${custom.name}</option>
						         		</c:forEach>
						         	</select>
								</div>
								<label class="col-sm-1"> 销售时间: </label>
								<div class="col-sm-4">
									<input name="orderDate" placeholder="选择销售时间" type="text"  id="orderDate" class="ol-xs-10 col-sm-12" readonly="readonly" > 
								</div>
								<div class="col-sm-1">
									<button id="query" type="button" class="btn btn-sm btn-grey" onclick="addDetail();">
										<i class="glyphicon glyphicon-plus bigger-110"></i> 添加明细
									</button>
								</div>
							 </div>
					   	</div>
					</div>
					
					<div class="panel panel-default">
					   <div class="panel-heading">销售单明细</div>
					   <table class="table table-striped">
						   <thead>
						      <tr>
						         <th>货物</th>
						         <th>数量</th>
						         <th>单价</th>
						         <th>操作</th>
						      </tr>
						   </thead>
						   <tbody id="saleBody">
						      <tr id="cloneTr" style="display:none">
						         <td>
						         	<select name="m_id">
						         		<c:forEach items="${ml }" var="mat">
						         			<option value="${mat.id}">${mat.name}</option>
						         		</c:forEach>
						         	</select>
						         </td>
						         <td>
						         	<input type="text" name="num" size="8"/>
						         </td>
						         <td><input type="text" name="price" size="8"/></td>
						         <td>
						         	<button type="button" class="btn  btn-danger btn-sm" onclick="delsaleItem(this);">
											<i class="glyphicon glyphicon-trash"></i>
											删除
									</button>
						         </td>
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
	
	$("#cancel").click(function() {
		trans2('/system/userList', '系统管理-销售管理', null);
	});
	$("#back").click(function() {
		trans2('/system/userList', '系统管理-销售管理', null);
	});
	
	/* $("#orderDate").datetimepicker({
		format: 'yyyy-mm-dd',
	    autoclose: true,
	    todayBtn: true,
	    pickerPosition: "bottom-right"
	}); */
	
	$("#orderDate").datetimepicker({
		format: 'yyyy-mm-dd',
		startView : 3,
		minView : 2,
	    autoclose: true
	});
	
	//添加明细按钮的操作
	function addDetail(){
		//克隆新的一行
		var cloneTr = $("#cloneTr").clone().removeAttr("id").show();
		$("#saleBody").append(cloneTr);
	}
	
	function delsaleItem(obj){
		//将一行删除
		$(obj).parent().parent().remove();
	}

	$("#save").click(function() {
		
		var param = $("#addForm").find(":not(:hidden)").serialize(); // 获取表单数据
		var url = "/sale/add"; // 入库并跳转到销售列表
		trans2(url, '系统管理-添加销售', param); 
	});
</script>

