package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportgame.Model.Friend;
import com.example.sportgame.R;
import com.example.sportgame.Variables;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Friends extends AppCompatActivity {

    private Button add_btn;
    private TextView friends_team;
    private TextView name_label;
    private TextView friends_name;
    private TextView team_label;
    private Spinner friends_spinner;
    private Variables variables = new Variables();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        add_btn = findViewById(R.id.add_btn);
        friends_team = findViewById(R.id.friends_team);
        friends_name = findViewById(R.id.friends_name);
        team_label = findViewById(R.id.team_label);
        name_label = findViewById(R.id.name_label);
        friends_spinner = findViewById(R.id.friends_spinner);
        friends_spinner.setPrompt("Pick One");

        ArrayAdapter<Friend> spinnerArrayAdapter = new ArrayAdapter<Friend>
                (this, android.R.layout.simple_spinner_item,
                        variables.getArr());
        friends_spinner.setAdapter(spinnerArrayAdapter);


        String name = "";
        String team = "";
        try {
            String[] arr_nameTeam = friends_spinner.getSelectedItem().toString().split(" ");
            name = arr_nameTeam[0];
            team = arr_nameTeam[1];
        }catch (Exception e){
            name = "";
            team = "";
        }

        friends_team.setText(name);
        friends_name.setText(team);


        friends_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String name = "";
                String team = "";
                try {
                    String[] arr_nameTeam = friends_spinner.getSelectedItem().toString().split(",");
                    name = arr_nameTeam[0];
                    team = arr_nameTeam[1];
                }catch (Exception e){
                    name = "";
                    team = "";
                }

                friends_team.setText(name);
                friends_name.setText(team);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void add_player(View view) {
        Intent intent = new Intent(this,PlayerInsert.class);
        startActivity(intent);
    }



    public void load(View view) {
        Toast.makeText(this,"Information Upload",Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences = getSharedPreferences(variables.getSharedSpinnerPref(),MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(variables.getSharedPlayersArraylistPref(),"");
        Type type = new TypeToken<ArrayList<Friend>>() {}.getType();
        variables.setArr(gson.fromJson(json,type));
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}