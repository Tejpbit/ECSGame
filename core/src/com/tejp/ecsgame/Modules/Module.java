package com.tejp.ecsgame.modules;

import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public interface Module {
	long getBitPattern();
	void doAction(Entity entity);
}
