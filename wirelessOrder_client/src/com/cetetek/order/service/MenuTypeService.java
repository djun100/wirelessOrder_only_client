/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : MenuTypeService.java 
 * Date : 2011-8-16
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cetetek.order.entity.Menu;
import com.cetetek.order.entity.MenuType;
import com.cetetek.order.entity.Type;
import com.cetetek.order.util.DBHelper;
import com.cetetek.order.util.HTTPUtil;
import com.cetetek.order.util.ServiceUtil;
import com.cetetek.order.util.SystemCount;

/**
 * 类别Service
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-8-16下午04:59:48
 */
public class MenuTypeService extends ServiceUtil<Type>{
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<MenuType> menuTypeList;
	public MenuTypeService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * 存入数据到SQLite数据库中 
	 * @param menuType
	 */
	public void insert(MenuType menuType){
		String sql = "insert into t_menu_type (menuid,typeid)values(?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{menuType.getMenu().getId(),menuType.getType().getId()});
		db.close();
	}
	
/*	*//**
	 * 从服务器端请求得到所有的type数据
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public void getAllType() throws Exception{
		menuTypeList = new ArrayList<MenuType>();
		byte[] data = HTTPUtil.downloadGET(SystemCount.MENU_TYPE);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONArray array = new JSONArray(json);
		for(int i=0;i<array.length();i++){
			JSONObject jsonObject = (JSONObject) array.get(i);
			MenuType menuType = new MenuType();
			menuType.setId(jsonObject.getInt("id"));
			Menu menu = new Menu();
			menu.setId(jsonObject.getInt("menuid"));
			menuType.setMenu(menu);
			Type type = new Type();
			type.setId(jsonObject.getInt("typeid"));
			menuType.setType(type);
			menuTypeList.add(menuType);
		}
	}
	/**
	 * 保存所有的类别信息
	 * @param path
	 * @throws Exception
	 */
	public void saveAllType(){
		try {
			getAllType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(MenuType menuType : menuTypeList){
			insert(menuType);
		}
	}
}
