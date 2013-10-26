/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
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
 * ��ʼ��ҳ��
 * @author xice Email:jian.xun@cetetek.com
 * @version 1.0 
 * @date 2011-9-16����02:44:23
 */
public class InitActivity extends Activity{
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTitle(R.string.app_name);
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//ȥ����Ϣ��
		setContentView(R.layout.init);
		new Thread(){
		public void run() {
			/**
			 * �ѷ����������е����ݸ��µ��������ݿ���
			 */
			// 1.������в�����Ϣ
			MenuService menuService = new MenuService(InitActivity.this);
			menuService.saveAllMenu();
			
			// 2.�������������Ϣ
			TablesService tablesService = new TablesService(InitActivity.this);
			tablesService.saveAllTables();
			
			// 3.������е������Ϣ
			TypeService typeService = new TypeService(InitActivity.this);
			typeService.saveAllType();
			
			// 5.������еĲ��ȵĲ�ϵ��Ϣ
			SortService sortService = new SortService(InitActivity.this);
			sortService.saveAllSort();
			
			// ���ݸ������ ת����¼activity
			startActivity(new Intent(InitActivity.this,IndexActivity.class));
			InitActivity.this.finish();
    	};
    }.start();
	}

}

