package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.sportgame.R;
import com.example.sportgame.Variables;

public class SplacshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splacsh_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        Intent intent;
        Variables variables = new Variables();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(variables.getSharedLoginPref(), MODE_PRIVATE);
        String check = sharedPreferences.getString(variables.getLoginCheck(),"");
        if (check.equalsIgnoreCase("1")){
            intent  = new Intent(this,MainActivity.class);
        }
        else {
            intent = new Intent(this,Registration.class);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}