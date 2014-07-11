package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.CollisionEvent;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;
import com.tejp.ecsgame.event.MoveEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class CollisionModule implements Module, EventListener<MoveEvent> {

	List<Entity> entitiesWithCollision = new ArrayList<>();

	public CollisionModule() {
		EventHandler.INSTANCE.addListener(MoveEvent.class, this);
	}

	@Override
	public long getBitPattern() {
		return Position.BIT_PATTERN | Collision.BIT_PATTERN;
	}

	public void addCollisionEntity(Entity entity) {
		entitiesWithCollision.add(entity);
	}

	@Override
	public void onEvent(MoveEvent event) {
		doAction(event.getEntity());
	}

	@Override
	public void doAction(Entity entity) {
		Vector2D position = ((Position)entity.getComponent(Position.BIT_PATTERN)).getVector();
		Rectangle collision = ((Collision)entity.getComponent(Collision.BIT_PATTERN)).getRect();

		float left = (float)position.getX();
		float bot = (float)position.getY();

		Optional<Entity> overlappingEntity =
			isOverlapping(
				entity,
				left,
				bot + collision.height,
				left + collision.width,
				bot
			);
		overlappingEntity.ifPresent(e -> EventHandler.INSTANCE.report(new CollisionEvent(entity, e)));
	}

	private Optional<Entity> isOverlapping(Entity entityToCheck, float left, float top, float right, float bot) {
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

			//TODO räkna ut ints för denna kollen och gör kollen genom att jämföra med noll.
			//skicka sedan med ints i collisionEventet som säger hur långt in i varandra entitysarna är.
			//sen är det bara kolla vilken av dem som är störst.

			if (left < right2 && right > left2 && top > bot2 && bot < top2)
				return Optional.of(entity);
		}
		return Optional.empty();
	}
}
