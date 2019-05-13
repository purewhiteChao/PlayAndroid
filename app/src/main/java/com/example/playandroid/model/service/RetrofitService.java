package com.example.playandroid.model.service;

import com.example.playandroid.model.BaseResponse;
import com.example.playandroid.model.bean.AvaterBean;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;
import com.example.playandroid.model.bean.ProjectContentBean;
import com.example.playandroid.model.bean.ProjectNameBean;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.model.bean.WxContentBean;
import com.example.playandroid.model.bean.WxNameBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 8:43
 * Describe: ${as}
 */
public interface RetrofitService {

    @GET("banner/json")
    Call<AvaterBean> getAvater();

    @GET("article/list/0/json")
    Call<HomeRecyclerViewBean> getHomeRecyclerView();

    @GET("tree/json")
    Call<SystemBean> getSystem();

    @GET("wxarticle/chapters/json")
    Observable<WxNameBean> getWxName();

    @GET
    Observable<WxContentBean> getWxContent(@Url String url);

    @GET("project/tree/json")
    Observable<ProjectNameBean> getProjectName();

    @GET
    Observable<ProjectContentBean> getProjectContent(@Url String url);

    @POST("user/login")
    @FormUrlEncoded
    Observable<ResponseBody> postLogin(@Field("username")String username,@Field("password")String password);


    @POST("user/register")
    @FormUrlEncoded
    Observable<ResponseBody> postRegister(@Field("username")String username,@Field("password")String password,@Field("repassword")String repassword);

    @GET("user/logout/json")
    Observable<ResponseBody> getLogout();

    @GET
    Observable<SystemSubBean> getSystemSub(@Url String url);
}
