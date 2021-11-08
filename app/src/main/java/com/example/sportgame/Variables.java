package com.example.sportgame;

import com.example.sportgame.Model.Friend;

import java.util.ArrayList;

public class Variables {

    private static final String SHARED_LOGIN_PREF = "sharedLogin";
    private static final String LOGIN_USERNAME = "username";
    private static final String LOGIN_EMAIL = "email";
    private static final String LOGIN_CHECK = "checkLogin";

    private static final String SHARED_SPINNER_PREF = "sharedSpinner";
    private static final String SHARED_PLAYERS_ARRAYLIST_PREF = "arrPlayersShared";


    private static final String SHARED_TOKENS_PREF = "sharedTokensPref";
    private static final String SHARED_TOKENS = "sharedTokens";

    private static ArrayList<Friend> arr = new ArrayList<>();



    public Variables() {}


    public String getSharedLoginPref() {
        return SHARED_LOGIN_PREF;
    }

    public String getLoginUsername() {
        return LOGIN_USERNAME;
    }

    public String getLoginEmail() {
        return LOGIN_EMAIL;
    }

    public String getLoginCheck() {
        return LOGIN_CHECK;
    }

    public String getSharedSpinnerPref() {
        return SHARED_SPINNER_PREF;
    }

    public String getSharedPlayersArraylistPref() {
        return SHARED_PLAYERS_ARRAYLIST_PREF;
    }

    public String getSharedTokensPref() {
        return SHARED_TOKENS_PREF;
    }

    public String getSharedTokens() {
        return SHARED_TOKENS;
    }

    public ArrayList<Friend> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Friend> arr) {
        Variables.arr = arr;
    }
}
