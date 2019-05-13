package com.example.playandroid.view.activity.systemsub;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_Tab_SysSubAvtivity;
import com.example.playandroid.base.MVPActivity;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.persenter.systemsub.SystemSubPresenter;
import com.example.playandroid.persenter.systemsub.SystemSubView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 23:19
 * Describe: ${as}
 */
public class SystemSubManager implements SystemSubView<List<SystemSubBean.DataBean.DatasBean>> {
    private View view;
    private Context context;
    private SystemSubPresenter presenter;
    private RecyclerAdapter_Tab_SysSubAvtivity adapter;

    public SystemSubManager(View view,Context context){
        this.context = context;
        this.view = view;
        presenter = new SystemSubPresenter();
        presenter.attachView(this);
    }

    public void ininData(int id){
        presenter.getData(id,0);
    }
    public void init(){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_tablayout_wxfragment);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter_Tab_SysSubAvtivity();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void successTitle(List<String> list) {

    }

    @Override
    public void success(List<SystemSubBean.DataBean.DatasBean> data) {

        adapter.refresh(data);
    }

    @Override
    public void failess(String message) {

    }
}
