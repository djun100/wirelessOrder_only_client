/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : Type.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * Type ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:31:38
 */
public class Type implements Serializable{

	private static final long serialVersionUID = -4652817993752781734L;
	//���id
	private int id;
	// �˵����������
	private String typename;
	//���׷������
	private String introduce;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
