package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Velocity implements Component {

	public static final long BIT_PATTERN = 0b0100;

	private Vector2D velocity;

	public Velocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	public Velocity() {
		this(new Vector2D(0, 0));
	}

	public Vector2D getVector() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	@Override
	public long getBitPattern() {
		return 0b0100;
	}
}
