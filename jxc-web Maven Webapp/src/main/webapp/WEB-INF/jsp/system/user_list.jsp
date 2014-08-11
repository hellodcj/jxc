<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="widget-box">
	<div class="widget-header header-color-pink">
		<h5><i class="icon-table"></i>用户列表</h5>
		<div class="widget-toolbar no-border">
			<button id="add" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-pencil"> 添加新用户</i>
			</button>
			<button id="refresh" class="btn btn-xs bigger btn-yellow dropdown-toggle">
				<i class="icon-refresh"> 刷新</i>
			</button>
		</div>
	</div>
	<div class="widget-body">
	<div class="widget-toolbox padding-8 clearfix">
		<form id="searchForm" class="form-inline" role="form">
			<div class="form-group">
				<input type="text" class="form-control" id="username" name="username" value="${username}" placeholder="登录名">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="name" name="name" value="${name}" placeholder="姓名">
			</div>
			<button type="button" onclick="toPage(1)" class="btn btn-default  btn-sm">查询 <i class="icon-search icon-on-right bigger-110"></i></button>
		</form>
	</div>
		<div class="widget-main no-padding">
			<table class="table table-striped table-bordered table-hover">
				<thead class="thin-border-bottom">
					<tr>
						<th class='center'><i class="icon-user"></i> 登录名</th>
						<th class='center'>姓名</th>
						<th class='center'>邮箱</th>
						<th class='center'>电话</th>
						<th class='center'>状态</th>
						<th class='center'>操作</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${pr.datas}" var="user" varStatus="pageStatus">
						<tr>
							<td class='center'>${user.username}</td>
							<td class='center'>${user.nickname}</td>
							<td class='center'>${user.email}</td>
							<td class='center'>${user.phone}</td>
							<td class='center'>
								<c:if test="${user.status eq 0}"><span class="label label-success">正常</span></c:if>
								<c:if test="${user.status eq 1}"><span class="label label-danger">禁用</span></c:if>
							</td>
							<td class='center'>
								<button onclick="edit(${user.id})" class="btn btn-xs btn-info tooltip-info" data-toggle="tooltip" data-placement="top" data-original-title="编辑">
									<i class="icon-edit bigger-110"></i>
									编辑
								</button>
								<c:if test="${user.id != 1}">
									<c:choose> 
										<c:when test="${user.status eq 0}">
											<button onclick="updateState(${user.id},1)" class="btn btn-xs btn-danger">
												<i class="icon-ban-circle bigger-110"></i>
												禁用
										</c:when> 
										<c:otherwise>
											<button onclick="updateState(${user.id},0)" class="btn btn-xs btn-success ">
												<i class="icon-ok bigger-110"></i>
												启用
										</c:otherwise> 
									</c:choose>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
<!-- 分页开始 -->
<input type="hidden" id="pageurl" value="${root}/system/user"/>
<input type="hidden" id="pageform" value="searchForm"/>
<%-- <jsp:include page="../page.jsp"></jsp:include> --%>
<!-- 分页结束 -->
<script type="text/javascript">
    $("#add").click(function(){
    	trans2('/system/user_create','系统管理-添加用户');
    });
    
    $("#refresh").click(function(){
    	trans2('/system/userList','系统管理-用户管理');
    });
    
    function edit(id) {
    	trans2('/system/user_edit?id='+id,'系统管理-修改用户');
    }

    function updateState(id, type) {
    	var title;
    	if(type == 0) {
    		title = "<h2>确认启用?</h2>";
    	} else {
    		title = "<h3>确认禁用?</h3>";
    	}
    	bootbox.confirm(title, function(result){
    		if(result) {
    			trans2('/system/user_delete?id='+id +"&type="+type,'系统管理-用户管理', null);
    		}
    	});
    }
    
    $(".tooltip-info").tooltip();
</script>