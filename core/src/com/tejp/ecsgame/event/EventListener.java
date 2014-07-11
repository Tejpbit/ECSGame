package com.tejp.ecsgame.event;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public interface EventListener<T> {
	void onEvent(T event);
}
