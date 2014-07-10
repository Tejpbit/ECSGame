package com.tejp.ecsgame.modules;

import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.Event;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class CollisionModule implements Module, EventListener{

	List<Collision> collisionComponents = new ArrayList<>();

	public CollisionModule() {
		EventHandler.INSTANCE.addListener(Event.MOVE, this);
	}

	@Override
	public long getBitPattern() {
		return Position.BIT_PATTERN | Collision.BIT_PATTERN;
	}

	public void addCollisionComponent(Collision collision) {
		collisionComponents.add(collision);
	}

	@Override
	public void doAction(Entity entity) {
		Position position = entity.getComponent(Position.BIT_PATTERN);
		Collision collision = entity.getComponent(Collision.BIT_PATTERN);

		//TODO Yet to be imlemented. Check collision and  report an event if it happens
	}

	@Override
	public void onEvent(Event event, Entity entity) {
		doAction(entity);
	}
}
