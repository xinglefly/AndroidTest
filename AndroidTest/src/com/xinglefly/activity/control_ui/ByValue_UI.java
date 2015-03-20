
package com.xinglefly.activity.control_ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.bean.VideoInfo;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;

import java.io.Serializable;

public class ByValue_UI extends BaseActivity implements OnClickListener {

    private TextView tv_url,tv_playid,tv_videoid;
    private String url;
    private int playid;
    private long play_id;
    private int videoid;
    
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.byvalue_ui);
    }

    @Override
    protected void findViewByid() {

        initHeader();

        initContent();
    }

    private void initHeader() {
        img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
        img_header_view_back_key.setOnClickListener(this);
        tv_titlename = (TextView) findViewById(R.id.tv_titlename);
        tv_titlename.setText(getIntent().getStringExtra(TITLENAME));
    }

    private void initContent() {
        tv_url = (TextView) findViewById(R.id.tv_url);
        tv_playid = (TextView) findViewById(R.id.tv_playid);
        tv_videoid = (TextView) findViewById(R.id.tv_videoid);
        
//        by_getIntent();
//        by_getBundle();
        by_getSerializable();
        
    }

    private void by_getSerializable() {
        VideoInfo info = (VideoInfo) getIntent().getSerializableExtra("VideoInfo");
        url = info.getUrl();
        play_id = info.getPlayid();
        videoid = info.getVideoid();
    }

    private void by_getBundle() {
        Bundle bundle = getIntent().getExtras();
        url = bundle.getString("url");
        playid = bundle.getInt("playid");
        videoid = bundle.getInt("videoid");
    }

    private void by_getIntent() {
        url = getIntent().getStringExtra("url");
        playid = getIntent().getIntExtra("playid",0);
        videoid = getIntent().getIntExtra("videoid",0);
    }

    @Override
    protected void setOnClick() {

    }

    @Override
    protected void updateUI() {
        tv_url.setText("url:"+url);
        tv_playid.setText("playid:"+play_id);
        tv_videoid.setText("videoid:"+videoid);
    }

    @Override
    protected void processLogic() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.img_header_view_back_key:
                ActivityUtil.finishActivity(ByValue_UI.this);
                break;

            default:
                break;
        }

    }

}
