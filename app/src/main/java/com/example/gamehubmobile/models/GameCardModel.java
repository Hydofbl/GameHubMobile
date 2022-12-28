package com.example.gamehubmobile.models;

public class GameCardModel {
    String gameName;
    int image;

    public GameCardModel(String gameName, int image) {
        this.gameName = gameName;
        this.image = image;
    }

    public String getGameName() {
        return gameName;
    }

    public int getImage() {
        return image;
    }
}
