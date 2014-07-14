package com.tejp.ecsgame.modules;

import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.entitys.Entity;

import java.util.Collection;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public interface Module {
	Collection<Class<? extends Component>> getRequiredComponents();
	void doAction(Entity entity);
}
