package com.example.gamehubmobile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverPageActivity extends AppCompatActivity {

    TextView tvScore, tvPersonalBest, tvGameName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        String gameName = getIntent().getExtras().getString("gameName");
        int score = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        int scoreSP = pref.getInt("scoreSP", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(score > scoreSP){
            scoreSP = score;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
        }
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvPersonalBest = (TextView) findViewById(R.id.tvPersonalBest);
        tvGameName = (TextView) findViewById(R.id.tvGameName);
        tvGameName.setText("Personal best for " + gameName + ": ");
        tvScore.setText(""+score);
        tvPersonalBest.setText(""+scoreSP);
    }
    public void restart(View view){
        finish();
    }
    public void home(View view){
        Intent intent = new Intent(GameOverPageActivity.this, GamePage.class);
        startActivity(intent);
        finish();
    }
}