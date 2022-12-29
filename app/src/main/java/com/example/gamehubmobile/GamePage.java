package com.example.gamehubmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gamehubmobile.adapters.GameCardAdapter;
import com.example.gamehubmobile.models.GameCardModel;

import java.util.ArrayList;

public class GamePage extends AppCompatActivity {

    ArrayList<GameCardModel> gameCardModels = new ArrayList<>();

    // Image'leri buraya koy sıraya göre.
    // isimlerini de strings içine ekle.
    int[] gameImages = {R.drawable.plane_1, R.drawable.black_jokerturned, R.drawable.closebtn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpGameCardModels();

        GameCardAdapter gameCardAdapter = new GameCardAdapter(this, gameCardModels);

        recyclerView.setAdapter(gameCardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpGameCardModels(){
        String[] gameNames = getResources().getStringArray(R.array.game_names);

        for (int i = 0; i < gameNames.length; i++) {
            gameCardModels.add(new GameCardModel(gameNames[i], gameImages[i]));
        }
    }
}