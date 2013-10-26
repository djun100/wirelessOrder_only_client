package com.cetetek.order.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.cetetek.order.adapter.KitchenAdaptert;
import com.cetetek.order.adapter.TimeThread;
import com.cetetek.order.entity.Menu;
import com.cetetek.order.entity.MenuOrder;
import com.cetetek.order.entity.Order;

public class KitchenActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	//接受传递过来的数据
	private List<MenuOrder> data = new ArrayList<MenuOrder>();
	//左侧listView中的数据
	private List<MenuOrder> leftData = new ArrayList<MenuOrder>();
	//右侧listView的数据
	private List<MenuOrder> rightData = new ArrayList<MenuOrder>();;
	
	private TextView timeText;
	private TimeThread loader;
	private ListView leftListView;
	private ListView rightListView;
	private KitchenAdaptert kitchenAdaptert;
	private static int FIRST = 0;
	//接受线程中的消息    设置时间
	private Handler h = new Handler() {
		public void handleMessage(Message msg) {
			String len = msg.getData().getString("time");
			timeText.setText(len);
			 
			//接受KitchenAdapter中传过来的数据
			MenuOrder mo = (MenuOrder) msg.getData().getSerializable("menuOrder");
			//判断是不是第一次进入页面，如果不是则接受适配器传递过来的数据
			if(mo!=null&&FIRST==0){
				if(mo.getStatus()==1){//判断是否制作
					rightData.add(mo);
//					Log.i("Other","" + mo.getId());
//					rightListView.setVisibility(View.VISIBLE);
				}
				else if(mo.getStatus()==2){//没有制作"
					leftData.add(mo);
//					leftListView.setVisibility(View.VISIBLE);
				}
			}	//调用简单的适配器，给listView添加数据，并设置onclick监听事件
		       leftAdapter(leftData);
		       //同LeftAdapter 
		       rightApapter(rightData);
		       kitchenAdaptert.notifyDataSetChanged();
		}
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen); 
       
        Button leftBtn = (Button) findViewById(R.id.kitchen_content_left_button);
        Button rightBtn = (Button) findViewById(R.id.kitchen_content_right_button);
        timeText = (TextView) findViewById(R.id.kitchen_top_right_textView);
        
        leftListView = (ListView) findViewById(R.id.kitchen_left_listview);
        rightListView = (ListView) findViewById(R.id.kitchen_right_listview);
        
        leftBtn.setOnClickListener(this);
      
        //时间线程，每隔1秒钟分线程给主线程发送一次消息
		loader = new TimeThread(h);
		loader.startTime();
		if(data.isEmpty()&&FIRST==0){
	       //初始化工作，返回数据
	       data = init();
	       //遍历data中的数据，根据菜的制作情况分别分到相应的集合
	       ergodic(data);
		}
        
        //调用简单的适配器，给listView添加数据，并设置onclick监听事件
       leftAdapter(leftData);
        
       //同LeftAdapter 
       rightApapter(rightData);
        
       leftBtn.setOnClickListener(this);
       rightBtn.setOnClickListener(this);
       
       
      //给leftListView 添加监听事件
      /* leftListView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
		     Spinner sp=(Spinner)parent;
		     String style=sp.getSelectedItem().toString();
             parent.setVisibility(View.VISIBLE);
             Log.i("tag",style);
		}
       });*/
    

    }
    

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Other", "OnStart has been calles!");
	}


	//判断有没有制作
    private void ergodic(List<MenuOrder> menuOrder) {
		// TODO Auto-generated method stub
    	if(rightData.isEmpty()|leftData.isEmpty()){
			for(int i=0;i<menuOrder.size();i++){
				MenuOrder kitchenOrder = menuOrder.get(i);
				if(kitchenOrder.getStatus()==1){
					rightData.add(kitchenOrder);
				}else if (kitchenOrder.getStatus()==2){
					leftData.add(kitchenOrder);
				}
			}
		}
	}

	//给rtListview添加适配器
    private void rightApapter(List<MenuOrder> rightData2) {
		kitchenAdaptert = new KitchenAdaptert(this, rightData2,rightListView,h);
		rightListView.setAdapter(kitchenAdaptert);
		kitchenAdaptert.notifyDataSetChanged();
//		MenuOrder kt = new MenuOrder();
//		Collections.sort(rightData2,kt);  
	}
    //给lfListview添加适配器
	private void leftAdapter(List<MenuOrder> leftData2) {
		KitchenAdaptert kitchenAdaptert = new KitchenAdaptert(this, leftData2,leftListView,h); // 创建适配器
		leftListView.setAdapter(kitchenAdaptert);
		kitchenAdaptert.notifyDataSetChanged();
		
//		MenuOrder kt = new MenuOrder();
//		Collections.sort(leftData2,kt);
	}

	/**
     * 初始化数据
     * @return 
     * 
     */
	private List<MenuOrder> init() {
		List<MenuOrder> data = new ArrayList<MenuOrder>();
	       
	        for(int i=0;i<18;i++){
	        	MenuOrder mo = new MenuOrder();
	        	Order order = new Order();
	        	Menu menu = new Menu();
	        	
	        	order.setOrderdate(1+"");
	        	menu.setMenuname("menu");
	        	mo.setId(i);
	        	mo.setMenu(menu);
	        	mo.setOrder(order);
	        	mo.setRemark("remark"+i);
	        	mo.getOrder().setNum("num");
	        	
	        	//判断有没有制作  伪代码
	        	if(i%2==0){
	        		mo.setStatus(1);
	        	}else{
	        		mo.setStatus(2);
	        	}
	        	data.add(mo);
	        }
	        return data;
	}
	
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.kitchen_content_left_button:
			// 
			openOrder();
		break;
		
		case R.id.kitchen_content_right_button:
			//
			login();
		break;
		}
	}
	
	//进行登陆
	private void login() {
		// TODO Auto-generated method stub
		
	}
	private void openOrder() {
		// TODO Auto-generated method stub
		//跳转到登陆页面
		Intent intent = new Intent(this, OrderActivity.class);
    	startActivity(intent);
	}
}
    
  
	