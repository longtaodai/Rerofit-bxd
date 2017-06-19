package com.dltao.bxd.app.api;

import com.dltao.bxd.app.api.bean.Area;
import com.dltao.bxd.app.api.bean.User;
import com.dltao.bxd.app.api.response.HttpResponse;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ui on 2016/8/19.
 */
public interface ApiService {

    //用户登录
    @FormUrlEncoded
    @POST("api/Account/UserLogin")
    Observable<HttpResponse<User>> login(@Field("EncryptData") String EncryptData );

    //获取所有区域列表
    @GET("api/BaseInfo/GetSysTBRegion")
    Observable<HttpResponse<HttpResponse<Area>>>  getAreaList();

    //获取手机验证码
    @GET("api/Account/SendVerificationCode")
    Observable<HttpResponse<JSONObject>> getCode(@Query("straccount")String straccount,
                                                 @Query("strModuleName")String strModuleName);
    //图片上传
    @Multipart
    @POST("api/Account/uploadAvatar")
    Observable<HttpResponse<User>>  uploadAvatar(@Query("strAccount") String strAccount,
                                                 @Part("strAvatar") RequestBody avatar);

}
