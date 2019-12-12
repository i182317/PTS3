package com.example.pts3.classes;

import android.widget.ImageView;

import com.example.pts3.R;
import com.example.pts3.activity.Game_Activity;
import com.example.pts3.interfaces.IPerso;

public class PersoVert implements IPerso {

    private ImageView img;
    private char drawable = 'V';

    public PersoVert(Game_Activity activity) {
        super();

        img = new ImageView(activity);
        img.setBackgroundResource(R.drawable.perso_vert);
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
