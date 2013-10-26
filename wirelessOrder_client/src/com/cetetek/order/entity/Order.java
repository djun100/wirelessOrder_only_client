/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : Order.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * order ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:29:15
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 2330542724052503954L;
	//����id
	private int id;
	// �������
	private String num;
	// �µ���ʱ��
	private String orderdate;
	// ��һ���µ�
	private Tables tables;
	// ��������������
	private int personnum;
	// �Ƿ񸶿�
	private boolean ispay;
	// �����ܶ�
	private String total;
	// ��ǰ������״̬
	private String status;
	// ��ע��Ϣ
	private String remark;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Tables getTables() {
		return tables;
	}
	public void setTables(Tables tables) {
		this.tables = tables;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getPersonnum() {
		return personnum;
	}
	public void setPersonnum(int personnum) {
		this.personnum = personnum;
	}
	public boolean isIspay() {
		return ispay;
	}
	public void setIspay(boolean ispay) {
		this.ispay = ispay;
	}
	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}
	
}
