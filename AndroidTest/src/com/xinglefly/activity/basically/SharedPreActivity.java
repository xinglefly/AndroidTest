package com.xinglefly.activity.basically;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinglefly.R;
import com.xinglefly.util.Constants;

/**
 * 
 * @author xinglefly
 * 
 */
public class SharedPreActivity extends Activity implements OnClickListener {
	private EditText et_name, et_pass, et_hobby;
	private Button btn_savedefaul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spcontent);

		initView();

		SharedPreferences sp = getSharedPreferences(Constants.SP_FILE_USERINFO, 0);
		String name = sp.getString("name", "");
		String pass = sp.getString("pass", "");
		String hobby = sp.getString("hobby", "");
		et_name.setText(name);
		et_pass.setText(pass);
		et_hobby.setText(hobby);
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		et_name = (EditText) findViewById(R.id.et_name);
		et_pass = (EditText) findViewById(R.id.et_pass);
		et_hobby = (EditText) findViewById(R.id.et_hobby);
		btn_savedefaul = (Button) findViewById(R.id.btn_savedefaul);
		btn_savedefaul.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_savedefaul:
			String name = et_name.getText().toString();
			String pass = et_pass.getText().toString();
			String hobby = et_hobby.getText().toString();

			Editor sp = getSharedPreferences(Constants.SP_FILE_USERINFO,
					MODE_PRIVATE).edit();
			sp.putString("name", name);
			sp.putString("pass", pass);
			sp.putString("hobby", hobby);
			sp.commit();
			Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
			et_name.setText("");
			et_pass.setText("");
			et_hobby.setText("");
			break;

		default:
			break;
		}
	}
}
