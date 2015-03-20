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
 * webViewӦ��
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

		// ����webView�ؼ�
		webview = (WebView) findViewById(R.id.webview);
		// �õ�WebSettings��������֧��JavaScript����
		// ������ʵ�ҳ������JavaScript����WebView��������֧��JavaScript ��������ʾ�հ�ҳ��
		webview.getSettings().setJavaScriptEnabled(true);
		// webview.loadUrl(PATH);//ֱ�Ӽ���һ��url
		Uri uri = Uri.parse(PATH);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);

		/**
		 * ����webview��ҳʱ��Ҫִ�е�һЩ����
		 */
		webview.setWebViewClient(new WebViewClient() {

			// �¿�ҳ��ʱ���Լ������webview����ʾ������ϵͳ�Դ������������ʾ  
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				//��ȻGoogle��ҳ��WebView����ʾ�ˣ��������������Ӽ�������������ʾ��ϵͳĬ�ϵ�Browser��   
				//Ϊ�˼�����WebView����ʾ����Ҫ��дshouldOverrideUrlLoading����   
				view.loadUrl(url);
				return true;
			}

			 // ��ʼ������ҳʱҪ���Ĺ���   
	        @Override  
	        public void onPageStarted(WebView view, String url, Bitmap favicon) {  
	            super.onPageStarted(view, url, favicon);  
	        }  
	          
	        // �������ʱҪ���Ĺ���   
	        @Override  
	        public void onPageFinished(WebView view, String url) {  
	            super.onPageFinished(view, url);  
	        }  
	          
	        // ���ش���ʱҪ���Ĺ���   
	        @Override  
	        public void onReceivedError(WebView view, int errorCode,  
	                String description, String failingUrl) {  
	            super.onReceivedError(view, errorCode, description, failingUrl);  
	        }  
			
		});
		
		/**
		 * ������ҳ�е�һЩ�Ի�����Ϣ����ʾ�Ի��򣬴�ѡ��ĶԻ��򣬴�����ĶԻ���
		 */
		webview.setWebChromeClient(new WebChromeClient() {  
	        // ��ʾ�Ի���   
	        @Override  
	        public boolean onJsAlert(WebView view, String url, String message,  
	                final JsResult result) {  
	            // ����һ��Builder����ʾ��ҳ�е�alert�Ի���   
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("��ʾ�Ի���");  
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
	  
	        // ����ť�ĶԻ���   
	        @Override  
	        public boolean onJsConfirm(WebView view, String url,  
	                String message, final JsResult result) {  
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("��ѡ��ĶԻ���");  
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
	  
	        // �������ĶԻ���   
	        @Override  
	        public boolean onJsPrompt(WebView view, String url, String message,  
	                String defaultValue, final JsPromptResult result) {  
	            LayoutInflater inflater = LayoutInflater  
	                    .from(WebView_UI.this);  
//	            final View v = inflater.inflate(R.layout.myDialog, null);  
//	            // ���� TextView��Ӧ��ҳ�е���ʾ��Ϣ   
//	            ((TextView) v.findViewById(R.id.textView)).setText(message);  
//	            // ����EditText��Ӧ��ҳ�е������   
//	            ((EditText) v.findViewById(R.id.editText))  
//	                    .setText(defaultValue);  
	  
	            Builder builder = new Builder(WebView_UI.this);  
	            builder.setTitle("������ĶԻ���");  
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
	  
	        // ������ҳ���صĽ�����   
	        @Override  
	        public void onProgressChanged(WebView view, int newProgress) {  
	        	WebView_UI.this.getWindow().setFeatureInt(  
	                    Window.FEATURE_PROGRESS, newProgress * 100);  
	            super.onProgressChanged(view, newProgress);  
	        }  
	          
	        // ����Ӧ�ó���ı���   
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
