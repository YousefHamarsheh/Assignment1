package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.example.sportgame.R;
import com.example.sportgame.Variables;
import com.google.android.material.textfield.TextInputEditText;

public class EmailInput extends AppCompatActivity {

    private TextInputEditText input_email;
    private Variables variables = new Variables();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_input);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        input_email = findViewById(R.id.input_team);

    }

    public void emailSubmit(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(variables.getSharedLoginPref(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(variables.getLoginEmail(),input_email.getText().toString());
        editor.apply();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}