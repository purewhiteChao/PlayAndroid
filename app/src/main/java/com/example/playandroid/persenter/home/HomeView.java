package com.example.playandroid.persenter.home;

import com.example.playandroid.base.BaseView;
import com.example.playandroid.model.bean.AvaterBean;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 21:47
 * Describe: ${as}
 */
public interface HomeView extends BaseView<String> {
    void successAvater(List<String> list, List<String> list_title);
    void successHomeRecycerView(List<HomeRecyclerViewBean.DataBean.DatasBean> datasBean);

}
