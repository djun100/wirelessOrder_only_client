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

import com.cetetek.order.entity.Tables;
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
public class TablesService extends ServiceUtil<Type>{
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<Tables> tablesList;
	public TablesService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * 存入数据到SQLite数据库中 
	 * @param tables
	 */
	public void insert(Tables tables){
		String sql = "insert into t_tables (isSmoke,personNum,remark,shape,site,status,tablenum)values(?,?,?,?,?,?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{});
		db.close();
	}
	
/*	*//**
	 * 从服务器端请求得到所有的tables数据
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public List<Tables> getAllTables() throws Exception{
		tablesList = new ArrayList<Tables>();
		byte[] data = HTTPUtil.downloadGET(SystemCount.TABLES);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONArray array = new JSONArray(json);
		for(int i=0;i<array.length();i++){
			JSONObject jsonObject = (JSONObject) array.get(i);
			Tables tables = new Tables();
			tables.setId(jsonObject.getInt("id"));
			tables.setIsSmoke(jsonObject.getInt("isSmoke"));
			tables.setPersonNum(jsonObject.getInt("personnum"));
			tables.setRemark(jsonObject.getString("remark"));
			tables.setShape(jsonObject.getString("shape"));
			tables.setSite(jsonObject.getInt("site"));
			tables.setStatus(jsonObject.getInt("status"));
			tables.setTablenum(jsonObject.getInt("tablenum"));
			tablesList.add(tables);
		}
			return null;
		
	}
	
	/**
	 * 保存所有的数据进入本地数据库中
	 * @throws Exception
	 */
	public void saveAllTables(){
		try {
			getAllTables();
			for(Tables tables : tablesList){
				insert(tables);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
