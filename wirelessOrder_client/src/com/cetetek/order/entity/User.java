package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * �Ƶ�Ա��ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-16 ����03:04:16
 */
public class User implements Serializable{

	private static final long serialVersionUID = 438498177384139826L;
	// ����id
	private int id;
	// �û���
	private String username;
	// ����
	private String password;
	// �Ƿ����
	private int isenable;
	// �����Ȩ��
	private Role role;
	// ��ע��Ϣ
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsenable() {
		return isenable;
	}
	public void setIsenable(int isenable) {
		this.isenable = isenable;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
