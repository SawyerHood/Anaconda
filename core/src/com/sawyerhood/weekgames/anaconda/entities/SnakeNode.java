package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by sawyer on 12/28/14.
 */
public class SnakeNode implements GameObject {
    private float x,y;
    @Override
    public void update(float delta) {

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
