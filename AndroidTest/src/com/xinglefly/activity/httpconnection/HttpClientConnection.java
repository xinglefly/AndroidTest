package com.xinglefly.activity.httpconnection;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.BaseAdapter_UI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class HttpClientConnection extends BaseActivity implements
		OnClickListener {

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.httpclientui);
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
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(HttpClientConnection.this);
			break;

		default:
			break;
		}

	}

}
