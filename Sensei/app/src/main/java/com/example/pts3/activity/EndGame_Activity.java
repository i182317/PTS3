package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pts3.R;

public class EndGame_Activity extends AppCompatActivity {
    public TextView textJ1,textJ2;
    private boolean test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_);
        textJ1 = (TextView) findViewById(R.id.textJ1);
        textJ2 = (TextView) findViewById(R.id.textJ2);

        Intent intent = getIntent();
        test=intent.getBooleanExtra("test",false);
        if(test){
            textJ1.setText("J1 WIN");
            textJ2.setText("J2 LOOSE");
        }else {
            textJ2.setText("J2 WIN");
            textJ1.setText("J1 LOOSE");
        }

    }
}
