package com.tejp.ecsgame.components;

/**
 * Created by Tejpbit on 2014-07-14.
 */
public class Damage implements Component {

	private final int damage;

	public Damage(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
}
