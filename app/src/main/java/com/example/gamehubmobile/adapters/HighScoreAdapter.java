package com.example.gamehubmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamehubmobile.R;
import com.example.gamehubmobile.models.HighScoreModel;

import java.util.ArrayList;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.MyViewHolder>{
    Context context;
    ArrayList<HighScoreModel> highScoreModels;

    public HighScoreAdapter(Context context, ArrayList<HighScoreModel> highScoreModels) {
        this.context = context;
        this.highScoreModels = highScoreModels;
    }

    @NonNull
    @Override
    public HighScoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.highscore_recycler_row, parent, false);

        return new HighScoreAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HighScoreAdapter.MyViewHolder holder, int position) {
        holder.gameName.setText(highScoreModels.get(position).getGameName() + " : ");
        holder.gameHighScore.setText(highScoreModels.get(position).getHighScore());
    }

    @Override
    public int getItemCount() {
        return highScoreModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView gameName;
        TextView gameHighScore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            gameName = itemView.findViewById(R.id.gameNameText);
            gameHighScore = itemView.findViewById(R.id.gameHighScoreText);
        }
    }
}
