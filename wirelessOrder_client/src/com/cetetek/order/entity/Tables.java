/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : Tables.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * Table 实体类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:33:46
 */
public class Tables implements Serializable{

	private static final long serialVersionUID = -2158905864646708301L;
	//餐桌id
	private int id;
	// 餐桌的标号
	private int tablenum;
	// 是否为无烟区（0为无 1为有）
	private int isSmoke;
	// 可坐多少人
	private int personNum;
	// 餐桌的形状
	private String shape;
	// 餐桌的图片
	private String pic;
	// 餐桌的状态
	private int status;
	// 餐桌在前台显示的位置
	private int site;
	// 餐桌的详细描述/备注
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTablenum() {
		return tablenum;
	}
	public void setTablenum(int tablenum) {
		this.tablenum = tablenum;
	}
	public int getIsSmoke() {
		return isSmoke;
	}
	public void setIsSmoke(int isSmoke) {
		this.isSmoke = isSmoke;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSite() {
		return site;
	}
	public void setSite(int site) {
		this.site = site;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
}
