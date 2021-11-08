package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sportgame.Model.Trohpy;
import com.example.sportgame.R;
import com.example.sportgame.Variables;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrophiesAddition extends AppCompatActivity {

    private ListView trophies_list;
    private ArrayList<String> arrTrophy = new ArrayList<>();
    private Variables variables = new Variables();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies_addition);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        trophies_list = findViewById(R.id.trophies_list);

        Trohpy[] arrObjectTrophy = {new Trohpy("Beginner",150),
                new Trohpy("Intermediate",250),
                new Trohpy("Advanced",400),
                new Trohpy("Expert",700)};


        SharedPreferences sharedPreferences =getApplicationContext().getSharedPreferences(variables.getSharedTokensPref(),MODE_PRIVATE);
        int tokens = 0;
        try {
            tokens = Integer.parseInt(sharedPreferences.getString(variables.getSharedTokens(),""));
        }catch (Exception e){
            tokens = 0;
        }

        for (int i = 0; i < arrObjectTrophy.length; i++){
            if (arrObjectTrophy[i].getTokens() <= tokens){
                arrTrophy.add(arrObjectTrophy[i].getName());
            }
        }



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrTrophy);
        trophies_list.setAdapter(arrayAdapter);
    }
}