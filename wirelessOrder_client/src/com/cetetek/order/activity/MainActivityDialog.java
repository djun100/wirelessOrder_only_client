package com.cetetek.order.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityDialog extends Activity implements OnClickListener {   
    /** Called when the activity is first created. */  
	private Button add;
	private Button reduce;
	private TextView text;
	private Button btn;
	int i=1;
	private View DialogView;
	
    public void onCreate(Bundle savedInstanceState) {   
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.main);   
        //����ť��Ӽ����¼�
        //btn = (Button)findViewById(R.id.orderBtn);
       // btn.setOnClickListener(this);
   }
		
    @Override
	public void onClick(View v) {
    	
		switch (v.getId()) {
		//������µ���ʱ�򵯳��Ի���
		/*case R.id.orderBtn:
			showDialog();
			break;*/
		case R.id.dialog_button_add:
			text = (TextView)DialogView.findViewById(R.id.dialog_text);
			i++;
			//textView����ҪString����   ���򱨴�   �ӡ��� ��int�͵�תΪString����
			text.setText(i+"");
			break;
		case R.id.dialog_button_reduce:
			i--;
			text.setText(i+"");
			break;
		}
		
	}
		
	private void showDialog(){
        //���ȷ��ת��Ի���   
        LayoutInflater factory=LayoutInflater.from(MainActivityDialog.this);   
        //�õ��Զ���Ի���   
        DialogView=factory.inflate(R.layout.main_dialog, null);  
        
        add = (Button)DialogView.findViewById(R.id.dialog_button_add);
        reduce = (Button)DialogView.findViewById(R.id.dialog_button_reduce);
        
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        
        //�����Ի���   
        AlertDialog dlg=new AlertDialog.Builder(MainActivityDialog.this) 
        //tittle��ߵ�ֵ�������洫�ݹ����Ĳ���
        .setTitle("������ͷ")   
        .setView(DialogView)//�����Զ���Ի�����ʽ   
        .setPositiveButton("ȷ��",    
        new DialogInterface.OnClickListener() {//���ü����¼�   
            @Override  
            public void onClick(DialogInterface dialog, int which) { 
            	Toast.makeText(MainActivityDialog.this,"������"+i+"������ͷ", 1);
                Log.i("tag", "������"+i+"�ݺ�����ͷ");
            }   
        }).setNegativeButton("ȡ��",//����ȡ����ť   
          new DialogInterface.OnClickListener() {   
               @Override  
                public void onClick(DialogInterface dialog, int which) {   
                   //���ȡ�� 
            	   dialog.dismiss();  
                }   
           }).create();//�����Ի���   
        dlg.show();//��ʾ�Ի���   
    }
}
  
