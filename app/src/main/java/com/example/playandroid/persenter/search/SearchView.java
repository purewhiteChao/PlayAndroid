package com.example.playandroid.persenter.search;

import com.example.playandroid.base.BaseView;
import com.example.playandroid.model.bean.Article;
import com.example.playandroid.model.bean.SerachHotMsgBean;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 21:07
 * Describe: ${as}
 */
public interface SearchView extends BaseView<String> {

    void successHotMsg(List<SerachHotMsgBean.DataBean> list);
    void successData(List<Article> list);
}
