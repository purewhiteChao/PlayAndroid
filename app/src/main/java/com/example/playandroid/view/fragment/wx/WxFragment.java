package com.example.playandroid.view.fragment.wx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ViewPagerAdapter_WxFragment;
import com.example.playandroid.base.BaseMVPFragment;
import com.example.playandroid.model.bean.WxNameBean;
import com.example.playandroid.persenter.wx.WxPresenter;
import com.example.playandroid.persenter.wx.WxView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 16:25
 * Describe: ${as}
 */
public class WxFragment extends BaseMVPFragment<WxPresenter, WxView, List<WxNameBean.DataBean>> implements WxView<List<WxNameBean.DataBean>> {

    @BindView(R.id.tablayout_wxfragment)
    TabLayout tablayoutWxfragment;
    @BindView(R.id.viewpager_wxfragment)
    ViewPager viewpagerWxfragment;
    private ViewPagerAdapter_WxFragment adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        persenter.getData();
    }



    @Override
    protected WxPresenter getPersenter() {
        return new WxPresenter();
    }


    @Override
    public void success(List<WxNameBean.DataBean> datas) {

        adapter = new ViewPagerAdapter_WxFragment(datas);
        viewpagerWxfragment.setAdapter(adapter);
    }

    @Override
    public void failess(String message) {

        Log.i("guochao",message);
    }

    @Override
    public int getContextView() {
        return R.layout.fragment_wx_layout;
    }
}
