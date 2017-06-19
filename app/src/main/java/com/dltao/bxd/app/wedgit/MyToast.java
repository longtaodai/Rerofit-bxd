package com.dltao.bxd.app.wedgit;

import android.widget.Toast;

import com.dltao.bxd.app.myapp.MyApplication;

/**
 * Created by ui on 2016/8/19.
 */
public class MyToast {



    public static void shortMsg(String message){
        Toast.makeText(MyApplication.getInstance().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public static void longMsg(String message){

    }
}
