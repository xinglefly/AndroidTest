package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class CheckBox_UI extends BaseActivity implements OnClickListener {

	private List<CheckBox> checkBoxs = new ArrayList<CheckBox>();
	private Button btn_hobby;

	@Override
	protected void loadViewLayout() {

		String[] checkboxText = new String[] { "旅游", "摄影", "运动", "足球", "美食",
				"人文" };

		LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(
				R.layout.checkbox_ui, null);

		for (int i = 0; i < checkboxText.length; i++) {
			// linearLayout.setGravity(Gravity.TOP);
			CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(
					R.layout.checkbox_ui_item, null);
			checkBoxs.add(checkBox);
			checkBoxs.get(i).setText(checkboxText[i]);
			checkBoxs.get(i).setTextColor(Color.RED);
			// checkBox.setBottom(Gravity.BOTTOM);
			// checkBox.setGravity(Gravity.BOTTOM);
			/**
			 * 这里面会有一个问题：默认情况下加载布局的时候是从0个控件开始加载，如果
			 * linearLayout.addView(checkBox,
			 * i);就相当于从上而下将checkBox布局文件首先加载，这下头文件会显示在下面，设置 任何属性是不起作用的。
			 * linearLayout
			 * .addView(checkBox,1)；就相当于先加载完include布局文件，然后才会加载checkbox
			 * ，最后加载button 总结，加载的顺序，就相当于从xml布局文件中写的，控件依次是从0开始的
			 * 
			 */
			linearLayout.addView(checkBox, 1);
		}
		setContentView(linearLayout);
		btn_hobby = (Button) findViewById(R.id.btn_hobby);
		btn_hobby.setOnClickListener(this);
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
		case R.id.btn_hobby:
			String s = "";
			for (CheckBox checkBox : checkBoxs) {
				if (checkBox.isChecked()) {
					s += checkBox.getText() + "\n";
				}
			}
			if ("".equals(s)) {
				s = "您还没有选中一项！";
			}
			new AlertDialog.Builder(this).setMessage(s)
					.setPositiveButton("确定", null).show();
			break;
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(CheckBox_UI.this);
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
