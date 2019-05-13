package com.example.playandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 19:23
 * Describe: ${as}
 */
public abstract  class MVPActivity<P extends BasePresenter,V extends BaseView,D> extends BaseActivity implements BaseView<D>{

    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attachView((V)this);
    }

    protected abstract P initPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deachView();
    }
}
