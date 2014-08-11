var wsServer = $('#websocket-servlet').val();
websocket = new WebSocket(wsServer);
websocket.onopen = function(evt) {
	console.log('connect websocket');
    // websocket.send('open');
};
websocket.onclose = function(evt) {
	if(intervalId) clearInterval(intervalId);
    alert('服务连接失败!!!');
};
websocket.onmessage = function(evt) {
	//console.log(evt.data);
	if(evt.data == '')
		return;
	console.log(evt.data);
	var data = eval('(' + evt.data + ')');
	var sensors = data.sensors, dataTmp = data.dataTmp;
	for(var i in sensors) {
		var sensor = sensors[i];
		var tval = dataTmp['v'+sensor.port];
		var dom = $('#sen_'+sensor.id), chat = $('#modal-content-1');
		if(chat.length != 0 && sensor.id == $('#msid').val()) {
			// data.tvalue != -9999
			if(tval != -9999)
				addPoint([dataTmp.ttime, tval]);
			//addPoint([new Date().getTime(), Math.random()*1000]);
		}
		
		if(dom.length != 0) {
			var map_sen_val = tval != -9999 ? sensor.type != 0 ? tval == 0 ? sensor.lowdes : sensor.highdes : tval : '断线';
            setFlagAlarm(dom, sensor, tval);
            //showTip(dom);
            //setTimeout(delayHide, 1000, dom);
            $('#map-sen-val-'+sensor.id).text(map_sen_val);
		}
	}
	console.log('========================');
	console.log(data);
	console.log('========================');
};
var showTip = function(dom) {
    dom.popover({
                title : dom.attr('data-title'),
                content : dom.attr('data-content')
    }).popover('show', 1000);// 测点显示信息
};

var delayHide = function(dom) {
	dom.popover('hide').popover('destroy');
}
//设置测点图片和提示信息
var setFlagAlarm = function(dom, sensor, tval) {
    var curval = tval | 0, alarmup = sensor.alarmup, alarmdown = sensor.alarmdown;
    if (curval == -9999 || (sensor.type == 1 && sensor.normal != curval) || (curval >= alarmup && alarmup != 0) || (curval <= alarmdown && alarmdown != 0)) {
        dom.attr('src', root+'/resources/map/alarm-flag-2.png');
        //showTip(dom);
    } else {
        dom.attr('src', root+'/resources/map/alarm-flag-0.png');
    }
    dom.attr('data-content', '当前值：' + curval == -9999 ? '断线' : curval + '上控值：' + alarmup + '下控值：' + alarmdown);
};