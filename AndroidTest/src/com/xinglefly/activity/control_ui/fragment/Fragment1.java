package com.xinglefly.activity.control_ui.fragment;

import com.xinglefly.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment
 * 
 * @author xinglefly
 * 
 */
public class Fragment1 extends Fragment {

	// ��fragment��������ʱ����õķ��������ص�ǰfragment��ʾ�����ݡ�
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment1, null);
	}

}
