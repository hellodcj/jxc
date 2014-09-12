package com.dcj.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.dcj.jxc.model.Material;

public class ViewExcel extends AbstractExcelView{
	 public void buildExcelDocument(Map model, HSSFWorkbook workbook,   
	            HttpServletRequest request, HttpServletResponse response)   
	            throws Exception {   
	        HSSFSheet sheet = workbook.createSheet("list");   
	        getCell(sheet, 0, 0).setCellValue("库存情况");  
	        getCell(sheet, 1, 0).setCellValue("物料名称");  
	        getCell(sheet, 1, 1).setCellValue("物料类别"); 
	        getCell(sheet, 1, 2).setCellValue("物料单位"); 
	        getCell(sheet, 1, 3).setCellValue("库存"); 
	        List<Material> l = (List<Material>) model.get("list");
	        int i =0;
	        for (Material m :l){
	        	HSSFRow sheetRow = sheet.createRow(2+i);   
	        	i++;
	        	sheetRow.createCell(0).setCellValue(m.getName());
	        	sheetRow.createCell(1).setCellValue(m.getCategory());
	        	sheetRow.createCell(2).setCellValue(m.getUnit());
	        	sheetRow.createCell(3).setCellValue(m.getStorageNum());
	        }
	  
	    }   
}
