/*************************************************
Function:		Video
Description:	视频参数初始化
*************************************************/

function Video() {
	this.uname="";
	this.pwd = "";
	this.hostip = "";
	this.hostport = "";
	this.rtspport = "";
	this.code = "";
	this.wh = 0;
	if(navigator.appName == "Netscape"|| navigator.appName == "Opera"){
		this.wh = -40;
	}
}

Video.prototype = {
		_init:function(d){
			var that = this;
			$.getJSON(root+'/data/loadConfigAjax?se='+d+'&random='+Math.random(), null, function(result) {
        		that.uname=result.videologinname;
        		that.pwd=result.videologinpwd;
        		that.hostip=result.videourl;
        		that.hostport=result.videoport;
        		that.rtspport=result.videortspport;
        		that.code = Base64.encode(that.uname+":"+that.pwd);
    			$.cookie('language', 'zh');
    			$.cookie("userInfo"+that.hostport, that.code);
        	});
		},
		checkPlugin:function(szInfo, iWndType, szPlayMode,PreviewActiveX,divframe) {
			var trs = $(".form-group",divframe);
			var td = null;
			var tds = $("div",trs[trs.length-1]);
			if($(tds[tds.length-1]).html().trim().length>0){
				var clonediv = $("#clonedivfor","#homevedio").clone().removeAttr("id");
				$(divframe).find("#main_plugin").append(clonediv);
				td=$("div",clonediv)[0];
			}else{
				for(var i in tds){
					if(td==null&&tds[i].innerHTML.trim()==""){
						td=tds[i];
						break;
					}
				}
			}
			$("div",$("#main_plugin")).each(function(){
				//$(this).css({"padding-left":"0px","padding-right":"1px","padding-top":"1px","padding-bottom":"1px"});
			});
			if(navigator.appName == "Netscape" || navigator.appName == "Opera") {
				var bInstalled = false;
				var len = navigator.mimeTypes.length;
				var downurl = root + "/resources/media/WebComponents.exe";
				for(var i = 0; i < len; i++) {
					if(navigator.mimeTypes[i].type.toLowerCase() == "application/hwp-webvideo-plugin") {
						bInstalled = true;
						//$(td).html("<embed type='application/hwp-webvideo-plugin' id='"+PreviewActiveX+"' width='100%' height='288' name='PreviewActiveX' align='center' wndtype='"+iWndType+"' playmode='"+szPlayMode+"'>");
						$(td).html('<embed type="application/hwp-webvideo-plugin" id="'+PreviewActiveX+'" width="100%" height="288" name="PreviewActiveX" align="center" wndtype="1" playmode="'+szPlayMode+'">');
						$("#"+PreviewActiveX).hide();
						break;
					}
				}
				if(!bInstalled) {
					if(navigator.platform == "Win32") {
						$("#main_plugin").html("<label name='laPlugin' onclick='window.open(\""+downurl+"\",\"_self\")' class='pluginLink' onMouseOver='this.className =\"pluginLinkSel\"' onMouseOut='this.className =\"pluginLink\"'>"+szInfo+"<label>");
					} else if(navigator.platform == "Mac68K" || navigator.platform == "MacPPC" || navigator.platform == "Macintosh") {
						$("#main_plugin").html("<label name='laPlugin' onclick='' class='pluginLink' onMouseOver='' onMouseOut=''>"+szInfo+"<label>");
					} else {
						$("#main_plugin").html("<label name='laPlugin' onclick='' class='pluginLink' onMouseOver='' onMouseOut=''>"+szInfo+"<label>");
					}
					return false;
				}
			} else {
				$(td).html("<object classid='clsid:E7EF736D-B4E6-4A5A-BA94-732D71107808' codebase='' standby='Waiting...' id='"+PreviewActiveX+"' width='568' height='288' name='ocx' align='center' ><param name='wndtype' value='"+iWndType+"'><param name='playmode' value='"+szPlayMode+"'></object>");
				var previewOCX = $("#"+PreviewActiveX)[0];
				if(previewOCX == null || previewOCX.object == null) {
					if((navigator.platform == "Win32") || (navigator.platform == "Windows")) {
						$("#main_plugin").html("<label name='laPlugin' onclick='window.open(\""+downurl+"\",\"_self\")' class='pluginLink' onMouseOver='this.className =\"pluginLinkSel\"' onMouseOut='this.className =\"pluginLink\"'>"+szInfo+"<label>");
					} else if(navigator.platform == "Mac68K" || navigator.platform == "MacPPC" || navigator.platform == "Macintosh") {
						$("#main_plugin").html("<label name='laPlugin' onclick='' class='pluginLink' onMouseOver='' onMouseOut=''>"+szInfo+"<label>");
					} else {
						$("#main_plugin").html("<label name='laPlugin' onclick='' class='pluginLink' onMouseOver='' onMouseOut=''>"+szInfo+"<label>");
					}
					return false;
				}
			}
			return true;
		},
		initCCTV:function(channel,divframe) {
			channel = channel.toString();
			var chanels=[];
			if(channel.indexOf(":")!=-1){
				chanels=channel.split(":");
			}else{
				chanels[0]=channel;
			}
			//$('.modal1').css({'display':'block','width':'1px','height':'1px'});
			for(var s in chanels){
				if(chanels[s]==undefined||chanels[s]==null){
					continue;
				}
				console.log(chanels[s]);
				var PreviewActiveXid = "PreviewActiveX"+Math.random().toString().substring(2,10);
				this.checkPlugin('提示信息', 'laPlugin', 4,PreviewActiveXid,divframe);
				var previewOCX = $("#"+PreviewActiveXid)[0];
				if(previewOCX == null) {
					continue;
				}
				$(previewOCX).parent().append("<input type= 'hidden' rtspport="+this.rtspport+" hostip="+this.hostip+" chanels="+chanels[s]+" code="+this.code+" />");
				//previewOCX.HWP_Play("rtsp://"+this.hostip+":"+this.rtspport+"/PSIA/streaming/channels/"+chanels[s],this.code,0,"","")
			}
			$('.modal1').css({'width':'auto','height':'auto'});
			//$('#cctvDiv').modal('show');
			//$('#main_plugin').css({'width':'352px','height':'288px'});
		},
		showVideo:function(){
			pt.menu_change('nav06',document.getElementById('m_videoshow'));
			var url = "http://"+this.hostip+":"+this.hostport+"/doc/page/main.asp";
			$('#content-container').html('<iframe id="videoFrame"  style="margin-top: '+this.wh+'px;margin-left: -20px;margin-left: -20px" src="'+url+'" width="100%" height="600" onload="m_video.clearVideo();"></iframe>');
		},
		clearVideo:function(){
			$(window.frames["videoFrame"].document).find("#header").replaceWith("");
			$(window.frames["videoFrame"].document).find("#curruser").replaceWith("");
//			$(window.frames["videoFrame"].document).find("label[name='laCopyRight']").html("");
			$(window.frames["videoFrame"].document).find("label[name='laExit']").replaceWith("");
		}
}

