package com.example.peruv.osmosis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by peruv on 11/22/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "safe.db";
    //contacts table name
    private static final String TABLE_NAME = "login";
    //login table column names
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_CREATE = "create table login (username text not null, " + "password text not null);";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        //this.db = db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop table
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);

        //creates table again
        this.onCreate(db);
    }
}
