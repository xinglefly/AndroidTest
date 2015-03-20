package com.xinglefly.activity.control_ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyBaseAdapter;
import com.xinglefly.datacontrol.MyBaseAdapter.ViewHolder1;
import com.xinglefly.util.ActivityUtil;

public class CheckSelector_UI extends BaseActivity implements OnClickListener {

	private ArrayList<HashMap<String, String>> list;
	private TextView tv_shownumber;
	private Button btn_selectall;
	private Button btn_cancelall;
	private Button btn_deselectall;
	private Button btn_confirmdelete;
	private ListView lv_selectall;
	private MyBaseAdapter adapter;
	private int checkNum;

	static String str[] = { "data1", "data2", "data3", "data4", "data5",
			"data6", "data7", "data8", "data9", "data10", "data11", "data12",
			"data13" };

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.checkselector);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		list = new ArrayList<HashMap<String, String>>();

		tv_shownumber = (TextView) findViewById(R.id.tv_shownumber);
		btn_selectall = (Button) findViewById(R.id.btn_selectall);
		btn_cancelall = (Button) findViewById(R.id.btn_cancelall);
		btn_deselectall = (Button) findViewById(R.id.btn_deselectall);
		btn_confirmdelete = (Button) findViewById(R.id.btn_confirmdelete);
		lv_selectall = (ListView) findViewById(R.id.lv_selectall);

		//动态设置边距，改变布局
		LinearLayout lay_button = (LinearLayout) findViewById(R.id.lay_button);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.setMargins(-50, 0, 0, 0);
		
		lay_button.setLayoutParams(lp);
		initData();
		adapter = new MyBaseAdapter(list, this);
		lv_selectall.setAdapter(adapter);

	}

	/**
	 * 初始化数据
	 */
	private void initData() {
		for (int i = 0; i < 10; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("content", str[i]);
			map.put("flag", "false");
			list.add(map);
		}
	}

	@Override
	protected void setOnClick() {

		/*
		 * 全选
		 */
		btn_selectall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).put("flag", "true");
				}
				checkNum = list.size();
				dataChanged();
			}

		});

		/*
		 * 取现全选
		 */
		btn_cancelall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).get("flag").equals("true")) {
						list.get(i).put("flag", "false");
						checkNum--;
					}
				}
				dataChanged();
			}
		});

		/*
		 * 反选
		 */
		btn_deselectall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).get("flag").equals("true")) {
						list.get(i).put("flag", "false");
						checkNum--;
					} else {
						list.get(i).put("flag", "true");
						checkNum++;
					}
				}
				dataChanged();
			}
		});

		/*
		 * 点击某一条数据
		 */
		lv_selectall.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ViewHolder1 holder = (ViewHolder1) view.getTag();
				holder.cb.toggle();// 改变checkbox状态

				if (holder.cb.isChecked() == true) {
					list.get(position).put("flag", "true");
					checkNum++;
				} else {
					list.get(position).put("flag", "false");
					checkNum--;
				}

				// 显示条目
				tv_shownumber.setText("以选中" + checkNum + "项");
				// ToastUtil.showToastText("--position-->" + position);
				Toast.makeText(CheckSelector_UI.this,
						"--position-->" + position, Toast.LENGTH_SHORT).show();
			}
		});

		/*
		 * 确认删除
		 */
		btn_confirmdelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Iterator<HashMap<String, String>> iterator = list.iterator();
				while (iterator.hasNext()) {
					HashMap<String, String> temp = iterator.next();
					if (temp.get("flag").equals("true")) {
						iterator.remove();
					}
				}
				checkNum = 0;
				dataChanged();
			}
		});

	}

	/**
	 * 刷新listview数据，更新UI
	 */
	private void dataChanged() {
		adapter.notifyDataSetChanged();
		// 最新显示条目
		tv_shownumber.setText("以选中" + checkNum + "项");
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
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(CheckSelector_UI.this);
			break;

		default:
			break;
		}

	}

}
