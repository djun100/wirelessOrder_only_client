/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : Menu.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.entity;

import java.io.Serializable;

/**
 * Menu ʵ����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:30:35
 */
public class Menu implements Serializable {
	
	private static final long serialVersionUID = -9040088739624114953L;
	//id
	private int id;
	// �˵�������
	private String menuname;
	// �˵��ļ۸�
	private String price;
	// �����۸�
	private String cutprice;
	// ���׽���
	private String introduce;
	// ������
	private String discount;
	// �Ƿ����
	private boolean isdiscount;
	// �Ƿ�ɵ�
	private boolean isorder;
	// �����˶��ٴ�
	private int ordertime;
	// �Ƿ�Ϊ��ʦ�Ƽ�
	private boolean isrecommend;
	// ��ϵ
	private Sort sort;
	// ����
	private String address;
	// ���ʱ��
	private String createdate;
	// �˵���ͼƬ����·��
	private String pic;
	//�����ѯ(�Ƽ���Ϣ)
	private int category;
	//���
	private Type type;
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getCutprice() {
		return cutprice;
	}

	public void setCutprice(String cutprice) {
		this.cutprice = cutprice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @return the isdiscount
	 */
	public boolean isIsdiscount() {
		return isdiscount;
	}

	/**
	 * @param isdiscount the isdiscount to set
	 */
	public void setIsdiscount(boolean isdiscount) {
		this.isdiscount = isdiscount;
	}

	/**
	 * @return the isorder
	 */
	public boolean isIsorder() {
		return isorder;
	}

	/**
	 * @param isorder the isorder to set
	 */
	public void setIsorder(boolean isorder) {
		this.isorder = isorder;
	}

	/**
	 * @return the isrecommend
	 */
	public boolean isIsrecommend() {
		return isrecommend;
	}

	/**
	 * @param isrecommend the isrecommend to set
	 */
	public void setIsrecommend(boolean isrecommend) {
		this.isrecommend = isrecommend;
	}

	public int getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(int ordertime) {
		this.ordertime = ordertime;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
