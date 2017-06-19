package com.dltao.bxd.app.pages.activity;

import android.view.View;
import android.widget.TextView;

import com.dltao.bxd.R;
import com.dltao.bxd.app.api.ApiEngine;
import com.dltao.bxd.app.api.HttpSubscriber;
import com.dltao.bxd.app.api.bean.User;
import com.dltao.bxd.app.api.bean.postModel.PostLogin;
import com.dltao.bxd.utill.MyDesUtil;
import com.google.gson.Gson;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ui on 2017/3/31.
 */
public class ActivityLogin extends BaseActivity {

    @Bind(R.id.text_account)
    TextView text_account;
    @Bind(R.id.text_password)
    TextView text_password;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
    }

    @OnClick({R.id.btn_login})
    void onClick(View v){
        switch (v.getId()){
            case R.id.btn_login:{
                PostLogin mPostLogin=new PostLogin("13636056655","wwwwww","","Android");
                String mJsonString="";
                try{
                    mJsonString=MyDesUtil.encryptDES(new Gson().toJson(mPostLogin),
                            "12345678");
                }catch (Exception e){

                }
                ApiEngine.getInstance().getApiObservable(ApiEngine.getInstance().getApiService()
                        .login(mJsonString))
                        .subscribe(new HttpSubscriber<User>() {
                            @Override
                            public void onStart() {
                                super.onStart();
                            }

                            @Override
                            public void onCompleted() {
                                super.onCompleted();
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                            }

                            @Override
                            public void onNext(User o) {
                                if (o != null) {

                                }
                            }
                        });

                break;
            }
            default:
                break;
        }
    }
}
