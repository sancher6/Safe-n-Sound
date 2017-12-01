package com.example.peruv.osmosis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by peruv on 11/30/2017.
 */

//-----------------------------------------------------------------------------------------
//
//  Function: myDbAdapter class
//
//    Parameters:
//    NA
//
//    Pre-condition: app is opened
//    Post-condition: database is created
//-----------------------------------------------------------------------------------------
public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: insertData ()
//
//    Parameters:
//    String name, String pass
//
//    Pre-condition: insertData method is called with correct datatypes
//    Post-condition: data is inserted to database
//-----------------------------------------------------------------------------------------
    public long insertData(String name, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: searchPass ()
//
//    Parameters:
//    String username
//
//    Pre-condition: searchPass method is called with correct datatypes
//    Post-condition: password is returned
//-----------------------------------------------------------------------------------------
    public String searchPass(String username){
        SQLiteDatabase db = myhelper.getReadableDatabase();
        System.out.printf("before query");
        String query = "SELECT * FROM " + myDbHelper.TABLE_NAME + " WHERE " + myDbHelper.NAME;
        Cursor cursor = db.rawQuery(query,null);
        String uname, pword;
        pword = "Not found";
        System.out.printf("after query");
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
        System.out.printf("cursor is done");
        cursor.close();
        db.close();
        return pword;
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: getData ()
//
//    Parameters:
//    NA
//
//    Pre-condition: getData method is called
//    Post-condition: all data in database is displayed
//-----------------------------------------------------------------------------------------
    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid+ "   " + name + "   " + password +" \n");
        }
        cursor.close();
        return buffer.toString();
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: myDbHelper class
//
//    Parameters:
//    NA
//
//    Pre-condition: database is attempted to be created
//    Post-condition: database is created
//-----------------------------------------------------------------------------------------
    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String MyPASSWORD= "Password";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+ MyPASSWORD+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }

}