package com.example.peruv.osmosis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Log extends AppCompatActivity {
    EditText logText;
    Button logButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        final EditText logtext = (EditText)findViewById(R.id.logText);
        Button logenter = (Button)findViewById(R.id.logButton);

        //sets resources button action
        logenter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String log = logtext.getText().toString();
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
