package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.xinglefly.R;
import com.xinglefly.activity.BasicControlUI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;

public class GuideActivity extends BaseActivity {

	private static final String Tag = "GuideActivity";
	private ViewPager viewpager;
	private List<View> views;
	private View v4;

	@Override
	protected void loadViewLayout() {

		setContentView(R.layout.guide);
		views = new ArrayList<View>();
		viewpager = (ViewPager) findViewById(R.id.viewpager);// ʵ����viewpager���

		views.add(getLayoutInflater().inflate(R.layout.guide01, null));
		views.add(getLayoutInflater().inflate(R.layout.guide02, null));
		views.add(getLayoutInflater().inflate(R.layout.guide03, null));
		v4 = getLayoutInflater().inflate(R.layout.guide04, null);
		views.add(v4);

		viewpager.setAdapter(new vpAdapter());
		initData();
	}

	protected void initData() {
		// ����������İ�ť����
		Button mstart = (Button) v4.findViewById(R.id.mstart);
		mstart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// startGuided();  
				goHome();
			}
		});
	}

	@Override
	protected void updateUI() {

	}

	@Override
	protected void processLogic() {

	}

	/**
	 * �Զ���pagerAdapter
	 * 
	 * @author xinglefly
	 */
	private class vpAdapter extends PagerAdapter {

		/**
		 * ����positionλ�õĽ���
		 */
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) { // ɾ��ҳ��
			container.removeView(views.get(position));
		}

		/**
		 * ��ʼ��positionλ�õĽ���
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {// ʵ����ҳ��
			container.addView(views.get(position));// ����ҳ��
			return views.get(position);
		}

		/**
		 * ��õ�ǰ������
		 */
		@Override
		public int getCount() {
			return views.size();// ����ҳ��������
		}

		/**
		 * �ж��Ƿ��ɶ������ɽ���
		 */
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}

	/**
	 * ����������
	 */
	protected void goHome() {
		ActivityUtil.startActivity(GuideActivity.this, new Intent(
				GuideActivity.this, BasicControlUI.class),
				getString(R.string.android_basis));
		finish();
	}

	/**
	 * ƫ�����ã���¼�Ƿ��һ�ΰ�װapp������������
	 */
	protected void startGuided() {
		SharedPreferences preferences = getSharedPreferences(
				Constants.SP_GUIDEINFO, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean("isFirst", true);
		editor.commit();
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