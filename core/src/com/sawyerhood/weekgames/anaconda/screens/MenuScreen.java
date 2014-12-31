package com.sawyerhood.weekgames.anaconda.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sawyerhood.weekgames.anaconda.AnacondaGame;
import com.sawyerhood.weekgames.anaconda.entities.GameObject;
import com.sawyerhood.weekgames.anaconda.entities.SnakeNode;

import java.util.ArrayList;

/**
 * Created by sawyer on 12/28/14.
 */
public class MenuScreen extends AbstractScreen implements InputProcessor {

    SpriteBatch batch;
    Texture img;
    BitmapFont font;
    Pixmap titleArray;
    ArrayList<GameObject> entities;
    ShapeRenderer shapeRenderer;

    public MenuScreen(AnacondaGame game) {
        super(game);
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        font = new BitmapFont();
        font.scale(2.0f);
        titleArray = new Pixmap(new FileHandle("lol.png"));
        entities = new ArrayList<GameObject>();
        shapeRenderer = new ShapeRenderer();
        initTitle();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for(GameObject obj : entities) {
            obj.update(delta);
            obj.draw(shapeRenderer, delta);
        }
        shapeRenderer.end();
        batch.begin();
        font.draw(batch, "Touch to start", Gdx.graphics.getWidth() / 2 - 50, Gdx.graphics.getHeight() / 4);
        batch.end();

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
        batch.dispose();
        font.dispose();
        titleArray.dispose();
        shapeRenderer.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        startGame();
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
        startGame();
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

    private void startGame() {
        game.setScreen(new AnacondaGameScreen(game));
    }

    private void initTitle() {
        for(int i = 0; i < titleArray.getWidth(); i++) {
            for(int j = 0; j < titleArray.getHeight(); j++) {
                if(titleArray.getPixel(i,j) == 255) {
                    entities.add(new SnakeNode(i, titleArray.getHeight()-j));
                }
            }
        }
    }

}
