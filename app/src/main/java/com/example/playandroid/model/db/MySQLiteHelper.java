package com.example.playandroid.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 14:06
 * Describe: ${as}
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(@Nullable Context context) {
        super(context, "playandroid.db",null ,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+CollectTable.TAB_NAME+" ("+CollectTable.COL_TITLE+" text primary key,"+CollectTable.COL_AUTHOR+" text,"+CollectTable.COL_SUBTITLE+" text,"+CollectTable.COL_DATE+" text,"+CollectTable.COL_LINK+" text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
