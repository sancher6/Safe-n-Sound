package com.example.peruv.osmosis;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//-----------------------------------------------------------------------------------------
//
//  Function: LoginMain class
//
//    Parameters:
//    NA
//
//    Pre-condition: activity is called
//-----------------------------------------------------------------------------------------
public class LoginMain extends AppCompatActivity {
    @Override
    //-----------------------------------------------------------------------------------------
//
//  Function: onCreate ()
//
//    Parameters:
//    Bundle
//
//    Pre-condition: LoginMain.java must be called to be created
//    Post-condition: Login page is displayed
//-----------------------------------------------------------------------------------------
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        EditText username = (EditText) findViewById(R.id.usernameTextField);
        EditText pass = (EditText) findViewById(R.id.passwordTextField);
    }
}