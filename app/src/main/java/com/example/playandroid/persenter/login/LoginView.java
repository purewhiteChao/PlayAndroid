package com.example.playandroid.persenter.login;

import com.example.playandroid.base.BaseView;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 15:34
 * Describe: ${as}
 */
public interface LoginView extends BaseView<String> {
    void successLogin(String data);
    void successRegister(String data);
    void successLogout(String data);
}
