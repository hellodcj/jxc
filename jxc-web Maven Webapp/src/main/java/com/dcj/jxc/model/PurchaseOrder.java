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
@Table(name="t_purchaseorder")
public class PurchaseOrder {
	private int id;
	private Date ordertime;
	private Vendor vendor;
	private Set<PurchaseOrderItem> items = new HashSet<PurchaseOrderItem>();
	
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
	@JoinColumn(name="vendor_id")
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "puerchaseOrder")
	public Set<PurchaseOrderItem> getItems() {
		return items;
	}
	public void setItems(Set<PurchaseOrderItem> items) {
		this.items = items;
	}
	
	
}
