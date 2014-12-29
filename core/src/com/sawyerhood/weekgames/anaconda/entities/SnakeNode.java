package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sawyerhood.weekgames.anaconda.settings.Settings;
import java.util.Random;

/**
 * Created by sawyer on 12/28/14.
 */
public class SnakeNode implements GameObject {
    private int x,y;
    private Color nodeColor;
    private boolean goingUp = true;

    public SnakeNode(int x, int y) {
        setX(x);
        setY(y);
        nodeColor = new Color(Settings.rand.nextFloat(), Settings.rand.nextFloat(), Settings.rand.nextFloat(), 1);

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
    public void draw(ShapeRenderer renderer, float delta) {

        changeColor();
        float width = Settings.GAME_WORLD_X/Settings.NUM_GAME_TILES_X;
        float height = Settings.GAME_WORLD_Y/Settings.NUM_GAME_TILES_Y;

        renderer.setColor(nodeColor);
        renderer.rect(x*width, y*width, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeColor() {
        if(goingUp){
            if(nodeColor.r < 1f) {
                nodeColor.r += .01f;
            } else if (nodeColor.g < 1f) {
                nodeColor.g += .01f;
            } else if (nodeColor.b < 1f) {
                nodeColor.b += .01f;
            } else {
                goingUp = false;
            }
        } else {
             if (nodeColor.r > 0f) {
                nodeColor.r -= .01f;
            } else if (nodeColor.g > 0f) {
                nodeColor.g -= .01f;
            } else if (nodeColor.b > 0f) {
                nodeColor.b -= .01f;
            } else {
                 goingUp = true;
             }
        }
    }
}
