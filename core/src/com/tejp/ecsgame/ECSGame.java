package com.tejp.ecsgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tejp.ecsgame.entitys.Game;

public class ECSGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;

	private Game game;
	private DesktopInput desktopInput = new DesktopInput(); //TODO dependency injection till konstruktorn. Skicka input från de olika launchersarna till en kontruktor här.

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		game = new Game(desktopInput);
	}

	@Override
	public void render () {
		desktopInput.updateInput();
		game.update();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);

		TextureRegion textureRegion = ScreenUtils.getFrameBufferTexture();

		batch.end();
	}
}
