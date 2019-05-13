package com.example.playandroid.model.system;

import android.util.Log;

import com.example.playandroid.base.BaseModel;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.model.uri.Uris;
import com.example.playandroid.model.service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 14:14
 * Describe: ${as}
 */
public class SystemModel extends BaseModel<SystemCallBack> {
    @Override
    public void get(final SystemCallBack callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Uris.WANANDROID_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<SystemBean> system = retrofitService.getSystem();
        system.enqueue(new Callback<SystemBean>() {
            @Override
            public void onResponse(Call<SystemBean> call, Response<SystemBean> response) {
                Log.i("guochao","SystemFragment:onsuccess:"+response.code());
                callback.success(response.body());
            }

            @Override
            public void onFailure(Call<SystemBean> call, Throwable t) {

                Log.i("guochao","SystemFragment:onfailure"+ t.getMessage());
            }
        });
    }

    @Override
    public void post(SystemCallBack callback) {

    }
}
