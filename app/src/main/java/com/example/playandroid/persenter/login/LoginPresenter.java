package com.example.playandroid.persenter.login;

import android.util.Log;

import com.example.playandroid.base.BasePresenter;
import com.example.playandroid.model.wx.WxModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 15:39
 * Describe: ${as}
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private WxModel wxModel;

    public LoginPresenter(){
        wxModel = new WxModel();
    }

    public void postLogin(String username,String pwd){
        Observable<ResponseBody> responseBodyObservable = wxModel.postLogin(username, pwd);
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","loginPresenterLoginOnError"+e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseBody body) {

                        try {
                            getView().successLogin(body.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    public void postRegister(String username,String pwd,String repwd){
        Observable<ResponseBody> responseBodyObservable = wxModel.postRegister(username, pwd, repwd);
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.i("guochao","loginPresenterRegisterOnError"+e.getMessage());

                    }

                    @Override
                    public void onNext(ResponseBody body) {

                        try {
                            getView().successRegister(body.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


    }
    public void getLogout(){
        Observable<ResponseBody> logout = wxModel.getLogout();
        logout.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("guochao","loginPresenterLogoutOnError"+e.getMessage());

                    }

                    @Override
                    public void onNext(ResponseBody body) {

                        try {
                            getView().successLogout(body.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
