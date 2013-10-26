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
 * �Զ��������� order�������õ�
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
		listContainer = LayoutInflater.from(context); // ������ͼ����������������
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
		// ��Ʒ������
		String greenType = listItems.get(position).getMenu().getSort()
				.getSortname();
		convertView = listContainer.inflate(R.layout.order_left_items, null);
		// ��Ʒ������
		TextView TextType = (TextView) convertView
				.findViewById(R.id.order_Left_type);
		TextType.setText(greenType);
		// �����б�
		final String menu = listItems.get(position).getOrder().getNum();
		final int id = listItems.get(position).getId();

		TextView textView = (TextView) convertView
				.findViewById(R.id.order_Left_text);
		textView.setText(menu + "�Żݼ�    �������   " + id + "   ������   ����      ����      �۸�  ");

		ImageView image = (ImageView) convertView
				.findViewById(R.id.order_image_delete);
		image.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// �����image��ʱ�򣬴�ӡ���������������Ϣ
				Log.i("tag", menu + " " + id + "            ");
				Toast.makeText(context,menu + " " + id  , 1).show();
			}
		});
		return convertView;
	}

}