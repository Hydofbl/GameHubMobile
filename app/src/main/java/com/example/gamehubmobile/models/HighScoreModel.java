package com.example.gamehubmobile.models;

public class HighScoreModel {
    String gameName;
    String highScore;
    String scoreType;

    public HighScoreModel(String gameName, String highScore, String scoreType) {
        this.gameName = gameName;
        this.highScore = highScore;
        this.scoreType = scoreType;
    }

    public String getGameName() {
        return gameName;
    }

    public String getHighScore() {
        return highScore;
    }

    public String getScoreType() {
        return scoreType;
    }
}
