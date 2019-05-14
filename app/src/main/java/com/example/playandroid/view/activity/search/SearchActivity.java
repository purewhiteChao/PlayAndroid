package com.example.playandroid.view.activity.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.RecyclerAdapter_History_Search;
import com.example.playandroid.adapter.RecyclerAdapter_SearchActivity;
import com.example.playandroid.base.MVPActivity;
import com.example.playandroid.model.bean.Article;
import com.example.playandroid.model.bean.SerachHotMsgBean;
import com.example.playandroid.persenter.search.SearchPresenter;
import com.example.playandroid.persenter.search.SearchView;
import com.example.playandroid.view.activity.searchdata.SearchDataActivity;
import com.example.playandroid.view.fragment.person.PersonFragment;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 21:07
 * Describe: ${as}
 */
public class SearchActivity extends MVPActivity<SearchPresenter, SearchView, String> implements SearchView {
    @BindView(R.id.back_search)
    ImageView backSearch;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.search_search)
    TextView searchSearch;
    @BindView(R.id.toolbar_search)
    Toolbar toolbarSearch;
    @BindView(R.id.hotsearch_search)
    RecyclerView hotsearchSearch;
    @BindView(R.id.history_search)
    RecyclerView historySearch;
    RecyclerAdapter_SearchActivity adapter;
    private String data;
    private int hotFlag = 0;
    private String hotName;
    private List<String> list;
    private RecyclerAdapter_History_Search adapter_history;
    private String historyName;

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    public void success(String data) {

    }

    @Override
    public void failess(String message) {

    }

    @Override
    public void successHotMsg(List<SerachHotMsgBean.DataBean> list) {

        adapter.refresh(list);
    }

    @Override
    public void successData(List<Article> list) {

        Intent intent = new Intent(this, SearchDataActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) list);
        if(hotFlag==1){
            bundle.putString("title",hotName);
        }else if(hotFlag==2){
            bundle.putString("title", data);
        } else if (hotFlag==3) {
            bundle.putString("title",historyName);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        backSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.finish();
            }
        });
        searchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = editSearch.getText().toString();
                hotFlag = 2;
                list.add(data);
                adapter_history.refresh(list);
                presenter.getData(data,0);
            }
        });
        adapter.setOnCallBack(new RecyclerAdapter_SearchActivity.OnCallBack() {
            @Override
            public void oncallback(String name) {
                hotName = name;
                hotFlag = 1;
                presenter.getData(name,0);
            }
        });
        adapter_history.setCallBack(new RecyclerAdapter_History_Search.OnHistoryCallBack() {
            @Override
            public void onHistoryCallBack(String name) {

                historyName = name;
                hotFlag =3;
                presenter.getData(name,0);
            }

            @Override
            public void onHistoryDeleteCallBack(int index) {

                list.remove(index);
                adapter_history.refresh(list);
            }
        });
    }

    private void initData() {
        presenter.getHotMsg();
    }

    private void initView() {
        FlexboxLayoutManager manager = new FlexboxLayoutManager(this);
        manager.setFlexDirection(FlexDirection.ROW);
        hotsearchSearch.setLayoutManager(manager);
        adapter = new RecyclerAdapter_SearchActivity();
        hotsearchSearch.setAdapter(adapter);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        historySearch.setLayoutManager(manager1);
        adapter_history = new RecyclerAdapter_History_Search();
        historySearch.setAdapter(adapter_history);
        list = new ArrayList<>();


    }
}
