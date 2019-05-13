package com.example.playandroid.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/11 0011
 * Time: 18:59
 * Describe: ${as}
 */
public class SPUtils {
    private static final SPUtils ourInstance = new SPUtils();
    private SharedPreferences sharedPreferences;

    public static SPUtils getInstance() {
        return ourInstance;
    }

    private SPUtils() {

    }
    public void init(Context context){
        sharedPreferences = context.getSharedPreferences("purewhite",Context.MODE_PRIVATE);
    }

    public void setStringSp(String key,String value){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,value);
        edit.commit();
    }
    public String getStringSp(String key,String defValue){
        return sharedPreferences.getString(key,defValue);
    }
    public void removeStringSp(String key){

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.commit();
    }
    public void clearAll(){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }
}
