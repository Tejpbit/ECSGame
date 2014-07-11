package com.tejp.ecsgame.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public enum EventHandler {
	INSTANCE;

	private final Map<Class<? extends Event>, List<IEventHandler<?>>> categorizedEventListeners = new HashMap<>();

	private static class IEventHandler<T> {
		private final EventListener<T> listener;

		public IEventHandler(EventListener<T> listener) {
			this.listener = listener;
		}

		void executeEvent(Event event) {
			listener.onEvent((T) event);
		}
	}

	/**
	 *
	 * @param event the event which eventListener want to know about
	 * @param eventListener
	 */
	public <T extends Event> void addListener(Class<T> event, EventListener<T> eventListener) {
		if (categorizedEventListeners.containsKey(event)) {
			categorizedEventListeners.get(event).add(new IEventHandler<>(eventListener));
			return;
		}
		List<IEventHandler<?>> eventListeners = new ArrayList<>();
		eventListeners.add(new IEventHandler<>(eventListener));
		categorizedEventListeners.put(event, eventListeners);
	}

	public void removeListener(EventListener eventListener) {
		// checks and removes eventListener from all lists in the map
		categorizedEventListeners.values().forEach(list -> list.forEach(el -> list.remove(el) ));
	}

	public void report(Event event) {
		List<IEventHandler<?>> list = categorizedEventListeners.getOrDefault(event.getClass(), new ArrayList<>());
		list.forEach(eh -> eh.executeEvent(event));
	}
}
