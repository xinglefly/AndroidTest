package com.xinglefly.activity.control_ui;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class SeekBar_UI extends BaseActivity implements OnClickListener,
		OnSeekBarChangeListener {

	private SeekBar sekkbar1;
	private SeekBar sekkbar2;
	private TextView tv_show;
	private ListView fraglist;
	private String[] fragtypes;
	private ArrayAdapter<String> adapter;
	
	
	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.seekbar_ui);
		tv_show = (TextView) findViewById(R.id.tv_show);
		sekkbar1 = (SeekBar) findViewById(R.id.sekkbar1);
		sekkbar2 = (SeekBar) findViewById(R.id.sekkbar2);
		sekkbar1.setOnSeekBarChangeListener(this);
		sekkbar2.setOnSeekBarChangeListener(this);
		
		tv_show.setTextColor(Color.RED);
		tv_show.setText("第一刻度：当前播放的进度 ;第二刻度：缓冲进度;主要用于服务器");
	}

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub
		
		
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		
		
		fraglist = (ListView) findViewById(R.id.fraglist);
		fragtypes = getResources().getStringArray(R.array.fragmenttypes);
		adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,fragtypes);
		fraglist.setAdapter(adapter);
		
	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(SeekBar_UI.this);
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

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		if (seekBar.getId() == R.id.sekkbar1) {
			tv_show.setText("进度：" + progress);
		} else {
			tv_show.setText("进度：" + progress);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		if (seekBar.getId() == R.id.sekkbar1) {
			tv_show.setText("seekbar1开始拖动");
		} else {
			tv_show.setText("seekbar2开始拖动");
		}
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		if (seekBar.getId() == R.id.sekkbar1) {
			tv_show.setText("seekBar1停止拖动");
		} else {
			tv_show.setText("seekBar2停止拖动");
		}
	}

}
