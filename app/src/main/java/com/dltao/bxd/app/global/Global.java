package com.dltao.bxd.app.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.dltao.bxd.app.api.bean.User;
import com.dltao.bxd.app.myapp.MyApplication;
import com.dltao.bxd.utill.SharedPreferencesUtils;

/**
 * Created by ui on 2016/8/19.
 */
public class Global {

    static User user = null;
    static String BXDINFO="info";
    static String BXDUSER="bxdUser";

    static SharedPreferences mPreferences= MyApplication.getInstance().getSharedPreferences(BXDINFO, Context.MODE_PRIVATE);

    public static User getUser(){
        if (user == null) {
            user = SharedPreferencesUtils.getObject(mPreferences, BXDUSER,
                    User.class);
        }
        return user;
    }

    public static void setUser(User user){
        if (user == null) {
            return;
        }
        SharedPreferencesUtils.setObject(mPreferences, BXDUSER, user);
    }

    public static void ClearUser(){
        SharedPreferencesUtils.setObject(mPreferences,BXDUSER,null);
    }
}
