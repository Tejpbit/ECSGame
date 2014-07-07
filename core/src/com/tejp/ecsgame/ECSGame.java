package com.tejp.ecsgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.entitys.Game;

public class ECSGame extends ApplicationAdapter {
	public static SpriteBatch batch;
	private Sprite sprite;
	private Texture img;
	private Camera camera;

	private Game game;
	private final DesktopInput desktopInput = new DesktopInput(); //TODO dependency injection till konstruktorn. Skicka input från de olika launchersarna till en kontruktor här.

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera(1280, 720);
		game = new Game(desktopInput);
		sprite = new Sprite(img);
		sprite.setOrigin(0, 0);
		sprite.setPosition(0, 0);
	}

	@Override
	public void render() {
		desktopInput.updateInput();
//		game.update();

		Vector2D newCameraPos = game.getCameraPosition();
		camera.position.set((float)newCameraPos.getX(), (float)newCameraPos.getY(), 0);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);
		game.update();
		batch.end();
	}
}
