package com.example.playandroid.view.fragment.system;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_SystemFragment;
import com.example.playandroid.base.BaseMVPFragment;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.persenter.system.SystemPersenter;
import com.example.playandroid.persenter.system.SystemView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 14:13
 * Describe: ${as}
 */
public class SystemFragment extends BaseMVPFragment<SystemPersenter, SystemView, List<SystemBean.DataBean>> implements SystemView {
    @BindView(R.id.recycler_systemfragment)
    RecyclerView recyclerSystemfragment;
    RecyclerAdapter_SystemFragment adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {

        persenter.getData();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerSystemfragment.setLayoutManager(manager);
        adapter = new RecyclerAdapter_SystemFragment();
        recyclerSystemfragment.setAdapter(adapter);
        recyclerSystemfragment.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }



    @Override
    protected SystemPersenter getPersenter() {
        return new SystemPersenter();
    }

    @Override
    public void success(List<SystemBean.DataBean> data) {

        adapter.refresh(data);
    }

    @Override
    public void failess(String message) {

        Log.i("guochao","systemfragment:"+message);
    }

    @Override
    public int getContextView() {
        return R.layout.fragment_system_layout;
    }
}
