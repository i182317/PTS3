package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pts3.R;

public class Mode_Activity extends AppCompatActivity {

    // Variables
    private Button buttonArashi;
    private Button buttonShizukana;
    private int gameMode; // Mode de jeu selectionné : 1 = Arashi et 2 = Shizukana
    private Mode_Activity mode_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_activity);

        this.mode_activity = this;

        // Initialisation des buttons
        this.buttonArashi = (Button) findViewById(R.id.buttonArashi);
        this.buttonShizukana = (Button) findViewById(R.id.buttonShizukana);

        this.buttonArashi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mode_activity, Plateau_Activity.class);
                mode_activity.startActivity(intent);
            }
        });

        this.buttonShizukana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mode_activity, Plateau_Activity.class);
                mode_activity.startActivity(intent);
            }
        });

    }

    // Mise en plein écran :
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if(hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | decorView.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}

