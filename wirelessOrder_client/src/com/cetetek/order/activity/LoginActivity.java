/**
 * Copyright (c) 2011, 北京思迪康泰科技有限公司 All rights reserved.
 * Website : http://www.cetetek.com
 * name : LoginActivity.java 
 * Date : 2011-9-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.activity;

import java.util.HashMap;
import java.util.Map;

import com.cetetek.order.entity.User;
import com.cetetek.order.service.LoginService;
import com.cetetek.order.util.SystemCount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 登录（login） activity
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 上午09:43:23
 */
public class LoginActivity extends Activity implements View.OnClickListener{
	//用户名
	private EditText usernameEdt;
	//密码
	private EditText passwordEdt;
	//登录按钮
	private Button loginbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		loginbtn = (Button) findViewById(R.id.login_submit);
		loginbtn.setOnClickListener(this);
		usernameEdt = (EditText) findViewById(R.id.login_username);
		passwordEdt = (EditText) findViewById(R.id.login_password);
	}
	
	/**
	 * 登录方法
	 */
	public void login(){
		try {
			String username = usernameEdt.getText().toString();
			String password = passwordEdt.getText().toString();
			if("".equals(username)){//用户名不能为空
				Log.i("LoginActivity", "用户名不能为空！");
				Toast.makeText(LoginActivity.this, R.string.empty_username, 0).show();
			}else if("".equals(password)){//密码不能为空
				Toast.makeText(LoginActivity.this, R.string.empty_password, 0).show();
			}else{
				Map<String, String> params = new HashMap<String, String>();
				params.put("username", username);
				params.put("password", password);
				User user = LoginService.login(SystemCount.LOGIN, params);
				if(user != null){
					//登陆成功
					Toast.makeText(LoginActivity.this, R.string.login_ok, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent();
					intent.setClass(LoginActivity.this, InitActivity.class);
					startActivity(intent);
				}else{
					Toast.makeText(LoginActivity.this, R.string.login_error, Toast.LENGTH_SHORT).show();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_submit:
			login();
			break;
		}
	}
}

