package com.dltao.bxd.app.pages.activity;

import com.dltao.bxd.R;
import com.dltao.bxd.app.api.ApiEngine;
import com.dltao.bxd.app.api.HttpSubscriber;
import com.dltao.bxd.app.wedgit.MyToast;

import org.json.JSONObject;

import butterknife.OnClick;

public class ActivityMain extends BaseActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.login)
    void gotoLogin() {
        ApiEngine.getInstance().getApiObservable(ApiEngine.getInstance().getApiService().getCode
                ("17071785865", "Android注册"))
                .subscribe(new HttpSubscriber<JSONObject>() {
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
                    public void onNext(JSONObject o) {
                        MyToast.shortMsg("验证码发送成功");
                    }
                });
    }

}
