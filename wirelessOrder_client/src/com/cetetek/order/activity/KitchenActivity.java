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
	//���ܴ��ݹ���������
	private List<MenuOrder> data = new ArrayList<MenuOrder>();
	//���listView�е�����
	private List<MenuOrder> leftData = new ArrayList<MenuOrder>();
	//�Ҳ�listView������
	private List<MenuOrder> rightData = new ArrayList<MenuOrder>();;
	
	private TextView timeText;
	private TimeThread loader;
	private ListView leftListView;
	private ListView rightListView;
	private KitchenAdaptert kitchenAdaptert;
	private static int FIRST = 0;
	//�����߳��е���Ϣ    ����ʱ��
	private Handler h = new Handler() {
		public void handleMessage(Message msg) {
			String len = msg.getData().getString("time");
			timeText.setText(len);
			 
			//����KitchenAdapter�д�����������
			MenuOrder mo = (MenuOrder) msg.getData().getSerializable("menuOrder");
			//�ж��ǲ��ǵ�һ�ν���ҳ�棬���������������������ݹ���������
			if(mo!=null&&FIRST==0){
				if(mo.getStatus()==1){//�ж��Ƿ�����
					rightData.add(mo);
//					Log.i("Other","" + mo.getId());
//					rightListView.setVisibility(View.VISIBLE);
				}
				else if(mo.getStatus()==2){//û������"
					leftData.add(mo);
//					leftListView.setVisibility(View.VISIBLE);
				}
			}	//���ü򵥵�����������listView������ݣ�������onclick�����¼�
		       leftAdapter(leftData);
		       //ͬLeftAdapter 
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
      
        //ʱ���̣߳�ÿ��1���ӷ��̸߳����̷߳���һ����Ϣ
		loader = new TimeThread(h);
		loader.startTime();
		if(data.isEmpty()&&FIRST==0){
	       //��ʼ����������������
	       data = init();
	       //����data�е����ݣ����ݲ˵���������ֱ�ֵ���Ӧ�ļ���
	       ergodic(data);
		}
        
        //���ü򵥵�����������listView������ݣ�������onclick�����¼�
       leftAdapter(leftData);
        
       //ͬLeftAdapter 
       rightApapter(rightData);
        
       leftBtn.setOnClickListener(this);
       rightBtn.setOnClickListener(this);
       
       
      //��leftListView ��Ӽ����¼�
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


	//�ж���û������
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

	//��rtListview���������
    private void rightApapter(List<MenuOrder> rightData2) {
		kitchenAdaptert = new KitchenAdaptert(this, rightData2,rightListView,h);
		rightListView.setAdapter(kitchenAdaptert);
		kitchenAdaptert.notifyDataSetChanged();
//		MenuOrder kt = new MenuOrder();
//		Collections.sort(rightData2,kt);  
	}
    //��lfListview���������
	private void leftAdapter(List<MenuOrder> leftData2) {
		KitchenAdaptert kitchenAdaptert = new KitchenAdaptert(this, leftData2,leftListView,h); // ����������
		leftListView.setAdapter(kitchenAdaptert);
		kitchenAdaptert.notifyDataSetChanged();
		
//		MenuOrder kt = new MenuOrder();
//		Collections.sort(leftData2,kt);
	}

	/**
     * ��ʼ������
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
	        	
	        	//�ж���û������  α����
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
	
	//���е�½
	private void login() {
		// TODO Auto-generated method stub
		
	}
	private void openOrder() {
		// TODO Auto-generated method stub
		//��ת����½ҳ��
		Intent intent = new Intent(this, OrderActivity.class);
    	startActivity(intent);
	}
}
    
  
	