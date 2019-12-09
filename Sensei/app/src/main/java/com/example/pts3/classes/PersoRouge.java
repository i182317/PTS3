package com.example.pts3.classes;

import android.widget.ImageView;

import com.example.pts3.R;
import com.example.pts3.activity.Game_Activity;
import com.example.pts3.interfaces.IPerso;
import com.example.pts3.interfaces.IPiece;

class PersoRouge implements IPerso {

    private ImageView img;
    private char drawable = 'R';

    public PersoRouge(Game_Activity activity) {
        super();

        img = new ImageView(activity);
        img.setBackgroundResource(R.drawable.perso_rouge);
    }

    @Override
    public char getDrawable() {
        return drawable;
    }

    @Override
    public ImageView getImage() {
        return img;
    }
}
