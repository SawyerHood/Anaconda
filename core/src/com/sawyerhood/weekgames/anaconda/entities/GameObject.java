package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by sawyer on 12/28/14.
 */
public interface GameObject {
    public void update(float delta);
    public void draw(ShapeRenderer renderer);
}
