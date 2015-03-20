package com.xinglefly.activity.control_ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;

public class Xutil_UI extends BaseActivity implements OnClickListener {
	 private float scaleWidth=1;
	  private float scaleHeight=1;
	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.xutil);
	}

	@Override
	protected void findViewByid() {
		//UI: header
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		
		//UI: imageView
		ImageView img_bitmap = (ImageView) findViewById(R.id.img_bitmap);
		
		
		//��̬�ü�ͼƬ
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.videoimage);
		//���Bitmap�ĸߺͿ� 
		int bmpWidth=bmp.getWidth(); 
		int bmpHeight=bmp.getHeight(); 
		 
		//������С���� 
		double scale=0.8; 
		//��������Ҫ��С�ı��� 
		scaleWidth=(float)(scaleWidth*scale); 
		scaleHeight=(float)(scaleHeight); 
		 
		//����resize���Bitmap���� 
		Matrix matrix=new Matrix(); 
		matrix.postScale(scaleWidth, scaleHeight); 
		Bitmap resizeBmp=Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeight, matrix, true);
		
		
		
//		BitmapUtils bitutil = new BitmapUtils(this);
//		BitmapDisplayConfig config = new BitmapDisplayConfig();
//		BitmapSize size = new BitmapSize();
//		size.setWidth(125);
//		size.setHeight(360);
//		config.setBitmapMaxSize(size);
//		
//		config.setLoadingDrawable(getResources().getDrawable(R.drawable.videoimage));
//		config.setLoadFailedDrawable(getResources().getDrawable(R.drawable.videoimage));
		
		
//		bitutil.display(img_bitmap, "http://58.30.240.26/test/pic.jpg", config);
//		bitutil.display(img_bitmap, "/sdcard/pacer_steps_chart.jpg", config);
		
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
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img_header_view_back_key:
			ActivityUtil.finishActivity(Xutil_UI.this);
			break;

		default:
			break;
		}
		
	}

}
