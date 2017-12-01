package com.example.peruv.osmosis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//-----------------------------------------------------------------------------------------
//
//  Function: Log class
//
//    Parameters:
//    NA
//
//    Pre-condition: Log button is pressed
//-----------------------------------------------------------------------------------------
public class Log extends AppCompatActivity {
    Button logButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        final EditText logText = (EditText)findViewById(R.id.logText);
        logButton = (Button)findViewById(R.id.logButton);

        //sets resources button action
        logButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String log = logText.getText().toString();
                if(log.equals("")){
                        Toast temp = Toast.makeText(Log.this,"No Journal Entry Recorded ", Toast.LENGTH_SHORT);
                        temp.show();
                }
                else{

                }
            }
        });
    }
}
