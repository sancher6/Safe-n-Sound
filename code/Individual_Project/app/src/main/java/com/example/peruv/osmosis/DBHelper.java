package com.example.peruv.osmosis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by peruv on 11/22/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //database version
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "safe.sqlite";
    //contacts table name
    private static final String TABLE_NAME = "contacts";
    //login table column names
    public static final String COLUMN_ID = "ID";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_USERNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop table
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);

        //creates table again
        onCreate(db);
    }
    public void addContact(contact contacts){
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        String query = "select * from contacts";
//        Cursor cursor = db.rawQuery(query,null);
//        int count = cursor.getCount();
//
//        contentValues.put(COLUMN_ID,COLUMN_ID);
        contentValues.put(COLUMN_USERNAME, contacts.getUsername());
        contentValues.put(COLUMN_PASSWORD, contacts.getPassword());
        db.insert(TABLE_NAME, null, contentValues);
//        cursor.close();
        db.close();
    }
    public String searchPass(String username){
        db = this.getReadableDatabase();
        String query = "string username, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String uname, pword;
        pword = "Not found";
        if(cursor.moveToFirst()){
            do{
                uname = cursor.getString(0);
                if(uname.equals(username)){
                    pword = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return pword;
    }
    public contact getContact(int id){
        db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{
                COLUMN_ID,COLUMN_USERNAME,COLUMN_PASSWORD}, COLUMN_ID + "=?",new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
            contact contacts = new contact(cursor.getString(1),cursor.getString(2));
            return contacts;
        }
        cursor.close();
        db.close();
        return null;
    }

}
