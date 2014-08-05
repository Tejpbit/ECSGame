package com.tejp.ecsgame.event;

import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-24.
 */
public class AddEntityEvent implements Event {
	private final Entity entity;

	public AddEntityEvent(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}
}
