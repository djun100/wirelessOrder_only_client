/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : MenuService.java 
 * Date : 2011-9-16
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cetetek.order.entity.Menu;
import com.cetetek.order.entity.Sort;
import com.cetetek.order.entity.Type;
import com.cetetek.order.util.DBHelper;
import com.cetetek.order.util.HTTPUtil;
import com.cetetek.order.util.SystemCount;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16����03:10:27
 */
public class MenuService {
	
	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private ArrayList<Menu> menuList;
	public MenuService(Context context) {
		dbHelper = new DBHelper(context);
	}
	/**
	 * �������ݵ�SQLite���ݿ��� 
	 * @param menu
	 */
	public void insert(Menu menu){
		String sql = "insert into t_menu (menuname,price,cutprice,pic)values(?,?,?,?)";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{menu.getMenuname(),menu.getPrice(),menu.getCutprice(),menu.getPic()});
		db.close();
	}
	
	/**
	 * �������ݵ�SQLite���ݿ���
	 * @param menu
	 */
	public void update(Menu menu){
		String sql = "update t_menu set menuname=?,price=? where id = ?";
		db = dbHelper.getWritableDatabase();
		db.execSQL(sql,new Object[]{menu.getMenuname(),menu.getPrice()});
		db.close();
	}

	/**
	 * ��ѯ���еĲ���
	 * @return List<Menu>
	 */
	public List<Menu> query(){
		String sql = "select id,menuname,price,cutprice,pic from t_menu";
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		List<Menu> menus = new ArrayList<Menu>();
		while(cursor.moveToNext()){
			Menu menu = new Menu();
			menu.setId(cursor.getInt(0));
			menu.setMenuname(cursor.getString(1));
			menu.setPrice(cursor.getString(2));
			menu.setCutprice(cursor.getString(3));
			menu.setCutprice(cursor.getString(4));
			menus.add(menu);
		}
		cursor.close();
		db.close();
		return menus;
	}
	
	/**
	 * ����ID��ѯ
	 * @param id
	 * @return
	 */
	public Menu query(String id){
		String sql = "select id,menuname,price,cutprice from t_menu where id = ?";
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, new String[]{id});
		Menu menu = null;
		if(cursor.moveToNext()){
			menu = new Menu();
			menu.setId(cursor.getInt(0));
			menu.setMenuname(cursor.getString(1));
			menu.setPrice(cursor.getString(2));
			menu.setCutprice(cursor.getString(3));
		}
		cursor.close();
		db.close();
		return menu;
	}
	
	/**
	 * ��ѯ���ҷ�ҳ
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<Menu> page(String start,String pageSize){
		String sql = "select id,menuname,price,cutprice from t_menu limit ?,?";
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, new String[]{start,pageSize});
		List<Menu> menus = new ArrayList<Menu>();
		while(cursor.moveToNext()){
			Menu menu = new Menu();
			menu.setId(cursor.getInt(0));
			menu.setMenuname(cursor.getString(1));
			menu.setPrice(cursor.getString(2));
			menu.setCutprice(cursor.getString(3));
		}
		cursor.close();
		db.close();
		return menus;
	}
	/**
	 * �õ�ȫ���Ĳ���
	 * @return
	 */
	public List<Menu> getAllMenu(){
		menuList = new ArrayList<Menu>();
		try {
			byte[] data = HTTPUtil.downloadGET(SystemCount.MENU);
			String array = new String(data,HTTPUtil.HTTP_UTF8);
			JSONArray jsonArray = new JSONArray(array);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				//menu����
				Menu menu = new Menu();
				menu.setId(jsonObject.getInt("id"));
				menu.setAddress(jsonObject.getString("address"));
				menu.setCutprice(jsonObject.getString("cutprice"));
				menu.setPrice(jsonObject.getString("price"));
				menu.setIntroduce(jsonObject.getString("menuintroduce"));
				menu.setIsdiscount(Boolean.valueOf(jsonObject.getString("isdiscount")));
				menu.setIsorder(Boolean.valueOf(jsonObject.getString("isorder")));
				menu.setMenuname(jsonObject.getString("menuname"));
				menu.setOrdertime(jsonObject.getInt("ordertime"));
				menu.setPic(jsonObject.getString("pic"));
				menu.setCreatedate(jsonObject.getString("createdate"));
				menu.setCategory(jsonObject.getInt("category"));
				
				// Sort����
				Sort sort = new Sort();
				sort.setId(jsonObject.getInt("sortid"));
				sort.setSortname(jsonObject.getString("sortname"));
				sort.setIntroduce(jsonObject.getString("sortintroduce"));
				menu.setSort(sort);
				
				// type����
				Type type = new Type();
				type.setId(jsonObject.getInt("typeid"));
				type.setTypename(jsonObject.getString("typename"));
				type.setIntroduce(jsonObject.getString("typeintroduce"));
				menu.setType(type);
				
				menuList.add(menu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	/**
	 * ��ȫ�������ݲ���SQLite���ݿ���
	 */
	public boolean saveAllMenu(){
		
		try {
			//�õ�ȫ��������
			getAllMenu();
			for(Menu menu : menuList){
				insert(menu);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ���ݷ����ѯ������������menu����
	 * @param type
	 * @return
	 */
	public List<Menu> queryAll(String type) {
		StringBuffer sb = new StringBuffer("select");
		sb.append(" m.id as mid,m.menuname,m.address,m.introduce,m.price,m.cutprice,");
		sb.append(" m.pic,m.isOrder,m.ordertime,m.createDate,m.category,");
		sb.append(" s.id as sid,s.sortname,s.introduce as sintroduce,");
		sb.append(" t.id as tid,t.typename,t.introduce as tintroduce");
		sb.append(" from t_menu m");
		sb.append(" left join t_sort s on");
		sb.append(" m.sortid = s.id");
		sb.append(" left join t_type t on");
		sb.append(" m.typeid = t.id");
		sb.append(" where m.typeid" + type );
		String sql = "select id,menuname,price,pic from t_menu";
		db = dbHelper.getReadableDatabase();
		//Cursor cursor = db.rawQuery(sb.toString(), null);
		Cursor cursor = db.rawQuery(sql, null);
		List<Menu> menus = new ArrayList<Menu>();
		while(cursor.moveToNext()){
			Menu menu = new Menu();
			menu.setId(cursor.getInt(0));
			menu.setMenuname(cursor.getString(1));
			menu.setPrice(cursor.getString(2));
			menu.setPic(cursor.getString(3));
			menus.add(menu);
		}
		cursor.close();
		db.close();
		return menus;
	}
	
	
}
