package com.sawyerhood.weekgames.anaconda.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.sawyerhood.weekgames.anaconda.AnacondaGame;
import com.sawyerhood.weekgames.anaconda.entities.PowerUp;
import com.sawyerhood.weekgames.anaconda.entities.Snake;
import com.sawyerhood.weekgames.anaconda.events.listeners.GameOverEvent;
import com.sawyerhood.weekgames.anaconda.events.listeners.SnakeMoveListener;
import com.sawyerhood.weekgames.anaconda.input.DesktopGameScreenInputListener;
import com.sawyerhood.weekgames.anaconda.input.MobileSwipeListener;
import com.sawyerhood.weekgames.anaconda.settings.Settings;

/**
 * Created by sawyer on 12/28/14.
 */
public class AnacondaGameScreen extends AbstractScreen {

    private ShapeRenderer renderer;
    private Snake snake;
    private PowerUp powerUp;
    private EventBus eventBus;


    public AnacondaGameScreen(AnacondaGame game) {
        super(game);
        renderer = new ShapeRenderer();

        eventBus = new EventBus();
        snake = new Snake(eventBus);
        eventBus.register(new SnakeMoveListener(snake));
        eventBus.register(this);

        spawnPowerUp();
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(new DesktopGameScreenInputListener(eventBus));
        inputMultiplexer.addProcessor(new GestureDetector(new MobileSwipeListener(eventBus)));
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    public void spawnPowerUp() {
        powerUp = new PowerUp(Settings.rand.nextInt(Settings.NUM_GAME_TILES_X), Settings.rand.nextInt(Settings.NUM_GAME_TILES_Y));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        snake.update(delta);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        snake.draw(renderer, delta);
        powerUp.draw(renderer, delta);
        renderer.end();
        if (com.sawyerhood.weekgames.anaconda.util.Etc.doesCollide(snake.getHead().getX(), snake.getHead().getY(), powerUp.getX(), powerUp.getY())) {
            snake.addToTail();
            spawnPowerUp();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Subscribe
    public void GameOver(GameOverEvent e) {
        game.setScreen(new MenuScreen(game));
    }


}
