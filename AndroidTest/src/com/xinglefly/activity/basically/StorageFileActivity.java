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
 * �����ļ�
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
		//����ͷ�ļ��Ŀؼ�
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
				Environment.MEDIA_MOUNTED));// ���û��SD�����ð�ť������
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
//			Toast.makeText(this, "�ļ����Ʋ���Ϊ��", Toast.LENGTH_SHORT).show();
			et_filename.setError("�ļ����Ʋ���Ϊ��");
			return;
		}
		if (content == null || content.trim().length() == 0) {
			Toast.makeText(this, "�ļ����ݲ���Ϊ��", Toast.LENGTH_SHORT).show();
			return;
		}
		switch (v.getId()) {
		case R.id.btn_sd:
			//���浽SD��
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Toast.makeText(this, "SD��������,�����豸", Toast.LENGTH_SHORT).show();
			}
			try {
				StorageService.saveSD(fileName, content);
				Toast.makeText(this, "����ɹ�", Toast.LENGTH_SHORT).show();
				et_filename.setText("");
				et_filecontent.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "�洢ʧ��", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.btn_rom:
			//���浽Rom
			try {
				StorageService service = new StorageService(this);
				service.saveRom(fileName, content);
				Toast.makeText(this, "���浽rom�ɹ�", Toast.LENGTH_SHORT).show();
				et_filename.setText("");
				et_filecontent.setText("");

			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "����ʧ��", Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.btn_read:
			//��ȡrom�ļ�
			try {
				// StorageService service = new StorageService(this);
				String data = StorageService.readFile(readfilename);
				show_content.setText(data);
				et_readname.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "��ȡʧ��", Toast.LENGTH_SHORT).show();

			}
			break;
		case R.id.btn_read_sd:
			//��ȡSD���ļ�
			try {
				String data = StorageService.readFileSD(sdfilename);
				show_content.setText(data);
				et_readname_sd.setText("");
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "��ȡʧ��", Toast.LENGTH_SHORT).show();

			}
			break;
		case R.id.btn_savefile:
			//�����ļ�
			try {
				if (!Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					Toast.makeText(this, "�豸�����ã�����SD���Ƿ�װ", Toast.LENGTH_SHORT)
							.show();
					btn_savefile.setText("���浽ROM��");
					StorageService service = new StorageService(this);
					service.saveRom(fileName, content);
					Toast.makeText(this, "���浽Rom�ɹ�", Toast.LENGTH_SHORT).show();
				}
				StorageService.saveSD(fileName, content);
				Toast.makeText(this, "���浽SD�ɹ�", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				et_filename.setText("");
				et_filecontent.setText("");
			}
			break;
		case R.id.img_header_view_back_key:
			//����
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
