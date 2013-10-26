/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
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
 * ��¼��login�� activity
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:43:23
 */
public class LoginActivity extends Activity implements View.OnClickListener{
	//�û���
	private EditText usernameEdt;
	//����
	private EditText passwordEdt;
	//��¼��ť
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
	 * ��¼����
	 */
	public void login(){
		try {
			String username = usernameEdt.getText().toString();
			String password = passwordEdt.getText().toString();
			if("".equals(username)){//�û�������Ϊ��
				Log.i("LoginActivity", "�û�������Ϊ�գ�");
				Toast.makeText(LoginActivity.this, R.string.empty_username, 0).show();
			}else if("".equals(password)){//���벻��Ϊ��
				Toast.makeText(LoginActivity.this, R.string.empty_password, 0).show();
			}else{
				Map<String, String> params = new HashMap<String, String>();
				params.put("username", username);
				params.put("password", password);
				User user = LoginService.login(SystemCount.LOGIN, params);
				if(user != null){
					//��½�ɹ�
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

