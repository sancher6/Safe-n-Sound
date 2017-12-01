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
    EditText username, Pass , updateold, updatenew, delete;
    myDbAdapter helper;
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
        username= (EditText) findViewById(R.id.usernameTextField);
        Pass= (EditText) findViewById(R.id.passwordTextField);
        Button signin = (Button)findViewById(R.id.signinButton);
        Button register = (Button)findViewById(R.id.registerButton);
        Button enterguest = (Button)findViewById(R.id.enterguestButton);

        helper = new myDbAdapter(this);
        //adds functionality to enter guest button
        enterguest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginMain.this,WaterTracker.class));
            }
        });
        //adds functionality to register button
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginMain.this,activity_register.class));
            }
        });
        //adds functionality to login button
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.signinButton) {
                    String usernametext = username.getText().toString();
                    String passwordtext = Pass.getText().toString();

//                    String passwordcheck = helper.searchPass(usernametext);
//                    if(passwordtext.equals(passwordcheck)){
//                        startActivity(new Intent(LoginMain.this,SafenSound.class));
//                    }
//                    else{
//                        Toast temp = Toast.makeText(LoginMain.this,"Incorrect Parameters", Toast.LENGTH_SHORT);
//                        temp.show();
//                    }
                    if(passwordtext.equals("") || usernametext.equals("")){
                        Toast temp = Toast.makeText(LoginMain.this,"Please enter a Username and Password", Toast.LENGTH_SHORT);
                        temp.show();
                    }
                    else if(passwordtext.equals("se415") && usernametext.equals("student")){
                        startActivity(new Intent(LoginMain.this,SafenSound.class));
                    }
                    else{
                        Toast temp = Toast.makeText(LoginMain.this,"Incorrect Parameters", Toast.LENGTH_SHORT);
                        temp.show();
                    }
                }
            }
        });
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: addUser ()
//
//    Parameters:
//    View
//
//    Pre-condition: addUser method is called
//    Post-condition: User is successfully added
//-----------------------------------------------------------------------------------------
    public void addUser(View view)
    {
        String t1 = username.getText().toString();
        String t2 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Both Name and Password");
        }
        else
        {
            long id = helper.insertData(t1,t2);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Insertion Unsuccessful");
                username.setText("");
                Pass.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                username.setText("");
                Pass.setText("");
            }
        }
    }
    //-----------------------------------------------------------------------------------------
//
//  Function: viewData ()
//
//    Parameters:
//    View
//
//    Pre-condition: viewData method is called to view contents of the table within
//                   the database.
//    Post-condition: Data is all successfully displayed
//-----------------------------------------------------------------------------------------
    public void viewdata(View view)
    {
        String data = helper.getData();
        Message.message(this,data);
    }
}