package com.xinglefly.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * A warpper of AlertDialog</br> post a callback Interface
 * "BaseAlertDialogCallback"
 * 
 * @author sw.zhang
 * 
 */
public class BaseAlertDialog {
	public BaseAlertDialog(final int flag,
			final BaseAlertDialogCallback callback, Context context,
			String title, String message, String positive, String negative) {

		new AlertDialog.Builder(context).setTitle(title).setMessage(message)
				.setPositiveButton(positive, new OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						callback.positive(flag);
					}
				}).setNegativeButton(negative, new OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						callback.negative(flag);
					}
				}).create().show();

	}

	/**
	 * 回调接口
	 * 
	 * @author sw.zhang
	 * 
	 */
	public interface BaseAlertDialogCallback {
		public static final int FLAG_SCAN_ONLINE = 0;
		public static final int FLAG_SCAN_OTHER = 1;
		public static final int FLAG_CONNECT_OTHER = 2;

		void positive(int flag);

		void negative(int flag);
	}

}
