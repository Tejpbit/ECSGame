package com.tejp.ecsgame.event;

import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public interface EventListener {
	void onEvent(Event event, Entity entity);
}
