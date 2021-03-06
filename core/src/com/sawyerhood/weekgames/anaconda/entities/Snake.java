package com.sawyerhood.weekgames.anaconda.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.google.common.eventbus.EventBus;
import com.sawyerhood.weekgames.anaconda.util.Heading;
import com.sawyerhood.weekgames.anaconda.settings.Settings;
import com.sawyerhood.weekgames.anaconda.events.listeners.GameOverEvent;

import java.util.ArrayList;

/**
 * Created by sawyer on 12/28/14.
 */
public class Snake extends GameObject {

    private float speed;
    private ArrayList<SnakeNode> nodes;
    private Heading heading;
    private float timeSinceLastUpdate;
    private EventBus eventBus;


    public Snake (EventBus eventBus) {
        this.speed = Settings.STARTING_SPEED;
        this.nodes = new ArrayList<SnakeNode>();
        this.heading = Heading.NORTH;
        this.timeSinceLastUpdate = 0f;
        this.nodes.add(new SnakeNode(11,11));
        this.nodes.add(new SnakeNode(11,10));
        this.nodes.add(new SnakeNode(11,9));
        this.eventBus = eventBus;
    }

    @Override
    public void update(float delta) {
        timeSinceLastUpdate += delta;
        if (timeSinceLastUpdate >= speed) {
            updatePositions();
            timeSinceLastUpdate = 0f;
            if (speed > .05f)
                speed -= .001f;
            if(checkCollisions(getHead())) {
                eventBus.post(new GameOverEvent());
            }
        }



    }

    private void updatePositions() {
        SnakeNode back, front;
        for (int i = nodes.size() - 1; i > 0; i--) {
            back = nodes.get(i);
            front = nodes.get(i-1);
            back.setX(front.getX());
            back.setY(front.getY());
        }
        if (nodes.size() > 0) {
            int snakeX = getHead().getX();
            int snakeY = getHead().getY();
            getHead().setX(snakeX + heading.x);
            getHead().setY(snakeY + heading.y);
        }
    }

    private boolean checkCollisions(SnakeNode head) {

        for(SnakeNode n : nodes) {
            if (n == head)
                continue;
            if(n.getX() == getHead().getX() && n.getY() == getHead().getY())
                return true;
        }
        return false;
    }

    @Override
    public void draw(ShapeRenderer renderer, float delta) {
        for (SnakeNode node : nodes) {
            node.draw(renderer, delta);
        }
    }

    public SnakeNode getHead() {
        if (nodes.size() > 0)
            return nodes.get(0);
        return null;
    }

    public void setHeading(Heading h) {
        if(!h.isOpposite(heading))
            heading = h;
    }


    public void addToTail() {
        SnakeNode tail = nodes.get(nodes.size()-1);
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(Math.abs(i) + Math.abs(j) > 1)
                    continue;
                SnakeNode tmpNode = new SnakeNode(tail.getX() + i, tail.getY() + j);
                boolean valid = checkCollisions(tmpNode);
                if(valid) {
                   nodes.add(tmpNode);
                    return;
                }

            }
        }
    }
}
