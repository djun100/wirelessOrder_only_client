/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : LoginService.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.service;

import java.util.Map;

import org.json.JSONObject;

import com.cetetek.order.entity.User;
import com.cetetek.order.util.ServiceUtil;

/**
 * 登录Service
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:59:20
 */
public class LoginService extends ServiceUtil<User>{
	public static User login(String path,Map<String, String> params) throws Exception{
		String json = postRequest(path, params);
		JSONObject jsonObject = new JSONObject(json);
		User user = new User();
		try {
			user.setId(jsonObject.getInt("id"));
			user.setUsername(jsonObject.getString("username"));
			user.setPassword(jsonObject.getString("password"));
		} catch (Exception e) {
			return null;
		}
		return user;
	}
}
