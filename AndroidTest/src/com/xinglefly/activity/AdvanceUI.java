package com.xinglefly.activity;

import io.vov.vitamio.demo.VitamioListActivity;

import java.util.List;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.advance.VideoViewDemo;
import com.xinglefly.activity.control_ui.BaseAdapter_UI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;
import com.xinglefly.util.ActivityUtil;

/**
 * �߼�Ӧ��
 * 
 * @author xinglefly
 * 
 */
public class AdvanceUI extends BaseActivity implements OnClickListener {
	private ListView lv_netcontrolui;
	private ArrayAdapter<String> adapter = null;
	private List<String> list = null;
	private static final String Tag = "AdvanceUI";
	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.advanceui);
		Log.i(Tag, "advance application");
		
		lv_netcontrolui = (ListView) findViewById(R.id.lv_advanceui);

		list = MyDataSource.getArrayAdavanceSource();
		
		adapter = new ArrayAdapter<String>(AdvanceUI.this,
				android.R.layout.simple_list_item_1, list);
		lv_netcontrolui.setAdapter(adapter);
		
		lv_netcontrolui.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String selectItemname = list.get(position);
				Intent intent = null;
				if (selectItemname.equals("Vitamio 3.0")) {
					intent = new Intent(AdvanceUI.this, VideoViewDemo.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.putExtra(TITLENAME,
							getString(R.string.android_advance_vitamio30));
					startActivity(intent);
				}else if (selectItemname.equals("Vitamio 4.0")) {
					intent = new Intent(AdvanceUI.this, VitamioListActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.putExtra(TITLENAME,
							getString(R.string.android_advance_vitamio40));
					startActivity(intent);
				} 
			}

		});

	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
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
			ActivityUtil.finishActivity(AdvanceUI.this);
			break;
		default:
			break;
		}
	}
}
