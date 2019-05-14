package com.example.playandroid.persenter.search;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.bean.Article;
import com.example.playandroid.model.bean.SearchDataBean;
import com.example.playandroid.model.bean.SerachHotMsgBean;
import com.example.playandroid.model.wx.WxModel;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 21:13
 * Describe: ${as}
 */
public class SearchPresenter extends BasePresenter<SearchView> {
    private WxModel model;
    public SearchPresenter(){
        model = new WxModel();
    }
    public void getHotMsg(){
        final Observable<SerachHotMsgBean> searchHotMsg = model.getSearchHotMsg();
        searchHotMsg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SerachHotMsgBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","SearchPresenterHot:OnError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(SerachHotMsgBean serachHotMsgBean) {

                        List<SerachHotMsgBean.DataBean> data = serachHotMsgBean.getData();
                        if(isAttach()){
                            getView().successHotMsg(data);
                        }
                    }
                });
    }
    public void getData(String key,int page){
        Observable<SearchDataBean> searchData = model.getSearchData(key, page);
        searchData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","SearchPresenterData:OnError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(SearchDataBean searchDataBean) {

                        List<Article> datas = searchDataBean.getData().getDatas();
                        if(isAttach()){
                            getView().successData(datas);
                        }
                    }
                });
    }
}
