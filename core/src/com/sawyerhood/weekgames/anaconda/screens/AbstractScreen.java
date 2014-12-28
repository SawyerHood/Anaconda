package com.sawyerhood.weekgames.anaconda.screens;

import com.badlogic.gdx.Screen;
import com.sawyerhood.weekgames.anaconda.AnacondaGame;

/**
 * Created by sawyer on 12/28/14.
 */
public abstract class AbstractScreen implements Screen {
    protected AnacondaGame game;

    public AbstractScreen(final AnacondaGame game) {
        this.game = game;
    }
}
