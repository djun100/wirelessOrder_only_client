/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : DBUtil.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * SQLite数据库帮助类
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:48:43
 */
public class DBHelper  extends SQLiteOpenHelper{
	 // 数据库名称常量
    private static final String DATABASE_NAME = "WirelessOrder.db";
    // 数据库版本常量
    private static final int DATABASE_VERSION = 2;
    // 菜肴表
    public static final String TABLE_MENU = "t_menu";
    // 类别表
    public static final String TABLE_TYPE = "t_type";
    // 餐桌表
    public static final String TABLE_TABLES = "t_tables";
    // 菜系表
    public static final String TABLE_SORT = "t_sort";
    // 订单表
    public static final String TABLE_ORDER = "t_order";
    //菜肴订单关系表
    public static final String TABLE_MENU_ORDER = "t_menu_order";
	// 构造方法
	public DBHelper(Context context) {
		// 创建数据库
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
	}
	// 创建时调用
	public void onCreate(SQLiteDatabase db) {
		/**
		 * 创建菜肴表
		 */
        db.execSQL("CREATE TABLE " + TABLE_MENU + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "address" + " VERCHAR(50),"
                + "createdate" + " VERCHAR(50),"
                + "price" + " VERCHAR(50),"
                + "cutprice" + " VERCHAR(50),"
                + "discount" + " BOOLEAN,"
                + "introduce" + " TEXT,"
                + "isdiscount" + " BOOLEAN,"
                + "isorder" + " BOOLEAN,"
                + "isrecommend" + " BOOLEAN,"
                + "menuname" + " VERCHAR(50),"
                + "ordertime" + " VERCHAR(30),"
                + "pic" + " VERCHAR(50),"
                + "typeid" + " INTEGER,"
                + "category" + " INTEGER,"
                + "sortid" + " INTEGER"
                + ");");
        
        /**
         * 创建类别表
         */
        db.execSQL("CREATE TABLE " + TABLE_TYPE + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "typename" + " VERCHAR(50),"
                + "introduce" + " VERCHAR(50) "
                + ");");
        
        
        /**
         * 创建餐桌表
         */
        db.execSQL("CREATE TABLE " + TABLE_TABLES + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "issmoke" + " BOOLEAN,"
                + "personnum" + " INTEGER,"
                + "remark" + " TEXT,"
                + "shape" + " VERCHAR(30),"
                + "site" + " INTEGER,"
                + "status" + " INTEGER,"
                + "tablenum" + " INTEGER"
                + ");");
        
        /**
         * 创建菜系表
         */
        db.execSQL("CREATE TABLE " + TABLE_SORT + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "sortname" + " VERCHAR(50),"
                + "introduce" + " VERCHAR(50) "
                + ");");
        
        /**
         * 创建订单菜谱关系表
         */
        db.execSQL("CREATE TABLE " + TABLE_MENU_ORDER + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "orderid" + " INTEGER,"
                + "num" + " INTEGER,"
                + "menuid" + " INTEGER, "
                + "status" + " INTEGER,"
                + "remark" + " TEXT"
                + ");");
        
        /**
		 * 创建订单表
		 */
        db.execSQL("CREATE TABLE " + TABLE_ORDER + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "num" + " VERCHAR(100),"
                + "status" + " INTEGER,"
                + "tableid" + " INTEGER,"
                + "orderdate" + " VERCHAR(50),"
                + "isdock" + " BOOLEAN,"
                + "remark" + " TEXT,"
                + "isprint" + " BOOLEAN,"
                + "ispay" + " BOOLEAN,"
                + "total" + " FLOAT,"
                + "customerid " + " INTEGER"
                + ");");
	}

	// 版本更新时调用
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 删除表
		db.execSQL("DROP TABLE IF EXISTS t_menu");
		db.execSQL("DROP TABLE IF EXISTS t_type");
		db.execSQL("DROP TABLE IF EXISTS t_tables");
		db.execSQL("DROP TABLE IF EXISTS t_menu_type");
		db.execSQL("DROP TABLE IF EXISTS t_sort");
		db.execSQL("DROP TABLE IF EXISTS t_menu_order");
		db.execSQL("DROP TABLE IF EXISTS t_order");
        onCreate(db);
	}
}
