/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : DateUtil.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 日期、字符串帮助类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:47:38
 */
public class DateUtil {
	/**
	 * 生成日期格式为： yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	/**
	 * 获取字符串，用于订单编号
	 * @return
	 */
	public static String getOrderNum(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + new Random().nextInt(1000);
	}
}
