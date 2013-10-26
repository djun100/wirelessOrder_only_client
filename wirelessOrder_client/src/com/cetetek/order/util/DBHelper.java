/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
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
 * SQLite���ݿ������
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:48:43
 */
public class DBHelper  extends SQLiteOpenHelper{
	 // ���ݿ����Ƴ���
    private static final String DATABASE_NAME = "WirelessOrder.db";
    // ���ݿ�汾����
    private static final int DATABASE_VERSION = 2;
    // ���ȱ�
    public static final String TABLE_MENU = "t_menu";
    // ����
    public static final String TABLE_TYPE = "t_type";
    // ������
    public static final String TABLE_TABLES = "t_tables";
    // ��ϵ��
    public static final String TABLE_SORT = "t_sort";
    // ������
    public static final String TABLE_ORDER = "t_order";
    //���ȶ�����ϵ��
    public static final String TABLE_MENU_ORDER = "t_menu_order";
	// ���췽��
	public DBHelper(Context context) {
		// �������ݿ�
		super(context, DATABASE_NAME,null, DATABASE_VERSION);
	}
	// ����ʱ����
	public void onCreate(SQLiteDatabase db) {
		/**
		 * �������ȱ�
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
         * ��������
         */
        db.execSQL("CREATE TABLE " + TABLE_TYPE + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "typename" + " VERCHAR(50),"
                + "introduce" + " VERCHAR(50) "
                + ");");
        
        
        /**
         * ����������
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
         * ������ϵ��
         */
        db.execSQL("CREATE TABLE " + TABLE_SORT + " ("
                + "id" + " INTEGER PRIMARY KEY,"
                + "sortname" + " VERCHAR(50),"
                + "introduce" + " VERCHAR(50) "
                + ");");
        
        /**
         * �����������׹�ϵ��
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
		 * ����������
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

	// �汾����ʱ����
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// ɾ����
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
