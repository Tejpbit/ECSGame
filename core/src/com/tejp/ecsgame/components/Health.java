package com.tejp.ecsgame.components;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Health implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000000001;

	private int health;

	public Health(int health) {
		this.health = health;
	}

	public Health() {
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
