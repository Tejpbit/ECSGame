package com.tejp.ecsgame.event;

import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class MoveEvent implements Event{

	private Entity entity;

	public MoveEvent(Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return entity;
	}
}
