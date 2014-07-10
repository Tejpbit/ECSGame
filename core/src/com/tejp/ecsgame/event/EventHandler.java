package com.tejp.ecsgame.event;

import com.tejp.ecsgame.entitys.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public enum EventHandler {
	INSTANCE;

	Map<Event, List<EventListener>> categorizedEventListeners;

	/**
	 *
	 * @param event the event which eventListener want to know about
	 * @param eventListener
	 */
	public void addListener(Event event, EventListener eventListener) {
		if (categorizedEventListeners.containsKey(event)) {
			categorizedEventListeners.get(event).add(eventListener);
			return;
		}
		List<EventListener> eventListeners = new ArrayList<>();
		eventListeners.add(eventListener);
		categorizedEventListeners.put(event, eventListeners);
	}

	public void removeListener(EventListener eventListener) {
		// checks and removes eventListener from all lists in the map
		categorizedEventListeners.values().forEach(list -> list.forEach(el -> list.remove(el) ));
	}

	public void report(Event event, Entity entity) {
		categorizedEventListeners.get(event).forEach(el -> el.onEvent(event, entity));
	}

}
