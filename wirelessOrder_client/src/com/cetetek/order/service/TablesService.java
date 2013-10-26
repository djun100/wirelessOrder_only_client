/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
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
 * ���Service
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16����03:39:48
 */
public class TablesService extends ServiceUtil<Type>{
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<Tables> tablesList;
	public TablesService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * �������ݵ�SQLite���ݿ��� 
	 * @param tables
	 */
	public void insert(Tables tables){
		String sql = "insert into t_tables (isSmoke,personNum,remark,shape,site,status,tablenum)values(?,?,?,?,?,?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{});
		db.close();
	}
	
/*	*//**
	 * �ӷ�����������õ����е�tables����
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
	 * �������е����ݽ��뱾�����ݿ���
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
