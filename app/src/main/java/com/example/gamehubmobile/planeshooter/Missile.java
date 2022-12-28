package com.example.gamehubmobile.planeshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.gamehubmobile.GameViewPlaneShooter;
import com.example.gamehubmobile.R;

/**
 * Created by Recording on 11/3/2017.
 */

public class Missile {
    public int x;
    public int y;
    public int mVelocity;
    public Bitmap missile;
    public Missile(Context context){
        missile = BitmapFactory.decodeResource(context.getResources(), R.drawable.missile);
        x = GameViewPlaneShooter.dWidth/2 - getMissileWidth()/2;
        y = GameViewPlaneShooter.dHeight - GameViewPlaneShooter.tankHeight - getMissileHeight()/2;
        mVelocity = 50;
    }
    public int getMissileWidth(){
        return missile.getWidth();
    }
    public int getMissileHeight(){
        return missile.getHeight();
    }
}
