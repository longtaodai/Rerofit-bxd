package com.dltao.bxd.app.api;

import android.widget.Toast;

import com.dltao.bxd.app.myapp.MyApplication;

import rx.Subscriber;

/**
 * Created by leason on 2016/5/15.
 */
public abstract class HttpSubscriber<T> extends Subscriber<T>{

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(MyApplication.getInstance(),e.getMessage()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    abstract public void onNext(T o);
}
