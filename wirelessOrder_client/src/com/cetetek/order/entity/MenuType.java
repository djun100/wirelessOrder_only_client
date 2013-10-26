/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : MenuType.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * MenuType ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:37:53
 */
public class MenuType implements Serializable{

	private static final long serialVersionUID = -3811707736511519230L;
	//��������ϵid
	private int id;
	//����ʵ����
	private Menu menu;
	//����ʵ����
	private Type type;
	
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

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
