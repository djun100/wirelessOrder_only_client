/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : SystemCount.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

/**
 * 常量集合帮助类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:53:31
 */
public class SystemCount {
	//URL的基类
	public static final String BASE_URL = "http://192.168.1.109/wirelessOrder/api/";
	//登录
	public static final String LOGIN = BASE_URL+"login";
	//获取全部菜肴
	public static final String MENU = BASE_URL + "menu/all";
	//请求得到所有的菜肴类别关系表中的数据
	public static final String MENU_TYPE = BASE_URL + "menutype/all";
	//得到所有的餐桌数据
	public static final String TABLES = BASE_URL + "tables/all";
	//得到所有的类别的数据
	public static final String TYPE = BASE_URL + "type/all";
	//得到所有的菜系数据
	public static final String SORT = BASE_URL + "sort/all";
	//得到其中对应订单一份的订单关系数据
	public static final String MENU_ORDER = BASE_URL + "menuorder";
	//保存订单关系表中的信息
	public static final String MENU_ORDER_SAVE = BASE_URL + "order/save";
	//保存一条订单信息
	public static final String ORDER_SAVE = BASE_URL + "menuorder/save";
	
	//图像文件的基本路径问题
	public static final String IMAGES_BASE = "/sdcard/order/images/";
}
