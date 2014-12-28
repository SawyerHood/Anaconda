package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sawyerhood.weekgames.anaconda.util.Heading;

import java.util.ArrayList;

/**
 * Created by sawyer on 12/28/14.
 */
public class Snake implements GameObject {

    private ArrayList<SnakeNode> nodes;
    private Heading heading;
    private float timeSinceLastUpdate;

    @Override
    public void update(float delta) {
        timeSinceLastUpdate -= delta;
        if (timeSinceLastUpdate <= 0) {
            SnakeNode back, front;
            for (int i = nodes.size() - 1; i > 0; i++) {
                back = nodes.get(i);
                front = nodes.get(i-1);
                back.setX(front.getX());
                front.setY(back.getY());
            }
            if (nodes.size() > 0) {
                nodes.get(0).setX(heading.x);
                nodes.get(0).setY(heading.y);
            }
        }
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        for (SnakeNode node : nodes) {
            node.draw(renderer);
        }
    }
}
