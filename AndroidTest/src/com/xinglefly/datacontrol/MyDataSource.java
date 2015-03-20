package com.xinglefly.datacontrol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xinglefly.R;

public class MyDataSource {

	public MyDataSource() {
		super();
	}

	/**
	 * Http data
	 * @return
	 */
	public static List<String> getArrayNetSource() {
		List<String> list = new ArrayList<String>();
		list.add("UrlConnection application");
		list.add("UrlClient application");
		return list;
	}
	
	
	/**
	 * advance data
	 * @return
	 */
	public static List<String> getArrayAdavanceSource() {
		List<String> list = new ArrayList<String>();
		list.add("Vitamio 3.0");
		list.add("Vitamio 4.0");
		return list;
	}

	/**
	 * fragment data
	 * @return
	 */
	public static List<String> getFragmentTypes() {
		List<String> list = new ArrayList<String>();
		list.add("fragmentTabhost");
		list.add("fragmentpageradapter");
		return list;
	}

	/**
	 * basice UI data
	 * 
	 * @return
	 */
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
		list.add("GridLayout application");
		list.add("spinner application");
		list.add("imageSwitch application");
		list.add("TabHost application");
		list.add("ViewStub application");
		list.add("ViewPage application");
		list.add("ListView application");
		list.add("Fragment application");
		list.add("WebView application");
		list.add("FragmentTabhost");
		list.add("SimpleAdapter_bitmap");
		list.add("BaseAdapter");
		list.add("search");
		list.add("Timer");
		list.add("ViewPagerIndicator");
		list.add("AsyncTask");
		list.add("WelcomeActivity");
		list.add("PullRefresh");
		list.add("Xutil");
		list.add("CheckSelector_UI");
		list.add("Intent_UI");
		return list;
	}

	/**
	 * listView adapter data
	 * @return
	 */
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

	/**
	 * baseAdapter struct data
	 * return 
	 */
	public static List<Map<String, Object>> getBaseAdapterData() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> map,map1;
//		for(int i=0;i<10;i++){
//			map = new HashMap<String, Object>();
//			map.put("img", R.drawable.face9);
//			map.put("tv", "小白猪");
//			map.put("info", "园园");
//			list.add(map);
//		}
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.face9);
		map.put("tv", "小白猪");
		map.put("info", "园园");
		list.add(map);
		
		
		
		return list;
	}
	
	
	

}
