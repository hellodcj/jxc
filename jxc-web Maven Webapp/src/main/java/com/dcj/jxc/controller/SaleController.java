package com.dcj.jxc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcj.utils.JsonUtils;

@Controller("saleController")
@RequestMapping(value="/sale")
public class SaleController {
	
	/**
	 * 销售曲线，折线图的跳转
	 */
	@RequestMapping(value="/linegragh",method=RequestMethod.GET)
	public String lineGraghPage(ModelMap model){
		//1.获得近三十天的日期数据，作为x轴的数据
		List<String> xAxis = new ArrayList<String>();
		for (int i=1;i<=30;i++){
			Calendar calendar=new GregorianCalendar(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			calendar.add(Calendar.DATE,i-30);
			//System.out.println(i+"=="+sdf.format(calendar.getTime()));
			xAxis.add(sdf.format(calendar.getTime()));
		}
		//2.暂时伪造一些销售额的数据，作为y轴的数据
		List<Float> yAxis = new ArrayList<Float>();
		for (float i=1.4f;i<=31;i++){
			yAxis.add(i);
		}
		//3.将数据放入modelmap中
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("xAxis", xAxis);
		map.put("yAxis", yAxis);
		String graghData = JsonUtils.writeObjToString(map);
	System.out.println(graghData);
		model.addAttribute("graghData",map);
		return "/sale/linegragh";
	}
}
