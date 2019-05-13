package com.example.playandroid.model.home;

import com.example.playandroid.base.BaseCallBack;
import com.example.playandroid.model.bean.AvaterBean;
import com.example.playandroid.model.bean.HomeRecyclerViewBean;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 21:49
 * Describe: ${as}
 */
public interface HomeCallBack extends BaseCallBack<String> {
    void successAvater(AvaterBean bean);
    void successHomeRecycerView(HomeRecyclerViewBean bean);
}
