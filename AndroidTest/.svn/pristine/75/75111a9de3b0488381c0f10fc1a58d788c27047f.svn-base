package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.fragment.Fragment_UI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class SimpleAdapter_UI extends BaseActivity implements OnClickListener {

	private ListView listvideo;
	private Map<String, Object> map;
	private List list;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.simplebitmap);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		listvideo = (ListView) findViewById(R.id.listvideo);

		list = new ArrayList();
		
		//装载数据
		map = new HashMap<String, Object>();
		for(int i=0;i<10;i++){
			map.put("img", BitmapFactory.decodeResource(getResources(), R.drawable.u31));
			list.add(map);
		}
//		map.put("img",BitmapFactory.decodeFile(Environment.getRootDirectory() + "/Photo/P40511-192714.jpg"));// 后面跟sd卡之后的路径
//		map.put("img",BitmapFactory.decodeFile(Environment.getRootDirectory() + "/P40511-192714.jpg"));// 后面跟sd卡之后的路径
		
		
		
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.onlinelistitem, new String[] { "img" },
				new int[] { R.id.img_video });
		// 存入binder
		adapter.setViewBinder(new ViewBinder() {

			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				ImageView img = (ImageView) view;
				Bitmap bm = (Bitmap) data;
				img.setImageBitmap(bm);
				return true;
			}
		});
		
		listvideo.setAdapter(adapter);
		
		listvideo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Object obj = list.get(position);
				Log.i("--list item-->", obj.toString());
//				if(obj.equals("img")){
//					Intent intent = new Intent(SimpleAdapter_UI.this,Fragment_UI.class);
//					startActivity(intent);
//				}
				Intent intent = new Intent(SimpleAdapter_UI.this,Fragment_UI.class);
				startActivity(intent);
			}
		});
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(SimpleAdapter_UI.this);
			break;

		default:
			break;
		}
	}

}

