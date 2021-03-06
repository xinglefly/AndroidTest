package com.xinglefly.activity.control_ui;

import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;
import com.xinglefly.util.ActivityUtil;

public class ListView_UI extends BaseActivity implements OnClickListener {

	private ListView lv_product;
	private List<Map<String, Object>> data = null;

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.list_ui);
		lv_product = (ListView) findViewById(R.id.lv_product);
		data = MyDataSource.getSimpleDataSource();
		
		SimpleAdapter adapter = new SimpleAdapter(ListView_UI.this, data,
				R.layout.list_item_ui, new String[] { "proname", "proaddress",
						"proprice" }, new int[] { R.id.tv_proname,
						R.id.tv_proaddress, R.id.tv_proprice });
		
		View footerView = ((LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_footer, null, false);
		lv_product.addFooterView(footerView);
		
		lv_product.setAdapter(adapter);
		
	}
	

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub
		 img_header_view_back_key = (ImageView)
		 findViewById(R.id.img_header_view_back_key);
		 img_header_view_back_key.setOnClickListener(this);
		 tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		 tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(ListView_UI.this);
			break;

		default:
			break;
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

}
