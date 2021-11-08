package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportgame.CalculateThread;
import com.example.sportgame.R;
import com.example.sportgame.Variables;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private int tokens = 0;
    private TextView tokens_txt;
    private TextView left_team;
    private TextView right_team;
    private Button next;
    private String[] arrPrem = {"MAN UN","Arsenal","MAN City","WestHam",
            "Spurs","FullHam","Liverpool","Chelsea","NewCastle","Everton",
            "Aston","WolverHam","Leeds","Leicester","Norwich",
            "Brentford","Crystal","Watford","Bernley","Brighton",
            "Southampton","Al-Nasr"};

    private String[] arrLalgia = {"Barcelona", "Real Bits", "Real Sociedad",
            "Vallecano", "Sevilla", "Athletic", "Getafe FC",
            "Geranada", "Atlatico Madrid", "Real Madrid", "Valencia"};


    private TextView name;
    Variables variables = new Variables();
    private ArrayList arr = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        getSupportActionBar().hide();

        score = findViewById(R.id.score);
        tokens_txt = findViewById(R.id.tokens);
        tokens_txt.setText("Tokens = " + tokens);

        left_team = findViewById(R.id.left_team);
        right_team = findViewById(R.id.right_team);
        left_team.setText(arrLalgia[0]);
        right_team.setText(arrPrem[0]);

        next = findViewById(R.id.next);
        next.setVisibility(View.GONE);

        name = findViewById(R.id.name);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(variables.getSharedLoginPref(), MODE_PRIVATE);
        String shared_name = sharedPreferences.getString(variables.getLoginUsername(), "");
        name.setText(shared_name);
    }

    //Left Button action
    public void left_team_action(View view) {
        if (next.getVisibility() == View.GONE){

            /*
            * Use of Thread is here*/
            CalculateThread calculateThread = new CalculateThread();
            calculateThread.start();
            String ans = calculateThread.getLeft_team_score() + "-" + calculateThread.getRight_team_score();



            String[] arrAns = ans.split("-");
            int left_team_score = Integer.parseInt(arrAns[0]);
            int right_team_score = Integer.parseInt(arrAns[1]);
            score.setText(ans);

            if(left_team_score > right_team_score){
                Toast.makeText(this,"You have won",Toast.LENGTH_SHORT).show();
                tokens = tokens + 50;
                tokens_txt.setText("Tokens = " + tokens);
            }
            else if (left_team_score == right_team_score){
                Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"You have lost",Toast.LENGTH_SHORT).show();
            }

            next.setVisibility(View.VISIBLE);
        }
        else{Toast.makeText(this,"Please press next",Toast.LENGTH_SHORT).show();}

    }



    //Right Button action
    public void right_team_action(View view) {
        if (next.getVisibility() == View.GONE){
            /*
             * Use of Thread is here*/
            CalculateThread calculateThread = new CalculateThread();
            calculateThread.start();
            String ans = calculateThread.getLeft_team_score() + "-" + calculateThread.getRight_team_score();


            String[] arrAns = ans.split("-");
            int left_team_score = Integer.parseInt(arrAns[0]);
            int right_team_score = Integer.parseInt(arrAns[1]);
            score.setText(ans);

            if(left_team_score < right_team_score){
                Toast.makeText(this,"You have won",Toast.LENGTH_SHORT).show();
                tokens = tokens + 50;
                tokens_txt.setText("Tokens = " + tokens);
            }
            else if (left_team_score == right_team_score){
                Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"You have lost",Toast.LENGTH_SHORT).show();
            }
            next.setVisibility(View.VISIBLE);
        }
        else{Toast.makeText(this,"Please press next",Toast.LENGTH_SHORT).show();}


    }

    //Calculating the score for each team
//    public String calculateScore(){
//        int minScore = 0;
//        int maxScore = 15;
//        int left_team_score = 0;
//        int right_team_score = 0;
//
//        left_team_score = new Random().nextInt(maxScore - minScore + 1) + minScore;
//        right_team_score = new Random().nextInt(maxScore - minScore + 1) + minScore;
//
//        return left_team_score + "-" + right_team_score;
//
//    }

    public void nextRound(View view) {
        left_team.setText(arrLalgia[new Random().nextInt(arrLalgia.length - (0 + 1)) + 0]);
        right_team.setText(arrPrem[new Random().nextInt(arrPrem.length - (0 + 1)) + 0]);
        score.setText("0-0");
        next.setVisibility(View.GONE);
    }

    public void nextProfilePage(View view) {
        Intent intent = new Intent(this,ProfilePage.class);
        startActivity(intent);
    }


    public void nextTrophies(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(variables.getSharedTokensPref(),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(variables.getSharedTokens(),String.valueOf(tokens));
        editor.apply();
        Intent intent = new Intent(this,TrophiesAddition.class);
        startActivity(intent);

    }



    public void nextFriends(View view) {
        Intent intent = new Intent(this,Friends.class);
        startActivity(intent);
    }
}