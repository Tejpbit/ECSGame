package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.components.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public final class Entity {

	private final Map<Class<? extends Component>, Component> components = new HashMap<>();

	public Entity(Component... components) {
		for (Component component : components)
			addComponent(component);
	}

	public <T extends Component> T getComponent (Class<?> clazz) {
		return (T) components.get(clazz);
	}

	public void addComponent(Component component) {
		components.put(component.getClass(), component);
	}

	public void removeComponent(Class<?> clazz) {
		components.remove(clazz);
	}

	public boolean hasComponent(Class<? extends Component> clazz) {
		return components.containsKey(clazz);
	}

	public boolean hasComponents(Collection<Class<? extends Component>> clazz) {
		return components.keySet().containsAll(clazz);
	}

	public boolean hasComponents(Class<? extends Component>... classes) {
		for (Class<? extends Component> clazz : classes) {
			if (!hasComponent(clazz)) {
				return false;
			}
		}
		return true;
	}
}
