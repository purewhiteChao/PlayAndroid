package com.example.playandroid.view.activity.searchdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ReecyclerAdapter_searchdata;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.bean.Article;
import com.example.playandroid.model.bean.SearchDataBean;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 22:53
 * Describe: ${as}
 */
public class SearchDataActivity extends BaseActivity {
    @BindView(R.id.back_searchdata)
    ImageView backSearchdata;
    @BindView(R.id.search_searchdata)
    TextView searchSearchdata;
    @BindView(R.id.toolbar_searchdata)
    Toolbar toolbarSearchdata;
    @BindView(R.id.recycler_searchdata)
    RecyclerView recyclerSearchdata;
    ReecyclerAdapter_searchdata adapter;


    @Override
    protected int getContentView() {
        return R.layout.activity_searchdata;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        List<Article> data = (List<Article>) extras.getSerializable("data");
        adapter.refresh(data);
        String title = extras.getString("title");
        searchSearchdata.setText(title);
        initListener();

    }

    private void initListener() {
        backSearchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchDataActivity.this.finish();
            }
        });
    }

    private void initView() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerSearchdata.setLayoutManager(manager);
        adapter = new ReecyclerAdapter_searchdata();
        recyclerSearchdata.setAdapter(adapter);
    }
}
