package com.dltao.bxd.app.pages.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dltao.bxd.R;
import com.dltao.bxd.app.wedgit.TitleBar;

import butterknife.ButterKnife;

/**
 * Created by ui on 2016/8/19.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
        initTitleBar();
        initEvent();
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

    protected void initEvent() {
    }

    protected void initTitleBar() {
        titleBar= (TitleBar) findViewById(R.id.titleBar);
        if (titleBar!=null){
            setSupportActionBar(titleBar);
            titleBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    protected void initData() {
    }
}
