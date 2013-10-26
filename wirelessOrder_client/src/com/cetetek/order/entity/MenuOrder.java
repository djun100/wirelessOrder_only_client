/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : OrderMenu.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * orderMenu 实体类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:36:34
 */
public class MenuOrder implements Serializable{

	private static final long serialVersionUID = 7125217191299078475L;
	
	//主键
	private int id;
	//菜肴外键
	private Menu menu;
	//订单外键
	private Order order;
	//所定数量
	private int num;
	//当前所订菜肴的状态
	private int status;
	//备注信息
	private String remark;
	
	private String existIndex;
 
	

	public String getExistIndex() {
		return existIndex;
	}

	public void setExistIndex(String existIndex) {
		this.existIndex = existIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
