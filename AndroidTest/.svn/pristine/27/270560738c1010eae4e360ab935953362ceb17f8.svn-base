package com.xinglefly.activity.control_ui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
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

public class MyTaskSecond_UI extends BaseActivity implements OnClickListener {

	private Button btn_second;
	private ImageView img_sercond;
	private ProgressDialog pd;
	private String imge_path = "http://g.hiphotos.baidu.com/image/w%3D2048/sign=f8ebea8cb11c8701d6b6b5e613479f2f/b3fb43166d224f4af63c277b0bf790529822d135.jpg";
	
	
	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.asynctask_two_ui);
	}

	@Override
	protected void findViewByid() {
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		
		
		btn_second = (Button) findViewById(R.id.btn_second);
		img_sercond = (ImageView) findViewById(R.id.img_second);
		pd = new ProgressDialog(MyTaskSecond_UI.this);
		pd.setTitle("提示");
		pd.setMessage("正在下载，请稍后……");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		pd.setCancelable(false);
		btn_second.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 new MyTask().execute(imge_path);
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
			ActivityUtil.finishActivity(MyTaskSecond_UI.this);
			break;

		default:
			break;
		}
		
	}
	

	@Override
	protected void processLogic() {
		// TODO Auto-generated method stub
		
	}

	
	
public class MyTask extends AsyncTask<String, Integer, Bitmap>{
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd.show();
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			pd.setProgress(values[0]);
		}
		
		@Override
		protected Bitmap doInBackground(String... params) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(params[0]);
			Bitmap bitmap = null;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream inputStream = null;
			try {
				HttpResponse httpResponse = httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()==200){
					inputStream = httpResponse.getEntity().getContent();
					int len = 0;
					long file_length = httpResponse.getEntity().getContentLength();
					byte[] data = new byte[1024];
					int total_length = 0;
					while((len = inputStream.read(data))!=-1){
						total_length += len;
						out.write(data, 0, len);//存放到内存中（动态内存）
						int values = (int)((total_length/(float)file_length )*100);
						publishProgress(values);
					}
					byte[] result = out.toByteArray();
					bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
				}
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			return bitmap;
		}
		
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			img_sercond.setImageBitmap(result);
			pd.dismiss();
		}
	}
	
	

}
