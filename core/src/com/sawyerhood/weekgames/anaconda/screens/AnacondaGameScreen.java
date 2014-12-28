package com.sawyerhood.weekgames.anaconda.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sawyerhood.weekgames.anaconda.AnacondaGame;
import com.sawyerhood.weekgames.anaconda.entities.PowerUp;
import com.sawyerhood.weekgames.anaconda.settings.Settings;
import com.sawyerhood.weekgames.anaconda.entities.Snake;
import com.sawyerhood.weekgames.anaconda.util.Heading;

import java.util.Random;

/**
 * Created by sawyer on 12/28/14.
 */
public class AnacondaGameScreen extends AbstractScreen implements InputProcessor{

    private ShapeRenderer renderer;
    private Viewport viewport;
    private Snake snake;
    private PowerUp powerUp;
    private Random rand;

    public AnacondaGameScreen(AnacondaGame game) {
        super(game);
        renderer = new ShapeRenderer();
        viewport = new StretchViewport(Settings.GAME_WORLD_X, Settings.GAME_WORLD_Y);
        snake = new Snake();
        rand = new Random();
        spawnPowerUp();
        Gdx.input.setInputProcessor(this);

    }

    public void spawnPowerUp() {
        powerUp = new PowerUp(rand.nextInt(Settings.NUM_GAME_TILES_X), rand.nextInt(Settings.NUM_GAME_TILES_Y));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        boolean gameOver = snake.update(delta);
        renderer.setProjectionMatrix(viewport.getCamera().projection);
        renderer.setTransformMatrix(viewport.getCamera().view);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        snake.draw(renderer);
        powerUp.draw(renderer);
        renderer.end();
        if (gameOver)
            game.setScreen(new MenuScreen(game));
        if(com.sawyerhood.weekgames.anaconda.util.Etc.doesCollide(snake.getHead().getX(), snake.getHead().getY(), powerUp.getX(), powerUp.getY())){
            snake.addToTail();
            spawnPowerUp();
        }

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        viewport.getCamera().position.set(width/2f, height/2f, 0);
        viewport.getCamera().update();
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


    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.W:
                snake.setHeading(Heading.NORTH);
                break;
            case Input.Keys.A:
                snake.setHeading(Heading.WEST);
                break;
            case Input.Keys.S:
                snake.setHeading(Heading.SOUTH);
                break;
            case Input.Keys.D:
                snake.setHeading(Heading.EAST);
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
