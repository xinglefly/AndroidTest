package com.xinglefly;

import android.app.Application;

/**
 * Context Util
 * 
 * @author xinglefly
 * 
 */
public class MyApp extends Application {

	private static MyApp instance = null;

	public static MyApp getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

}
