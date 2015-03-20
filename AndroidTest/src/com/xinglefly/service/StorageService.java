package com.xinglefly.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.xinglefly.activity.basically.StorageFileActivity;

import android.content.Context;
import android.os.Environment;

public class StorageService {

	private static Context context;

	public StorageService(Context context) {
		super();
		this.context = context;
	}

	/**
	 * 存储文件到sd
	 * 
	 * @param name
	 *            文件名称
	 * @param content
	 *            文件内容
	 * @throws Exception
	 */
	public static void saveSD(String fileName, String content) throws Exception {
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), fileName + ".txt");
		FileOutputStream outStream = new FileOutputStream(file);
		outStream.write(content.getBytes());
		outStream.close();
	}

	/**
	 * 存储文件到rom
	 * 
	 * @param fileName
	 *            文件名称
	 * @param content
	 *            文件内容
	 * @throws Exception
	 */
	public void saveRom(String fileName, String content)
			throws Exception {
		FileOutputStream outStream = context.openFileOutput(fileName + ".txt",
				Context.MODE_PRIVATE);
		outStream.write(content.getBytes());
		outStream.close();
	}

	/**
	 * 读取rom文件
	 * 
	 * @param readfilename
	 *            文件名称
	 * @return 文件内容
	 * @throws Exception
	 */
	public static String readFile(String readfilename) throws Exception {
		FileInputStream instream = context.openFileInput(readfilename+".txt");
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = instream.read(buffer)) != -1) {
			outstream.write(buffer, 0, buffer.length);
		}
		instream.close();
		byte[] data = outstream.toByteArray();
		return new String(data);
	}

	/**
	 * 读取sd文件
	 * 
	 * @param readfilename
	 *            文件名称
	 * @return 文件内容
	 * @throws Exception
	 */
	public static String readFileSD(String readfilename) throws Exception {
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath(), readfilename + ".txt");
		FileInputStream instream = new FileInputStream(file);
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = instream.read(buffer)) != -1) {
			outstream.write(buffer, 0, buffer.length);
		}
		return new String(outstream.toByteArray());
	}

}
