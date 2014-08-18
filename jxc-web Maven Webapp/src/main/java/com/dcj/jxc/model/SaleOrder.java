package com.dcj.jxc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_saleorder")
public class SaleOrder {
	private int id;
	private Date ordertime;
	private Custom custom;
	private Set<SaleOrderItem> items = new HashSet<SaleOrderItem>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	
	@ManyToOne
	@JoinColumn(name="custom_id")
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "saleOrder")
	public Set<SaleOrderItem> getItems() {
		return items;
	}
	public void setItems(Set<SaleOrderItem> items) {
		this.items = items;
	}
	
	
}
