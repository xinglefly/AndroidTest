package com.xinglefly.activity.httpconnection;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.spec.EncodedKeySpec;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.BaseAdapter_UI;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;

/**
 * HttpUrlConnection的应用
 * 
 * @author xinglefly
 * 
 */
public class HttpConnection extends BaseActivity implements OnClickListener {

	private static final String Tag = "HttpConnection";
	private TextView httpconnection;
	private final String URL_PATH = "http://10.18.112.94:8080/xingleflyProject/servlet/TestServlet";
	private final String URL_PATH_IMG = "http://10.18.112.94:8080/xingleflyProject/upload/expect.jpg";
	private ImageView img_httpshow;

	@Override
	protected void loadViewLayout() {
		// TODO Auto-generated method stub
		setContentView(R.layout.httpconnui);
	}

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		Button btn_httpget = (Button) findViewById(R.id.btn_httpget);
		Button btn_httppost = (Button) findViewById(R.id.btn_httppost);
		Button btn_imgshow = (Button) findViewById(R.id.btn_imgshow);
		Button btn_asynctask = (Button) findViewById(R.id.btn_asynctask);
		btn_httpget.setOnClickListener(this);
		btn_httppost.setOnClickListener(this);
		btn_imgshow.setOnClickListener(this);
		btn_asynctask.setOnClickListener(this);

		httpconnection = (TextView) findViewById(R.id.httpconnection);
		img_httpshow = (ImageView) findViewById(R.id.img_httpshow);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_httpget:
			String httpUrlConnectionGet = httpUrlConnectionGet(URL_PATH);
			httpconnection.setText(httpUrlConnectionGet);
			// httpGet();
			break;
		case R.id.btn_httppost:
			String httpUrlConnectionPost = httpUrlConnectionPost(URL_PATH);
			httpconnection.setText(httpUrlConnectionPost);
			break;

		case R.id.btn_imgshow:
			Bitmap bm = httpRequestImg(URL_PATH_IMG);
			img_httpshow.setImageBitmap(bm);
			break;
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(HttpConnection.this);
			break;

