package com.example.sportgame.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sportgame.R;
import com.example.sportgame.Variables;

public class ProfilePage extends AppCompatActivity {

    private TextView name_profile;
    private TextView email_profile;
    private Button edit_email;
    private Button edit_name;
    private Button profilePage_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        name_profile = findViewById(R.id.name_profile);
        email_profile = findViewById(R.id.email_profile);
        edit_email = findViewById(R.id.edit_email);
        edit_name = findViewById(R.id.edit_name);
        profilePage_login = findViewById(R.id.profilepage_login);

        Variables variables = new Variables();

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(variables.getSharedLoginPref(),MODE_PRIVATE);
        String shared_name = sharedPreferences.getString(variables.getLoginUsername(),"");
        String shared_email = sharedPreferences.getString(variables.getLoginEmail(),"");

        name_profile.setText("Name: " + shared_name);
        email_profile.setText("Email: " + shared_email);

        if (shared_name.equalsIgnoreCase("Guest")){
            edit_name.setVisibility(View.GONE);
            edit_email.setVisibility(View.GONE);
        }else {
            profilePage_login.setVisibility(View.GONE);
        }
    }

    //Login Button when the user is guest
    public void login_user_profile(View view) {
        Intent intent = new Intent(this,Registration.class);
        startActivity(intent);
    }


    public void nextEmailPref(View view) {
        Intent intent = new Intent(this,EmailInput.class);
        startActivity(intent);
    }

    public void nextNamePref(View view) {
        Intent intent = new Intent(this,NameInput.class);
        startActivity(intent);
    }
}