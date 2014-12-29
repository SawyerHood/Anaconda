package com.sawyerhood.weekgames.anaconda.events.listeners;
import com.sawyerhood.weekgames.anaconda.util.Heading;
/**
 * Created by sawyer on 12/29/14.
 */
public class MoveSnakeEvent {
    private Heading heading;

    public MoveSnakeEvent(Heading heading) {
        this.heading = heading;
    }

    public Heading getHeading() {

        return heading;
    }
}
