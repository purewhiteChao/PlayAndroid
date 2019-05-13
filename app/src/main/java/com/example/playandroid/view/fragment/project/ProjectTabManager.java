package com.example.playandroid.view.fragment.project;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_Tab_ProjectTabManager;
import com.example.playandroid.model.bean.ProjectContentBean;
import com.example.playandroid.persenter.project.ProjectPresenter;
import com.example.playandroid.persenter.project.ProjectView;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 11:17
 * Describe: ${as}
 */
public class ProjectTabManager implements ProjectView<List<ProjectContentBean.DataBean.DatasBean>> {
    private View view;
    private Context context;
    private int id;
    private RecyclerView recyclerView;
    private RecyclerAdapter_Tab_ProjectTabManager adatpter;
    private ProjectPresenter presenter;

    public ProjectTabManager(View view, Context context,int id){
        this.view = view;
        this.context = context;
        this.id = id;
        presenter = new ProjectPresenter();
        presenter.attachView(this);
    }
    public void init(){
        recyclerView = view.findViewById(R.id.recycler_tablayout_wxfragment);
        LinearLayoutManager  manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adatpter = new RecyclerAdapter_Tab_ProjectTabManager();
        recyclerView.setAdapter(adatpter);
    }
    public void initData(){
        presenter.getContentData(id,1);
    }
    @Override
    public void success(List<ProjectContentBean.DataBean.DatasBean> data) {

        adatpter.refresh(data);
    }

    @Override
    public void failess(String message) {

    }
}
