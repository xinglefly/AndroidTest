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

		String[] checkboxText = new String[] { "����", "��Ӱ", "�˶�", "����", "��ʳ",
				"����" };

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
			 * ���������һ�����⣺Ĭ������¼��ز��ֵ�ʱ���Ǵ�0���ؼ���ʼ���أ����
			 * linearLayout.addView(checkBox,
			 * i);���൱�ڴ��϶��½�checkBox�����ļ����ȼ��أ�����ͷ�ļ�����ʾ�����棬���� �κ������ǲ������õġ�
			 * linearLayout
			 * .addView(checkBox,1)�����൱���ȼ�����include�����ļ���Ȼ��Ż����checkbox
			 * ��������button �ܽᣬ���ص�˳�򣬾��൱�ڴ�xml�����ļ���д�ģ��ؼ������Ǵ�0��ʼ��
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
				s = "����û��ѡ��һ�";
			}
			new AlertDialog.Builder(this).setMessage(s)
					.setPositiveButton("ȷ��", null).show();
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