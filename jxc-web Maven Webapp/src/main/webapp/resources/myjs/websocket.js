var wsServer = $('#websocket-servlet').val();
var websocket;
function init() {
	if (!websocket||websocket==null){
		websocket = new WebSocket(wsServer);
		websocket.onopen = function(evt) {
			console.log('connect websocket');
		};
		websocket.onclose = function(evt) {
			websocket = null;
		};
		// 默认socket信息监听
		websocket.onmessage = serverNotify;
	}
}
// 全局监听返回信息
function globalNotify(evt) {
	if(evt.data == '')
		return 0;
	var d = eval('(' + evt.data + ')');
	if(d.type == 'init') { // 分站初始化
		console.log('globalNotify>>>>>> ' + d.rs);
		var s = '';
		for(var i in d.rs) {
			if(d.rs[i] == 1) {
				s += '通道['+(i*1 + 1)+']设置失败\r\n';
			}
		}
		if(s == '') {
			_my_alert('分站初始化提示', '['+d.code+']号分站初始化完成', 5000);
		} else {
			alert('['+d.code+']号分站初始化失败：\r\n'+s);
		}
		return 0;
	}
	if(evt.data.indexOf('11000000')!=-1) { // 初始化开始
		var ppid = evt.data.split("000000")[1];
		theMainModal.show({title: '提示', body: '<i class="icon-spinner icon-spin orange bigger-125"></i>'+ppid+' 号分站正在初始化，请稍候<span style="color:red" id="aaa">10</span>秒...'});
		theMainModal.daojishi();
		return 0;
	} else if(evt.data == '21') { // 初始化结束
		theMainModal.hide();
		return 0;
	}  else if(evt.data == '001') {//
		_my_alert("","获取串口失败！");
		return 0;
	}
	return 1;
}
function serverNotify(evt) {
	//console.log('the initialize station return >>>>>' + evt.data);
	globalNotify(evt);
}

function setMessageFunction(url) {
	init();
	if(url==null){
		websocket.onmessage = null;
		return;
	}
	if (url.indexOf('/mon/map') != -1) {
		websocket.onmessage = onMessage4Map;
	} else if (url.indexOf('/mon/modal') != -1) {
		websocket.onmessage = onMessage4Trend;
	} else if(url.indexOf('/list/real/focus') != -1) {
		websocket.onmessage = onMessage4RealFocus;
	} else if (url.indexOf('/main/result') != -1) {
		websocket.onmessage = onMessage4Main;
	} else {
		websocket.onmessage = serverNotify;
	}
}

function onMessage4Main(evt) {
	// 先全局监听校验
	if(!globalNotify(evt)) return;
	var sid = $('#main-slt-stations').val();
	var data = eval('(' + evt.data + ')');
	if(data.sid == sid){
		for(var j in _main_result.sensors) {
			var ele = _main_result.sensors[j],
			    tval = data['v'+ele.port],
			    slider = $('#slider-range-'+ele.id);
			if(tval == -9999) {
				__cs(slider, 0, 'rgb(51,51,51)', '断线');
				continue;
			}
			if(ele.type == 0) {
				if((ele.alarmup != 0 && tval >= ele.alarmup) || (ele.alarmdown != 0 && tval <= ele.alarmdown)) {
					__cs(slider, tval, 'rgb(255,0,0)', tval);
				} else {
					__cs(slider, tval, 'rgb(0,255,0)', tval, 'rgb(51,51,51)');
				}
			} else {
				if(tval != ele.normal) {
					__cs(slider, 3, 'rgb(255,0,0)', tval == 0 ? ele.lowdes : ele.highdes);
				} else {
					__cs(slider, 6, 'rgb(0,255,0)', tval == 0 ? ele.lowdes : ele.highdes, 'rgb(51,51,51)');
				}
			}
		}
	}
}

function onMessage4Map(evt) {
	if(!globalNotify(evt)) return;
	var data = eval('(' + evt.data + ')');
	for(var i=1;i<=16;i++){
		var dom = $('#sen-'+data.sid+'-'+i);
		var sensor = dom.data('sensor');
		var tval=data['v'+i] ;
		if(dom.length!=0){
			var map_sen_val = tval != -9999 ? sensor.type != 0 ? tval == 0 ? sensor.lowdes : sensor.highdes : tval : '断线';
			setFlagAlarm(dom, sensor, tval);
			$('#map-sen-val-' +data.sid+'-'+i).text(map_sen_val);
			$('#map-sen-val-' +data.sid+'-'+i).parent().attr('data-content',
					sensor.pid + '号分站    '+(sensor.stname||'')+ '    '+map_sen_val);
		}
	}

}

function onMessage4RealFocus(evt) {
	/*console.log('evt-----');
	$('#sen_8_1').parent().attr("color", "red");*/
	if(!globalNotify(evt)) return;
	var data = eval('(' + evt.data + ')');
	for(var i=1; i<=16; i++) {
		var dom = $('#sensor_'+data.sid+'_'+i);
		if(dom.length!=0){
			var sensor = dom.data('sensor');
			var tval = data['v'+i];
			var map_sen_val;
			if(tval != -9999) { // 不是断线
				if(sensor.type != 0) { // 开关量
					if(tval == 0) {
						map_sen_val = sensor.lowdes;
					} else {
						map_sen_val = sensor.highdes;
					}
				} else { // 模拟量
					if((sensor.alarmdown!=0&&tval<=sensor.alarmdown)||(sensor.alarmup!=0&&tval>=sensor.alarmup)) { // 报警
						map_sen_val = "<span class=\"label label-danger\">"+tval+"</span>";
					} else {
						map_sen_val = tval;
					}
				}
			} else {
				map_sen_val = "<span class=\"label label-yellow\">断线</span>";
			}
			$('#sen_'+data.sid+'_'+i).empty();
			$('#sen_'+data.sid+'_'+i).append(map_sen_val);
		}
	}
}

function onMessage4Trend(evt) {
	//evt 为一条分站采集信息
	if(!globalNotify(evt)) return;
	var chat = $('#modal-content-1');
	var sid = $('#ssid').val();
	var port = $('#sport').val()
	var data = eval('(' + evt.data + ')');
	if(data.sid == sid){
		//当前分站数据
		var tval=data['v'+port] ;
		addPoint([ data.ttime,tval==-9999?null:tval]);
	}
}
var showTip = function(dom) {
    dom.popover({
                title : dom.attr('data-original-title'),
                content : dom.attr('data-content')
            }).popover('show', 1000);// 测点显示信息
};
var delayHide = function(dom) {
	dom.popover('hide').popover('destroy');
}
// 设置测点图片和提示信息
var setFlagAlarm = function(dom, sensor, tval) {
	var curval = tval || 0, alarmup = sensor.alarmup, alarmdown = sensor.alarmdown;
	if (curval == -9999 || (sensor.type == 1 && sensor.normal != curval) || (curval >= alarmup && alarmup != 0) || (curval <= alarmdown && alarmdown != 0)) {
		dom.attr('src', root + '/resources/images/st/'+sensor.alarmImage);
		// showTip(dom);
	} else {
		dom.attr('src', root + '/resources/images/st/'+sensor.normalImage);
	}
	dom.attr('data-content', '当前值：' + curval == -9999 ? '断线' : curval + '上控值：' + alarmup + '下控值：' + alarmdown);
};