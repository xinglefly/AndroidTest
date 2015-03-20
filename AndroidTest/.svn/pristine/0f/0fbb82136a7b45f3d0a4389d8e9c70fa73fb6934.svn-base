package com.xinglefly.util;

import android.app.Activity;
import android.content.Intent;

import com.xinglefly.LoginActivity;
import com.xinglefly.R;
import com.xinglefly.activity.control_ui.ViewPagerIndicator;
import com.xinglefly.commonutil.BaseActivity;

/**
 * 抽取的公共方法
 * @author xinglefly
 */

/**
 * 使用说明：
 * ActivityUtil.startActivity(LoginActivity.this,new Intent(LoginActivity.this,ViewPagerIndicator.class),getString(R.string.android_basis));
 * 
 */

public class ActivityUtil {

    /**
     * add a anim  and FLAG_ACTIVITY_CLEAR_TOP flag#;
     * @param activity  
     * @param intent
     */
    public static void startActivity(Activity activity,Intent intent,String message){
    	intent.putExtra(BaseActivity.TITLENAME, message);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_in_right, R.anim.push_out_left);
    }
    
    public static void finishActivity(Activity activity){
    	activity.finish();
        activity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
