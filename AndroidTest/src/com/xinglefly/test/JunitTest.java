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
				System.out.println("请求成功！");
			} else {
				System.out.println("请求失败");
			}
		} catch (RuntimeException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	/**
	 * 存储文件
	 * @throws Exception
	 */
	public void testSave()throws Exception{
		StorageService service = new StorageService(this.getContext());
//		service.saveRom("pp", "喜欢你的啦");
		service.saveSD("pp", "我不知道我会选择谁，有一点值得肯定那就是对我最为有利的，我会选择她");
	}
	
	public void testReadRom()throws Exception{
		StorageService service = new StorageService(this.getContext());
		String file = service.readFile("pp.txt");
		Log.i(TAG, file);
	}
	
	/**
	 * 读取sd卡文件
	 * @throws Exception
	 */
	public void testReadSD()throws Exception{
		StorageService service = new StorageService(this.getContext());
		String file = service.readFileSD("pp");
		Log.i(TAG, file.toString());
	}
	
	
	
	
	
}
