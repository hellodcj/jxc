function JsContext() {
	this.method = [];
	this.intervalId = [];
	this.ownMethod = null;
}

JsContext.prototype = {
	clear : function() {
		if(this.ownMethod!=null)
			this.ownMethod();
		for (m in this.method) {
			delete window[this.method[m]];
		}
		this.method = [];
		for (inter in this.intervalId) {
			clearInterval(this.intervalId[inter]);
		}
		this.intervalId = [];
	},
	init:function(ms,inters,m){
		this.method = ms;
		this.intervalId = inters;
		this.ownMethod = m;
	}
}

var jsContext = new JsContext();
