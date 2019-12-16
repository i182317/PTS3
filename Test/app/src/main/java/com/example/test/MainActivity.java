package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public ImageButton Winj2,Winj1;
    public MainActivity scoreActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreActivity=this;
        Winj1 =(ImageButton) findViewById(R.id.winJ1);
        Winj2 =(ImageButton) findViewById(R.id.winJ2);
        listenbutton();
    }

    private void listenbutton() {
        Winj1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentreplay = new Intent(scoreActivity,test.class);
                        intentreplay.putExtra("test",true);
                        scoreActivity.startActivity(intentreplay);
                        finish();
                    }
                });
        Winj2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentreplay = new Intent(scoreActivity,test.class);
                        intentreplay.putExtra("test",false);
                        scoreActivity.startActivity(intentreplay);

                        finish();
                    }
                });
    }
}