var m_video = new Video();

function clearVedio(){
	$("#main_plugin").find(".form-group").each(function(i){
		var id = this.id;
		if(id!=undefined&&id!=null&&id=="clonedivfor"){
			$("div",this).html("");
		}else{
			$(this).remove();
		}
	});
}

function checkAll(obj){
	if(obj!=null){
		var table = $(obj).parent().parent().parent().parent();
		if(obj.checked==true){
			$("[name=checkid]",table).each(function(){
				this.checked=true;
			});
		}else{
			$("[name=checkid]",table).each(function(){
				this.checked=false;
			});
		}
	}
}
//全屏显示
function fullscreen (obja,objb){
	$(obja).click(function(e) {
		var atxt = $(obja).text();
    	$(".modal-content,.modal-body,.modal-dialog,[name=PreviewActiveX]",objb).each(function(){
    		if(atxt=="放大"||atxt==""){
    			var widt = this.width;
	    		if(this.tagName.toLowerCase()=="div"){
	    			if($(this).attr("class")=="modal-dialog"){
	    				$(this).css({"margin-left":"0px","margin-right":"0px"});
	    			}else{
	    				$(this).css({"width":window.screen.availWidth,"height":window.screen.availHeight-100});
	    			}
	    		}else{
	        		$(this).css({"width":"100%","height":((window.screen.availWidth)/widt*288)+"px"});
	    		}
	    		$(obja).text("缩小");
    		}else{
    			if(this.tagName.toLowerCase()=="div"){
    				if($(this).attr("class")=="modal-dialog"){
	    				$(this).css({"margin-left":"auto","margin-right":"auto"});
	    			}else{
	    				$(this).css({"width":"800px","height":"100%"});
	    			}
	    		}else{
	    			$(this).css({"width":"100%","height":"288px"});
	    		}
    			$(obja).text("放大");
    		}
    	});
    	$(obja).css({"font-size:":"20px"});
    });
}

/**
 * 克隆视频窗口框架
 */
function cloneVedioDiv(name,id){
	var radom = Math.random().toString().substring(2,10);//随机数
	//克隆头
	var head =  $("#colnelivedio").clone().attr("id","vediotitl_"+id+"_"+radom).removeAttr("class");
	$("[role=tab]",head).attr("href","#vediobody_"+radom).html("<a href='javascript:void(0);'>"+name+"</a>");
	$("#videoTabs").append(head);
	$("#vediotitl_"+id+"_"+radom+":not([id=colnelivedio])").show()
	
	//克隆body
	var vedioframbody = $("#homevedio").clone().attr("id","vediobody_"+radom).removeAttr("class").attr("class","tab-pane");
	$("#videoContents").append(vedioframbody);
	if(($(".tab-pane","#videoContents").length<=2)){
		 $("#vediobody_"+radom).show();
		var tme1= setTimeout(function(){
			 showVedioOnly($("[role=tab]",head));
			 clearTimeout(tme1);
		 },300);
	} 
	return $("#vediobody_"+radom);
}

/**
 * 显示按钮下的视频
 * @param div
 */
function showVedioOnly(div){
	var divid = $(div).attr("href");
	$("[name='PreviewActiveX']","#videoContents .tab-pane:not("+divid+")").each(function(){//隐藏其他视频
		var hideinput = $(this).parent().find("input[type=hidden]");
		$(this).parent().html(this.outerHTML+hideinput[0].outerHTML);
		$("#"+this.id).hide();
	});
	$(divid).show();
	$("[name='PreviewActiveX']",divid).each(function(){//开启lable对应的视频
		$(this).show();
		/* 获取端口信息 开始*/
		var hideinput = $(this).parent().find("input[type=hidden]");
		var  hostip = $(hideinput).attr("hostip");
		var  rtspport = $(hideinput).attr("rtspport");
		var  chanels = $(hideinput).attr("chanels");
		var  code = $(hideinput).attr("code");
		/* 提示控件 结束*/
		try{
			this.HWP_Play("rtsp://"+ hostip+":"+rtspport+"/PSIA/streaming/channels/"+chanels,code,0,"","");
		}catch(e){
			var tm3 = setTimeout(function(){
				showVedioOnly(div);
				clearTimeout(tm3);
			},500);
		}
	});
}
