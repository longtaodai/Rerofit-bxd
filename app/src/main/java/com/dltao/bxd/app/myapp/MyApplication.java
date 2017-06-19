package com.dltao.bxd.app.myapp;

import android.app.Application;

/**
 * Created by ui on 2016/8/19.
 */
public class MyApplication extends Application {

    private static MyApplication mApplication=null;

    public static MyApplication getInstance(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    private String machineCode;

    public String getMachineCode(){
        return machineCode;
    }
}
