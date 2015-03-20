package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.ToastUtil;
import com.xinglefly.util.ViewHolder;

/**
 * 对baseAdapter详解
 * 
 * @author Administrator
 * 
 */
public class BaseAdapter_UI extends BaseActivity implements OnClickListener {

	private ListView lv;
	private List<Map<String, Object>> list;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.baseadapter);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		lv = (ListView) findViewById(R.id.lv);

		list = new ArrayList<Map<String, Object>>();
		list = MyDataSource.getBaseAdapterData();

		MyAdapter adapter = new MyAdapter();

		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new MyClickListener());

	}

	public class MyClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Object obj = parent.getItemAtPosition(position);
			ToastUtil.showToastText(obj.toString());
		}

	}

	@Override
	protected void setOnClick() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void updateUI() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processLogic() {
		// TODO Auto-generated method stub

	}

	public class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stubd
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			/**
			 * 第一种：没有任何处理，不建议这样写。如果数据量少看将就，但是如果列表项数据量很大的时候，会每次都重新创建View，设置资源，
			 * 严重影响性能，所以从一开始就不要用这种方式
			 */
			/*
			 * View view =
			 * getLayoutInflater().inflate(R.layout.baseadapter_item, null);
			 * ImageView img = (ImageView) view.findViewById(R.id.img); TextView
			 * tv = (TextView) view.findViewById(R.id.tv); TextView info =
			 * (TextView) view.findViewById(R.id.info);
			 * 
			 * img.setImageResource(R.drawable.face3); tv.setText("标题");
			 * info.setText("内容");
			 */
			/**
			 * 第二种ListView优化：通过缓存convertView,
			 * 这种利用缓存contentView的方式可以判断如果缓存中不存在View才创建View
			 * ，如果已经存在可以利用缓存中的View，提升了性能
			 */
			/*
			 * if(convertView==null){ convertView=
			 * getLayoutInflater().inflate(R.layout.baseadapter_item, null); }
			 * ImageView img = (ImageView) convertView.findViewById(R.id.img);
			 * TextView tv = (TextView) convertView.findViewById(R.id.tv);
			 * TextView info = (TextView) convertView.findViewById(R.id.info);
			 * 
			 * img.setImageResource(R.drawable.face3); tv.setText("标题");
			 * info.setText("内容");
			 */

			/**
			 * 第三种ListView优化：通过convertView+ViewHolder来实现，ViewHolder就是一个静态类，使用
			 * ViewHolder 的关键好处是缓存了显示数据的视图（View），加快了 UI 的响应速度。
			 */
			/*
			 * ViewHolder holder; if (convertView == null) { holder = new
			 * ViewHolder(); convertView = getLayoutInflater().inflate(
			 * R.layout.baseadapter_item, null); holder.img = (ImageView)
			 * convertView.findViewById(R.id.img); holder.tv = (TextView)
			 * convertView.findViewById(R.id.tv); holder.info = (TextView)
			 * convertView.findViewById(R.id.info); convertView.setTag(holder);
			 * } else { holder = (ViewHolder) convertView.getTag(); //
			 * holder.img.setImageResource(R.drawable.face8); //
			 * holder.tv.setText("找媳妇"); // holder.info.setText("不知道选哪个"); }
			 * holder.img .setImageResource((Integer)
			 * list.get(position).get("img"));
			 * holder.tv.setText(list.get(position).get("tv") + "");
			 * holder.info.setText(list.get(position).get("info") + "");
			 */

			/**
			 * 第四种实现，抽取ViewHolder,多个baseAdapter里面复用
			 */
			if (convertView == null) {
				convertView = getLayoutInflater().inflate(
						R.layout.baseadapter_item, null);
			}
			ImageView img = ViewHolder.get(convertView, R.id.img);
			TextView tv = ViewHolder.get(convertView, R.id.tv);
			TextView info = ViewHolder.get(convertView, R.id.info);

			Map<String, Object> data = list.get(position);
			img.setImageResource((Integer) data.get("img"));
			tv.setText(data.get("tv") + "");
			info.setText(data.get("info") + "");
			return convertView;
		}

	}

	/*
	 * static class ViewHolder { public ImageView img; public TextView tv;
	 * public TextView info; }
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(BaseAdapter_UI.this);
			break;
		default:
			break;
		}

	}

}
