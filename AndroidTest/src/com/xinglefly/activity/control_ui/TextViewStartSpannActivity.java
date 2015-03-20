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
		String[] data = new String[] { "巴神", "鸟叔", "切尔西-猎豹", "切尔西-伊万",
				"切尔西-阿扎尔", "切尔西-奥斯卡", "巴神-AC米兰", "C罗", "梅西", "卡卡" };
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
		String tag = "“生活的船不能没有理想的帆，生活的理想就是为了理想的生活”。"
				+ "一旦扬帆远征，必须主宰航向。正如理想与生活比肩催情，须新感觉。抉择致使我会选他，"
				+ "这样看似复杂但却充实、享受的生活。我愿每天做最勤奋的一个，追逐至死不渝！每天敲击自己，"
				+ "有新鲜血液的注入，刺激大脑皮层让我变得不那么陌生！高度敏锐观察力，" + "会给我十万个为什么的理由来说服我的。";
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
