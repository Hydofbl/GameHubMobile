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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        soundButton = (ImageButton) findViewById(R.id.soundOnOffButton);

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("MyPref", 0);
                boolean soundOnOff = pref.getBoolean("soundOnOff", false);
                SharedPreferences.Editor editor = pref.edit();
                if(soundOnOff){
                    soundButton.setImageResource(R.drawable.soundoffbtnsmall);
                    soundOnOff = false;
                    Toast.makeText(getApplicationContext(),"Sound Off",Toast.LENGTH_SHORT).show();
                }
                else{
                    soundButton.setImageResource(R.drawable.soundonbtnsmall);
                    soundOnOff = true;
                    Toast.makeText(getApplicationContext(),"Sound On",Toast.LENGTH_SHORT).show();
                }

                editor.putBoolean("soundOnOff", soundOnOff);
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