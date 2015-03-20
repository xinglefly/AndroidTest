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
 * ��baseAdapter���
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
			 * ��һ�֣�û���κδ���������������д������������ٿ����ͣ���������б����������ܴ��ʱ�򣬻�ÿ�ζ����´���View��������Դ��
			 * ����Ӱ�����ܣ����Դ�һ��ʼ�Ͳ�Ҫ�����ַ�ʽ
			 */
			/*
			 * View view =
			 * getLayoutInflater().inflate(R.layout.baseadapter_item, null);
			 * ImageView img = (ImageView) view.findViewById(R.id.img); TextView
			 * tv = (TextView) view.findViewById(R.id.tv); TextView info =
			 * (TextView) view.findViewById(R.id.info);
			 * 
			 * img.setImageResource(R.drawable.face3); tv.setText("����");
			 * info.setText("����");
			 */
			/**
			 * �ڶ���ListView�Ż���ͨ������convertView,
			 * �������û���contentView�ķ�ʽ�����ж���������в�����View�Ŵ���View
			 * ������Ѿ����ڿ������û����е�View������������
			 */
			/*
			 * if(convertView==null){ convertView=
			 * getLayoutInflater().inflate(R.layout.baseadapter_item, null); }
			 * ImageView img = (ImageView) convertView.findViewById(R.id.img);
			 * TextView tv = (TextView) convertView.findViewById(R.id.tv);
			 * TextView info = (TextView) convertView.findViewById(R.id.info);
			 * 
			 * img.setImageResource(R.drawable.face3); tv.setText("����");
			 * info.setText("����");
			 */

			/**
			 * ������ListView�Ż���ͨ��convertView+ViewHolder��ʵ�֣�ViewHolder����һ����̬�࣬ʹ��
			 * ViewHolder �Ĺؼ��ô��ǻ�������ʾ���ݵ���ͼ��View�����ӿ��� UI ����Ӧ�ٶȡ�
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
			 * holder.tv.setText("��ϱ��"); // holder.info.setText("��֪��ѡ�ĸ�"); }
			 * holder.img .setImageResource((Integer)
			 * list.get(position).get("img"));
			 * holder.tv.setText(list.get(position).get("tv") + "");
			 * holder.info.setText(list.get(position).get("info") + "");
			 */

			/**
			 * ������ʵ�֣���ȡViewHolder,���baseAdapter���渴��
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