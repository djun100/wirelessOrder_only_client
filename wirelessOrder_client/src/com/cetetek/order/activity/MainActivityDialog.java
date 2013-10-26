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
        //给按钮添加监听事件
        //btn = (Button)findViewById(R.id.orderBtn);
       // btn.setOnClickListener(this);
   }
		
    @Override
	public void onClick(View v) {
    	
		switch (v.getId()) {
		//当点击下单的时候弹出对话框
		/*case R.id.orderBtn:
			showDialog();
			break;*/
		case R.id.dialog_button_add:
			text = (TextView)DialogView.findViewById(R.id.dialog_text);
			i++;
			//textView中需要String类型   否则报错   加“” 把int型的转为String类型
			text.setText(i+"");
			break;
		case R.id.dialog_button_reduce:
			i--;
			text.setText(i+"");
			break;
		}
		
	}
		
	private void showDialog(){
        //点击确定转向对话框   
        LayoutInflater factory=LayoutInflater.from(MainActivityDialog.this);   
        //得到自定义对话框   
        DialogView=factory.inflate(R.layout.main_dialog, null);  
        
        add = (Button)DialogView.findViewById(R.id.dialog_button_add);
        reduce = (Button)DialogView.findViewById(R.id.dialog_button_reduce);
        
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        
        //创建对话框   
        AlertDialog dlg=new AlertDialog.Builder(MainActivityDialog.this) 
        //tittle里边的值是主界面传递过来的菜名
        .setTitle("红烧鱼头")   
        .setView(DialogView)//设置自定义对话框样式   
        .setPositiveButton("确定",    
        new DialogInterface.OnClickListener() {//设置监听事件   
            @Override  
            public void onClick(DialogInterface dialog, int which) { 
            	Toast.makeText(MainActivityDialog.this,"您点了"+i+"红烧鱼头", 1);
                Log.i("tag", "您点了"+i+"份红烧鱼头");
            }   
        }).setNegativeButton("取消",//设置取消按钮   
          new DialogInterface.OnClickListener() {   
               @Override  
                public void onClick(DialogInterface dialog, int which) {   
                   //点击取消 
            	   dialog.dismiss();  
                }   
           }).create();//创建对话框   
        dlg.show();//显示对话框   
    }
}
  
