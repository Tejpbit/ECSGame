package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Position implements Component {

	private Vector2D posVector;

	public Position(Vector2D posVector) {
		this.posVector = posVector;
	}

	public Position() {
		posVector = new Vector2D(0, 0);
	}

	@Override
	public long getBitPattern() {
		return 0b0010;
	}
}
