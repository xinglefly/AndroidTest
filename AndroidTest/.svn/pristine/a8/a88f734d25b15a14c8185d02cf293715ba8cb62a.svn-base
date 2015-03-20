package com.xinglefly.activity.control_ui;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class AsyncTask_UI extends BaseActivity implements OnClickListener {

	private Button btn;
	private ImageView imgView;
	private ProgressDialog pd;
	private String imge_path = "http://g.hiphotos.baidu.com/image/w%3D2048/sign=f8ebea8cb11c8701d6b6b5e613479f2f/b3fb43166d224f4af63c277b0bf790529822d135.jpg";
	private Button btn_two;
	
	
	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.aynctask_ui);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		
		btn = (Button) findViewById(R.id.btn);
		btn_two = (Button) findViewById(R.id.btn_two);
		imgView = (ImageView) findViewById(R.id.imgView);
		
		pd = new ProgressDialog(AsyncTask_UI.this);
		pd.setTitle("提示");
		pd.setMessage("正在下载网络资源，请稍后……");
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setCancelable(false);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				//开启线程
				new myAsyncTast().execute(imge_path);
				
				
				//这种方式是不对的，直接在UI中做线程操作导致ANR异常
//				new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
//						HttpClient httpClient = new DefaultHttpClient();
//						HttpGet httpGet = new HttpGet(imge_path);
//						try {
//							httpClient.execute(httpGet);
//						} catch (ClientProtocolException e) {
//							e.printStackTrace();
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}).start();

			}
		});
		
		btn_two.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AsyncTask_UI.this, MyTaskSecond_UI.class);
//				intent.setClass(AsyncTask_UI.this, MyTaskSecond_UI.class);
				startActivity(intent);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(AsyncTask_UI.this);
			break;

		default:
			break;
		}
		
	}
	
	
	/**
	 * 3个参数代表了什么意思 第一个 要执行的任务通常是网络地址 第二个 进度的刻度 第三个 任务执行后返回的结果
	 */
	class myAsyncTast extends AsyncTask<String, Void, Bitmap> {
		// 任务执行前的操作
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd.show();
		}

		// 耗时任务操作
		@Override
		protected Bitmap doInBackground(String... params) {
			//使用网络连接类
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(params[0]);
			Bitmap bitmap = null;

			try {
				HttpResponse httpResponse = httpClient.execute(httpGet);
				if (httpResponse.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = httpResponse.getEntity();//响应的实体
					byte[] data = EntityUtils.toByteArray(entity);
					bitmap = BitmapFactory
							.decodeByteArray(data, 0, data.length);
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bitmap;
		}

		// 任务执行后的操作,更新UI
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			imgView.setImageBitmap(result);
			btn_two.setVisibility(View.VISIBLE);
			pd.dismiss();
		}

	}


	@Override
	protected void processLogic() {
		// TODO Auto-generated method stub
		
	}

	
	

}
