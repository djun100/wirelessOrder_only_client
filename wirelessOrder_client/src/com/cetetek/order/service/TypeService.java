/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : TypeService.java 
 * Date : 2011-9-16
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cetetek.order.entity.Type;
import com.cetetek.order.util.DBHelper;
import com.cetetek.order.util.HTTPUtil;
import com.cetetek.order.util.ServiceUtil;
import com.cetetek.order.util.SystemCount;

/**
 * 类别Service
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16下午03:39:48
 */
public class TypeService extends ServiceUtil<Type>{
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<Type> typeList;
	public TypeService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * 存入数据到SQLite数据库中 
	 * @param type
	 */
	public void insert(Type type){
		String sql = "insert into t_type (typename,introduce)values(?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{type.getTypename(),type.getIntroduce()});
		db.close();
	}
	
	/**
	 * 从服务器端请求得到所有的type数据
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<Type> getAllType() throws Exception{
		typeList = new ArrayList<Type>();
		byte[] data = HTTPUtil.downloadGET(SystemCount.TYPE);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONArray array = new JSONArray(json);
		for(int i=0;i<array.length();i++){
			JSONObject jsonObject = (JSONObject) array.get(i);
			Type type = new Type();
			type.setId(jsonObject.getInt("id"));
			type.setIntroduce(jsonObject.getString("introduce"));
			type.setTypename(jsonObject.getString("typename"));
			typeList.add(type);
		}
			return typeList;
		
	}
	
	public void saveAllType(){
		try {
			getAllType();
			for(Type type : typeList){
				insert(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
