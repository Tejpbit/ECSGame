package com.tejp.ecsgame;

import com.badlogic.gdx.Gdx;
import com.tejp.ecsgame.components.Input;
import com.badlogic.gdx.Input.Keys;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class DesktopInput implements Input {

	private Vector2D input;

	@Override
	public Vector2D getInput() {
		return input;
	}

	@Override
	public void updateInput() {
		Direction direction = Direction.getDirection(
				Gdx.input.isKeyPressed(Keys.LEFT),
				Gdx.input.isKeyPressed(Keys.RIGHT),
				Gdx.input.isKeyPressed(Keys.UP),
				Gdx.input.isKeyPressed(Keys.DOWN)
		);

		direction = Direction.getDirection(direction.getX(), -direction.getY());
		input = direction.getVector();
	}
}
