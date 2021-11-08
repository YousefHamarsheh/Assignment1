package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sportgame.Model.Friend;
import com.example.sportgame.R;
import com.example.sportgame.Variables;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.util.ArrayList;

public class PlayerInsert extends AppCompatActivity {

    private TextInputEditText input_name;
    private TextInputEditText input_team;
    private Variables variables = new Variables();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_insert);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        input_name = findViewById(R.id.input_name);
        input_team = findViewById(R.id.input_team);


    }

    public void savePlayer(View view) {
        variables.getArr().add(new Friend(input_name.getText().toString(),input_team.getText().toString()));
        SharedPreferences sharedPreferences = getSharedPreferences(variables.getSharedSpinnerPref(),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(variables.getArr());
        editor.putString(variables.getSharedPlayersArraylistPref(),json);
        editor.apply();
        Intent intent = new Intent(this,Friends.class);
        startActivity(intent);
    }
}