package com.example.playandroid.view.fragment.wx;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_HomeFragment;
import com.example.playandroid.adapter.RecyclerAdapter_WxTabManager;
import com.example.playandroid.model.bean.WxContentBean;
import com.example.playandroid.model.bean.WxNameBean;
import com.example.playandroid.persenter.wx.WxPresenter;
import com.example.playandroid.persenter.wx.WxView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 9:17
 * Describe: ${as}
 */
public class WxTabManager implements WxView<List<WxContentBean.DataBean.DatasBean>> {
    private WxPresenter presenter;
    private View view;
    private RecyclerView recyclerView;
    private Context context;
    private RecyclerAdapter_WxTabManager adapter;
    private int id;

    public WxTabManager(View view, Context context,int id){

        this.view = view;
        this.context = context;
        this.id = id;
        presenter = new WxPresenter();
        presenter.attachView(this);
    }

    public void init(){
        recyclerView = view.findViewById(R.id.recycler_tablayout_wxfragment);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter_WxTabManager();
        recyclerView.setAdapter(adapter);
    }

    public void initData(){

        presenter.getContentData(id,1);
    }

    @Override
    public void success(List<WxContentBean.DataBean.DatasBean> data) {

        Log.i("guochao",""+data.size());
        adapter.refresh(data);
    }

    @Override
    public void failess(String message) {

    }
}
