package com.xinglefly.activity.control_ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class TimerCount extends BaseActivity implements OnClickListener {

	private Button btn_start;
	private TextView tv_showcount;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.timercount);
	}

	@Override
	protected void findViewByid() {
		// 初始化head控件
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		// 初始化控件
		btn_start = (Button) findViewById(R.id.btn_start);
		tv_showcount = (TextView) findViewById(R.id.tv_showcount);
		btn_start.setOnClickListener(this);
	}

	/**
	 * millisInFuture 从开始调用start()到倒计时完成并onFinish()方法被调用的毫秒数。（倒计时时间，单位毫秒）
	 * 
	 * countDownInterval 接收onTick(long)回调的间隔时间。（单位毫秒）
	 */
	CountDownTimer timer = new CountDownTimer(20000, 1000) {
		private ProgressDialog customDialog;
		/**
		 * 固定间隔被调用 millisUntilFinished 倒计时剩余时间	
		 */
		@Override
		public void onTick(long millisUntilFinished) {
			tv_showcount.setText("" + millisUntilFinished / 1000);
			String html = "<font color='#55BBFF'>正在安装升级文件……</font><br>";
//			html += "正在重启路由器<br>";
			html += "<font color='#55BBFF'>更新完成之后，程序将自动关闭，请手动重新启动应用程序！</font><br>";
			CharSequence charSequence = Html.fromHtml(html);
			customDialog = new ProgressDialog(TimerCount.this);
			customDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//
			// 设置风格为圆形进度条
			customDialog.setCanceledOnTouchOutside(false);
			customDialog.setTitle("固件升级");
			customDialog.setMessage(charSequence+"" + millisUntilFinished / 1000);
			customDialog.setIndeterminate(false);// 设置进度条是否为不明确
			customDialog.setCancelable(false);
			customDialog.show();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 倒计时完成时被调用
		 */
		@Override
		public void onFinish() {
			tv_showcount.setText("done!");
			customDialog.cancel();
			CloseApplication();
		}

		/**
		 * 关闭整个应用程序
		 */
		private void CloseApplication() {
			Intent exit = new Intent(Intent.ACTION_MAIN);
			exit.addCategory(Intent.CATEGORY_HOME);
			exit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(exit);
			java.lang.System.exit(0);
		}
		

	};

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
		case R.id.btn_start:
			timer.start();
			break;
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(TimerCount.this);
			break;

		default:
			break;
		}

	}

}
