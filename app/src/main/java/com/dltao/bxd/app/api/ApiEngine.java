package com.dltao.bxd.app.api;

import com.dltao.bxd.app.api.bean.User;
import com.dltao.bxd.app.api.response.HttpResponse;
import com.dltao.bxd.app.global.Global;
import com.dltao.bxd.utill.JsonHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ui on 2016/8/19.
 */
public class ApiEngine {

    private static final String BaseUrl = "http://t2.ttshj.com/";

    private static Retrofit retrofit;

    private static final OkHttpClient.Builder mHttpClientBuilder = new OkHttpClient.Builder();

    /*****
     * Interceptor 接口只包含一个方法 intercept，
     * 其参数是 Chain 对象。Chain 对象表示的是当前的拦截器链条。
     * 通过 Chain 的 request 方法可以获取到当前的 Request 对象。
     * 在使用完 Request 对象之后，通过 Chain 对象的 proceed 方法来继续拦截器链条的执行。
     * 当执行完成之后，可以对得到的 Response 对象进行额外的处理。
     */
    private static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            User user = Global.getUser();
            if (user != null) {
                String token = user.getToken();
                String phone = user.getStrPhone();
                if (token != null) {
                    builder.addHeader("UserAccount", phone);
                }
                if (phone != null) {
                    builder.addHeader("Token", token);
                }
            }
            builder.addHeader("SystemVersion", "AB0003");
            builder.addHeader("machineCode", "12306Android");

            return chain.proceed(builder.build());

        }
    };

    static {
        mHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS).addInterceptor(interceptor);
        OkHttpClient okHttpClient = mHttpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(JsonHelper.getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private ApiService mApiService = retrofit.create(ApiService.class);

    public ApiService getApiService() {
        return mApiService;
    }

    private static ApiEngine mApiEngine = new ApiEngine();

    public static ApiEngine getInstance(){
        return mApiEngine;
    }

    public ApiEngine() {

    }

    public <R> Observable getApiObservable(Observable<? extends HttpResponse> o) {

        return o.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap
                (new Func1<HttpResponse, Observable<?>>() {

            @Override
            public Observable<?> call(HttpResponse httpResponse) {
                if (httpResponse.isSuccess()) {
                    return Observable.just(httpResponse.getData());
                } else {
                    String Message = httpResponse.getMessage();
                    return Observable.error(new Throwable(Message));
                }
            }
        });
    }
}
