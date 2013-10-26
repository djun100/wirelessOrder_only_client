package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * 酒店员工实体类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-16 下午03:04:16
 */
public class User implements Serializable{

	private static final long serialVersionUID = 438498177384139826L;
	// 定义id
	private int id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 是否可用
	private int isenable;
	// 分配的权限
	private Role role;
	// 备注信息
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
