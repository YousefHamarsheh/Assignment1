package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sportgame.R;
import com.example.sportgame.Variables;
import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {

    private TextInputEditText input_name;
    private TextInputEditText input_email;

    Variables variables = new Variables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        input_name = findViewById(R.id.input_name);
        input_email = findViewById(R.id.input_team);


    }

    //When the user enter the application using the guest user
    public void nextMainGuest(View view) {
        saveData("Guest", "None");
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Submit button when user enters information
    public void nextMainUser(View view) {
        saveData(input_name.getText().toString(), input_email.getText().toString());
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void saveData(String name, String email){
        SharedPreferences sharedPreferences = getSharedPreferences(variables.getSharedLoginPref(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(variables.getLoginUsername(), name);
        editor.putString(variables.getLoginEmail(), email);
        editor.putString(variables.getLoginCheck(),"1");

        editor.apply();
    }


    //Help button message that will show a notification to the user
    public void helpMSG(View view) {
        Toast.makeText(this,"Please call DR. SAMER Zain",Toast.LENGTH_LONG);
    }
}