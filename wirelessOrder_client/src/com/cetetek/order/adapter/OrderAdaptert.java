package com.cetetek.order.adapter;

import java.util.List;

import com.cetetek.order.activity.OrderActivity;
import com.cetetek.order.activity.R;
import com.cetetek.order.entity.MenuOrder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义适配器 order界面中用的
 * 
 * @author Mawentao
 * 
 */
public class OrderAdaptert extends BaseAdapter {
	private Context context;
	private List<MenuOrder> listItems;
	private LayoutInflater listContainer;

	public OrderAdaptert(Context context, List<MenuOrder> items) {
		this.context = context;
		listContainer = LayoutInflater.from(context); // 创建视图容器并设置上下文
		this.listItems = items;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// 菜品的种类
		String greenType = listItems.get(position).getMenu().getSort()
				.getSortname();
		convertView = listContainer.inflate(R.layout.order_left_items, null);
		// 菜品的种类
		TextView TextType = (TextView) convertView
				.findViewById(R.id.order_Left_type);
		TextType.setText(greenType);
		// 菜名列表
		final String menu = listItems.get(position).getOrder().getNum();
		final int id = listItems.get(position).getId();

		TextView textView = (TextView) convertView
				.findViewById(R.id.order_Left_text);
		textView.setText(menu + "优惠价    当点操作   " + id + "   制作中   数量      菜名      价格  ");

		ImageView image = (ImageView) convertView
				.findViewById(R.id.order_image_delete);
		image.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 当点击image的时候，打印点击所在行数的信息
				Log.i("tag", menu + " " + id + "            ");
				Toast.makeText(context,menu + " " + id  , 1).show();
			}
		});
		return convertView;
	}

}