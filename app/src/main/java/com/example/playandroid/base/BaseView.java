package com.example.playandroid.base;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 19:23
 * Describe: ${as}
 */
public interface BaseView<D> {

    void success(D data);
    void failess(String message);

}
