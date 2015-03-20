package com.xinglefly.activity.control_ui;

import java.lang.reflect.Field;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

/**
 * EditText lime light
 * 
 * @author xinglefly
 * 
 */
public class EditText_UI extends BaseActivity implements OnClickListener {

	private EditText et_name;
	private Button btn_submit;
	private Button btn_addface;
	private EditText et_face;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.edittext_ui);

		addEmotion(); // 添加表情
	}

	private void addEmotion() {
		btn_addface = (Button) findViewById(R.id.btn_addface);
		btn_addface.setOnClickListener(this);
		et_face = (EditText) findViewById(R.id.et_face);

	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		et_name = (EditText) findViewById(R.id.et_name);
		btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			String username = et_name.getText().toString();
			if (username == null || username.trim().equals("")) {
				et_name.setError("请输入注册的用户名!!");
				return;
			}
			break;
		case R.id.btn_addface:
			try {
				int randomId = 1 + new Random().nextInt(9);
				Field field = R.drawable.class.getDeclaredField("face"
						+ randomId);
				int sourceId = Integer.parseInt(field.get(null).toString());
				// 使用Bitmap位图对象来装载图片
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
						sourceId);
				ImageSpan imageSpan = new ImageSpan(EditText_UI.this, bitmap);

				SpannableString spannableString = new SpannableString("face");
				spannableString.setSpan(imageSpan, 0, 4,
						Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

				et_face.append(spannableString);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(EditText_UI.this);
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
