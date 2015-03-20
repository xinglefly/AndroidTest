package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

/**
 * ViewPagerʹ��
 * 
 * @author xinglefly
 * 
 */
public class ViewPager_UI extends BaseActivity implements OnClickListener,
		OnPageChangeListener {
	private static final String Tag = "ViewPager_UI";

	private ViewPager viewpager; // viewPager�ؼ�
	// private PagerTitleStrip pagertitle; // pagetitle �ؼ�
	private PagerTabStrip pagertag; // pagertag�ؼ�
	private PagerAdapter adapter = null; // pagerAdapter
	private List<View> pagerlist = null;// ��Ϊ���صĵ���pager
	private List<String> titlelist = null;// ��Ϊ���صĵ���pager

	private View tab1, tab2, tab3;

	private Button btn_startMain;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.viewpager_ui);

	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		// ��ʼ��viewpager���
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		// pagertitle = (PagerTitleStrip) findViewById(R.id.pagertitle);
		pagertag = (PagerTabStrip) findViewById(R.id.pagertag);
		pagertag.setDrawFullUnderline(false);
		pagertag.setTabIndicatorColor(Color.WHITE);
		// pagertitle.setTextSpacing(150);
		// pagertitle.setTextColor(Color.RED);

		viewpager.setAdapter(new MyAdapter());

		tab1 = getLayoutInflater().inflate(R.layout.tab1, null);
		tab2 = getLayoutInflater().inflate(R.layout.tab2, null);
		tab3 = getLayoutInflater().inflate(R.layout.tab3, null);

		btn_startMain = (Button) tab3.findViewById(R.id.btn_startMain);

		initData();

	}

	/**
	 * ��ʼ������
	 */
	private void initData() {
		// ����ҳ��ʾ���ӵ�list������

		pagerlist = new ArrayList<View>();
		pagerlist.add(tab1);
		pagerlist.add(tab2);
		pagerlist.add(tab3);

		titlelist = new ArrayList<String>();
		titlelist.add("��Ƶ");
		titlelist.add("Ӧ��");
		titlelist.add("�ȵ�");

		btn_startMain.setOnClickListener(this);

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

	private class MyAdapter extends PagerAdapter {

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) { // ɾ��ҳ��
			// TODO Auto-generated method stub
			Log.i(Tag, "--destroyItem-->" + pagerlist.get(position));
			container.removeView(pagerlist.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {// ʵ����ҳ��
			Log.i(Tag, "--instantiateItem-->" + pagerlist.get(position));
			container.addView(pagerlist.get(position));// ����ҳ��

			return pagerlist.get(position);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titlelist.get(position);
		}

		@Override
		public int getCount() {

			// TODO Auto-generated method stub
			return pagerlist.size();// ����ҳ��������
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_startMain:
			startButton();
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(ViewPager_UI.this);
			break;

		default:
			break;
		}
	}

	private void startButton() {
		Intent intent = new Intent(ViewPager_UI.this, WebView_UI.class);
		startActivity(intent);
		this.finish();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

}