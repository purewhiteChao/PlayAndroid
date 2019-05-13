package com.example.playandroid.view.fragment.project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ViewPagerAdapter_ProjectFragment;
import com.example.playandroid.base.BaseMVPFragment;
import com.example.playandroid.model.bean.ProjectNameBean;
import com.example.playandroid.persenter.project.ProjectPresenter;
import com.example.playandroid.persenter.project.ProjectView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 10:38
 * Describe: ${as}
 */
public class ProjectFragment extends BaseMVPFragment<ProjectPresenter, ProjectView, List<ProjectNameBean.DataBean>> implements ProjectView<List<ProjectNameBean.DataBean>> {
    @BindView(R.id.tablayout_projectfragment)
    TabLayout tablayoutProjectfragment;
    @BindView(R.id.viewpager_projectfragment)
    ViewPager viewpagerProjectfragment;
    private ViewPagerAdapter_ProjectFragment adapter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {

        persenter.getNameData();
    }



    @Override
    protected ProjectPresenter getPersenter() {
        return new ProjectPresenter();
    }

    @Override
    public void success(List<ProjectNameBean.DataBean> data) {

        adapter = new ViewPagerAdapter_ProjectFragment(data);
        viewpagerProjectfragment.setAdapter(adapter);
    }

    @Override
    public void failess(String message) {

    }

    @Override
    public int getContextView() {
        return R.layout.fragment_project_layout;
    }
}
