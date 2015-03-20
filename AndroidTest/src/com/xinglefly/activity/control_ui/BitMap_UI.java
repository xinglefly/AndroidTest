package com.xinglefly.activity.control_ui;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class BitMap_UI extends BaseActivity implements OnClickListener {

	private ImageView img_tailor;
	private TextView tv_showname;

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.bitmap_ui);
		tv_showname = (TextView) findViewById(R.id.tv_showname);
		tv_showname.setTextColor(Color.RED);
		tv_showname.setText("ͼƬ�ü�");
		img_tailor = (ImageView) findViewById(R.id.img_tailor);
		img_tailor.setLayoutParams(new LinearLayout.LayoutParams(500,300));
		img_tailor.setEnabled(false);
		img_tailor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BitMap_UI.this,Text.class);
				startActivity(intent);
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(BitMap_UI.this);
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
