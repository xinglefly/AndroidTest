package com.xinglefly.activity.control_ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.xinglefly.R;
import com.xinglefly.activity.BasicControlUI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;

/**
 * 主界面
 * 
 * @author xinglefly
 * 
 */
public class WelcomeActivity extends BaseActivity {

	private static final String Tag = "WelcomeActivity";
	private static final int GO_HOME = 100;
	private static final int GO_GUIDE = 200;
	private boolean isFirst = false;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_GUIDE:
				goGuide();
				break;
			case GO_HOME:
				goHome();
				break;
			}
		}

	};

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.welcome);
	}

	protected void initData() {

	}

	@Override
	protected void updateUI() {

	}

	@Override
	protected void processLogic() {
		// 获取偏好设置的引导界面
		isFirst = getSharedPreferences(Constants.SP_GUIDEINFO, MODE_PRIVATE)
				.getBoolean("isFirst", false);
		if (isFirst) {
			mHandler.sendEmptyMessageDelayed(GO_HOME, 10);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, 10);
		}
	}

	/**
	 * 进入引导页
	 */
	private void goGuide() {
		ActivityUtil.startActivity(WelcomeActivity.this, new Intent(
				WelcomeActivity.this, GuideActivity.class),
				getString(R.string.android_basis));
		finish();
	};

	/**
	 * 进入主界面
	 */
	private void goHome() {
		ActivityUtil.startActivity(WelcomeActivity.this, new Intent(
				WelcomeActivity.this, BasicControlUI.class),
				getString(R.string.android_basis));
		finish();
	}

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setOnClick() {
		// TODO Auto-generated method stub

	}

}
