/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
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
 * ���ڡ��ַ���������
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:47:38
 */
public class DateUtil {
	/**
	 * �������ڸ�ʽΪ�� yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getNowDateTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	/**
	 * ��ȡ�ַ��������ڶ������
	 * @return
	 */
	public static String getOrderNum(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + new Random().nextInt(1000);
	}
}
