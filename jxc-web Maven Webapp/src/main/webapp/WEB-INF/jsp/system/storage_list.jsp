<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>库存列表</h5>
		<div class="widget-toolbar no-border">
			<button id="export" class="btn btn-xs bigger btn-yellow dropdown-toggle" onclick="javascript:window.open('/system?method=exceltest');">
				<i class="icon-save"> excel导出</i>
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
						<th class='center'>库存</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pr.datas}" var="material" varStatus="pageStatus">
						<tr>
							<td class='center'>${material.name}</td>
							<td class='center'>${material.category}</td>
							<td class='center'>${material.unit}</td>
							<td class='center'><span class="label label-success">${material.storageNum}</span></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
<script type="text/javascript">
    
</script>