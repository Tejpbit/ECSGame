package com.tejp.ecsgame.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class PlayerInput implements Component {
	public static long BIT_PATTERN = 0b00000000000000000000000000000010;

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}

	public Vector2D getInput() {
		return Direction.getDirection(
				Gdx.input.isKeyPressed(Keys.LEFT),
				Gdx.input.isKeyPressed(Keys.RIGHT),
				Gdx.input.isKeyPressed(Keys.DOWN),
				Gdx.input.isKeyPressed(Keys.UP)
				).getVector();
	}
}
