package com.example.playandroid;

import android.app.Application;
import android.content.Context;

import com.example.playandroid.utils.SPUtils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 18:56
 * Describe: ${as}
 */
public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.context;
        SPUtils.getInstance().init(this);
    }

    public static Context getContext(){
        return context;
    }
}
