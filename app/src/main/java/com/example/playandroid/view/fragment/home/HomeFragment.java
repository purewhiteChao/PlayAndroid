package com.example.playandroid.view.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_HomeFragment;
import com.example.playandroid.base.BaseMVPFragment;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;
import com.example.playandroid.persenter.home.HomePersenter;
import com.example.playandroid.persenter.home.HomeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 21:42
 * Describe: ${as}
 */
public class HomeFragment extends BaseMVPFragment<HomePersenter, HomeView, String> implements HomeView {

    @BindView(R.id.banner_homefragment)
    Banner bannerHomefragment;
    @BindView(R.id.recycler_homefragment)
    RecyclerView recyclerHomefragment;
    private RecyclerAdapter_HomeFragment adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerHomefragment.setLayoutManager(manager);
        adapter = new RecyclerAdapter_HomeFragment();
        recyclerHomefragment.setAdapter(adapter);
    }

    private void initData() {

        persenter.getData();
    }



    @Override
    protected HomePersenter getPersenter() {
        return new HomePersenter();
    }

    @Override
    public void success(String data) {

    }

    @Override
    public void failess(String message) {

        Log.i("guochao","HomeFragment"+message);
    }


    @Override
    public void successAvater(List<String> list, List<String> list_title) {

        bannerHomefragment.setImages(list)
                .setBannerTitles(list_title)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                })
                .setDelayTime(1000)
                .isAutoPlay(true)
                .start();
    }

    @Override
    public void successHomeRecycerView(List<HomeRecyclerViewBean.DataBean.DatasBean> datasBean) {

        adapter.refresh(datasBean);
    }

    @Override
    public int getContextView() {
        return R.layout.fragment_home_layout;
    }
}
