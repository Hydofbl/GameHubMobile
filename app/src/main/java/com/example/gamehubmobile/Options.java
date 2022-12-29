package com.example.gamehubmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Options extends AppCompatActivity {

    ImageButton soundButton;
    boolean isSoundOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        soundButton = (ImageButton) findViewById(R.id.soundOnOffButton);

        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        isSoundOn = pref.getBoolean("soundOnOff", false);

        if(isSoundOn){
            soundButton.setImageResource(R.drawable.soundonbtnsmall);
        }
        else{
            soundButton.setImageResource(R.drawable.soundoffbtnsmall);
        }

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSoundOn = pref.getBoolean("soundOnOff", false);
                SharedPreferences.Editor editor = pref.edit();
                if(isSoundOn){
                    soundButton.setImageResource(R.drawable.soundoffbtnsmall);
                    isSoundOn = false;
                    Toast.makeText(getApplicationContext(),"Sound Off",Toast.LENGTH_SHORT).show();
                }
                else{
                    soundButton.setImageResource(R.drawable.soundonbtnsmall);
                    isSoundOn = true;
                    Toast.makeText(getApplicationContext(),"Sound On",Toast.LENGTH_SHORT).show();
                }

                editor.putBoolean("soundOnOff", isSoundOn);
                editor.commit();
            }
        });
    }

    public void goBackToMainMenu(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}