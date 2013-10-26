package com.cetetek.order.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.cetetek.order.adapter.OrderAdaptert;
import com.cetetek.order.entity.Menu;
import com.cetetek.order.entity.MenuOrder;
import com.cetetek.order.entity.Order;
import com.cetetek.order.entity.Sort;

public class OrderActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	private ListView parentListView;
	private OrderAdaptert orderAdaptert;
	List<MenuOrder> items = new ArrayList<MenuOrder>();
	ListView sonListView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order);
		
		Button addGreensBtn = (Button) findViewById(R.id.order_addGreens);
		addGreensBtn.setOnClickListener(this);
		// 初始化数据
		items = init();
		// 创建适配器
		createAdapter();
		// 获取text中的priceSum
		TextView sumText = (TextView) findViewById(R.id.order_sum);
		sumText.setText("菜品总金额 为  ：1088元         优惠金额：188元        实际收取 ：980元");
	}

	// 创建适配器 , 给order_left添加适配器
	private void createAdapter() {
		// TODO Auto-generated method stub
		parentListView = (ListView) findViewById(R.id.order_listView);
		orderAdaptert = new OrderAdaptert(this, items); // 创建适配器
		parentListView.setAdapter(orderAdaptert);
	}

	// 初始化数据 把数据存放到 list中
	private List<MenuOrder> init() {
		for(int i=0;i<20;i++){
			MenuOrder menuOrder = new MenuOrder();
			Sort sort = new Sort();
			sort.setSortname("热菜 "+i);
			Order order = new Order();
			Menu menu = new Menu();
			menu.setSort(sort); 
			order.setId(i);
			order.setNum("订单的id为"+i);
			menuOrder.setOrder(order);
			menuOrder.setMenu(menu);
			items.add(menuOrder);
		}
		return items;
	}

	/**
	 * 点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.order_amusement:
			break;
		case R.id.order_service:
			break;
		case R.id.order_addGreens:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
		case R.id.order_verify:
			break;
		case R.id.order_settle:
			break;
		case R.id.order_back:
			break;
		}
	}

}