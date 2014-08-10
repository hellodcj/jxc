<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="root" value="<%=request.getContextPath()%>" />
<a class="menu-toggler" id="menu-toggler" href="javascript:void(0);"> <span class="menu-text"></span>
</a>

<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed');
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<a href="javascript:void(0);" onclick="javascript:$('#nav01').trigger('click');" class="btn btn-success icon-home" title="首页"> </a> <a href="javascript:void(0);"
				onclick="trans('/list/real/list','列表显示-实时列表','nav04','#menu-real-list');" class="btn btn-info icon-only icon-align-left" title="实时列表"> </a> <a href="javascript:void(0);"
				onclick="trans('/mon/map','模拟图显示-通风系统','nav07', '#menu-map-item');" class="btn btn-warning  icon-globe" title="模拟图"> </a> <a href="javascript:void(0);"
				onclick="trans('/monitor/state','模拟图显示-系统自检','nav07', '#menu-check-state');" class="btn btn-danger icon-legal" title="自检图"> </a>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span> <span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li id="nav01" class='active' onclick="trans('/main','','',this);"><a href="javascript:void(0);"> <i class="icon-home"></i> <span class="menu-text"> 首页 </span>
		</a></li>
		<c:if test="${fn:contains(sessionScope['ABKJ-PT-ACCOUNT-AUTH'],'sys')}">
			<li id="nav000"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-cog"></i> <span class="menu-text"> 系统管理 </span> <b class="arrow icon-angle-down"></b>
			</a>
				<ul class="submenu">
					<li id="menu-user-mana" onclick="trans('/system/user','系统管理－用户管理','nav000',this);"><a href="javascript:void(0)"> <i class="icon-leaf"></i> 用户管理
					</a></li>
					<li id="menu-user-log" onclick="trans('/system/userlog','系统管理－用户日志','nav000',this);"><a href="javascript:void(0)"> <i class="icon-leaf"></i> 用户日志
					</a></li>
				</ul></li>
			<li id="nav02"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-cogs"></i> <span class="menu-text"> 参数设置 </span> <b class="arrow icon-angle-down"></b>
			</a>
				<ul class="submenu">
					<li id="menu-system-param" onclick="trans('/param/config','系统管理-系统参数','nav02',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 系统参数
					</a></li>
					<li id="menu-sensor-type" onclick="trans('/param/st','系统管理-传感器类别','nav02',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 传感器类别
					</a></li>
					<li id="menu-station-config" onclick="trans('/param/sub','参数设置-分站配置','nav02',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 分站配置
					</a></li>
					<li id="menu-sensor-sim" onclick="trans('/param/sen/0','系统设置-模拟量','nav02',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 模拟量
					</a></li>
					<li id="menu-sensor-swi" onclick="trans('/param/sen/1','系统设置-开关量','nav02',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 开关量
					</a></li>

				</ul></li>

			<li id="nav03"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-wrench"></i> <span class="menu-text"> 控制 </span> <b class="arrow icon-angle-down"></b>
			</a>
				<ul class="submenu">
					<li id="menu-control-logic" onclick="trans('/rule/rule_list','控制-控制逻辑','nav03',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 控制逻辑
					</a></li>
				</ul></li>
		</c:if>
		<li id="nav04"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-list"></i> <span class="menu-text"> 列表显示 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-list-alarm" onclick="trans('/list/alarm','列表显示-报警','nav04',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 报警
				</a></li>
				<li id="menu-list-invoke" onclick="trans('/list/invoke','列表显示-调用','nav04',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 调用
				</a></li>
				<li id="menu-list-fault" onclick="trans('/list/fault','列表显示-设备故障','nav04',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 设备故障
				</a></li>
				<li id="menu-real-list" onclick="trans('/list/real/list','列表显示-实时列表','nav04',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 实时列表
				</a></li>
			</ul></li>
		<li id="nav05"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-dashboard"></i> <span class="menu-text"> 曲线显示 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-chart-alarm" onclick="trans('/line/alarm/1','曲线显示-报警','nav05',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 报警
				</a></li>
				<li id="menu-chart-break" onclick="trans('/line/alarm/2','曲线显示-断电控制','nav05',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 断电控制
				</a></li>
				<li id="menu-chart-back" onclick="trans('/line/alarm/3','曲线显示-馈电异常','nav05',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 馈电异常
				</a></li>
				<li id="menu-chart-invoke" onclick="trans('/line/alarm/0','曲线显示-调用','nav05',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 调用
				</a></li>

			</ul></li>
		<li id="nav06"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-bar-chart"></i> <span class="menu-text"> 状态图与柱状图显示 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-chart-state" onclick="trans('/graph/stategraph','状态图与柱状图显示-状态图','nav06',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 状态图
				</a></li>
				<li id="menu-chart-column" onclick="trans('/graph/column','状态图与柱状图显示-柱状图','nav06',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 柱状图
				</a></li>

			</ul></li>
		<li id="nav07"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-barcode"></i> <span class="menu-text"> 模拟图显示 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-map-item" onclick="trans('/mon/map','模拟图显示-通风系统图','nav07',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 通风系统图
				</a></li>
				<li onclick="trans('/monitor/gas_state','模拟图显示-瓦斯抽放图','nav07',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 瓦斯抽放图
				</a></li>
				<li id="menu-check-state" onclick="trans('/monitor/state','模拟图显示-系统自检图','nav07',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 系统自检图
				</a></li>

			</ul></li>

		<li id="nav08"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-search"></i> <span class="menu-text"> 查询 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-query-alarm" onclick="trans('/query/alarm','查询-报警','nav08',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 报警
				</a></li>
				<li id="menu-query-invoke" onclick="trans('/query/invoke','查询-调用','nav08',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 调用
				</a></li>
				<li id="menu-query-fault" onclick="trans('/query/fault','查询-设备故障','nav08',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 设备故障
				</a></li>

			</ul></li>

		<li id="nav09"><a href="javascript:void(0);" class="dropdown-toggle"> <i class="icon-table"></i> <span class="menu-text"> 打印 </span> <b class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li id="menu-report-alarm" onclick="trans('/report/analog','报表-模拟量报警日(班)报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 模拟量报警日(班)报表
				</a></li>
				<li id="menu-report-swi" onclick="trans('/report/switch','报表-开关量状态变动日(班)报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 开关量状态变动日(班)报表
				</a></li>
				<li id="menu-report-break" onclick="trans('/report/analogbreak','报表-模拟量断电日(班)报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 模拟量断电日(班)报表
				</a></li>
				<li id="menu-report-back" onclick="trans('/report/analogabnormal','报表-模拟量馈电异常日(班)报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 模拟量馈电异常日(班)报表
				</a></li>
				<li id="menu-report-fault" onclick="trans('/report/faultlog','报表-设备故障日(班)报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 设备故障日(班)报表
				</a></li>

				<li id="menu-query-count" onclick="trans('/query/count','查询-模拟量统计值记录报表','nav09',this);"><a href="javascript:void(0);"> <i class="icon-leaf"></i> 统计值记录报表
				</a></li>
			</ul></li>
		<li id="nav10" onclick="trans('/faq','系统帮助','',this);"><a href="javascript:void(0);"> <i class="icon-info-sign"></i> <span class="menu-text"> 系统帮助 </span>
		</a></li>
		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
		</div>

		<script type="text/javascript">
			//var realDataListIntervalId = -1; // 实时列表数据定时Interval id
			try {
				ace.settings.check('sidebar', 'collapsed')
			} catch (e) {
			}
			var opennav = '';
			var active = document.getElementById('nav01');
			var alertMsg = '<div class="alert alert-info"><i class="icon-hand-right"></i>访问出现错误,请稍后重试,如果问题仍然存在请联系管理员</div>';
			function trans(url, txt, o, a) {
				if(jsContext)
					jsContext.clear();
				/* if(window.clearPageScript)
					clearPageScript(); */
				/* if(realDataListIntervalId > -1) {
					clearInterval(realDataListIntervalId);
					realDataListIntervalId = -1;
				} */
				setMessageFunction(url);
				url = root + url;
				if (opennav != '') {
					$('#' + opennav).attr('class', '');
					$('#' + opennav + ' .submenu').attr('style', 'display:none');
				}
				$(active).attr('class', '');
				if (o != '') {
					$('#' + o).attr('class', 'active open');
					$('#' + o + ' .submenu').attr('style', 'display:block');
				}
				opennav = o;
				$(a).attr('class', 'active');
				active = a;
				$('#content-container').empty();
				$('#content-container').innerHTML="";
				$('#breadcrumb').empty();
				$('#breadcrumb').innerHTML="";
				$.ajax({
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					type : 'get',
					url : url+'?random='+Math.random(),
					success : function(data) {
						$('#breadcrumb').append(txt);
						$('#content-container').append(data);
					},
					error : function(req) {
						$('#breadcrumb').empty();
						$('#breadcrumb').append('出现错误!');
						$('#content-container').append(alertMsg);
					},complete: function (XHR, TS) { XHR = null }
				});
			}
			function trans2(url,txt, param, call){
				setMessageFunction(url);
				if(url.indexOf('?')!=-1){
					url = url+'&random='+Math.random();
				}else{
					url = url+'?random='+Math.random();
				}
				url = root + url;
				$('#content-container').empty();
				$('#content-container').innerHTML="";
				$('#breadcrumb').empty();
				$('#breadcrumb').innerHTML="";
				reload(true);
				$.ajax({
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data: param,
					type: 'post',
					url: url,
					success : function(data){
						if(call) call();
						reload(false);
						if(txt!="")
							$('#breadcrumb').append(txt);
						$('#content-container').append(data);
					},
					error : function(req) {
						reload(false);
						$('#breadcrumb').append('<li class="active">出现错误!</li>');
						$('#content-container').append(alertMsg);
					},complete: function (XHR, TS) { XHR = null }
				});
			}

			function reload(state) {
				if(state) {
					$("#refesh").attr("style", "display:block");
				} else {
					$("#refesh").attr("style", "display:none");
				}
			}
			//
			function ajaxSubmit(url, param, type, call) {
				url = root + url;
				if(param==null||param==''){
					param = "random="+Math.random();
				}else {
					var isjson = typeof(param) == "object" && Object.prototype.toString.call(param).toLowerCase() == "[object object]" && !param.length;
					if(isjson){
						param["random"] =Math.random();
					}else{
						param = param + "&random="+Math.random();
					}
				}
				$.ajax({
					contentType : "application/x-www-form-urlencoded; charset=utf-8",
					data: param,
					type: type,
					url: url,
					success :call,
					error : function(req) {
						reload(false);
						$('#breadcrumb').append('<li class="active">出现错误!</li>');
						$('#content-container').append(alertMsg);
					},complete: function (XHR, TS) { XHR = null }
				});
			}
		</script>
</div>