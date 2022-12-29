package com.example.gamehubmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.gamehubmobile.adapters.HighScoreAdapter;
import com.example.gamehubmobile.models.HighScoreModel;

import java.util.ArrayList;

public class HighScoreBoard extends AppCompatActivity {

    ArrayList<HighScoreModel> highScoreModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_board);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerViewHighScore);

        setUpHighScoreModels();

        HighScoreAdapter highScoreAdapter = new HighScoreAdapter(this, highScoreModels);

        recyclerView.setAdapter(highScoreAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpHighScoreModels(){
        String[] gameNames = getResources().getStringArray(R.array.game_names);
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        int gameHighScore;

        for (int i = 0; i < gameNames.length; i++) {
            gameHighScore = pref.getInt(gameNames[i], 0);
            highScoreModels.add(new HighScoreModel(gameNames[i], Integer.toString(gameHighScore)));
        }
    }

    public void goBackToMainMenu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}