package com.example.gamehubmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
    }

    public void startPlaneShooter(View v) {
        Intent intent = new Intent(this, StartTicTacToe.class);
        startActivity(intent);
        finish();
    }
}