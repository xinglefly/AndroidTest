package com.xinglefly.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Constants {

	// 调试的常量
	public static final boolean DEBUG = true;

	// Sharedpreference相关常量
	public static final String SP_GUIDEINFO = "guideinfo";	//引导页面
	public static final String SP_FILE_USERINFO = "user_info";
	public static final String SP_ITEM_USERNAME = "uname";
	public static final String SP_ITEM_PASSWORD = "upass";
	public static final String SP_ITEM_HASLOGIN = "has_login";

	public static final String LOG_OUT = "login_out";
	
	/******************** 定义intent保存数据 开始 **********************/
	public static final String URL = "";
	public static final String PLAYID = "";
	public static final String VIDEOID = "";
	
	/******************** 定义intent保存数据结束 **********************/
	
	/******************** 定义常见错误码 开始 **********************/
	public static final int FAILED = -1;

	public static final int UNKNOWN_ERROR = -2;

	public static final int SUCCESS = 200;

	public static final int CONNT_CONNECT_SERVER = 0;

	public static final int PASSWORD_EMPTY = 1;

	public static final int PASSWORD_ERROR = 2;

	/********************* 定义常见错误码结束 ******************/

	
	
	/******************** 定义常见错误码文案 开始 **********************/
	public static final String FAILED_STRING = "操作不成功";

	public static final String UNKNOWN_ERROR_STRING = "未知错误";

	public static final String SUCCESS_STRING = "操作成功";

	public static final String CONNET_FAILD = "联网超时，请重试...";

	public static final String CONNT_CONNECT_SERVER_STRING = "无法连接到远程服务器，请检查您的网络连接,或者远程服务器不可用";

	public static final String CONNT_CONNECT_WXB_STRING = "无法连接到无线宝，请检查您的无线宝是否连接,或者无线宝不可用";

	public static final String USERNAME_EMPTY_STRING = "用户名不能为空";
	
	public static final String PASSWORD_EMPTY_STRING = "密码为空";

	public static final String PASSWORD_ERROR_STRING = "密码错误";
	/******************** 定义常见错误码文案 结束 **********************/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 读取输入流，写入到缓存区
	 * 
	 * @param inputStream
	 * @return byte
	 * @throws IOException
	 */
	public static byte[] read(InputStream inputStream) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int len = -1;
		byte[] buffer = new byte[1024];
		while ((len = inputStream.read(buffer)) != -1)
			bos.write(buffer, 0, len);
		inputStream.close();
		bos.close();
		return bos.toByteArray();
	}

}
