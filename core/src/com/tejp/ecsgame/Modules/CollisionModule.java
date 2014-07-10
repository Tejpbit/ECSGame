package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Vector2D;
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

	List<Entity> entitiesWithCollision = new ArrayList<>();

	public CollisionModule() {
		EventHandler.INSTANCE.addListener(Event.MOVE, this);
	}

	@Override
	public long getBitPattern() {
		return Position.BIT_PATTERN | Collision.BIT_PATTERN;
	}

	public void addCollisionEntity(Entity entity) {
		entitiesWithCollision.add(entity);
	}

	@Override
	public void onEvent(Event event, Entity entity) {
		doAction(entity);
	}

	@Override
	public void doAction(Entity entity) {
		Vector2D position = ((Position)entity.getComponent(Position.BIT_PATTERN)).getVector();
		Rectangle collision = ((Collision)entity.getComponent(Collision.BIT_PATTERN)).getRect();

		float left = (float)position.getX();
		float bot = (float)position.getY();

		boolean overlapping =
			isOverlapping(
				entity,
				left,
				bot + collision.height,
				left + collision.width,
				bot
			);

		System.out.println(overlapping);

		if (overlapping)
			EventHandler.INSTANCE.report(Event.COLLISION, entity);
	}

	private boolean isOverlapping(Entity entityToCheck, float left, float top, float right, float bot) {
		for (Entity entity : entitiesWithCollision) {
			if (entityToCheck == entity) {
				continue;
			}
			Vector2D position = ((Position)entity.getComponent(Position.BIT_PATTERN)).getVector();
			Rectangle collision = ((Collision)entity.getComponent(Collision.BIT_PATTERN)).getRect();
			float left2 = (float)position.getX();
			float right2 = left2 + collision.width;
			float bot2 = (float)position.getY();
			float top2 = bot2 + collision.height;

			if (left < right2 && right > left2 && top > bot2 && bot < top2)
				return true;
		}
		return false;
	}
}
