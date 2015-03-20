package com.xinglefly.activity.control_ui.fragment;

import java.util.List;

import android.content.Intent;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xinglefly.MyApp;
import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.datacontrol.MyDataSource;

/**
 * fragment����android4.0�Ժ���ֵ������ԡ�������������Ҫ���嵥�б�ע�ᡣ����ʾƬ�Σ���ҪӦ����ƽ���У� Fragment��ϸ�÷�
 * 
 * @author xinglefly
 * 
 */
public class Fragment_UI extends BaseActivity implements OnClickListener {

	private ListView fraglist;
	private String[] fragtypes;
	private List<String> fragmentTypes;
	private ArrayAdapter<String> adapter;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.fragment_ui);

		// ��ȡ�ֻ���Ļ�Ŀ�Ⱥ͸߶�
//		int width = getWindowManager().getDefaultDisplay().getWidth();
//		int height = getWindowManager().getDefaultDisplay().getHeight();

//		// ��̬��Ӳ���w
//		Fragment1 f1 = new Fragment1();
//		Fragment2 f2 = new Fragment2();
//
//		FragmentManager fm = getFragmentManager();
//		FragmentTransaction ft = fm.beginTransaction();
//
//		if (width > height) {
//			// ˮƽ����
//			ft.replace(android.R.id.content, f1);
//		} else {
//			// ��ֱ����
//			ft.replace(android.R.id.content, f2);
//		}
//		ft.commit();
		
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		fraglist = (ListView) findViewById(R.id.fraglist);
//		fragtypes = getResources().getStringArray(R.array.fragmenttypes);
		
		fragmentTypes = MyDataSource.getFragmentTypes();
		
		adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,fragmentTypes);
		fraglist.setAdapter(adapter);
		
		fraglist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String fragname = fragmentTypes.get(position);
				Intent intent;
				if(fragname.equals("fragmentTabhost")){
					intent = new Intent(Fragment_UI.this, MfragmentTabHost.class);
					startActivity(intent);
				}
			}
			
		});
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			finish();
			break;

		default:
			break;
		}
	}

}
