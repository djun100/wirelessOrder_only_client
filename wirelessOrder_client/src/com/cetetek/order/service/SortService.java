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
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cetetek.order.entity.Sort;
import com.cetetek.order.entity.Type;
import com.cetetek.order.util.DBHelper;
import com.cetetek.order.util.HTTPUtil;
import com.cetetek.order.util.ServiceUtil;
import com.cetetek.order.util.SystemCount;

/**
 * ��ϵ���Service
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16����03:39:48
 */
public class SortService extends ServiceUtil<Type>{
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<Sort> sortList;
	public SortService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * �������ݵ�SQLite���ݿ��� 
	 * @param sortMenu
	 */
	public void insert(Sort sort){
		String sql = "insert into t_sort (sortname,introduce)values(?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{sort.getSortname(),sort.getIntroduce()});
		db.close();
	}
	
/*	*//**
	 * �ӷ�����������õ����е�tables����
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public void getAllSort() throws Exception{
		sortList = new ArrayList<Sort>();
		byte[] data = HTTPUtil.downloadGET(SystemCount.SORT);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONArray array = new JSONArray(json);
		for(int i=0;i<array.length();i++){
			JSONObject jsonObject = (JSONObject) array.get(i);
			Sort sort = new Sort();
			sort.setId(jsonObject.getInt("id"));
			sort.setSortname(jsonObject.getString("sortname"));
			sort.setIntroduce(jsonObject.getString("introduce"));
			sortList.add(sort);
		}
	}
	
	/**
	 * �������е����ݽ��뱾�����ݿ���
	 * @throws Exception
	 */
	public void saveAllSort(){
		try {
			getAllSort();
			for(Sort sort : sortList){
				insert(sort);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
