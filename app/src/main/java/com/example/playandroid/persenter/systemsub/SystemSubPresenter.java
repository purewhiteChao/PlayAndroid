package com.example.playandroid.persenter.systemsub;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.bean.SystemSubBean;
import com.example.playandroid.model.wx.WxModel;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/12 0012
 * Time: 20:14
 * Describe: ${as}
 */
public class SystemSubPresenter extends BasePresenter<SystemSubView> {

    public void getData(int id,int page){
        Observable<SystemSubBean> systemSub = new WxModel().getSystemSub(id, page);
        systemSub.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SystemSubBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","SystemSubOnError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(SystemSubBean systemSubBean) {

                        List<SystemSubBean.DataBean.DatasBean> datas = systemSubBean.getData().getDatas();
                        if(isAttach()){
                            getView().success(datas);
                        }
//                        List<String> list = new ArrayList<>();
//                        for(int i=0;i<datas.size();i++){
//                            list.add(datas.get(i).getChapterName());
//                        }
//                        if(isAttach()){
//                            getView().successTitle(list);
//                        }
                    }
                });
    }
}
