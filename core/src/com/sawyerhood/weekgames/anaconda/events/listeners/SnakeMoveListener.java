package com.sawyerhood.weekgames.anaconda.events.listeners;
import com.google.common.eventbus.Subscribe;
import com.sawyerhood.weekgames.anaconda.entities.Snake;

/**
 * Created by sawyer on 12/29/14.
 */
public class SnakeMoveListener {

    private Snake snake;

    public SnakeMoveListener(Snake snake) {
        this.snake = snake;
    }

    @Subscribe public void moveSnake (MoveSnakeEvent e) {
        snake.setHeading(e.getHeading());
    }
}
