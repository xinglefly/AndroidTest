package com.xinglefly.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;

public class MyDialog extends Dialog {

	private int FLAG_DISMISS = 1;
	private boolean flag = true;

	public MyDialog(Context context) {
		super(context);
		String html = "正在安装升级文件<br>";
		html += "正在重启路由器<br>";
		html += "App将自动关闭，请重启应用程序";
		CharSequence charSequence = Html.fromHtml(html);
		setTitle(charSequence);
		
	}

	@Override
	public void show() {
		super.show();
		mThread.start();
	}

	@Override
	public void dismiss() {
		super.dismiss();
		flag = false;
	}

	private Thread mThread = new Thread() {
		@Override
		public void run() {
			super.run();
			while (flag) {
				try {
					Thread.sleep(1000 * 15);
					Message msg = mHandler.obtainMessage();
					msg.what = FLAG_DISMISS;
					mHandler.sendMessage(msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == FLAG_DISMISS)
				dismiss();
		}

	};

}


