/*
 * Copyright (C) 2012 YIXIA.COM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xinglefly.activity.advance;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnBufferingUpdateListener;
import io.vov.vitamio.MediaPlayer.OnCompletionListener;
import io.vov.vitamio.MediaPlayer.OnInfoListener;
import io.vov.vitamio.MediaPlayer.OnSeekCompleteListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;

public class VideoViewDemo extends Activity {

	private static final String Tag = "VideoViewDemo";
	private static final String SEEKBAR_STATE = "seekbarstate";
	// private String path = "file:///sdcard/test.mp4";
	// private String path =
	// "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8";
	// private String path =
	// "http://111.206.48.21/sohu/8/95/84/jhoEe4caXJK8WySBRVQBq1.mp4?key=BIK_15GN2hDgRqxz6EocK99PqYv7XUeAKS8Zxg..";
	private String path = "http://123.126.104.25/sohu/7/175/39/Uarl87ESTGHSKyY1PwTlP2.mp4?key=puRp8YICwc_rs5goIVGc97Jut5455YXHUOIAtg..";
	// private static String path =
	// "http://wefi.lan/media/xiaobaohelaocai-no1.mp4";
	// private static String path = "http://10.18.112.30:9999/cc.mp4";
	// private static String path = "http://10.18.112.30:8899/static/cc.mp4";
	// private static String path =
	// "http://58.30.240.26/GoT407.480P_20146321520.mp4";
	// private static String path =
	// "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8";

	private long currentPosition;
	private VideoView mVideoView = null;
	private View mVolumeBrightnessLayout, frame_top;
	private ImageView mOperationBg;
	private ImageView mOperationPercent;
	private AudioManager mAudioManager;
	/** 最大声音 */
	private int mMaxVolume;
	/** 当前声音 */
	private int mVolume = -1;
	/** 当前亮度 */
	private float mBrightness = -1f;
	/** 当前缩放模式 */
	private int mLayout = VideoView.VIDEO_LAYOUT_ZOOM;
	private GestureDetector mGestureDetector;

	/** 是否需要自动恢复播放，用于自动暂停，恢复播放 */
	private boolean needResume;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i(Tag, "打印 vitamio应用");
		super.onCreate(savedInstanceState);
		if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
			return;

		setContentView(R.layout.videoview);
		mVideoView = (VideoView) findViewById(R.id.surface_view);

		mVolumeBrightnessLayout = findViewById(R.id.operation_volume_brightness);
		mOperationBg = (ImageView) findViewById(R.id.operation_bg);
		mOperationPercent = (ImageView) findViewById(R.id.operation_percent);

		mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		mMaxVolume = mAudioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

		mVideoView.setVideoPath(path);
		mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
		mVideoView.setMediaController(new MediaController(this));
		mVideoView.setBufferSize(1024 * 1024 * 2);
		mVideoView.requestFocus();
		currentPosition = mVideoView.getCurrentPosition();

		mVideoView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					frame_top.setVisibility(View.VISIBLE);
				}
				return false;
			}
		});

		mGestureDetector = new GestureDetector(this, new MyGestureListener());

		String displayName = MediaStore.MediaColumns.DISPLAY_NAME;
		String title = MediaStore.MediaColumns.TITLE;
		Log.i(Tag, "displayname:" + displayName + title);

		// 添加播放器的上标题
		/**
		 * 标题获取不到
		 */
		frame_top = findViewById(R.id.frame_top);
		ImageView img_back = (ImageView) findViewById(R.id.img_back);
		TextView tv_displayName = (TextView) findViewById(R.id.tv_displayName);
		tv_displayName.setText(MediaStore.MediaColumns.DISPLAY_NAME);
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		/**
		 * 视频播放完回调
		 */
		mVideoView.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer arg0) {
//				releaseMediaPlayer();
				arg0.release();
				finish();
			}
		});

		/**
		 * 网络视频缓冲变化时调用
		 */
		mVideoView
				.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {

					@Override
					public void onBufferingUpdate(MediaPlayer arg0, int arg1) {
						mVideoView.setBufferSize(1024 * 1024);
					}
				});

		/**
		 * seek操作完成后调用
		 */
		mVideoView.setOnSeekCompleteListener(new OnSeekCompleteListener() {

			@Override
			public void onSeekComplete(MediaPlayer arg0) {
				// mVideoView.resume();
				// mVideoView.seekTo(currentPosition);
			}
		});

		/**
		 * 在有警告或错误信息时调用,例如：开始缓冲、缓冲结束、下载速度变化。
		 */
		mVideoView.setOnInfoListener(new OnInfoListener() {

			@Override
			public boolean onInfo(MediaPlayer arg0, int arg1, int arg2) {

				return true;
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.e(Tag, "onResume currentPosition:" + currentPosition);
		if (mVideoView != null) {
			mVideoView.resume();
			mVideoView.seekTo(currentPosition);
		}
	}

	protected void onPause() {
		super.onPause();
		Log.i(Tag, "onPause currentPosition:" + currentPosition);
		if (mVideoView != null) {
			mVideoView.pause();
			doCleanUp();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e(Tag, "onStop" + currentPosition);
		releaseMediaPlayer();
	}

	private void releaseMediaPlayer() {
		if (mVideoView != null) {
			doCleanUp();
			mVideoView.stopPlayback();
			mVideoView = null;
		}
	}

	private void doCleanUp() {
//		mVideoView.
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(Tag, "onStop" + currentPosition);
		releaseMediaPlayer();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		Log.e(Tag, "onNewIntent currentPosition:" + currentPosition);
		onDestroy();
	}

	/*
	 * @Override
	 * 
	 * @Override protected void onResume() { super.onResume(); Log.e(Tag,
	 * "onResume currentPosition:" + currentPosition); if (mVideoView != null) {
	 * mVideoView.resume(); mVideoView.seekTo(currentPosition);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Override protected void onDestroy() { super.onDestroy(); Log.e(Tag,
	 * "onDestroy" + currentPosition); if (mVideoView != null) {
	 * mVideoView.stopPlayback(); } }
	 * 
	 * @Override protected void onSaveInstanceState(Bundle outState) {
	 * outState.putLong(SEEKBAR_STATE, currentPosition);
	 * super.onSaveInstanceState(outState); }
	 * 
	 * @Override protected void onRestoreInstanceState(Bundle
	 * savedInstanceState) { super.onRestoreInstanceState(savedInstanceState);
	 * currentPosition = savedInstanceState.getLong(SEEKBAR_STATE);
	 * mVideoView.seekTo(currentPosition); }
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mGestureDetector.onTouchEvent(event))
			return true;

		// 处理手势结束
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_UP:
			endGesture();
			break;
		}

		return super.onTouchEvent(event);
	}

	/** 手势结束 */
	private void endGesture() {
		mVolume = -1;
		mBrightness = -1f;

		// 隐藏
		mDismissHandler.removeMessages(0);
		mDismissHandler.sendEmptyMessageDelayed(0, 500);
	}

	private class MyGestureListener extends SimpleOnGestureListener {

		/** 双击 */
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			if (mLayout == VideoView.VIDEO_LAYOUT_ZOOM)
				mLayout = VideoView.VIDEO_LAYOUT_ORIGIN;
			else
				mLayout++;
			if (mVideoView != null)
				mVideoView.setVideoLayout(mLayout, 0);
			return true;
		}

		/** 滑动 */
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			float mOldX = e1.getX(), mOldY = e1.getY();
			int y = (int) e2.getRawY();
			Display disp = getWindowManager().getDefaultDisplay();
			int windowWidth = disp.getWidth();
			int windowHeight = disp.getHeight();

			if (mOldX > windowWidth * 4.0 / 5)// 右边滑动
				onVolumeSlide((mOldY - y) / windowHeight);
			else if (mOldX < windowWidth / 5.0)// 左边滑动
				onBrightnessSlide((mOldY - y) / windowHeight);

			return super.onScroll(e1, e2, distanceX, distanceY);
		}
	}

	/** 定时隐藏 */
	private Handler mDismissHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			mVolumeBrightnessLayout.setVisibility(View.GONE);
			frame_top.setVisibility(View.GONE);
		}
	};

	/**
	 * 滑动改变声音大小
	 * 
	 * @param percent
	 */
	private void onVolumeSlide(float percent) {
		frame_top.setVisibility(View.VISIBLE);
		if (mVolume == -1) {
			mVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
			if (mVolume < 0)
				mVolume = 0;

			// 显示
			mOperationBg.setImageResource(R.drawable.video_volumn_bg);
			mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
		}

		int index = (int) (percent * mMaxVolume) + mVolume;
		if (index > mMaxVolume)
			index = mMaxVolume;
		else if (index < 0)
			index = 0;

		// 变更声音
		mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);

		// 变更进度条
		ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
		lp.width = findViewById(R.id.operation_full).getLayoutParams().width
				* index / mMaxVolume;
		mOperationPercent.setLayoutParams(lp);
	}

	/**
	 * 滑动改变亮度
	 * 
	 * @param percent
	 */
	private void onBrightnessSlide(float percent) {
		frame_top.setVisibility(View.VISIBLE);
		if (mBrightness < 0) {
			mBrightness = getWindow().getAttributes().screenBrightness;
			if (mBrightness <= 0.00f)
				mBrightness = 0.50f;
			if (mBrightness < 0.01f)
				mBrightness = 0.01f;

			// 显示
			mOperationBg.setImageResource(R.drawable.video_brightness_bg);
			mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
		}
		WindowManager.LayoutParams lpa = getWindow().getAttributes();
		lpa.screenBrightness = mBrightness + percent;
		if (lpa.screenBrightness > 1.0f)
			lpa.screenBrightness = 1.0f;
		else if (lpa.screenBrightness < 0.01f)
			lpa.screenBrightness = 0.01f;
		getWindow().setAttributes(lpa);

		ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
		lp.width = (int) (findViewById(R.id.operation_full).getLayoutParams().width * lpa.screenBrightness);
		mOperationPercent.setLayoutParams(lp);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if (mVideoView != null)
			mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
		super.onConfigurationChanged(newConfig);
	}

}
