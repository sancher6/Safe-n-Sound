package com.example.peruv.osmosis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

//-----------------------------------------------------------------------------------------
//
//  Function: activity_register class
//
//    Parameters:
//    NA
//
//    Pre-condition: Registration page is accessed
//-----------------------------------------------------------------------------------------
public class activity_register extends AppCompatActivity {
    myDbAdapter user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //casts variables to conduct an action
        final EditText username = (EditText)findViewById(R.id.usernameTextField);
        final EditText password = (EditText)findViewById(R.id.passwordTextField);
        final EditText reenterpw = (EditText)findViewById(R.id.reenterpassword);
        Button register = (Button)findViewById(R.id.registerButton);

        //-----------------------------------------------------------------------------------------
//
//  Function: registerButton
//
//    Parameters:
//    View
//
//    Pre-condition: register button is pressed
//    Post-condition: new user is added
//-----------------------------------------------------------------------------------------
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.registerButton){
                    String usernametext = username.getText().toString();
                    String passwordtext = password.getText().toString();
                    String reentertext = reenterpw.getText().toString();

                    if(passwordtext.equals(reentertext)){
                        user = new myDbAdapter(getApplicationContext());
                        user.insertData(usernametext,passwordtext);

                        Toast temp = Toast.makeText(activity_register.this,"Registered ", Toast.LENGTH_LONG);
                        temp.show();
                        startActivity(new Intent(activity_register.this,LoginMain.class));
                    }
                    else{
                        Toast temp = Toast.makeText(activity_register.this,"Passwords do not Match ", Toast.LENGTH_LONG);
                        temp.show();
                    }
                }
            }
        });
    }
}
