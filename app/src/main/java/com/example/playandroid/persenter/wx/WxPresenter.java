package com.example.playandroid.persenter.wx;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.BaseResponse;
import com.example.playandroid.model.bean.WxContentBean;
import com.example.playandroid.model.bean.WxNameBean;
import com.example.playandroid.model.wx.WxModel;
import com.example.playandroid.utils.RxUtils;
import com.example.playandroid.view.fragment.wx.WxTabManager;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/10 0010
 * Time: 16:26
 * Describe: ${as}
 */
public class WxPresenter extends BasePresenter<WxView> {


    public void getData() {
        Observable<WxNameBean> observable = new WxModel().WxName();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WxNameBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","WxPresenter:OnError"+e.getMessage());
                    }

                    @Override
                    public void onNext(WxNameBean wxNameBean) {

                        if(isAttach()) {
                            getView().success(wxNameBean.getData());
                        }
                    }
                });
    }

    public void getContentData(int id,int page){
        Observable<WxContentBean> wxContentBeanObservable = new WxModel().WxContentBean(id, page);
        wxContentBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WxContentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("guochao","WxPresenterContent:OnError"+e.getMessage());

                    }

                    @Override
                    public void onNext(WxContentBean wxContentBean) {

                        Log.i("guochao","contentonNext"+wxContentBean.getData().getDatas().size());
                        if(isAttach()){
                            getView().success(wxContentBean.getData().getDatas());

                        }
                    }
                });
    }
}
