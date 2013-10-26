package com.cetetek.order.entity;
/**
 * 提供菜谱信息
 */
public class GridInfo {
	private Integer image;
	private String name;
	private Float price;
	private Integer count;
	
	public GridInfo(Integer image, String name, Float price, Integer count) {
		this.image = image;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public Integer getImage() {
		return image;
	}
	public void setImage(Integer image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