		default:
			break;
		}
	}

	/**
	 * HttpUrlConnection 请求方式post
	 * 
	 * @param uRL_PATH2
	 */
	private String httpUrlConnectionPost(String URL_PATH) {
		InputStream in = null;
		try {
			String params = "par="+URLEncoder.encode("xinglefly", "UTF-8");
			URL url = new URL(URL_PATH);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", params.getBytes().length + "");
			conn.setRequestProperty("Host", "10.18.112.94:8080");
			conn.setDoOutput(true);
			conn.getOutputStream().write(params.getBytes());
            
            //将要上传的内容写入流中  
//            out1.writeBytes(content);   
//			String params = new String();
//			params = "username=xinglefly&age24&name="
//					+ URLEncoder.encode("阿兴", "gbk");
//			out.write(params.getBytes());
//            out1.flush();
//    		out1.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "联网超时，请重试...", Toast.LENGTH_SHORT).show();
		}
		return "";
	}

	/**
	 * 通过httpUrlConnection 下载图片 对图片进行缓存操作 这里我省去了很多的方法，比如：
	 * requestMethod("Get")默认情况是get,所以这个不用写
	 * 
	 * @param uRL_PATH2
	 */
	private Bitmap httpRequestImg(String URL_PATH_IMG) {
		Bitmap bitmap = null;
		try {
			URL url = new URL(URL_PATH_IMG);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			File cachefile = new File(getCacheDir(),
					URLEncoder.encode(URL_PATH));

			if (cachefile.exists()) {
				conn.setIfModifiedSince(cachefile.lastModified());// 获取文件的最后修改时间,作为请求头
			}

			int code = conn.getResponseCode();
			Log.i(Tag, "cachedir:" + getApplicationContext().getCacheDir());
			if (code == 200) {
				byte[] data = Constants.read(conn.getInputStream());
				// 把字节数据解码为图片
				bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
				// 存储图片到本地，用作缓存
				bitmap.compress(CompressFormat.JPEG, 100, new FileOutputStream(
						cachefile));
				return bitmap;
			} else if (code == 304) {
				// 读取缓存
				bitmap = BitmapFactory.decodeFile(cachefile.getAbsolutePath());
				return bitmap;
			}

		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "联网超时,请重试...", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	/**
	 * 详解HttpUrlConnection requestMethod GET return new String()
	 */
	private String httpUrlConnectionGet(String URL_PATH) {

		try {

			URL url = new URL(URL_PATH);// 创建URL对象
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 建立远程连接
			conn.setConnectTimeout(5000); // 设置连接超时
			// conn.setReadTimeout(6000); // 设置读入超时时间
			conn.setDoInput(true); // 设置输入流
			conn.setDoOutput(true); // 设置输出流
			conn.setRequestMethod("GET"); // 设置URL的请求方式
			int code = conn.getResponseCode(); // 获取响应状态码
			InputStream in = conn.getInputStream();// 读取输入流
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();// 内存输出流
			byte[] buffer = new byte[1024];
			int len = -1;

			if (code == HttpURLConnection.HTTP_OK) {
				while ((len = in.read(buffer)) != -1) {
					outputStream.write(buffer, 0, len);
				}
				in.close();
				outputStream.close();
				return new String(outputStream.toByteArray());
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "联网超时请重试", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private void httpGet() {
		String u1 = "http://10.18.112.120:8080/payDemo/test";
		String u2 = "http://10.18.112.69:8181/app?sn=test1234&method=init&data={info:appcallwxb}";
		
		String u3  = "http://<server>:<port>/index.php/config/lan/set_wlan_config?";
		try {
			DownloadText(u2);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "网络异常", 1).show();
		}
	}

	private InputStream OpenHttpConnection(String urlString) throws Exception {
		InputStream in = null;
		int response = -1;
		// 首先要封装URL对象
		URL url = new URL(urlString);
		// 调用URI对象的openConnection（）方法返回一个HttpURLConnection对象
		URLConnection conn = url.openConnection();
		// 判断conn对象是否是HttpURLConnection的实例
		if (!(conn instanceof HttpURLConnection)) {
			throw new IOException("它不是一个HTTP连接");
		}
		// 利用HttpURLConnection对象建立与远程URL的HTTP连接，可以设置连接的各种属性
		HttpURLConnection httpConn = (HttpURLConnection) conn;
		httpConn.setConnectTimeout(3000);
		httpConn.setReadTimeout(3000);

		// 设置不允许用户交互
		httpConn.setAllowUserInteraction(false);
		// 设置连接是否遵循定向
		httpConn.setInstanceFollowRedirects(true);
		// 设置请求方式
		httpConn.setRequestMethod("GET");

		httpConn.setRequestProperty("Accept-Charset", "utf-8");
		httpConn.setRequestProperty("contentType", "utf-8");
		// 进行连接
		httpConn.connect();
		// 通过远程HTTP服务器返回的返回响应代码，如果无响应，返回-1
		response = httpConn.getResponseCode();
		// 获取输入流
		if (response == HttpURLConnection.HTTP_OK) {
			in = httpConn.getInputStream();
		}

		return in;
	}

	// 下载数据方法(文本)
	private String DownloadText(String URL) throws Exception {
		String text = null;
		int buffer_size = 2000;
		InputStream in = null;
		in = OpenHttpConnection(URL);
		// 解码一个输入流进一个位图。
		InputStreamReader is = new InputStreamReader(in);
		int charRead;
		char[] inputBuffer = new char[buffer_size];
		while ((charRead = is.read(inputBuffer)) > 0) {
			String readString = String.copyValueOf(inputBuffer, 0, charRead);
			text += readString;
		}
		in.close();
		httpconnection.setText(text);

		return text;
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

}
