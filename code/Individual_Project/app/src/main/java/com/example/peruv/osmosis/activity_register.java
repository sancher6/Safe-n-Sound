package com.example.peruv.osmosis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class activity_register extends AppCompatActivity {
    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myDb = new DBHelper(this);
        //casts variables to conduct an action
        final EditText username = (EditText)findViewById(R.id.usernameTextField);
        final EditText password = (EditText)findViewById(R.id.passwordTextField);
        final EditText reenterpw = (EditText)findViewById(R.id.reenterpassword);
        Button register = (Button)findViewById(R.id.registerButton);

        //sets up register button
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.registerButton){
                    String usernametext = username.getText().toString();
                    String passwordtext = password.getText().toString();
                    String reentertext = reenterpw.getText().toString();

                    if(passwordtext.equals(reentertext)){
                        contact newContact = new contact(usernametext,passwordtext);
                        myDb.addContact(newContact);
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
