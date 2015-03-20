package com.xinglefly.activity.control_ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.xinglefly.R;

public class Text extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.pp);
		
		TextView tv_pp = (TextView) findViewById(R.id.tv_pp);
		Button btn_pp = (Button) findViewById(R.id.btn_pp);
		tv_pp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Text.this, ListView_UI.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.tv_pp:
			intent = new Intent(this, ListView_UI.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
}
