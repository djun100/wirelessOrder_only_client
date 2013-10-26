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
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//ȥ����Ϣ��
        setContentView(R.layout.main);
        
        Button mainOrderBtn = (Button) findViewById(R.id.main_order_button);
        Button mainServiceBtn = (Button) findViewById(R.id.main_service);
        Button mainElect = (Button) findViewById(R.id.main_elect);
        Button mainStyle = (Button) findViewById(R.id.main_style);
        mainElect.setOnClickListener(this);
        mainStyle.setOnClickListener(this);
        mainOrderBtn.setOnClickListener(this);
        mainServiceBtn.setOnClickListener(this);
        //׼����ʼ������
        initView();
        //׼����ʼ������
        initListener();
        
    }
	
	//׼����ʼ������
	private void initListener() {
		//ΪGridView��ItemͼƬ���ü���
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("Other", position + "");
			}
		});
		//ΪListView��ItemͼƬ���ü���
		lvOrder_information.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("Other", position + "");
			}
		});
		
		//ΪGridView��ItemͼƬ���ü���
		gridView.setOnItemClickListener(new OnItemClickListener(){
			//��ʼ��ͼƬ����
			Integer[] images = new Integer[]{R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise,
											 R.drawable.tortoise};
			
			//��ʼ����ť����
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
				//�ж������Image��ת��MenuActivity
				switch (images[position]) {
				case R.drawable.tortoise:
					Toast.makeText(MainActivity.this, "tortoise", 1).show();
					startActivity(new Intent(MainActivity.this, MenuActivity.class));//������һ��Activity
					finish();//������Activity���ɻ���
					break;
				}
				//�ж������Button��ת��MenuActivity
				switch (button[position]) {    
				case R.id.main_nine_itemButton:
					Toast.makeText(MainActivity.this, "main_nine_itemButton", 1).show();
					startActivity(new Intent(MainActivity.this, MenuActivity.class));//������һ��Activity
					finish();//������Activity���ɻ���
					break;
				}
				
			}});
		
		
		/*----------------------------------------------------------*/
		//ΪGridView��Item��ť���ü���
		
	}

	//׼����ʼ������
	private void initView(){ 
		gridView = (GridView) findViewById(R.id.main_gridview);
		menuService = new MenuService(MainActivity.this);
		menuOrders = new ArrayList<MenuOrder>();
		String typeid = "1";
		//׼��GridView����
        menuList = (ArrayList<Menu>) menuService.queryAll(typeid);
        for(Menu menu : menuList){
        	
        }
        /*for(int i = 1; i < 20; i++){
        	listGridInfo.add(new GridInfo(R.drawable.tortoise, "����"+i, 96f, 2));
        }*/
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        gridAdapter = new GridAdapter(this);
        //��������
        gridAdapter.setList(menuList);
        //��ʾ����
        gridView.setAdapter(gridAdapter);
        
        /*----------------------------------------------------------*/
        lvOrder_information = (ListView) findViewById(R.id.main_lvOrder_information);
        
        //׼��ListView����
        
        for(int i = 1; i < 4; i++){
        	MenuOrder menuOrder2 = new MenuOrder();
        	Sort sort = new Sort();
        	sort.setSortname("��ϵ"+i);
        	Menu menu =new Menu();
        	menu.setSort(sort);
        	menuOrder2.setRemark("  ��ע    ����     ɾ��   ");
        	menuOrder2.setMenu(menu);
        	menuOrders.add(menuOrder2);
        }
        
        listAdapter = new ListAdapter(this);
        //��������
        listAdapter.setList(menuOrders);
        
        //��ʾ����
        lvOrder_information.setAdapter(listAdapter);
	}
	
    /**
     * �õ�����
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
        	sort.setSortname("��ϵ1");
        	Menu menu =new Menu();
        	menu.setSort(sort);
        	menuOrder2.setRemark("  ��ע    ����     ɾ��   ");
        	menuOrder2.setMenu(menu);
        	
        	addOrder(menuOrder2,menuOrders);
			break;
		case R.id.main_style:
			MenuOrder menuOrder3 = new MenuOrder();
			Sort sort3 = new Sort();
			sort3.setSortname("��ϵ3");
			Menu menu3 =new Menu();
			menu3.setSort(sort3);
			menuOrder3.setRemark("  ��ע    ����     ɾ��   ");
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
	 * �жϲ˵�������û����ͬ��  ��ͬ������Ӧ��λ��   ��ͬ����null
	 * @param orders 
	 * @return 
	 */
	private String judge(MenuOrder menuOrder3, List<MenuOrder> orders) {
		
		int d = 1;
		// TODO Auto-generated method stub
		for(int i=0;i<orders.size();i++){
			//�˵�����
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