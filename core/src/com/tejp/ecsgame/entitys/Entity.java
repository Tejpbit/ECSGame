package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.components.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Entity {

	private final Map<Long, Component> components = new HashMap<>();
	private long bitPattern;

	public Entity(Component... components) {
		for (Component component : components)
			addComponent(component);
	}

	public <T extends Component> T getComponent (long bitPattern) {
		return (T) components.get(bitPattern);
	}

	public void addComponent(Component component) {
		components.put(component.getBitPattern(), component);
		bitPattern |= component.getBitPattern();
	}

	public void removeComponent(Component component) {
		components.remove(component);
		bitPattern &= ~component.getBitPattern();
	}

	public boolean hasComponent(long bitPattern) {

		return (this.bitPattern & bitPattern) == bitPattern;
	}

	public long getBitPattern() {
		return bitPattern;
	}
}
