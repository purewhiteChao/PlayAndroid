package com.example.playandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 21:36
 * Describe: ${as}
 */
public abstract class BaseMVPFragment<P extends BasePresenter,V extends BaseView,D> extends BaseFragment implements BaseView<D> {

    protected P persenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        persenter = getPersenter();
        persenter.attachView((V)this);
    }

    protected abstract P getPersenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        persenter.deachView();
    }
}
