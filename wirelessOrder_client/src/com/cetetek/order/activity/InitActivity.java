/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : InitActivity.java 
 * Date : 2011-9-16
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.activity;

import com.cetetek.order.service.MenuService;
import com.cetetek.order.service.SortService;
import com.cetetek.order.service.TablesService;
import com.cetetek.order.service.TypeService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * 初始化页面
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16下午02:44:23
 */
public class InitActivity extends Activity{
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTitle(R.string.app_name);
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
		setContentView(R.layout.init);
		new Thread(){
		public void run() {
			/**
			 * 把服务器端所有的数据更新到本地数据库中
			 */
			// 1.添加所有菜肴信息
			MenuService menuService = new MenuService(InitActivity.this);
			menuService.saveAllMenu();
			
			// 2.添加所有桌子信息
			TablesService tablesService = new TablesService(InitActivity.this);
			tablesService.saveAllTables();
			
			// 3.添加所有的类别信息
			TypeService typeService = new TypeService(InitActivity.this);
			typeService.saveAllType();
			
			// 5.添加所有的菜肴的菜系信息
			SortService sortService = new SortService(InitActivity.this);
			sortService.saveAllSort();
			
			// 数据更新完毕 转到登录activity
			startActivity(new Intent(InitActivity.this,IndexActivity.class));
			InitActivity.this.finish();
    	};
    }.start();
	}

}

