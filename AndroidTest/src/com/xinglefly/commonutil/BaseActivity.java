package com.xinglefly.commonutil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinglefly.R;
import com.xinglefly.util.Constants;

/**
 * ������
 * 
 * @author xinglefly
 * 
 */
public abstract class BaseActivity extends Activity {

	public static final boolean Debug = Constants.DEBUG;
	public static final String TITLENAME = "titlename"; // ��������
	public ImageView img_header_view_back_key; // ͷ�ļ�
	public TextView tv_titlename;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
				.build());
		requestWindowFeature(Window.FEATURE_NO_TITLE); // �ޱ���
		// getWindow().requestFeature(Window.FEATURE_NO_TITLE); һ����Ч��
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // ������ʾ
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		loadViewLayout();
		findViewByid();
		setOnClick();
		processLogic();
		updateUI();
	}

	public boolean hasMountedSD() {
		String state = Environment.getExternalStorageState();
		if (!state.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(BaseActivity.this, R.string.sd_hasmouted,
					Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
	}

	/**
	 * ����ҳ�沼���ļ�
	 */
	protected abstract void loadViewLayout();

	/**
	 * ��ʼ���ؼ�
	 */
	protected abstract void findViewByid();

	/**
	 * �����¼�
	 */
	protected abstract void setOnClick();

	/**
	 * ����UI
	 */
	protected abstract void updateUI();

	/**
	 * �߼�����
	 */
	protected abstract void processLogic();

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void startIntent(Context context, Class clz) {
		Intent intent = new Intent(context, clz.getClass());
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
		overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
	}

	/**
	 * ��������쳣
	 * 
	 * @return
	 */
	public boolean getNetWorkStatus() {

		boolean netSataus = false;
		ConnectivityManager cwjManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

		cwjManager.getActiveNetworkInfo();

		if (cwjManager.getActiveNetworkInfo() != null) {
			netSataus = cwjManager.getActiveNetworkInfo().isAvailable();
		}

		if (!netSataus) {
			Builder b = new AlertDialog.Builder(this).setTitle("û�п��õ�����")
					.setIcon(R.drawable.expect).setMessage("�Ƿ������������ã�");
			b.setPositiveButton("����", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
					if (android.os.Build.VERSION.SDK_INT > 10) {
						// 3.0���ϴ����ý��棬Ҳ����ֱ����ACTION_WIRELESS_SETTINGS�򿪵�wifi����
						startActivity(new Intent(
								android.provider.Settings.ACTION_SETTINGS));
					} else {
						startActivity(new Intent(
								android.provider.Settings.ACTION_WIRELESS_SETTINGS));
					}
				}
			}).setNegativeButton("֪����", null).show();

		}

		return netSataus;
	}

}