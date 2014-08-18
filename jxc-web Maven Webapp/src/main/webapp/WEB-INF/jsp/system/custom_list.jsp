<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>客户列表</h5>
		<div class="widget-toolbar no-border">
			<button id="add" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-pencil"> 添加新客户</i>
			</button>
			<button id="refresh" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-refresh"> 刷新</i>
			</button>
		</div>
	</div>
	<div class="widget-body">
		<div class="widget-main no-padding">
			<table class="table table-striped table-bordered table-hover">
				<thead class="thin-border-bottom">
					<tr>
						<th class='center'>客户名称</th>
						<th class='center'>客户地址</th>
						<th class='center'>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pr.datas}" var="custom" varStatus="pageStatus">
						<tr>
							<td class='center'>${custom.name}</td>
							<td class='center'>${custom.address}</td>
							<td class='center'>
								<button onclick="edit(${custom.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
									<i class="icon-edit bigger-110"></i>
									编辑
								</button>
								<button onclick="edit(${custom.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
									<i class="icon-edit bigger-110"></i>
									删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>

<script type="text/javascript">
    $("#add").click(function(){
    	trans2('/system/custom_create','系统管理-添加客户');
    });
    
    $("#refresh").click(function(){
    	trans2('/system/custom_list','系统管理-客户管理');
    });
    
    function edit(id) {
    	trans2('/system/custom_update?customId='+id,'系统管理-修改客户');
    }

    
    $(".tooltip-info").tooltip();
</script>