package com.cetetek.order.adapter;

import java.util.List;

import com.cetetek.order.activity.R;
import com.cetetek.order.entity.GridInfo;
import com.cetetek.order.entity.Menu;
import com.cetetek.order.util.SystemCount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	//GridView菜谱项
	private class GirdHolder {
		ImageView appImage;
		TextView appName;
		TextView appPrice;
		TextView appCount;
	}
	
	private Context context;
	
	//private List<GridInfo> list;
	private List<Menu> menuList;
    private LayoutInflater inflater;  
	
    public GridAdapter(Context c) {  
        super();  
        this.context = c;  
    }  
    
    public void setList(List<Menu> menuList) {  
        this.menuList = menuList;  
        inflater = (LayoutInflater) context  
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
  
    }  
    
	@Override
	public int getCount() {
		return menuList.size();
	}

	@Override
	public Object getItem(int index) {
		return menuList.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	/**
	 * 为GridView菜谱项赋值
	 */
	@Override
	public View getView(int index, View convertView, ViewGroup parent) {
		GirdHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.main_nine_item, null);
			holder = new GirdHolder();
			holder.appImage = (ImageView) convertView.findViewById(R.id.main_nine_itemImage);
			holder.appName = (TextView) convertView.findViewById(R.id.main_nine_itemName);
			holder.appPrice = (TextView) convertView.findViewById(R.id.main_nine_itemPrice);
			holder.appCount = (TextView) convertView.findViewById(R.id.main_nine_itemCount);
			
			convertView.setTag(holder);
		}
		else {
			holder = (GirdHolder) convertView.getTag();
		}
		//GridInfo info = list.get(index);
		Menu menu = menuList.get(index);
		if(menu != null){
			String myJpgPath = SystemCount.IMAGES_BASE + menu.getPic();
		    BitmapFactory.Options options = new BitmapFactory.Options();
		    options.inSampleSize = 1;
		    Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
			holder.appImage.setImageBitmap(bm);
			holder.appName.setText(menu.getMenuname());
			holder.appPrice.setText("价格 " + menu.getPrice() + "元");
			holder.appCount.setText("当前的菜谱已点 " + "1" + " 份");
		}
		return convertView;
	}

}
