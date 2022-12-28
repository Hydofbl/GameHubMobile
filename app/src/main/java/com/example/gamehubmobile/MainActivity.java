package com.example.gamehubmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToGamePage(View v) {
        Intent intent = new Intent(this, GamePage.class);
        startActivity(intent);
        finish();
    }

    public void goToOptions(View v) {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
        finish();
    }

    public void goToHighScoreBoard(View v) {
        Intent intent = new Intent(this, HighScoreBoard.class);
        startActivity(intent);
        finish();
    }

    public void exit(View v) {
        System.exit(0);
    }
}