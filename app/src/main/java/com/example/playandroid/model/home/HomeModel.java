package com.example.playandroid.model.home;

import android.util.Log;

import com.example.playandroid.base.BaseModel;
import com.example.playandroid.model.bean.AvaterBean;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;
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
 * Date: 2019/5/9 0009
 * Time: 21:44
 * Describe: ${as}
 */
public class HomeModel extends BaseModel<HomeCallBack> {
    @Override
    public void get(final HomeCallBack callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Uris.WANANDROID_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<AvaterBean> avater = retrofitService.getAvater();
        avater.enqueue(new Callback<AvaterBean>() {
            @Override
            public void onResponse(Call<AvaterBean> call, Response<AvaterBean> response) {
                Log.i("guochao",response.code()+"");
                callback.successAvater(response.body());
            }

            @Override
            public void onFailure(Call<AvaterBean> call, Throwable t) {

                Log.i("guochao","Avater:"+t.getMessage());
            }
        });
        Call<HomeRecyclerViewBean> homeRecyclerView = retrofitService.getHomeRecyclerView();
        homeRecyclerView.enqueue(new Callback<HomeRecyclerViewBean>() {
            @Override
            public void onResponse(Call<HomeRecyclerViewBean> call, Response<HomeRecyclerViewBean> response) {
                Log.i("guochao",response.code()+"");
                callback.successHomeRecycerView(response.body());
            }

            @Override
            public void onFailure(Call<HomeRecyclerViewBean> call, Throwable t) {
                Log.i("guochao","HomeRecyclerView:"+t.getMessage());


            }
        });

    }

    @Override
    public void post(HomeCallBack callback) {

    }
}
