package com.example.sportgame.Model;

public class Trohpy {
    private String name;
    private int tokens;

    public Trohpy(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
