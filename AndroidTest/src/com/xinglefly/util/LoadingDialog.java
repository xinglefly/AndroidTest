package com.xinglefly.util;



import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.xinglefly.R;

/**
 * ×Ô¶¨ÒåDialog
 * use: LoadingDialog dialog=new LoadingDialog(context);
 *      dialog.show();
 *      dialog.dismiss();
 * @author xinglefly
 */

public class LoadingDialog {
	Context context;
	Dialog dialog;
	
	public LoadingDialog(Context context){
		this.context = context;
		
		dialog = new Dialog(context);
		dialog.setCanceledOnTouchOutside(true);
		dialog.setCancelable(true);
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.loading_dialog);
		
	}
	
	public void show(){
		if(dialog.isShowing()) {
			dialog.dismiss();
		}
		dialog.show();
	}
	public void dismiss(){
		dialog.dismiss();
	}
}
