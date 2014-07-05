package com.tejp.ecsgame.components;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Health implements Component {

	private int health;

	public Health(int health) {
		this.health = health;
	}

	public Health() {
	}

	@Override
	public long getBitPattern() {
		return 0b0001;
	}
}
