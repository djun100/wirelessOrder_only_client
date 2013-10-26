package com.cetetek.order.adapter;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.cetetek.order.activity.R;
import com.cetetek.order.entity.MenuOrder;

/**
 * �Զ���������   
 * @author Mawentao
 *
 */
public class KitchenAdaptert extends BaseAdapter{
	private Context context;
	private List<MenuOrder> listItems;
	private LayoutInflater listContainer;
	private ListView listView;
	private Handler handler;
	private Button lfBtn;
	private Button rtBtn;
	public KitchenAdaptert(){}
	public KitchenAdaptert(Context context, List<MenuOrder> data,ListView leftListView, Handler h){
		 	this.context = context;             
	        listContainer = LayoutInflater.from(context);   //������ͼ����������������    
	        this.listItems = data;   
	        this.listView = leftListView;
	        this.handler = h;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
	       
	        //��listView��ֵ�����Ұ�View���ø�ContentView
	        convertView = buMake(convertView,position,listItems.get(position));
	        
	        lfBtn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {  
					// TODO Auto-generated method stub
					//��ȡ�����Ķ���
					MenuOrder menuOrder = listItems.get(position);
					menuOrder.setStatus(1);

					//����������е�ʱ�򣬷���Ϣ�����߳�
					Message msg = new Message();
					Bundle b = new Bundle();
					b.putSerializable("menuOrder", listItems.get(position));
					msg.setData(b);
					//�ѵ�ǰ�����Ƴ�
					listItems.remove(listItems.get(position));
//					listItems.remove(position);
					Log.i("tag", "______________");
					//���޸ĺ�Ķ����͵����߳�
					handler.sendMessage(msg);
				}
			});
	        
	        rtBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					listItems.remove(position);
					
					//�����ݷŵ����ݿ���
					
				}
			});
			return convertView;
}
	/**
	 * 
	 * ��ListView��ֵ
	 */
	private View buMake(View convertView,int position,MenuOrder menuOrder) {
		// TODO Auto-generated method stub
		convertView = listContainer.inflate(R.layout.kitchen_left_item, null);    
        TextView id = (TextView) convertView.findViewById(R.id.kitchen_id);
        final TextView name = (TextView) convertView.findViewById(R.id.kitchen_name);
        TextView min = (TextView) convertView.findViewById(R.id.kitchen_min);
        TextView num = (TextView) convertView.findViewById(R.id.kitchen_num);
        TextView operate = (TextView) convertView.findViewById(R.id.kitchen_operate);
        final TextView remark = (TextView) convertView.findViewById(R.id.kitchen_remark);
        TextView tabnum = (TextView) convertView.findViewById(R.id.kitchen_tabnum);
        id.setText(""+menuOrder.getId());
        name.setText(menuOrder.getMenu().getMenuname()); 
        min.setText(menuOrder.getOrder().getOrderdate()); 
        num.setText(menuOrder.getNum()+""); 
//        operate.setText(menuOrder.getOperate()); 
        remark.setText(menuOrder.getRemark()); 
//        tabnum.setText(menuOrder.getTabnum());
        
        lfBtn = (Button) convertView.findViewById(R.id.kitchen_btn);
    	lfBtn.setText("������");
    	rtBtn = (Button) convertView.findViewById(R.id.kitchen_btn);
    	rtBtn.setText("�������");
        return convertView;
	}
 
}