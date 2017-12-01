package com.example.peruv.osmosis;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

//-----------------------------------------------------------------------------------------
//
//  Function: safensound class
//
//    Parameters:
//    NA
//
//    Pre-condition: Successful Login
//    Post-condition: Button is pressed to access different pages
//-----------------------------------------------------------------------------------------
public class SafenSound extends AppCompatActivity {
    //initialize db
    myDbAdapter myDb;
    //initialize variables
    Button panicButton,resourcesButton,leavealogButton,calendarButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safen_sound);
        //casts variables to conduct an action
        myDb = new myDbAdapter(this);
        Button panic = (Button)findViewById(R.id.panicButton);
        Button resources = (Button)findViewById(R.id.resourcesButton);
        Button leavelog = (Button)findViewById(R.id.leavealogButton);
        Button calendar = (Button)findViewById(R.id.calendarButton);

        //sets resources button action
        resources.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SafenSound.this,Resources.class));
            }
        });
        //sets leave a log button action
        leavelog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SafenSound.this,Log.class));
            }
        });
        //sets calendar button
        calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SafenSound.this,Calendar.class));
            }
        });
        //-----------------------------------------------------------------------------------------
//
//  Function: panicButton
//
//    Parameters:
//    NA
//
//    Pre-condition: Panic button is pressed
//    Post-condition: Phone # is called
//-----------------------------------------------------------------------------------------
        panic.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        dialContactPhone("911");
                    }
                }
        );
    }

    private void dialContactPhone(final String phoneNumber){
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber,null)));
    }
}
