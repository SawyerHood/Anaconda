package com.sawyerhood.weekgames.anaconda.input;

import com.google.common.eventbus.EventBus;
import com.sawyerhood.weekgames.anaconda.entities.Snake;
import com.sawyerhood.weekgames.anaconda.events.listeners.MoveSnakeEvent;
import com.sawyerhood.weekgames.anaconda.util.Heading;
import com.sawyerhood.weekgames.anaconda.util.SwipeListener;

/**
 * Created by sawyer on 12/30/14.
 */
public class MobileSwipeListener extends SwipeListener {

    private EventBus eventBus;

    public MobileSwipeListener(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void swipeLeft(float velocityX, float velocityY) {
        eventBus.post(new MoveSnakeEvent(Heading.WEST));
    }

    @Override
    public void swipeRight(float velocityX, float velocityY) {
        eventBus.post(new MoveSnakeEvent(Heading.EAST));
    }

    @Override
    public void swipeUp(float velocityX, float velocityY) {
        eventBus.post(new MoveSnakeEvent(Heading.NORTH));
    }

    @Override
    public void swipeDown(float velocityX, float velocityY) {
        eventBus.post(new MoveSnakeEvent(Heading.SOUTH));
    }
}
