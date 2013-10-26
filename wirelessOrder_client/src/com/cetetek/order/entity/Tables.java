/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : Tables.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * Table ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:33:46
 */
public class Tables implements Serializable{

	private static final long serialVersionUID = -2158905864646708301L;
	//����id
	private int id;
	// �����ı��
	private int tablenum;
	// �Ƿ�Ϊ��������0Ϊ�� 1Ϊ�У�
	private int isSmoke;
	// ����������
	private int personNum;
	// ��������״
	private String shape;
	// ������ͼƬ
	private String pic;
	// ������״̬
	private int status;
	// ������ǰ̨��ʾ��λ��
	private int site;
	// ��������ϸ����/��ע
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
