package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * ��ɫʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-16 ����03:06:23
 */
public class Role implements Serializable{

	private static final long serialVersionUID = 4096357252794476120L;
	// ��ɫid
	private int id;
	// ��ɫ����
	private String rolename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
