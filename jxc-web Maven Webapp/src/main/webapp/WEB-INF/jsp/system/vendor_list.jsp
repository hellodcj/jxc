<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>供应商列表</h5>
		<div class="widget-toolbar no-border">
			<button id="add" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-pencil"> 添加新供应商</i>
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
						<th class='center'>供应商名称</th>
						<th class='center'>供应商地址</th>
						<th class='center'>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pr.datas}" var="vendor" varStatus="pageStatus">
						<tr>
							<td class='center'>${vendor.name}</td>
							<td class='center'>${vendor.address}</td>
							<td class='center'>
								<button onclick="edit(${vendor.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
									<i class="icon-edit bigger-110"></i>
									编辑
								</button>
								<button onclick="edit(${vendor.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
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
    	trans2('/system/vendor_create','系统管理-添加供应商');
    });
    
    $("#refresh").click(function(){
    	trans2('/system/vendor_list','系统管理-供应商管理');
    });
    
    function edit(id) {
    	trans2('/system/vendor_update?vendorId='+id,'系统管理-修改供应商');
    }

    
    $(".tooltip-info").tooltip();
</script>