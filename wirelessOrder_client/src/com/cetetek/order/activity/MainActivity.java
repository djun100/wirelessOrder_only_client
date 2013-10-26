package com.cetetek.order.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cetetek.order.adapter.GridAdapter;
import com.cetetek.order.adapter.ListAdapter;
import com.cetetek.order.entity.GridInfo;
import com.cetetek.order.entity.Menu;
import com.cetetek.order.entity.MenuOrder;
import com.cetetek.order.entity.PlanOrderInfo;
import com.cetetek.order.entity.Sort;
import com.cetetek.order.service.MenuService;

public class MainActivity extends Activity implements OnClickListener {
	
    private List<GridInfo> listGridInfo;
    private List<Menu> menuList;
    private List<PlanOrderInfo> planOrderInfo;
	private GridView gridView;
	private ListView lvOrder_information;
	private GridAdapter gridAdapter;
	private ListAdapter listAdapter;

	private List<MenuOrder> menuOrders ;
	
	
	private MenuService menuService;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.main);
        
        Button mainOrderBtn = (Button) findViewById(R.id.main_order_button);
        Button mainServiceBtn = (Button) findViewById(R.id.main_service);
        Button mainElect = (Button) findViewById(R.id.main_elect);
        Button mainStyle = (Button) findViewById(R.id.main_style);
        mainElect.setOnClickListener(this);
        mainStyle.setOnClickListener(this);
        mainOrderBtn.setOnClickListener(this);
        mainServiceBtn.setOnClickListener(this);
        //准备初始化数据
        initView();
        //准备初始化监听
        initListener();
        
    }
	
	//准备初始化监听
	private void initListener() {
		//为GridView中Item图片设置监听
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("Other", position + "");
			}
		});
		//为ListView中Item图片设置监听
		lvOrder_information.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("Other", position + "");
			}
		});
		
		//为GridView中Item图片设置监听
		gridView.setOnItemClickListener(new OnItemClickListener(){
			//初始化图片数组
			Integer[] images = new Integer[]{R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise};
			
			//初始化按钮数组
			Integer[] button = new Integer[]{R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton,
											 R.id.main_nine_itemButton};
				
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Log.i("Other", position + "");
				//判断所点击Image跳转到MenuActivity
				switch (images[position]) {
				case R.drawable.tortoise:
					Toast.makeText(MainActivity.this, "tortoise", 1).show();
					startActivity(new Intent(MainActivity.this, MenuActivity.class));//启动另一个Activity
					finish();//结束此Activity，可回收
					break;
				}
				//判断所点击Button跳转到MenuActivity
				switch (button[position]) {    
				case R.id.main_nine_itemButton:
					Toast.makeText(MainActivity.this, "main_nine_itemButton", 1).show();
					startActivity(new Intent(MainActivity.this, MenuActivity.class));//启动另一个Activity
					finish();//结束此Activity，可回收
					break;
				}
				
			}});
		
		
		/*----------------------------------------------------------*/
		//为GridView中Item按钮设置监听
		
	}

	//准备初始化数据
	private void initView(){ 
		gridView = (GridView) findViewById(R.id.main_gridview);
		menuService = new MenuService(MainActivity.this);
		menuOrders = new ArrayList<MenuOrder>();
		String typeid = "1";
		//准备GridView数据
        menuList = (ArrayList<Menu>) menuService.queryAll(typeid);
        for(Menu menu : menuList){
        	
        }
        /*for(int i = 1; i < 20; i++){
        	listGridInfo.add(new GridInfo(R.drawable.tortoise, "菜名"+i, 96f, 2));
        }*/
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        gridAdapter = new GridAdapter(this);
        //设置数据
        gridAdapter.setList(menuList);
        //显示数据
        gridView.setAdapter(gridAdapter);
        
        /*----------------------------------------------------------*/
        lvOrder_information = (ListView) findViewById(R.id.main_lvOrder_information);
        
        //准备ListView数据
        
        for(int i = 1; i < 4; i++){
        	MenuOrder menuOrder2 = new MenuOrder();
        	Sort sort = new Sort();
        	sort.setSortname("菜系"+i);
        	Menu menu =new Menu();
        	menu.setSort(sort);
        	menuOrder2.setRemark("  备注    操作     删除   ");
        	menuOrder2.setMenu(menu);
        	menuOrders.add(menuOrder2);
        }
        
        listAdapter = new ListAdapter(this);
        //设置数据
        listAdapter.setList(menuOrders);
        
        //显示数据
        lvOrder_information.setAdapter(listAdapter);
	}
	
    /**
     * 得到数据
     */
   public void getData(){
	   Intent intent = this.getIntent();
	   String type = intent.getStringExtra("type");
	   MenuService menuService = new MenuService(MainActivity.this);
	   menuList = (ArrayList<Menu>) menuService.queryAll(type);	
   }

	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.main_order_button:
			Intent intent = new Intent(this,OrderActivity.class);
			startActivity(intent);
			break;
		case R.id.main_service:
			Intent service = new Intent(this,KitchenActivity.class);
			startActivity(service);
			break;
		
		case R.id.main_elect:
			MenuOrder menuOrder2 = new MenuOrder();
        	Sort sort = new Sort();
        	sort.setSortname("菜系1");
        	Menu menu =new Menu();
        	menu.setSort(sort);
        	menuOrder2.setRemark("  备注    操作     删除   ");
        	menuOrder2.setMenu(menu);
        	
        	addOrder(menuOrder2,menuOrders);
			break;
		case R.id.main_style:
			MenuOrder menuOrder3 = new MenuOrder();
			Sort sort3 = new Sort();
			sort3.setSortname("菜系3");
			Menu menu3 =new Menu();
			menu3.setSort(sort3);
			menuOrder3.setRemark("  备注    操作     删除   ");
			menuOrder3.setMenu(menu3);
			
			addOrder(menuOrder3,menuOrders);
			
	        
			break;
		default:
			break;
		}
		
	}
	
	

	private void addOrder(MenuOrder order, List<MenuOrder> Orders) {
		// TODO Auto-generated method stub
		if(order!=null){
			String b = judge(order,Orders);
			if(b!=null){
				order.setExistIndex(b);
				Orders.add(Integer.parseInt(b)+1,order);
			}else if(b==null){
				Orders.add(order);  
			}
			
			ListView listView2 = (ListView) findViewById(R.id.main_lvOrder_information);
			listAdapter.notifyDataSetChanged();
			listView2.setVisibility(View.VISIBLE);
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Log.i("tag", menuOrders.size()+"menuOrderSize");
	}

	/**
	 * 判断菜的种类有没有相同的  相同返回相应的位置   不同返回null
	 * @param orders 
	 * @return 
	 */
	private String judge(MenuOrder menuOrder3, List<MenuOrder> orders) {
		
		int d = 1;
		// TODO Auto-generated method stub
		for(int i=0;i<orders.size();i++){
			//菜的种类
			String sortname = orders.get(i).getMenu().getSort().getSortname();
			String menusort = menuOrder3.getMenu().getSort().getSortname();
			if((menusort.trim()).equals(sortname.trim())&&sortname!=null&&menusort!=null){
				d = d+1;
				return i+"";
			} 
		}
		return null;
	}

}