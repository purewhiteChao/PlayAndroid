package com.example.playandroid.base;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/9 0009
 * Time: 19:23
 * Describe: ${as}
 */
public abstract class BasePresenter<V extends BaseView> {
    V view;

    public void attachView(V view){
        this.view = view;
    }

    public void deachView(){
        this.view = null;
    }

    public boolean isAttach(){
        return view!=null;
    }
    public V getView(){
        return view;
    }
}
