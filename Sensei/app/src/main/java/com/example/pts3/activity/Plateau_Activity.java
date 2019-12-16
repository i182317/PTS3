package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pts3.R;
import com.example.pts3.classes.Plateau;
import com.example.pts3.classes.XmlEditor;

public class Plateau_Activity extends AppCompatActivity {

    private Plateau_Activity plateau_Activity;  // Activity courrante
    private int gameMode;                       // Mode de jeu selectionné : 1 = Arashi et 2 = Shizukana
    private Button buttonPlateau1;              // Boutton du plateau 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plateau_);

        // Récupération des données de l'Activité précéente
        Bundle extras = getIntent().getExtras();
        this.gameMode = extras.getInt("gameMode");

        // Initialisation du bouttonPlateau1
        this.plateau_Activity = this;
        this.buttonPlateau1 = findViewById(R.id.buttonPlateau1);
        this.buttonPlateau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(plateau_Activity, Game_Activity.class);
                intent.putExtra("gameMode", gameMode);
                plateau_Activity.startActivity(intent);
                plateau_Activity.finish();
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
