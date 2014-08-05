package com.tejp.ecsgame.components;

import com.tejp.ecsgame.entitys.Entity;

import java.util.function.Consumer;

/**
 * Created by Tejpbit on 2014-07-24.
 */
public class Pickupable implements Component {

	private final Consumer<Entity> onPickup;

	public Pickupable(Consumer<Entity> onPickup) {
		this.onPickup = onPickup;
	}

	public Consumer<Entity> getOnPickup() {
		return onPickup;
	}
}
