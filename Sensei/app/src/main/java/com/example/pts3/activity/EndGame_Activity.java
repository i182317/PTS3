package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pts3.R;

public class EndGame_Activity extends AppCompatActivity {
    public TextView textJ1,textJ2;
    private ImageView imageViewReplay;
    private boolean test;
    private int screenWidth;
    private int screenHeight;
    private ConstraintLayout screenReplay;
    private EndGame_Activity endGame_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_);
        textJ1 = (TextView) findViewById(R.id.textJ1);
        textJ2 = (TextView) findViewById(R.id.textJ2);
        screenReplay=(ConstraintLayout) findViewById(R.id.screenReplay);
        endGame_activity=this;
        Intent intent = getIntent();
        test=intent.getBooleanExtra("test",false);
        if(test){
            textJ1.setText("J1 WIN");
            textJ2.setText("J2 LOOSE");
        }else {
            textJ2.setText("J2 WIN");
            textJ1.setText("J1 LOOSE");
        }
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        imageViewReplay = new ImageView(this);
        imageViewReplay.setX(screenWidth/2);
        imageViewReplay.setY(screenHeight/2);
        imageViewReplay.setMaxWidth(screenWidth/4);
        imageViewReplay.setMaxHeight(screenHeight/4);
        imageViewReplay.setBackgroundResource(R.drawable.perso_rouge);
        ViewGroup.LayoutParams replay = new ViewGroup.LayoutParams(screenWidth/6,screenHeight/12);
        imageViewReplay.setLayoutParams(replay);

        screenReplay.addView(imageViewReplay);

        testTouchListener();

    }

    private void testTouchListener() {
        imageViewReplay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentreplay = new Intent(endGame_activity,Game_Activity.class);
                        endGame_activity.startActivity(intentreplay);
                        finish();
                    }
                });
    }
}
