<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>物料列表</h5>
		<div class="widget-toolbar no-border">
			<button id="add" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-pencil"> 添加新物料</i>
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
						<th class='center'>物料名</th>
						<th class='center'>类别</th>
						<th class='center'>单位</th>
						<th class='center'>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pr.datas}" var="material" varStatus="pageStatus">
						<tr>
							<td class='center'>${material.name}</td>
							<td class='center'>${material.category}</td>
							<td class='center'>${material.unit}</td>
							<td class='center'>
								<button onclick="edit(${material.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
									<i class="icon-edit bigger-110"></i>
									编辑
								</button>
								<button onclick="edit(${material.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
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
<!-- 分页开始 -->
<%-- <jsp:include page="../page.jsp"></jsp:include> --%>
<!-- 分页结束 -->
<script type="text/javascript">
    $("#add").click(function(){
    	trans2('/system/material_create','系统管理-添加物料');
    });
    
    $("#refresh").click(function(){
    	trans2('/system/material_list','系统管理-物料管理');
    });
    
    function edit(id) {
    	trans2('/system/material_edit?id='+id,'系统管理-修改物料');
    }

    
    $(".tooltip-info").tooltip();
</script>