package com.xinglefly.activity.basically;

import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinglefly.R;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.service.StorageService;

/**
 * 保存文件
 * 
 * @author xinglefly
 * 
 */
public class StorageFileActivity extends BaseActivity implements
		OnClickListener {

	private EditText et_filename, et_filecontent, et_readname, et_readname_sd;
	private Button btn_sd, btn_rom, btn_read, btn_read_sd, btn_savefile;
	private TextView show_content;
	private TextView tv_titlename;
	private View img_header_view_back_key;
	
	
	
	@Override
	protected void loadViewLayout() {
		
		setContentView(R.layout.storagefile);
	}

	@Override
	protected void findViewByid() {
		//引入头文件的控件
		img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
		img_header_view_back_key.setOnClickListener(this);
		tv_titlename = (TextView) findViewById(R.id.tv_titlename);
		tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
		
		
		
		et_filename = (EditText) findViewById(R.id.et_filename);
		et_filecontent = (EditText) findViewById(R.id.et_filecontent);
		et_readname = (EditText) findViewById(R.id.et_readname);
		et_readname_sd = (EditText) findViewById(R.id.et_readname_sd);
		show_content = (TextView) findViewById(R.id.tv_show_content);
		
		btn_sd = (Button) findViewById(R.id.btn_sd);
		btn_rom = (Button) findViewById(R.id.btn_rom);
		btn_read = (Button) findViewById(R.id.btn_read);
		btn_read_sd = (Button) findViewById(R.id.btn_read_sd);
		btn_savefile = (Button) findViewById(R.id.btn_savefile);
		

	}

	private void setOnclick() {
//		img_header_view_back_key.setOnClickListener(this);
		btn_sd.setOnClickListener(this);
		btn_rom.setOnClickListener(this);
		btn_read.setOnClickListener(this);
		btn_read_sd.setOnClickListener(this);
		btn_savefile.setOnClickListener(this);
		btn_sd.setEnabled(Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED));// 如果没有SD卡设置按钮不可用
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
		String fileName = et_filename.getText().toString();
		String content = et_filecontent.getText().toString();
		String readfilename = et_readname.getText().toString();
		String sdfilename = et_readname_sd.getText().toString();
		if (fileName == null || fileName.trim().length() == 0) {
//			Toast.makeText(this, "文件名称不能为空", Toast.LENGTH_SHORT).show();
			et_filename.setError("文件名称不能为空");
			return;
		}
		if (content == null || content.trim().length() == 0) {
			Toast.makeText(this, "文件内容不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		switch (v.getId()) {
		case R.id.btn_sd:
			//保存到SD卡
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Toast.makeText(this, "SD卡不可用,请检查设备", Toast.LENGTH_SHORT).show();
			}
			try {
				StorageService.saveSD(fileName, content);
				Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
				et_filename.setText("");
				et_filecontent.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "存储失败", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.btn_rom:
			//保存到Rom
			try {
				StorageService service = new StorageService(this);
				service.saveRom(fileName, content);
				Toast.makeText(this, "保存到rom成功", Toast.LENGTH_SHORT).show();
				et_filename.setText("");
				et_filecontent.setText("");

			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.btn_read:
			//读取rom文件
			try {
				// StorageService service = new StorageService(this);
				String data = StorageService.readFile(readfilename);
				show_content.setText(data);
				et_readname.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();

			}
			break;
		case R.id.btn_read_sd:
			//读取SD卡文件
			try {
				String data = StorageService.readFileSD(sdfilename);
				show_content.setText(data);
				et_readname_sd.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "读取失败", Toast.LENGTH_SHORT).show();

			}
			break;
		case R.id.btn_savefile:
			//保存文件
			try {
				if (!Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					Toast.makeText(this, "设备不可用，请检查SD卡是否安装", Toast.LENGTH_SHORT)
							.show();
					btn_savefile.setText("保存到ROM中");
					StorageService service = new StorageService(this);
					service.saveRom(fileName, content);
					Toast.makeText(this, "保存到Rom成功", Toast.LENGTH_SHORT).show();
				}
				StorageService.saveSD(fileName, content);
				Toast.makeText(this, "保存到SD成功", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				et_filename.setText("");
				et_filecontent.setText("");
			}
			break;
		case R.id.img_header_view_back_key:
			//返回
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	protected void setOnClick() {
		// TODO Auto-generated method stub
		
	}
}
