package com.xinglefly.activity.control_ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xinglefly.MyApp;
import com.xinglefly.R;

public class VideoFragment extends Fragment {

	private ListView listvideo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.online_video, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		listvideo = (ListView) getActivity().findViewById(R.id.listvideo);
//		SimpleAdapter adapter = new SimpleAdapter(getActivity()
//				.getApplicationContext(), null, R.layout.offline_video, null,
//				null);
//		listvideo.setAdapter(adapter);
	}

}


