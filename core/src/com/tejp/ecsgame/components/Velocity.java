package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Velocity implements Component {

	private Vector2D velocity;

	public Velocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	public Velocity() {
	}

	@Override
	public long getBitPattern() {
		return 0b0100;
	}
}
