var Print = {
	print : function() {
		// 打开一个新窗口newWindow
		var newWindow=window.open("打印窗口","_blank");
		// 打印内容写入newWindow文档
		newWindow.document.write("<!doctype html><html>");
		newWindow.document.write("<link href='"+root+"/resources/css/bootstrap.min.css' rel='stylesheet' />");
		newWindow.document.write("<link href='"+root+"/resources/css/ace.min.css' rel='stylesheet' />");
		newWindow.document.write($('#printdiv').html());
		newWindow.document.write("</html>");
		// 关闭文档
		newWindow.document.close();
		// 调用打印机
		newWindow.print();
		// 关闭newWindow页面
		newWindow.close();
	},
	analog:function() {
		if ($('#value').val() == '') {
			alert('请先选择时间！');
			return;
		}
		var param = $("#data_alarm_form").serialize();
		trans2('/report/analog', '报表-模拟量报警日(班)报表', param);
	},
	analogbreak:function() {
		if ($('#value').val() == '') {
			alert('请先选择时间！');
			return;
		}
		if ($('#stid').val() == -1) {
			alert('请先选择分站！');
			return;
		}
		if ($('#sid').val() == -1) {
			alert('请先选择传感器！');
			return;
		}
		var param = $("#data_break_form").serialize();
		trans2('/report/analogbreak', '报表-模拟量断电日(班)报表', param);
	},
	analogback:function() {
		if ($('#value').val() == '') {
			alert('请先选择时间！');
			return;
		}
		if ($('#stid').val() == -1) {
			alert('请先选择分站！');
			return;
		}
		if ($('#sid').val() == -1) {
			alert('请先选择传感器！');
			return;
		}
		var param = $("#data_back_form").serialize();
		trans2('/report/analogabnormal', '报表-模拟量馈电异常日(班)报表', param);
	},
	dataSwitch:function() {
		if ($('#value').val() == '') {
			alert('请先选择时间！');
			return;
		}
		var param = $("#data_switch_form").serialize();
		trans2('/report/switch', '报表-开关量状态变动日(班)报表', param);
	}
}

