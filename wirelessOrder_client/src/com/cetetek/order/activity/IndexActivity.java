package com.cetetek.order.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IndexActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index); 
        init();
        
        TextView textOpen = (TextView) findViewById(R.id.index_openin);
        textOpen.setOnClickListener(this);
        Button btn = (Button) findViewById(R.id.index_button);
        btn.setOnClickListener(IndexActivity.this);
    }
    
    /**
     * ��ʼ������
     */
	private void init() {
		Toast makeText = Toast.makeText(IndexActivity.this, "��ʼ������",1);
		makeText.show();
	}
	/**
	 * ����¼�
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.index_openin:
			openIn();
			break;  
		case R.id.index_button:
			useHelp();
			break;
		}
	}
	
	/**
	 * ʹ�ð���
	 */
	private void useHelp() {
		// TODO Auto-generated method stub
//		Toast.makeText(IndexActivity.this, "ʹ�ð���",1).show();
	}
	
	/**
	 * ����������
	 */
	private void openIn() {
		// TODO Auto-generated method stub
		Toast.makeText(IndexActivity.this, "������",1).show();
		
		//����������
		Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
	}
}