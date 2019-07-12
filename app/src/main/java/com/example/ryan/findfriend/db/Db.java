package com.example.ryan.findfriend.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by harm on 2019/7/7.
 */
//String data=null,username=null,height=null,education=null,avatar=null;
//        int ageyear;

public class Db extends SQLiteOpenHelper {
    public Db(Context context) {
        super(context, "Db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(username TEXT DEFAULT \"\",height TEXT DEFAULT \"\",education TEXT DEFAULT\"\",avatar TEXT DEFAULT \"\",ageyear INT DEFAULT \"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
