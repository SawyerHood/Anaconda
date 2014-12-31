package com.sawyerhood.weekgames.anaconda.util;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by sawyer on 12/30/14.
 */
public abstract class SwipeListener implements GestureDetector.GestureListener {
    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        float angle = (float) Math.atan2(velocityY, velocityX) * 57.2957795f;
        angle = Math.abs((angle + 360) % 360);
        System.out.println("Angle: " + angle);
        if(angle < 45 || angle > 315)
            swipeRight(velocityX, velocityY);
        else if(angle >= 45 && angle < 135)
            swipeDown(velocityX, velocityY);
        else if(angle >= 135 && angle < 225)
            swipeLeft(velocityX, velocityY);
        else
            swipeUp(velocityX, velocityY);

        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    public abstract void swipeLeft(float velocityX, float velocityY);
    public abstract void swipeRight(float velocityX, float velocityY);
    public abstract void swipeUp(float velocityX, float velocityY);
    public abstract void swipeDown(float velocityX, float velocityY);

}
