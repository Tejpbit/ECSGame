package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.components.Component;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Player extends Entity {

	public Player(Component... components) {
		for (Component component : components)
			addComponent(component);
	}

}
