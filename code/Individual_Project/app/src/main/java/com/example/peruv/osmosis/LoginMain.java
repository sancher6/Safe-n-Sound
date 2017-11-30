package com.example.peruv.osmosis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMain extends AppCompatActivity {
    //initialize variables
    DBHelper myDb;
    EditText username,password;
    Button signin,register,enterguest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        //creates instance of database
        this.myDb = myDb;

        //casts variables to conduct an action
        final EditText  username = (EditText)findViewById(R.id.usernameTextField);
        final EditText password = (EditText)findViewById(R.id.passwordTextField);
        Button signin = (Button)findViewById(R.id.signinButton);
        Button register = (Button)findViewById(R.id.registerButton);
        Button enterguest = (Button)findViewById(R.id.enterguestButton);
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
                    String passwordtext = password.getText().toString();

//                    String passwordcheck = myDb.searchPass(usernametext);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
