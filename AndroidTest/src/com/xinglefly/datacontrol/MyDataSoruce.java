package com.xinglefly.datacontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataSoruce {

	public MyDataSoruce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static List<String> getArrayNetSource() {
		List<String> list = new ArrayList<String>();
		list.add("UrlConnection application");
		list.add("UrlClient application");
		return list;
	}

	public static List<String> getArrayDataSource() {
		List<String> list = new ArrayList<String>();
		list.add("TextView application");
		list.add("EditText application");
		list.add("BitMap application");
		list.add("RadioButton application");
		list.add("ToggleButton application");
		list.add("checkbox application");
		list.add("seekbar application");
		list.add("ProgressBar application");
		list.add("RatingBar application");
		list.add("imageView application");
		list.add("DateTimePicker application");
		list.add("DigitalColock application");
		list.add("ScrollView application");
		list.add("HorizontalScrollView application");
		list.add("Gallery application");
		list.add("GridView application");
		list.add("spinner application");
		list.add("imageSwitch application");
		list.add("TabHost application");
		list.add("ViewStub application");
		list.add("ViewPage application");
		list.add("ListView application");
		list.add("Fragment application");
		list.add("WebView application");
		return list;
	}

	public static List<Map<String, Object>> getSimpleDataSource() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("proname", "Jeep");
		map1.put("proaddress", "上海同瑞");
		map1.put("proprice", "380.00");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("proname", "nike");
		map2.put("proaddress", "美国俄勒冈州");
		map2.put("proprice", "1000.00");

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("proname", "Kappa");
		map3.put("proaddress", "意大利");
		map3.put("proprice", "500.00");

		list.add(map1);
		list.add(map2);
		list.add(map3);
		return list;
	}

}
