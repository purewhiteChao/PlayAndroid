package com.example.playandroid.view.activity.collect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_CollectActivity;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.bean.CollectBean;
import com.example.playandroid.model.dbdao.CollectTableDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 14:42
 * Describe: ${as}
 */
public class CollectActivity extends BaseActivity {
    @BindView(R.id.back_collectactivity)
    ImageView backCollectactivity;
    @BindView(R.id.title_collectactivity)
    TextView titleCollectactivity;
    @BindView(R.id.recycler_collectactivity)
    RecyclerView recyclerCollectactivity;
    RecyclerAdapter_CollectActivity adapter;
    CollectTableDao dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initData();
        initListener();
    }

    private void initData() {
        List<CollectBean> collectBeans = dao.selectDao();
        adapter.refresh(collectBeans);
    }

    private void initListener() {
        backCollectactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectActivity.this.finish();
            }
        });
    }

    private void init() {
        dao = new CollectTableDao(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerCollectactivity.setLayoutManager(manager);
        adapter = new RecyclerAdapter_CollectActivity();
        recyclerCollectactivity.setAdapter(adapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_collect;
    }


}
