package com.cetetek.order.entity;

import com.cetetek.order.activity.R;


/**
 * 提供订单信息
 */
public class PlanOrderInfo {
	private String category;
	private String name;
	private Integer count;
	private Float price;
	private Float subtotal;
	private Integer image;
	
	public PlanOrderInfo(String category, String name, Integer count, Float price) {
		this.category = category;
		this.name = name;
		this.count = count;
		this.price = price;
		this.subtotal = count * price;
		this.image = R.drawable.delete;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getImage() {
		return image;
	}
	public void setImage(Integer image) {
		this.image = image;
	}
	
	
}
