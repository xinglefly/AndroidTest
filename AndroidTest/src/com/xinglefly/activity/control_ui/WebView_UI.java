package com.xinglefly.activity.control_ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

/**
 * webView应用
 * 
 * @author xinglefly
 * 
 */
public class WebView_UI extends BaseActivity implements OnClickListener {

	// private String PATH = "http://wefi.lan/media/xiaobaohelaocai-no1.mp4";
	 private String PATH ="http://123.126.104.25/sohu/7/175/39/Uarl87ESTGHSKyY1PwTlP2.mp4?key=puRp8YICwc_rs5goIVGc97Jut5455YXHUOIAtg..";
//	private String PATH = "http://3g.youku.com";
//	private String PATH = "http://www.nasa.gov/55644main_NASATV_Windows.asx ";

	private WebView webview;

	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.webview_ui);
	}

	@Override
	protected void findViewByid() {
		// TODO Auto-generated method stub
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

		// 加载webView控件
		webview = (WebView) findViewById(R.id.webview);
		// 得到WebSettings对象，设置支持JavaScript参数
		// 如果访问的页面中有JavaScript，则WebView必须设置支持JavaScript ，否则显示空白页面
		webview.getSettings().setJavaScriptEnabled(true);
		// webview.loadUrl(PATH);//直接加载一个url
		Uri uri = Uri.parse(PATH);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);

		/**
		 * 加载webview网页时所要执行的一些方法
		 */
		webview.setWebViewClient(new WebViewClient() {

			// 新开页面时用自己定义的webview来显示，不用系统自带的浏览器来显示  
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				//虽然Google主页在WebView中显示了，但是如果点击链接继续浏览，则会显示到系统默认的Browser中   
				//为了继续在WebView中显示，需要重写shouldOverrideUrlLoading方法   
				view.loadUrl(url);
				return true;
			}

			 // 开始加载网页时要做的工作   
	        @Override  
	        public void onPageStarted(WebView view, String url, Bitmap favicon) {  
	            super.onPageStarted(view, url, favicon);  
	        }  
	          
	        // 加载完成时要做的工作   
	        @Override  
	        public void onPageFinished(WebView view, String url) {  
	            super.onPageFinished(view, url);  
	        }  
	          
	        // 加载错误时要做的工作   
	        @Override  
	        public void onReceivedError(WebView view, int errorCode,  
	                String description, String failingUrl) {  
	            super.onReceivedError(view, errorCode, description, failingUrl);  
	        }  
			
		});
		
		/**
		 * 处理网页中的一些对话框信息（提示对话框，带选择的对话框，带输入的对话框）
		 */
		webview.setWebChromeClient(new WebChromeClient() {  
	        // 提示对话框   
	        @Override  
	        public boolean onJsAlert(WebView view, String url, String message,  
	                final JsResult result) {  
	            // 构建一个Builder来显示网页中的alert对话框   
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("提示对话框");  
	            builder.setMessage(message);  
	            builder.setPositiveButton(android.R.string.ok,  
	                    new AlertDialog.OnClickListener() {  
	                        @Override  
	                        public void onClick(DialogInterface dialog,  
	                                int which) {  
	                            result.confirm();  
	                        }  
	                    });  
	            builder.setCancelable(false);  
	            builder.create();  
	            builder.show();  
	            return true;  
	        }  
	  
	        // 带按钮的对话框   
	        @Override  
	        public boolean onJsConfirm(WebView view, String url,  
	                String message, final JsResult result) {  
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("带选择的对话框");  
	            builder.setMessage(message);  
	            builder.setPositiveButton(android.R.string.ok,  
	                    new AlertDialog.OnClickListener() {  
	                        @Override  
	                        public void onClick(DialogInterface dialog,  
	                                int which) {  
	                            result.confirm();  
	                        }  
	                    });  
	            builder.setNeutralButton(android.R.string.cancel,  
	                    new AlertDialog.OnClickListener() {  
	                        @Override  
	                        public void onClick(DialogInterface dialog,  
	                                int which) {  
	                            result.cancel();  
	                        }  
	                    });  
	            builder.setCancelable(false);  
	            builder.create();  
	            builder.show();  
	            return true;  
	        }  
	  
	        // 带输入框的对话框   
	        @Override  
	        public boolean onJsPrompt(WebView view, String url, String message,  
	                String defaultValue, final JsPromptResult result) {  
	            LayoutInflater inflater = LayoutInflater  
	                    .from(WebView_UI.this);  
//	            final View v = inflater.inflate(R.layout.myDialog, null);  
//	            // 设置 TextView对应网页中的提示信息   
//	            ((TextView) v.findViewById(R.id.textView)).setText(message);  
//	            // 设置EditText对应网页中的输入框   
//	            ((EditText) v.findViewById(R.id.editText))  
//	                    .setText(defaultValue);  
	  
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("带输入的对话框");  
//	            builder.setView(v);  
	            builder.setPositiveButton(android.R.string.ok,  
	                    new AlertDialog.OnClickListener() {  
	                        @Override  
	                        public void onClick(DialogInterface dialog,  
	                                int which) {  
//	                            String value = ((EditText) v  
//	                                    .findViewById(R.id.editText)).getText()  
//	                                    .toString();  
	                            result.confirm("aa");  
	                        }  
	                    });  
	            builder.setNegativeButton(android.R.string.cancel,  
	                    new AlertDialog.OnClickListener() {  
	                        @Override  
	                        public void onClick(DialogInterface dialog,  
	                                int which) {  
	                            result.cancel();  
	                        }  
	                    });  
	            builder.setOnCancelListener(new DialogInterface.OnCancelListener() {  
	                @Override  
	                public void onCancel(DialogInterface dialog) {  
	                    result.cancel();  
	                }  
	            });  
	            builder.create();  
	            builder.show();  
	            return true;  
	        }  
	  
	        // 设置网页加载的进度条   
	        @Override  
	        public void onProgressChanged(WebView view, int newProgress) {  
	        	WebView_UI.this.getWindow().setFeatureInt(  
	                    Window.FEATURE_PROGRESS, newProgress * 100);  
	            super.onProgressChanged(view, newProgress);  
	        }  
	          
	        // 设置应用程序的标题   
	        @Override  
	        public void onReceivedTitle(WebView view, String title) {  
	        	WebView_UI.this.setTitle(title);  
	            super.onReceivedTitle(view, title);  
	        }  
	    });  
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if((keyCode == KeyEvent.KEYCODE_BACK)&& webview.canGoBack()){
			webview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
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
			ActivityUtil.finishActivity(WebView_UI.this);
			break;

		default:
			break;
		}
	}
}
