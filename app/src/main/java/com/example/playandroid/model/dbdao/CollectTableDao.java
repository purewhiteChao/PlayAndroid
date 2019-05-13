package com.example.playandroid.model.dbdao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.playandroid.model.bean.CollectBean;
import com.example.playandroid.model.db.CollectTable;
import com.example.playandroid.model.db.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2019/5/13 0013
 * Time: 14:18
 * Describe: ${as}
 */
public class CollectTableDao {
    MySQLiteHelper mySQLiteHelper;
    public CollectTableDao(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public void insertDao(ContentValues values){

        SQLiteDatabase writableDatabase = mySQLiteHelper.getWritableDatabase();
        try {
            writableDatabase.replace(CollectTable.TAB_NAME,null,values);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writableDatabase.close();
        }

    }
    public void deleteDao(String value){
        SQLiteDatabase writableDatabase = mySQLiteHelper.getWritableDatabase();
        try {
            writableDatabase.delete(CollectTable.TAB_NAME,CollectTable.COL_TITLE, new String[]{value});
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            writableDatabase.close();
        }

    }
    public List<CollectBean> selectDao(){
        SQLiteDatabase readableDatabase = mySQLiteHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("select * from " + CollectTable.TAB_NAME, null);
        List<CollectBean> list = new ArrayList<>();
        while(cursor.moveToNext()){
            CollectBean bean = new CollectBean();
            bean.setTltle(cursor.getString(cursor.getColumnIndex(CollectTable.COL_TITLE)));
            bean.setAuthor(cursor.getString(cursor.getColumnIndex(CollectTable.COL_AUTHOR)));
            bean.setDate(cursor.getString(cursor.getColumnIndex(CollectTable.COL_DATE)));
            bean.setSubname(cursor.getString(cursor.getColumnIndex(CollectTable.COL_SUBTITLE)));
            bean.setLink(cursor.getString(cursor.getColumnIndex(CollectTable.COL_LINK)));
            list.add(bean);
        }
        cursor.close();
        readableDatabase.close();
        return list;
    }
}
