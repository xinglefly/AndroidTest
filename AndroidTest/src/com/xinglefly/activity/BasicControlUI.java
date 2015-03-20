package com.xinglefly.activity;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.AsyncTask_UI;
import com.xinglefly.activity.control_ui.BaseAdapter_UI;
import com.xinglefly.activity.control_ui.BitMap_UI;
import com.xinglefly.activity.control_ui.Button_UI;
import com.xinglefly.activity.control_ui.CheckBox_UI;
import com.xinglefly.activity.control_ui.CheckSelector_UI;
import com.xinglefly.activity.control_ui.EditText_UI;
import com.xinglefly.activity.control_ui.Gridlayout_UI;
import com.xinglefly.activity.control_ui.Intent_UI;
import com.xinglefly.activity.control_ui.ListView_UI;
import com.xinglefly.activity.control_ui.Search_UI;
import com.xinglefly.activity.control_ui.SeekBar_UI;
import com.xinglefly.activity.control_ui.SimpleAdapter_UI;
import com.xinglefly.activity.control_ui.TextView_UI;
import com.xinglefly.activity.control_ui.TimerCount;
import com.xinglefly.activity.control_ui.ToggleButton_UI;
import com.xinglefly.activity.control_ui.ViewPagerIndicator;
import com.xinglefly.activity.control_ui.ViewPager_UI;
import com.xinglefly.activity.control_ui.WebView_UI;
import com.xinglefly.activity.control_ui.WelcomeActivity;
import com.xinglefly.activity.control_ui.Xutil_UI;
import com.xinglefly.activity.control_ui.fragment.Fragment_UI;
import com.xinglefly.activity.control_ui.fragment.MfragmentTabHost;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.BaseAlertDialog;
import com.xinglefly.util.BaseAlertDialog.BaseAlertDialogCallback;
import com.xinglefly.util.ToastUtil;

/**
 * Android basic control UI
 * 
 * @author xinglefly
 * 
 */
public class BasicControlUI extends BaseActivity implements OnClickListener {

	private ListView lv_ui;
	private ArrayAdapter<String> adapter;
	private List<String> list;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.basically_control_ui);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		lv_ui = (ListView) findViewById(R.id.lv_ui);

		list = MyDataSource.getArrayDataSource();
		adapter = new ArrayAdapter<String>(BasicControlUI.this,
				android.R.layout.simple_list_item_1, list);
		lv_ui.setAdapter(adapter);

		addListener();

	}

	private BaseAlertDialogCallback alertDialogCallback = new BaseAlertDialogCallback() {
		@Override
		public void positive(int flag) {
			ToastUtil.showToastText("删除成功");
		}

		@Override
		public void negative(int flag) {
			ToastUtil.showToastText("取消");
		}

	};

	private void addListener() {
		lv_ui.setSelector(R.drawable.listitem_selector);
		lv_ui.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
//				view.setBackgroundColor(R.drawable.listitem_selector);
//				view.setSelected(true);
				new BaseAlertDialog(BaseAlertDialogCallback.FLAG_SCAN_OTHER,
						alertDialogCallback, BasicControlUI.this, "确认删除", null,
						"删除", "取消");
				Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vibrator.vibrate(100);
				return true;
			}

		});

		lv_ui.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				String itemName = list.get(position);
				if (itemName.equals("TextView application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, TextView_UI.class),
							getString(R.string.android_ui_textview));
				} else if (itemName.equals("EditText application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, EditText_UI.class),
							getString(R.string.android_ui_edittext));
				} else if (itemName.equals("RadioButton application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, Button_UI.class),
							getString(R.string.android_ui_button));
				} else if (itemName.equals("ToggleButton application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, ToggleButton_UI.class),
							getString(R.string.android_ui_togglebutton));
				} else if (itemName.equals("checkbox application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, CheckBox_UI.class),
							getString(R.string.android_ui_checkbox));
				} else if (itemName.equals("seekbar application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, SeekBar_UI.class),
							getString(R.string.android_ui_seekbar));
				} else if (itemName.equals("BitMap application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, BitMap_UI.class),
							getString(R.string.android_ui_bitmap));
				} else if (itemName.equals("ListView application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, ListView_UI.class),
							getString(R.string.android_ui_listview));
				} else if (itemName.equals("Fragment application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, Fragment_UI.class),
							getString(R.string.android_ui_fragment));
				} else if (itemName.equals("ViewPage application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, ViewPager_UI.class),
							getString(R.string.android_ui_viewpager));
				} else if (itemName.equals("WebView application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, WebView_UI.class),
							getString(R.string.android_ui_WebView));
				} else if (itemName.equals("FragmentTabhost")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, MfragmentTabHost.class),
							getString(R.string.android_ui_video));
				} else if (itemName.equals("SimpleAdapter_bitmap")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, SimpleAdapter_UI.class),
							getString(R.string.android_ui_simpleAdapter));
				} else if (itemName.equals("GridLayout application")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, Gridlayout_UI.class),
							getString(R.string.android_ui_gridlayout_UI));
				} else if (itemName.equals("BaseAdapter")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, BaseAdapter_UI.class),
							getString(R.string.android_ui_gridlayout_UI));
				} else if (itemName.equals("search")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, Search_UI.class),
							getString(R.string.android_ui_search_UI));
				} else if (itemName.equals("Timer")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, TimerCount.class),
							getString(R.string.android_ui_timercount_UI));
				} else if (itemName.equals("ViewPagerIndicator")) {
					ActivityUtil
							.startActivity(
									BasicControlUI.this,
									new Intent(BasicControlUI.this,
											ViewPagerIndicator.class),
									getString(R.string.android_ui_viewpagerindicator_UI));
				} else if (itemName.equals("AsyncTask")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, AsyncTask_UI.class),
							getString(R.string.android_ui_aynctask_UI));
				} else if (itemName.equals("WelcomeActivity")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, WelcomeActivity.class),
							getString(R.string.android_ui_aynctask_UI));
				} else if (itemName.equals("PullRefresh")) {
//					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
//							BasicControlUI.this, PullRefresh_UI.class),
//							getString(R.string.android_ui_aynctask_UI));
				} else if (itemName.equals("Xutil")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, Xutil_UI.class),
							getString(R.string.android_ui_aynctask_UI));
				} else if (itemName.equals("CheckSelector_UI")) {
					ActivityUtil.startActivity(BasicControlUI.this, new Intent(
							BasicControlUI.this, CheckSelector_UI.class),
							getString(R.string.android_ui_checkSelector_UI));
				}else if (itemName.equals("Intent_UI")) {
                    ActivityUtil.startActivity(BasicControlUI.this, new Intent(
                            BasicControlUI.this, Intent_UI.class),
                            getString(R.string.android_ui_intent_UI));
                }

			}

		});

	}

	@Override
	protected void setOnClick() {
		// TODO Auto-generated method stub
		img_header_view_back_key.setOnClickListener(this);
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
			ActivityUtil.finishActivity(BasicControlUI.this);
			break;

		default:
			break;
		}
	}

}
