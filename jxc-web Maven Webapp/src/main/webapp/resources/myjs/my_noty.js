var _noty = function(dom,content,placement,time) {
	dom.popover({
        content : content,
        placement:placement,
        animation:true
	}).popover('show',1000);
	setTimeout(_delayHide,time,dom);
}

var _delayHide = function(dom) {
	dom.popover('hide').popover('destroy');
}

var _my_alert = function(title,text,t) {
	var unique_id = $.gritter.add({
		title: title,
		text: text,
		sticky: true,
		class_name: 'gritter-info gritter-myposition gritter-light'
	});
	setTimeout(function(){
		$.gritter.remove(unique_id, {
			fade: true,
			speed: 'slow'
		});
	}, t||2000);
}
