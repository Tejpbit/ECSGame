package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.components.Component;

import java.util.List;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public abstract class Entity {

	private List<Component> components;
	private long bitPattern;

	public long getBitPattern() {
		return bitPattern;
	}

	public void addComponent(Component component) {
		if (components.add(component))
			bitPattern |= component.getBitPattern();
	}

	public void removeComponent(Component component) {
		if (components.remove(component))
			bitPattern &= ~component.getBitPattern();
	}
}
