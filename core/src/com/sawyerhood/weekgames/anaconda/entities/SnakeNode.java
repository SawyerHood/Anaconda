package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sawyerhood.weekgames.anaconda.settings.Settings;

/**
 * Created by sawyer on 12/28/14.
 */
public class SnakeNode implements GameObject {
    private int x,y;


    public SnakeNode(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public boolean update(float delta) {
        return false;
    }

    public void setX(int x) {
        if(x > Settings.NUM_GAME_TILES_X)
            this.x = 0;
        else if (x < 0)
            this.x = Settings.NUM_GAME_TILES_X;
        else
            this.x = x;

    }

    public void setY(int y) {
        if(y > Settings.NUM_GAME_TILES_Y)
            this.y = 0;
        else if (y < 0)
            this.y = Settings.NUM_GAME_TILES_Y;
        else
            this.y = y;
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        float width = Settings.GAME_WORLD_X/Settings.NUM_GAME_TILES_X;
        float height = Settings.GAME_WORLD_Y/Settings.NUM_GAME_TILES_Y;
        renderer.setColor(Color.GREEN);
        renderer.rect(x*width + 1, y*width + 1, width-1, height-1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
