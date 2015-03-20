
package com.xinglefly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xinglefly.activity.AdvanceUI;
import com.xinglefly.activity.BasicControlUI;
import com.xinglefly.activity.NetControlUI;
import com.xinglefly.activity.control_ui.ViewPagerIndicator;
import com.xinglefly.commonutil.BaseActivity;
import com.xinglefly.util.ActivityUtil;
import com.xinglefly.util.Constants;
import com.xinglefly.util.ToastUtil;

/**
 * 登录界面
 * 
 * @author xinglefly
 */
public class LoginActivity extends BaseActivity implements OnClickListener {

    private static final boolean DEBUG = Constants.DEBUG;
    private static final String Tag = "LoginActivity";
    private static final String LOGINVIEW = "isLoging"; // 是否已经登录
    private boolean hasLogin = false; // 是否已经登录

    private EditText et_username, et_password;
    private LinearLayout lay_basic_android, lay_control_android,
            lay_web_service, lay_framework_layer, lay_bottom_driven,
            lay_advanced_application, lay_speech, lay_setting, lay_quit;
    private TextView tv_loging;
    private ImageView img_logo;

    private Handler mhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            hasLogin = savedInstanceState.getBoolean(LOGINVIEW, false);
            Log.i(Tag, "-onCreate savedInstanceState-->>" + hasLogin);
        }
    }

    @Override
    protected void loadViewLayout() {

        if (hasLogin) {
            // 主界面
            Log.i(Tag, "已经登录...." + hasLogin);
            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
            setContentView(R.layout.mainactivity);
            initFunctionMainView();
        } else {
            // 登录界面
            Log.i(Tag, "初次登录..." + hasLogin);
            setContentView(R.layout.login);
            initLoginView();
            hasLogin = true;
        }

    }

    @Override
    protected void findViewByid() {
        // 初始化各功能控件
        // 登录界面
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        tv_loging = (TextView) findViewById(R.id.tv_loging);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        initLoginView();
    }

    @Override
    protected void setOnClick() {

    }

    /**
     * 点击登录界面
     */
    private void initLoginView() {
        if (tv_loging != null) {
            tv_loging.setOnClickListener(this);
        }

        // 判断手机是否支持GPS功能，不支持就不能登录
        if (!getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_LOCATION_GPS)) {
            Toast.makeText(this, R.string.gps_show, Toast.LENGTH_LONG).show();
            img_logo.setEnabled(false);
        }

    }

    /**
     * 登录主画面
     */
    private void initFunctionMainView() {
        // 初始化主界面控件
        lay_basic_android = (LinearLayout) findViewById(R.id.lay_basic_android);
        lay_control_android = (LinearLayout) findViewById(R.id.lay_control_android);
        lay_web_service = (LinearLayout) findViewById(R.id.lay_web_service);
        lay_framework_layer = (LinearLayout) findViewById(R.id.lay_framework_layer);
        lay_bottom_driven = (LinearLayout) findViewById(R.id.lay_bottom_driven);
        lay_advanced_application = (LinearLayout) findViewById(R.id.lay_advanced_application);
        lay_speech = (LinearLayout) findViewById(R.id.lay_speech);
        lay_setting = (LinearLayout) findViewById(R.id.lay_setting);
        lay_quit = (LinearLayout) findViewById(R.id.lay_quit);
        // 监听事件
        lay_basic_android.setOnClickListener(this);
        lay_control_android.setOnClickListener(this);
        lay_web_service.setOnClickListener(this);
        lay_framework_layer.setOnClickListener(this);
        lay_bottom_driven.setOnClickListener(this);
        lay_advanced_application.setOnClickListener(this);
        lay_speech.setOnClickListener(this);
        lay_setting.setOnClickListener(this);
        lay_quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.tv_loging:
                // 登录界面
                // 没有这段代码，当进入主界面的时候键盘会自动弹出 IME
                InputMethodManager im = (InputMethodManager) this
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(v.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                checkVersion();
                break;
            case R.id.lay_basic_android:
                // android basically
                ActivityUtil.startActivity(LoginActivity.this, new Intent(
                        LoginActivity.this, ViewPagerIndicator.class),
                        getString(R.string.android_basis));
                break;
            case R.id.lay_control_android:
                // android basically control
                ActivityUtil.startActivity(LoginActivity.this, new Intent(
                        LoginActivity.this, BasicControlUI.class),
                        getString(R.string.android_basis_control));
                break;
            case R.id.lay_web_service:
                // network connection control
                ActivityUtil.startActivity(LoginActivity.this, new Intent(
                        LoginActivity.this, NetControlUI.class),
                        getString(R.string.android_basis_control));
                break;
            case R.id.lay_framework_layer:

                break;
            case R.id.lay_bottom_driven:

                break;
            case R.id.lay_advanced_application:
                // advanced application
                ActivityUtil.startActivity(LoginActivity.this, new Intent(
                        LoginActivity.this, AdvanceUI.class),
                        getString(R.string.android_advance_control));
                break;
            case R.id.lay_speech:

                break;
            case R.id.lay_setting:

                break;
            case R.id.lay_quit:
                // 注销
                Editor sp_quit = getSharedPreferences(Constants.SP_ITEM_HASLOGIN,
                        MODE_PRIVATE).edit();
                sp_quit.putBoolean(Constants.LOG_OUT, false);
                sp_quit.commit();
                hasLogin = false;
                ActivityUtil.finishActivity(LoginActivity.this);
                break;
            default:
                break;
        }
    }

    // 检查版本
    private void checkVersion() {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        if (username == null || username.trim().equals("")) {
            // et_username.setError("用户名不能为空！");
            ToastUtil.showToastText(Constants.USERNAME_EMPTY_STRING);
            et_username.requestFocus();
            return;
        }
        if (password == null || password.trim().equals("")) {
            et_password.setError("密码不能为空！");
            return;
        }

        // 验证用户名和密码
        // TODO verify

        // 保存到sp_filename
        Editor sp = getSharedPreferences(Constants.SP_FILE_USERINFO,
                MODE_PRIVATE).edit();
        sp.putString(Constants.SP_ITEM_USERNAME, username);
        sp.putString(Constants.SP_ITEM_PASSWORD, password);
        sp.putBoolean(Constants.SP_ITEM_HASLOGIN, true);
        sp.commit();
        mhandler.post(new Runnable() {

            @Override
            public void run() {
                setContentView(R.layout.mainactivity);
                hasLogin = true;
                initFunctionMainView();
            }
        });

    }

    @Override
    protected void updateUI() {

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /**
         * 解释： 当前的Activity onpause()方法的时候，然后调用新的intent打开新的Activity时执行此方法，记录状态。
         * 当重新返回到此Activity时
         * ，依次执行OnCreate(saveInstanceState)——>onRestoreInstanceState()方法
         */
        outState.putBoolean(LOGINVIEW, hasLogin);
        Log.i(Tag, "-onSaveInstanceState->>" + outState.getBoolean(LOGINVIEW));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(LOGINVIEW, hasLogin);
        Log.i(Tag,
                "-onRestoreInstanceState->>"
                        + savedInstanceState.getBoolean(LOGINVIEW));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        // set lauch model single_top
        /**
         * 解释：设置次方法，就相当于设置了lauch model 为 single_Top模式， 不知道为什么不执行
         * 主要应用在点击home键时调用此方法
         */
        boolean logout = getIntent().getBooleanExtra(Constants.LOG_OUT, false);
        Log.i(Tag, "--onNewIntent-->>" + 2);
        if (logout) {
            Log.i(Tag, "确定退出" + logout);
            logout = false;
            setContentView(R.layout.login);
            initLoginView();
        } else {
            Log.i(Tag, "点home键后再次启动Intent：" + logout);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 设置输入法的状态
        Log.i(Tag, "未登录...." + 1 + hasLogin);
        if (hasLogin) {
            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        } else {
            getWindow()
                    .setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                                    | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }

    }

}
