
package com.xinglefly.activity.control_ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinglefly.R;
import com.xinglefly.activity.control_ui.bean.VideoInfo;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;

public class Intent_UI extends BaseActivity implements OnClickListener {

    private Button btn_intent,btn_bundle,btn_object;
    private String url = "http://data.vod.itc.cn/?new=/3/100/YcRSKI9G6sJX26UE6bnCy3.mp4&vid=1000242326&plat=null&mkey=iEvNTj6POf0BmvKtf3YKEBzqO7YIHTkX&ch=tv";
    private int playid = 3779;
    private int videoid = 121299;
    
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.intent_bundle);
    }

    @Override
    protected void findViewByid() {
        img_header_view_back_key = (ImageView) findViewById(R.id.img_header_view_back_key);
        img_header_view_back_key.setOnClickListener(this);
        tv_titlename = (TextView) findViewById(R.id.tv_titlename);
        tv_titlename.setText(getIntent().getStringExtra(TITLENAME));

        btn_intent = (Button) findViewById(R.id.btn_intent);
        btn_bundle = (Button) findViewById(R.id.btn_bundle);
        btn_object = (Button) findViewById(R.id.btn_object);
        btn_intent.setOnClickListener(this);
        btn_bundle.setOnClickListener(this);
        btn_object.setOnClickListener(this);
    }

    @Override
    protected void setOnClick() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void updateUI() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void processLogic() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent_UI.this, ByValue_UI.class);;
        switch (v.getId()) {
            case R.id.img_header_view_back_key:
                ActivityUtil.finishActivity(Intent_UI.this);
                break;

            case R.id.btn_intent:
                //intent传值（不建议使用）
                intent.putExtra("url", url);
                intent.putExtra("playid", playid);
                intent.putExtra("videoid", videoid);
                startActivity(intent);
                break;
            case R.id.btn_bundle:
                //bundle传值（推荐使用）
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putInt("playid", playid);
                bundle.putInt("videoid", videoid);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.btn_object:
                //Serializable和 Parcelable的区别
                Bundle bdle = new Bundle();
                bdle.putSerializable("VideoInfo", new VideoInfo(url, playid, videoid));
                intent.putExtras(bdle);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

}
