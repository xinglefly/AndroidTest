package com.xinglefly.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Environment;
import android.test.AndroidTestCase;
import android.util.Log;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.xinglefly.MyApp;
import com.xinglefly.activity.control_ui.bean.VideoInfo;
import com.xinglefly.service.StorageService;
import com.xinglefly.util.Constants;

/**
 * Junit class
 * @author xinglefly
 *
 */
public class JunitTest extends AndroidTestCase {
	
    private static final String TAG = "JunitTest";
	
    
    
  
    
    
	
	public void testHttpConnection() {
		URL url;
		try {
			url = new URL("http://10.18.112.69:8181/app?sn=1234&method=init");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(3000);
			if (conn.getResponseCode() == 200) {
				System.out.println("����ɹ���");
			} else {
				System.out.println("����ʧ��");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	/**
	 * �洢�ļ�
	 * @throws Exception
	 */
	public void testSave()throws Exception{
		StorageService service = new StorageService(this.getContext());
//		service.saveRom("pp", "ϲ�������");
		service.saveSD("pp", "�Ҳ�֪���һ�ѡ��˭����һ��ֵ�ÿ϶��Ǿ��Ƕ�����Ϊ�����ģ��һ�ѡ����");
	}
	
	public void testReadRom()throws Exception{
		StorageService service = new StorageService(this.getContext());
		String file = service.readFile("pp.txt");
		Log.i(TAG, file);
	}
	
	/**
	 * ��ȡsd���ļ�
	 * @throws Exception
	 */
	public void testReadSD()throws Exception{
		StorageService service = new StorageService(this.getContext());
		String file = service.readFileSD("pp");
		Log.i(TAG, file.toString());
	}
	
	
	
	
	
}
