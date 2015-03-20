package com.xinglefly.activity.control_ui;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class TextViewStartSpannActivity extends BaseActivity implements
		OnClickListener {

	private TextView tv_start_activity;
	private AutoCompleteTextView auto_tv;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.autotextview_ui);

		getAutoCompleteTextView(); //
	}

	private void getAutoCompleteTextView() {
		auto_tv = (AutoCompleteTextView) findViewById(R.id.auto_tv);
		String[] data = new String[] { "����", "����", "�ж���-�Ա�", "�ж���-����",
				"�ж���-������", "�ж���-��˹��", "����-AC����", "C��", "÷��", "����" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				TextViewStartSpannActivity.this,
				android.R.layout.simple_dropdown_item_1line, data);
		auto_tv.setAdapter(adapter);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		tv_start_activity = (TextView) findViewById(R.id.tv_start_activity);
		tv_start_activity.setTextColor(Color.BLACK);
		String tag = "������Ĵ�����û������ķ���������������Ϊ������������"
				+ "һ���﷫Զ�����������׺�����������������ȼ���飬���¸о���������ʹ�һ�ѡ����"
				+ "�������Ƹ��ӵ�ȴ��ʵ�����ܵ������Ըÿ�������ڷܵ�һ����׷���������壡ÿ���û��Լ���"
				+ "������ѪҺ��ע�룬�̼�����Ƥ�����ұ�ò���ôİ�����߶�����۲�����" + "�����ʮ���Ϊʲô��������˵���ҵġ�";
		// CharSequence charSequence = Html.fromHtml(tag);
		tv_start_activity.setText(tag);
		// tv_start_activity.setMovementMethod(LinkMovementMethod.getInstance());

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
			ActivityUtil.finishActivity(TextViewStartSpannActivity.this);
			break;
		}
	}
}
