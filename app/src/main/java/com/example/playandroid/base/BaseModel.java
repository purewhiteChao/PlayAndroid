package com.example.playandroid.base;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 19:23
 * Describe: ${as}
 */
public abstract class BaseModel<C extends BaseCallBack> {

    protected abstract void get(C callback);
    protected abstract void post(C callback);
}
