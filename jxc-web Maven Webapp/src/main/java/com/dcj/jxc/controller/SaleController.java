package com.dcj.jxc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcj.dto.SaleDto;
import com.dcj.jxc.model.Custom;
import com.dcj.jxc.model.Material;
import com.dcj.jxc.model.SaleOrder;
import com.dcj.jxc.service.ICustomService;
import com.dcj.jxc.service.IMaterialService;
import com.dcj.jxc.service.ISaleService;

@Controller
@RequestMapping(value="/sale")
public class SaleController {
	private ISaleService saleService;
	private IMaterialService matService;
	private ICustomService customService;
	
	@Inject
	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}
	@Inject
	public void setMatService(IMaterialService matService) {
		this.matService = matService;
	}
	@Inject
	public void setCustomService(ICustomService customService) {
		this.customService = customService;
	}

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
		//String graghData = JsonUtils.writeObjToString(map);
		model.addAttribute("graghData",map);
		return "/sale/linegragh";
	}
	
	/**
	 * 添加销售单的跳转
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(ModelMap model){
		//1.获得客户的列表信息
		List<Custom> vl = customService.listCustom();
		//2.获得物料的信息列表
		List<Material> ml = matService.listMaterial();
		//3.将信息放入model
		model.addAttribute("vl", vl);
		model.addAttribute("ml", ml);
		return "/sale/add";
	}
	
	/**
	 * 提交表单，添加销售单
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saves(SaleDto dto){
		saleService.saveSale(dto);
		return "redirect:/sale/add";
	}
	
	/**
	 * 按月进行历史销售的跳转
	 * @return
	 */
	@RequestMapping(value="/listByMonth",method=RequestMethod.GET)
	public String listByMonthPage(){
		return "/sale/list";
	}
	
	/**
	 * 按月进行历史销售的列表显示
	 */
	@RequestMapping(value="/listByMonth",method=RequestMethod.POST)
	public String listByMonth(String month,ModelMap model){
		List<SaleOrder> pol = saleService.listByMonth(month);
		model.addAttribute("pol", pol);
		return "/purchase/list";
	}
}
