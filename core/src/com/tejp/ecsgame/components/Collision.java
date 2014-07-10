package com.tejp.ecsgame.components;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tejpbit on 2014-07-09.
 */
public class Collision implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000100000;

	private Rectangle rect;

	public Collision(Rectangle rect) {
		this.rect = rect;
	}

	public Rectangle getRect() {
		return rect;
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
