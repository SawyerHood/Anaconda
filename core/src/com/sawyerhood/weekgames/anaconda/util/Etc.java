package com.sawyerhood.weekgames.anaconda.util;

/**
 * Created by sawyer on 12/28/14.
 */
public class Etc {
    public static boolean doesCollide(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2)
            return true;
        return false;

    }
}
