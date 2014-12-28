package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sawyerhood.weekgames.anaconda.settings.Settings;

/**
 * Created by sawyer on 12/28/14.
 */
public class PowerUp implements GameObject {

    private int x, y;

    public PowerUp(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean update(float delta) {
        return false;
    }


    @Override
    public void draw(ShapeRenderer renderer) {
        float width = Settings.GAME_WORLD_X/Settings.NUM_GAME_TILES_X;
        float height = Settings.GAME_WORLD_Y/Settings.NUM_GAME_TILES_Y;
        renderer.setColor(Color.RED);
        renderer.rect(x*width + 1, y*width + 1, width-1, height-1);
    }
}
