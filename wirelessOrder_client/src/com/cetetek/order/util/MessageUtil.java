/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
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
 * 消息帮助类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:52:08
 */
public class MessageUtil {
	/**
	 * 发送消息类
	 * @param handler 
	 * @param what 接受消息时的标示
	 * @param key 存放消息的关键字
	 * @param value 传入序列化的对象
	 */
	public static void sendMessage(Handler handler,int what,String key,Serializable value){
		Message message = new Message();
		message.what = what;
		message.getData().putSerializable(key, value);
		handler.sendMessage(message);
	}
}
