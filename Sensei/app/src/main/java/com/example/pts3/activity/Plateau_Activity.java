package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.pts3.R;
import com.example.pts3.classes.XmlEditor;

public class Plateau_Activity extends AppCompatActivity {

    private int gameMode;           // Mode de jeu selectionné : 1 = Arashi et 2 = Shizukana
    private XmlEditor xmlEditor;    // Permet de gérer le fichier xml des platreau
    private List<> tabPlateau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plateau_);

        // Récupération des données de l'Activité précéente
        Bundle extras = getIntent().getExtras();
        this.gameMode = extras.getInt("gameMode");

        // Gestion du fichier XML
        this.xmlEditor = new XmlEditor();

        // Lecture du fichier XML
        this.xmlEditor.read();
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
