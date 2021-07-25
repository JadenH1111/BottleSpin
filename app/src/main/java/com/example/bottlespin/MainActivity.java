package com.example.bottlespin;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int fromDegrees = 0;
    ImageView bottle;
    boolean spinning;
    Random randy = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottle = findViewById(R.id.bottle);

    }

    public void spinBottle(View view) {
        if (spinning == false) {

        int toDegrees = randy.nextInt(200000) + 360;
        float pivotX = bottle.getWidth() / 2;
        float pivotY = bottle.getHeight() / 2;
        Animation rotate = new RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY);
        rotate.setDuration(100000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                spinning = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spinning = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fromDegrees = toDegrees;
        bottle.startAnimation(rotate);
    }
}
}