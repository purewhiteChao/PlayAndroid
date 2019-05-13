package com.example.playandroid.persenter.systemsub;

import com.example.playandroid.base.BaseView;
import com.example.playandroid.model.bean.SystemSubBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 20:15
 * Describe: ${as}
 */
public interface SystemSubView<T> extends BaseView<T> {

    void successTitle(List<String> list);
}
