/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : MessageUtil.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

import java.io.Serializable;

import android.os.Handler;
import android.os.Message;

/**
 * ��Ϣ������
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:52:08
 */
public class MessageUtil {
	/**
	 * ������Ϣ��
	 * @param handler 
	 * @param what ������Ϣʱ�ı�ʾ
	 * @param key �����Ϣ�Ĺؼ���
	 * @param value �������л��Ķ���
	 */
	public static void sendMessage(Handler handler,int what,String key,Serializable value){
		Message message = new Message();
		message.what = what;
		message.getData().putSerializable(key, value);
		handler.sendMessage(message);
	}
}
