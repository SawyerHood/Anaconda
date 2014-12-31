package com.sawyerhood.weekgames.anaconda.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.sawyerhood.weekgames.anaconda.events.listeners.MoveSnakeEvent;
import com.sawyerhood.weekgames.anaconda.util.Heading;
import com.google.common.eventbus.EventBus;

/**
 * Created by sawyer on 12/29/14.
 */
public class DesktopGameScreenInputListener implements InputProcessor {

    private EventBus eventBus;

    public DesktopGameScreenInputListener(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.W:
                eventBus.post(new MoveSnakeEvent(Heading.NORTH));
                break;
            case Input.Keys.A:
                eventBus.post(new MoveSnakeEvent(Heading.WEST));
                break;
            case Input.Keys.S:
                eventBus.post(new MoveSnakeEvent(Heading.SOUTH));
                break;
            case Input.Keys.D:
                eventBus.post(new MoveSnakeEvent(Heading.EAST));
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
