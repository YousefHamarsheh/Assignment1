package com.example.sportgame;

import java.util.Random;

public class CalculateThread extends Thread{
    private int minScore = 0;
    private int maxScore = 6;
    private static int left_team_score = 0;
    private static int right_team_score = 0;


    

    @Override
    public void run() {
        left_team_score = new Random().nextInt(maxScore - minScore + 1) + minScore;
        right_team_score = new Random().nextInt(maxScore - minScore + 1) + minScore;

    }


    public int getMinScore() {
        return minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getLeft_team_score() {
        return left_team_score;
    }

    public int getRight_team_score() {
        return right_team_score;
    }
}
