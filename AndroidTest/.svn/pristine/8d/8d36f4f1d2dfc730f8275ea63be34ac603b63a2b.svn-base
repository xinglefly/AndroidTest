package com.xinglefly.activity;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.BaseAdapter_UI;
import com.xinglefly.activity.httpconnection.HttpClientConnection;
import com.xinglefly.activity.httpconnection.HttpConnection;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;
import com.xinglefly.util.ActivityUtil;

/**
 * ÍøÂç·þÎñÖ÷Ò³
 * 
 * @author xinglefly
 * 
 */
public class NetControlUI extends BaseActivity implements OnClickListener {

	private ListView lv_netcontrolui;
	private ArrayAdapter<String> adapter = null;
	private List<String> list = null;

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.netcontrol_ui);
		lv_netcontrolui = (ListView) findViewById(R.id.lv_netcontrolui);

		list = MyDataSource.getArrayNetSource();
		adapter = new ArrayAdapter<String>(NetControlUI.this,
				android.R.layout.simple_list_item_1, list);
		lv_netcontrolui.setAdapter(adapter);
		lv_netcontrolui.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String selectItemname = list.get(position);
				Intent intent = null;
				if (selectItemname.equals("UrlConnection application")) {
					intent = new Intent(NetControlUI.this, HttpConnection.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.putExtra(TITLENAME,
							getString(R.string.android_net_httpurlcon));
					startActivity(intent);
				} else if (selectItemname.equals("UrlClient application")) {
					intent = new Intent(NetControlUI.this,
							HttpClientConnection.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					intent.putExtra(TITLENAME,
							getString(R.string.android_net_httpclientcon));
					startActivity(intent);
				}
			}

		});
	}

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub
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
			ActivityUtil.finishActivity(NetControlUI.this);
			break;
		default:
			break;
		}
	}

}
