package com.xinglefly.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xinglefly.R;

public class LoginView extends RelativeLayout {

	private static final boolean DEBUG = true;
	private static final String Tag = "LoginView";
	private LinearLayout username_ll, password_ll;
	private RelativeLayout.LayoutParams lpUsername, lpPassword;
	private int height = 0;

	private OnResizeListener mListener;

	/**
	 * ������Ļ�Ĵ�С
	 * 
	 * @author xinglefly
	 * 
	 */
	public interface OnResizeListener {
		void onResize(int w, int h, int oldw, int oldh);
	}

	public void setmListener(OnResizeListener mListener) {
		this.mListener = mListener;
	}

	/**
	 * ���췽��
	 * 
	 * @param context
	 */
	public LoginView(Context context) {
		super(context);
		username_ll = (LinearLayout) findViewById(R.id.lay_username);
		password_ll = (LinearLayout) findViewById(R.id.lay_password);
	}

	/**
	 * ���췽��
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public LoginView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		username_ll = (LinearLayout) findViewById(R.id.lay_username);
		password_ll = (LinearLayout) findViewById(R.id.lay_password);
	}

	/**
	 * ���췽��
	 * 
	 * @param context
	 * @param attrs
	 */
	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
		username_ll = (LinearLayout) findViewById(R.id.lay_username);
		password_ll = (LinearLayout) findViewById(R.id.lay_password);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (mListener != null) {
			mListener.onResize(w, h, oldw, oldh);
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		if (DEBUG) {
			Log.i(Tag, "widthMeasureSpec:" + widthMeasureSpec);
			Log.i(Tag, "heightMeasureSpec:" + heightMeasureSpec);
		}
		if (height == 0) {
			height = heightMeasureSpec;
		}

		if (username_ll == null) {
			username_ll = (LinearLayout) findViewById(R.id.lay_username);
		}
		if (password_ll == null) {
			password_ll = (LinearLayout) findViewById(R.id.lay_password);
		}

		lpUsername = (LayoutParams) username_ll.getLayoutParams();
		lpPassword = (LayoutParams) password_ll.getLayoutParams();

		// �������뷨
		if (height != heightMeasureSpec) {
			// �൱�ڶ�̬���ò����ļ���λ�ã����Ƚ�����⣬�ռ��Ҫ�ò��У����ĸ��ؼ����У���ʾ�ĸ߶ȾͲ�ͬ
			// �����˾������ԣ�Ȼ��ͻᶮ��
			//Ϊʲô��ߵ�����Ҫ������layout_centerInparent�����ģ�����ڸ�Ԫ�ؾ������ĸ��ؼ���Ϊ���㡣
			RelativeLayout.LayoutParams lp1 = new LayoutParams(lpUsername);
			lp1.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			password_ll.setLayoutParams(lp1);

			RelativeLayout.LayoutParams lp2 = new LayoutParams(lpPassword);
			lp2.addRule(RelativeLayout.ABOVE, username_ll.getId());
			lp2.bottomMargin = lpPassword.topMargin;
			username_ll.setLayoutParams(lp2);
			findViewById(R.id.img_logo).setVisibility(View.GONE);
		} else {
			RelativeLayout.LayoutParams lp2 = new LayoutParams(lpPassword);
			lp2.addRule(RelativeLayout.BELOW, username_ll.getId());
			lp2.bottomMargin = 0;
			password_ll.setLayoutParams(lp2);

			RelativeLayout.LayoutParams lp1 = new LayoutParams(lpUsername);
			lp1.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
			username_ll.setLayoutParams(lp1);

			findViewById(R.id.img_logo).setVisibility(View.VISIBLE);
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
