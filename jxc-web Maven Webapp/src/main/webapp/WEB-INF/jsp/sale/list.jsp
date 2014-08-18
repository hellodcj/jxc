<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>采购记录</h5>
	</div>
	<div class="widget-body">
	<div class="widget-toolbox padding-8 clearfix">
		<form id="searchForm" class="form-inline" role="form">
			<div id="month-div" class="form-group">
					<input type="text" readonly="readonly" class="date-picker-month" id="slt-date-month" name="month" data-date-format="yyyy-mm" placeholder="选择日期">
			</div>
			<button type="button" onclick="listByMonth();" class="btn btn-default  btn-sm">查询 <i class="icon-search icon-on-right bigger-110"></i></button>
		</form>
	</div>
		<div class="widget-main no-padding">
			<table class="table table-striped table-bordered table-hover">
				<thead class="thin-border-bottom">
					<tr>
						<th class='center'>日期</th>
						<th class='center'>供应商</th>
						<th class='center'>物料</th>
						<th class='center'>数量</th>
						<th class='center'>价格</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pol}" var="po" varStatus="pageStatus">
						<c:set value="${po.items}" var="items"></c:set>
						<c:set value="${fn:length(items)}" var="len"></c:set>
						<tr>
							<td class='center' rowspan="${len+1}" style="margin:auto;">${po.ordertime}</td>
							<td class='center' rowspan="${len+1}" style="margin:auto;">${po.vendor.name}</td>
							
							<c:forEach items="${po.items}" var="item">
								</tr><tr>
								<td class='center'>${item.material.name}</td>
								<td class='center'>${item.number}</td>
								<td class='center'>${item.price}</td>
							</c:forEach>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>

<script type="text/javascript">
$('.date-picker-month').datepicker({format: 'yyyy-mm',viewMode:2,minViewMode:1,autoclose: true});
//$('.date-picker-month').datepicker({format: 'yyyy-mm-dd',autoclose: true});

function listByMonth(){
	var url = "/purchase/listByMonth";
	var month = $('slt-date-month').val(); // 入库并跳转到采购列表
	trans2(url, '系统管理-添加采购', 'month='+month); 
}
</script>