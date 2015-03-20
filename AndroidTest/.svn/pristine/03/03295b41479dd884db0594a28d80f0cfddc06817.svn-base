package com.xinglefly.datacontrol;

import java.util.ArrayList;
import java.util.HashMap;

import com.xinglefly.R;
import com.xinglefly.util.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * listView checkbox is selected adapter
 * 
 * @author xinglefly
 * 
 */
@SuppressWarnings("unused")
public class MyBaseAdapter extends BaseAdapter {

	private ArrayList<HashMap<String, String>> list;
	// private HashMap<Integer, Boolean> isSelected;
	private Context context;
	private TextView tv_item;
	public CheckBox ck_select;

	public MyBaseAdapter(ArrayList<HashMap<String, String>> list,
			Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {// 获取所有数据的总数
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {// 点击某条数据返回的数据
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {// 点击某条数据返回的id
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {// 生成指定位置上的视图
		// TODO Auto-generated method stub
		ViewHolder1 holder = null;
		if (convertView == null) {
			holder = new ViewHolder1();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.checkselector_item, null);
			holder.tv = (TextView) convertView.findViewById(R.id.tv_item);
			holder.cb = (CheckBox) convertView.findViewById(R.id.ck_select);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder1) convertView.getTag();
		}

		// tv_item = ViewHolder.get(convertView, R.id.tv_item);
		// ck_select = ViewHolder.get(convertView, R.id.ck_select);

		holder.tv.setText(list.get(position).get("content").toString());
		holder.cb.setChecked(list.get(position).get("flag").equals("true"));
		return convertView;
	}

	// public HashMap<Integer, Boolean> getIsSelected() {
	// return isSelected;
	// }
	//
	// public void setIsSelected(HashMap<Integer, Boolean> isSelected) {
	// this.isSelected = isSelected;
	// }

	public final class ViewHolder1 {
		public TextView tv;
		public CheckBox cb;
	}

}
