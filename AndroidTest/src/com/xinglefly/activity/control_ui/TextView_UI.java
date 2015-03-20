package com.xinglefly.activity.control_ui;

import java.lang.reflect.Field;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

/**
 * TextView lime light
 * @author xinglefly
 *
 */
public class TextView_UI extends BaseActivity implements OnClickListener {
	private TextView tv_decalaration;
	private TextView tv_imgtv;
	private TextView tv_start_activity;

	/**
	 * ʹ�÷������ͨ��ͼƬ�����ƻ�ȡͼƬ��ID
	 * 
	 * @param source
	 * @return
	 */
	public int getResourceId(String name) {
		try {
			//ͨ����Դid��������ȡField����
			Field field = R.drawable.class.getField(name);
			//ȡ�÷��ص�ID�ֶ�
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.textview_ui);
		getHtmlFrom();// ---------------TextView
						// Html.fromHtmlusage----------------

		getImageText();// ---------------TextView ͼ�Ļ�� usage----------------

		getTextViewStartActivity(); //--TextViewʵ��acitvity֮�����ת--------
									
	}

	private void getHtmlFrom() {
		tv_decalaration = (TextView) findViewById(R.id.tv_decalaration);
		tv_decalaration.setTextColor(Color.BLACK);
//		String str = "http://192.168.91.61:8080/xingleflyProject/";
		String str = "http://www.baidu.com/";
		String html = "------TextView Html.fromHtmlusage------<br>";
		html += "���䣺<font color='red'>25</font><br>";
		html += "��飺<font color='red'>��</font><br>";
		html += "���䣺<font color='red'>xinglefly@163.com</font><br>";
		html += "ְҵ��<font color='red'>��һ���������������ʦ</font><br>";
		html += "��Ŀ��<a href='" + str + "'>coding is web server</a><br>";
		html += "�绰��+86 18612951361";
		CharSequence charSequence = Html.fromHtml(html);
		tv_decalaration.setText(charSequence);
		tv_decalaration.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void getImageText() {
		tv_imgtv = (TextView) findViewById(R.id.tv_imgtv);
		tv_imgtv.setTextColor(Color.BLACK);

		String html = "-------TextView ͼ�Ļ�� usage-------<br>";
		html += "<font color='red'>ͷ��</font> <img src='expect'/><br>";
		html += "<font color='red'>��ϵ��ʽ</font> <img src='portraint'/><br>";

		CharSequence charSequence = Html.fromHtml(html, new ImageGetter() {

			@Override
			public Drawable getDrawable(String source) {
				Drawable drawable = getResources().getDrawable(
						getResourceId(source));
				if (source.equals("expect")) {
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 5,
							drawable.getIntrinsicHeight() / 5);
				} else {
					drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
							drawable.getIntrinsicHeight());
				}
				return drawable;
			}
		}, null);

		tv_imgtv.setText(charSequence);
		tv_imgtv.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void getTextViewStartActivity() {
		tv_start_activity = (TextView) findViewById(R.id.tv_start_activity);
		tv_start_activity.setTextColor(Color.BLACK);

		String str = "TextView ʵ��acitvity֮�����ת";
		// ����ַ���
		SpannableString spannableString = new SpannableString(str);
		spannableString.setSpan(new ClickableSpan() {

			@Override
			public void onClick(View widget) {
				Intent intent = new Intent(TextView_UI.this,
						TextViewStartSpannActivity.class);
				intent.putExtra(TITLENAME, getString(R.string.android_ui_textview_startactivity));
				startActivity(intent);
			}
		}, 0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		tv_start_activity.setText(spannableString);
		tv_start_activity.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	protected void findViewByid() {
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
			ActivityUtil.finishActivity(TextView_UI.this);
			break;
		}
	}

}