package com.xinglefly.activity.control_ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class Gridlayout_UI extends BaseActivity implements OnClickListener {
	private int numButtons = 1;
	private GridLayout gridContainer;
	private Button addButton;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.gridlayout);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		//gridlayout����
		gridContainer = (GridLayout) findViewById(R.id.gridContainer);
		addButton = (Button) findViewById(R.id.addNewButton);
		addButton.setOnClickListener(this);
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
		
		case R.id.addNewButton:
			Button newButton = new Button(Gridlayout_UI.this);
			newButton.setText(String.valueOf(numButtons++));
			newButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
//					gridContainer.removeView(v);
				}
			});
			gridContainer.addView(newButton,
					Math.min(0, gridContainer.getChildCount()));
			break;
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(Gridlayout_UI.this);
			break;

		default:
			break;
		}

	}

}
