package com.cetetek.order.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MenuActivity extends Activity {
    private ImageView imageView;
	private Button addButton;
	private Button subtractButton;
	private Button add_orderButton;
	private EditText countEditText;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.menu);
        
        imageView = (ImageView) findViewById(R.id.menu_imageView);
        addButton = (Button) findViewById(R.id.menu_add);
        subtractButton = (Button) findViewById(R.id.menu_subtract);
        add_orderButton = (Button) findViewById(R.id.menu_add_order);
        countEditText = (EditText) findViewById(R.id.menu_count);
        
        imageView.setOnClickListener(new ClickListener());
        addButton.setOnClickListener(new ClickListener());
        subtractButton.setOnClickListener(new ClickListener());
        add_orderButton.setOnClickListener(new ClickListener());
        
    }
	
	class ClickListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			//取得EditText中文本内容
			String count = countEditText.getText().toString();
			int i = Integer.parseInt(count);
			
			int id = v.getId();
			switch (id) {
			case R.id.menu_imageView://单击图片
				
				/*MyApp myApp  =  (MyApp)getApplication();

				imageView.setDrawingCacheEnabled(true);
				Bitmap bitmap = imageView.getDrawingCache();

				myApp.setBitmap(bitmap);*/
				
//				Log.i("Other", "bitmap= " + bitmap);
				
				Intent intent = new Intent(MenuActivity.this, BigImageActivity.class);
				
				startActivity(intent);
				
				break;
			case R.id.menu_subtract://单击减号按钮
				i--;
				if(i < 1){
					i = 1;
				}
					countEditText.setText(i + "");
				break;
			case R.id.menu_add://单击加号按钮
				i++;
				countEditText.setText(i + "");
				   
				break;
			case R.id.menu_add_order://单击加入订单按钮
				
				break;
			}
		}
    }
}