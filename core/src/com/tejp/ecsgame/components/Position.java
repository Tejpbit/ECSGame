package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Position implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000000100;

	private Vector2D posVector;

	public Position (int x, int y) {
		this(new Vector2D(x, y));
	}

	public Position(Vector2D posVector) {
		this.posVector = posVector;
	}

	public Position() {
		posVector = new Vector2D(0, 0);
	}

	public void setPosition(int x, int y) {
		posVector = new Vector2D(x, y);
	}

	public void setPosition(Vector2D posVector) {
		this.posVector = posVector;
	}

	public Vector2D getVector() {
		return posVector;
	}

	@Override
	public long getBitPattern() {
		return 0b0010;
	}
}
