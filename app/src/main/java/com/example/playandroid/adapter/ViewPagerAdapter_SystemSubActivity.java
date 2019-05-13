package com.example.playandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.view.activity.systemsub.SystemSubManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 21:08
 * Describe: ${as}
 */
public class ViewPagerAdapter_SystemSubActivity extends PagerAdapter {
    private List<SystemBean.DataBean.ChildrenBean> list;
    private Context context;
    private RecyclerAdapter_Tab_SysSubAvtivity adapter;

    public ViewPagerAdapter_SystemSubActivity(List<SystemBean.DataBean.ChildrenBean> list){
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
        SystemSubManager manager = new SystemSubManager(view,context);
        manager.init();
        manager.ininData(list.get(position).getId());
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
