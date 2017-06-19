package com.dltao.bxd.app.pages.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.dltao.bxd.R;
import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by ui on 2016/8/15.
 */
public abstract class BaseActivity extends AppCompatActivity{

    /**
     * 注册eventbus的见优先级，越大越先收到，默认0
     * @return
     */
    protected int registPriority() {
        return 0;
    }

    private boolean isNeedRegistEvent = false;

    protected boolean isNeedRegistEvent() {
        return isNeedRegistEvent;
    }
    public void setRegistEvent(boolean regist) {
        isNeedRegistEvent = regist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册微客服登录方式
        initView();
        initEvent();
        initData();
        initTitleBar();

        /**
         * 友盟自定义事件统计
         */
        if (!TextUtils.isEmpty(this.getClass().getName())) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("page", this.getClass().getName());
            MobclickAgent.onEventValue(this, this.getClass().getName().substring(this.getClass()
                    .getName().indexOf("activity.") + 9), m, 1);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }


    protected abstract void initView();
    protected void initData(){}
    protected void initEvent(){}
    protected void initTitleBar(){}

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    public final void forward(Class<?> cls) {
        forward(cls, null, -1);
    }

    /**
     * 带参跳转至某一个activity
     *
     * @param cls
     * @param bundle
     */
    public final void forward(Class<?> cls, Bundle bundle) {
        forward(cls, bundle, -1);
    }

    /**
     * 带参和Intent.FLAG跳转至某一个activity
     *
     * @param cls
     * @param bundle
     * @param flags
     */
    public final void forward(Class<?> cls, Bundle bundle, int flags) {
        if (cls == null) {
            return;
        }
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (flags > 0) {
            intent.addFlags(flags);
        }
        startActivityWithDefaultTransition(intent);

    }
    public void startActivityWithDefaultTransition(Intent intent) {
        startActivity(intent);
        defaultStartTransition();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        defaultStartTransition();
    }

    @Override
    public void finish() {
        super.finish();
        defaultFinishTransition();
    }

    public void defaultStartTransition(){
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
    }
    public void defaultFinishTransition(){
        overridePendingTransition(R.anim.alpha_in, R.anim.push_right_out);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {

            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();

            if (isShouldHideInput(v, ev)) {
                hideSoftInput(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = { 0, 0 };
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }
    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 隐藏软键盘
     */
    public void hideKeyboard() {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null){
                InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    //设置不允许用户改变app的字体大小
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

}
