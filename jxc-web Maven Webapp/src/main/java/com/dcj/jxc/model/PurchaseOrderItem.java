package com.dcj.jxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_purchaseorder_item")
public class PurchaseOrderItem {
	private int id;
	private float price;
	private int number;
	private Material material;
	private PurchaseOrder puerchaseOrder;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@OneToOne
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@ManyToOne
	public PurchaseOrder getPuerchaseOrder() {
		return puerchaseOrder;
	}
	public void setPuerchaseOrder(PurchaseOrder puerchaseOrder) {
		this.puerchaseOrder = puerchaseOrder;
	}
	
}
