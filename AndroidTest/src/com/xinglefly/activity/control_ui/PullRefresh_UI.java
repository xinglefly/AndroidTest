//package com.xinglefly.activity.control_ui;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//
//import android.os.AsyncTask;
//import android.text.format.DateUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//import com.xinglefly.R;
//import com.xinglefly.commonutil.BaseActivity;
//import com.xinglefly.util.ActivityUtil;
//
///**
// * PullRefresh下拉刷新
// * 
// * @author xinglefly
// * 
// */
//public class PullRefresh_UI extends BaseActivity implements OnClickListener {
//
//	private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
//			"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
//			"Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
//			"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
//			"Allgauer Emmentaler" };
//	
//	private LinkedList<String> mListItems;
//	private PullToRefreshListView mPullRefreshListView;
//	private ArrayAdapter<String> mAdapter;
//
//	@Override
//	protected void loadViewLayout() {
//		setContentView(R.layout.gridlayout);
//	}
//
//	@Override
//	protected void findViewByid() {
//		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
//		img_header_view_back_key.setOnClickListener(this);
//		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
//		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
//
//		mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
//
//		// Set a listener to be invoked when the list should be refreshed.
//		mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
//			@Override
//			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
//				
//				String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
//						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//
//				// Update the LastUpdatedLabel
//				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
//
//				// Do work to refresh the list here.
//						new GetDataTask().execute();
//					}
//				});
//
//		// 设置列表内容
//		mListItems = new LinkedList<String>();
//		mListItems.addAll(Arrays.asList(mStrings));
//		mAdapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, mListItems);
//
//		// 这两个绑定方法用其一
//		// 方法一
//		// mPullRefreshListView.setAdapter(mAdapter);
//		// 方法二
//		ListView actualListView = mPullRefreshListView.getRefreshableView();
//		actualListView.setAdapter(mAdapter);
//
//
//	}
//
//	@Override
//	protected void setOnClick() {
//		// TODO Auto-generated method stub
//		mPullRefreshListView
//				.setOnRefreshListener(new OnRefreshListener<ListView>() {
//
//					@Override
//					public void onRefresh(
//							PullToRefreshBase<ListView> refreshView) {
//						String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
//								DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//
//						// Update the LastUpdatedLabel
//						refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
//						
//						new GetDataTask().execute();
//					}
//
//				});
//	}
//
//	private class GetDataTask extends AsyncTask<Void, Void, String> {
//		// 后台处理部分
//		@Override
//		protected String doInBackground(Void... params) {
//			// Simulates a background job.
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//			}
//			String str="Added after refresh...I add";
//			return str;
//		}
//
//		//这里是对刷新的响应，可以利用addFirst（）和addLast()函数将新加的内容加到LISTView中
//		//根据AsyncTask的原理，onPostExecute里的result的值就是doInBackground()的返回值
//		@Override
//		protected void onPostExecute(String result) {
//			//在头部增加新添内容
//			mListItems.addFirst(result);
////			mListItems.addLast(result);
//			
//			//通知程序数据集已经改变，如果不做通知，那么将不会刷新mListItems的集合
//			mAdapter.notifyDataSetChanged();
//			// Call onRefreshComplete when the list has been refreshed.
//			mPullRefreshListView.onRefreshComplete();
//
//			super.onPostExecute(result);//这句是必有的，AsyncTask规定的格式
//		}
//	}
//
//	@Override
//	protected void updateUI() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void processLogic() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		switch (v.getId()) {
//		case R.id.img_header_view_back_key:
//			ActivityUtil.finishActivity(PullRefresh_UI.this);
//			break;
//
//		default:
//			break;
//		}
//
//	}
//
//}
