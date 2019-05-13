package com.example.playandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 19:51
 * Describe: ${as}
 */
public abstract class BaseActivity extends FragmentActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        bind = ButterKnife.bind(this);
    }
    protected abstract int getContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
