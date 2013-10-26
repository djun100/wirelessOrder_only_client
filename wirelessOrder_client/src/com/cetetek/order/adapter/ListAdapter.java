package com.cetetek.order.adapter;

import java.util.List;

import com.cetetek.order.activity.R;
import com.cetetek.order.entity.MenuOrder;
import com.cetetek.order.entity.PlanOrderInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

	//ListView列表项
	private class ListHolder {
		ImageView appImage;
		TextView appTitle;
		TextView appText;
	}
	
	private Context context;
	
	private List<MenuOrder> list;  
    private LayoutInflater inflater;

	

	public ListAdapter(Context c) {
		super();
		this.context = c;
	}

	public void setList(List<MenuOrder> menuOrders) {  
        this.list = menuOrders;  
        inflater = (LayoutInflater) context  
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
       
  
    }  
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int index) {
		return list.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	/**
	 * 为ListView预购订单项赋值
	 */
	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		ListHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.main_plan_order, null);
			holder = new ListHolder();
			holder.appImage = (ImageView) convertView.findViewById(R.id.main_plan_order_itemImage);
			holder.appTitle = (TextView) convertView.findViewById(R.id.main_plan_order_itemTitle);
			holder.appText = (TextView) convertView.findViewById(R.id.main_plan_order_itemText);
			convertView.setTag(holder);
		}
		else {
			holder = (ListHolder) convertView.getTag();
		}
		MenuOrder info = list.get(index); 
		
		String sortName = info.getMenu().getSort().getSortname();
		int f = 1;
		if(info != null){
			//如果listView中有种类相同的菜  则隐藏相应的tittle
			if(info.getExistIndex()!=null&&f!=1){
				
				TextView text = (TextView) convertView.findViewById(R.id.main_plan_order_itemTitle);
				text.setVisibility(View.GONE);
			}else{
				
				holder.appTitle.setText(info.getMenu().getSort().getSortname());
			}	
			
			holder.appImage.setBackgroundResource(R.drawable.delete);
			holder.appText.setText(info.getMenu().getSort().getSortname());
		}
		return convertView;
	}

}
