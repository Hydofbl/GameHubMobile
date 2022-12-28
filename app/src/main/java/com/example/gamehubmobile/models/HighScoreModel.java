package com.example.gamehubmobile.models;

public class HighScoreModel {
    String gameName;
    String highScore;

    public HighScoreModel(String gameName, String highScore) {
        this.gameName = gameName;
        this.highScore = highScore;
    }

    public String getGameName() {
        return gameName;
    }

    public String getHighScore() {
        return highScore;
    }
}
