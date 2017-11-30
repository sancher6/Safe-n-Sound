package com.example.peruv.osmosis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

public class WaterTracker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tracker);
        //casts variables to conduct an action
        final EditText wateramt = (EditText) findViewById(R.id.enterwaterText);
        Button enter = (Button) findViewById(R.id.enterButton);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.enterButton) {
                    String water = wateramt.getText().toString();
                    if(Integer.parseInt(water) >= 64) {
                        Toast temp = Toast.makeText(WaterTracker.this, "Congratulations!! You drank " + water + " ounces of Water!", Toast.LENGTH_SHORT);
                        temp.show();
                    }
                    else{
                        Toast temp = Toast.makeText(WaterTracker.this, "Oh No! You only drank " + water + " ounces of Water!", Toast.LENGTH_SHORT);
                        temp.show();
                    }
                }
            }
        });
    }
}
