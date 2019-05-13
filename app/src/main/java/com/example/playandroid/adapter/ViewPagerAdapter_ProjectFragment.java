package com.example.playandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.ProjectNameBean;
import com.example.playandroid.view.fragment.project.ProjectTabManager;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 11:02
 * Describe: ${as}
 */
public class ViewPagerAdapter_ProjectFragment extends PagerAdapter {
    private List<ProjectNameBean.DataBean> list;
    private Context context;

    public ViewPagerAdapter_ProjectFragment(List<ProjectNameBean.DataBean> list){
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        context = container.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_tablayout_layout,container,false);
        ProjectTabManager manager = new ProjectTabManager(view,context,list.get(position).getId());
        manager.init();
        manager.initData();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
