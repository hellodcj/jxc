package com.dcj.dto;

import java.util.Date;

public class PurchaseDto {
	private Integer[] m_id; //明细单中的物理id
	private Integer[] num; //明细单中的数量
	private Float[] price; //明细单中的单价
	private Integer vendor_id; //供应商id
	private Date orderDate ; //时间
	public Integer[] getM_id() {
		return m_id;
	}
	public void setM_id(Integer[] m_id) {
		this.m_id = m_id;
	}
	public Integer[] getNum() {
		return num;
	}
	public void setNum(Integer[] num) {
		this.num = num;
	}
	public Float[] getPrice() {
		return price;
	}
	public void setPrice(Float[] price) {
		this.price = price;
	}
	public Integer getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(Integer vendor_id) {
		this.vendor_id = vendor_id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
