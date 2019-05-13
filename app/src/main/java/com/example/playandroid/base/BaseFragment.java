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
 * Date: 2019/5/11 0011
 * Time: 13:31
 * Describe: ${as}
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder bind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContextView(),container,false);
        bind = ButterKnife.bind(this,view);
        return view;
    }
    public abstract int getContextView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

}
