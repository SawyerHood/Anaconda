package com.sawyerhood.weekgames.anaconda.util;

/**
 * Created by sawyer on 12/28/14.
 */
public enum Heading {
    NORTH (0 ,1), SOUTH (0, -1), EAST (1, 0), WEST (-1, 0);
    public int x, y;
    Heading(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
