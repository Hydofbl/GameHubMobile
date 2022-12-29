package com.example.gamehubmobile.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamehubmobile.R;
import com.example.gamehubmobile.StartCardGame;
import com.example.gamehubmobile.StartPlaneShooter;
import com.example.gamehubmobile.StartTicTacToe;
import com.example.gamehubmobile.models.GameCardModel;

import java.util.ArrayList;

public class GameCardAdapter extends RecyclerView.Adapter<GameCardAdapter.MyViewHolder> {
    Context context;
    ArrayList<GameCardModel> gameCardModels;

    public GameCardAdapter(Context context, ArrayList<GameCardModel> gameCardModels){
        this.context = context;
        this.gameCardModels = gameCardModels;
    }

    @NonNull
    @Override
    public GameCardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new GameCardAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameCardAdapter.MyViewHolder holder, int position) {
        holder.gameName.setText(gameCardModels.get(position).getGameName());
        holder.gameImageView.setImageResource(gameCardModels.get(position).getImage());

        holder.gameImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int adapterPos = holder.getAdapterPosition();
                if(adapterPos==0){
                    Intent intent = new Intent(context, StartPlaneShooter.class);
                    //intent.putExtra("gameName", gameCardModels.get(adapterPos).getGameName());
                    context.startActivity(intent);
                }
                else if(adapterPos==1){
                    Intent intent = new Intent(context, StartCardGame.class);
                    context.startActivity(intent);
                }
                else if(adapterPos==2){
                    Intent intent = new Intent(context, StartTicTacToe.class);
                    context.startActivity(intent);
                }
                else{
                    // open Third Activity
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return gameCardModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView gameImageView;
        TextView gameName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            gameImageView = itemView.findViewById(R.id.gameImageView);
            gameName = itemView.findViewById(R.id.gameNameText);
        }
    }
}
