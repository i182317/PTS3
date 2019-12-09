package com.example.pts3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pts3.R;
import com.example.pts3.classes.Game;
import com.example.pts3.classes.Plateau;
import com.example.pts3.classes.XmlEditor;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

public class Game_Activity extends AppCompatActivity {

    public Game_Activity activity;
    private ConstraintLayout fenetrePrincipale;
    public LinearLayout aff;
    public Point size;
    private Handler myHandler;
    private Game game;
    private boolean plateau_set = false;

    private int num_plateau = 1;
    private boolean regleAntiJeu = true;
    private boolean modeArashi = false;

    public Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            if(!plateau_set) size.set(fenetrePrincipale.getWidth(), fenetrePrincipale.getHeight());

            if(!plateau_set && size.x != 0 && size.y != 0) {
                game.getPlateau().setPlateau();
                plateau_set = true;
            }

            if(plateau_set) {
                launch(game);
            }

            if(size.x == 0 && size.y == 0) myHandler.postDelayed(this, 1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        activity = this;

        fenetrePrincipale = (ConstraintLayout) findViewById(R.id.fenetrePrincipale);

        aff = (LinearLayout) findViewById(R.id.aff);

        size = new Point();

        XmlEditor xml = new XmlEditor("plateaux.xml", activity, aff);
        List<Plateau> listPlateau;
        Plateau p;

        try {
            listPlateau = xml.read();
            p = listPlateau.get(num_plateau);

            game = new Game(p, regleAntiJeu, modeArashi, activity);

            System.out.println("fin onCreate");
        }
        catch (JDOMException e) {
            finishActivity(-1);
        }
        catch (IOException i) {
            finishActivity(-1);
        }

        myHandler = new Handler();

        fenetrePrincipale.setOnTouchListener(touchListener);
    }

    private List<int[]> click_corect_coord = null;
    private int[] click_coord = null;

    public View.OnTouchListener touchListener = new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_UP && game.getWinner() == null && game.getAntiJeu() == null) {
                if(game.getPlateau().click_in_plateau(event)) {
                    int[] coord_click = game.getPlateau().get_coord_click(event);

                    if(click_corect_coord == null) {
                        System.out.println(coord_click[0] + "  " + coord_click[1]);
                        if (game.correctCoord(coord_click)) {
                            System.out.println("correct coord");
                            click_corect_coord = game.getCoordMoov(coord_click);
                        }
                        click_coord = coord_click.clone();
                    }
                    else {
                        for(int[] coordWantMoov : click_corect_coord) {
                            if(coord_click[0] == coordWantMoov[0] && coord_click[1] == coordWantMoov[1]) {
                                game.moov(click_coord, coordWantMoov);
                            }
                        }

                        click_coord = null;
                        click_corect_coord = null;
                    }
                }
                else {
                    click_coord = null;
                    click_corect_coord = null;
                }
                game.haveWinner();
                game.antiJeu();
                if(!game.playerCanPlay()) game.nextTurn();
                game.drawPlateau(click_corect_coord);
            }
            return  true;
        }
    };

    private void launch(Game game) {
        game.drawPlateau(null);
    }

    @Override
    public void onResume() {
        super.onResume();
        myHandler.postDelayed(myRunnable, 1);
    }

    @Override
    public void onPause() {
        super.onPause();
        if(myHandler != null) {
            myHandler.removeCallbacks(myRunnable);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();

        if(hasFocus) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_IMMERSIVE);
        }
    }
}
