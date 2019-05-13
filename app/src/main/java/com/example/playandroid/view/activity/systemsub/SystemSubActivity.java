package com.example.playandroid.view.activity.systemsub;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ViewPagerAdapter_SystemSubActivity;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.base.MVPActivity;
import com.example.playandroid.model.bean.SystemBean;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.persenter.systemsub.SystemSubPresenter;
import com.example.playandroid.persenter.systemsub.SystemSubView;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 20:12
 * Describe: ${as}
 */
public class SystemSubActivity extends BaseActivity {

    @BindView(R.id.back_systemsub)
    ImageView backSystemsub;
    @BindView(R.id.title_systemsub)
    TextView titleSystemsub;
    @BindView(R.id.toolbar_systemsub)
    Toolbar toolbarSystemsub;
    @BindView(R.id.webview)
    ViewPager viewpager;
    private int id;
    private int page;
    private ViewPagerAdapter_SystemSubActivity adapter;
    private List<SystemBean.DataBean.ChildrenBean> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        SystemBean.DataBean dataBean = (SystemBean.DataBean) b.getSerializable("list");
        titleSystemsub.setText(dataBean.getName());
        list = dataBean.getChildren();
        init();
        initListener();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_system_sub;
    }

    private void init() {
        adapter = new ViewPagerAdapter_SystemSubActivity(list);
        viewpager.setAdapter(adapter);
    }

    private void initListener() {
        backSystemsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemSubActivity.this.finish();
            }
        });
    }



}
