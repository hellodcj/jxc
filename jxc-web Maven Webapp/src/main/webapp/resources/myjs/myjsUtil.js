/**
 * 获取对象中的表单json格式数据
 */
function getJsonParam(obj){
	var param = {};
	$("input,select",obj).each(function(){
		var name = this.name;
		var val = this.value;
		if(name!=undefined&&name!=null&&name!=""){
			param[name]=val;
		}
	});	
	return JSON.stringify(param);
}

/**
	多选框value值获取
**/
function multSelectValueGet(obj){
	var selectedval = $(obj).selectpicker('Mustard').val();
	return selectedval==null?[]:selectedval;
}

/**
同步下拉
**/
function syslyzeMultSelectOption(obj){
	$(obj).selectpicker('refresh');
}
