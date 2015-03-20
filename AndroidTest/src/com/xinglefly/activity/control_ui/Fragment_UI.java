package com.xinglefly.activity.control_ui;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * fragment����android4.0�Ժ���ֵ������ԡ�������������Ҫ���嵥�б�ע�ᡣ����ʾƬ�Σ���ҪӦ����ƽ���У� Fragment��ϸ�÷�
 * 
 * @author xinglefly
 * 
 */
public class Fragment_UI extends BaseActivity implements OnClickListener {

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.fragment_ui);

		// ��ȡ�ֻ���Ļ�Ŀ�Ⱥ͸߶�
		int width = getWindowManager().getDefaultDisplay().getWidth();
		int height = getWindowManager().getDefaultDisplay().getHeight();

		// ��̬��Ӳ���w
		Fragment1 f1 = new Fragment1();
		Fragment2 f2 = new Fragment2();

		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		if (width > height) {
			// ˮƽ����
			ft.replace(android.R.id.content, f1);
		} else {
			// ��ֱ����
			ft.replace(android.R.id.content, f2);
		}
		ft.commit();
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
			ActivityUtil.finishActivity(Fragment_UI.this);
			break;

		default:
			break;
		}
	}

}
