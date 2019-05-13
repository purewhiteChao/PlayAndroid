package com.example.playandroid.persenter.project;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.bean.ProjectContentBean;
import com.example.playandroid.model.bean.ProjectNameBean;
import com.example.playandroid.model.wx.WxModel;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 10:38
 * Describe: ${as}
 */
public class ProjectPresenter extends BasePresenter<ProjectView> {

    public void getNameData(){

        Observable<ProjectNameBean> projectNameBeanObservable = new WxModel().projectName();
        projectNameBeanObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProjectNameBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","ProjectOnError:"+e.getMessage());
                    }

                    @Override
                    public void onNext(ProjectNameBean projectNameBean) {

                        if(isAttach())
                        getView().success(projectNameBean.getData());
                    }
                });
    }

    public void getContentData(int id,int page){
        Observable<ProjectContentBean> projectContentBeanObservable = new WxModel().projectContent(id, page);
        projectContentBeanObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProjectContentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("guochao","ProjectConentOnError:"+e.getMessage());

                    }

                    @Override
                    public void onNext(ProjectContentBean projectContentBean) {

                        if(isAttach()){
                            getView().success(projectContentBean.getData().getDatas());
                        }
                    }
                });

    }
}
