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


		Optional<Entity> overlappingEntity = isOverlapping(entity);
		overlappingEntity.ifPresent(e -> EventHandler.INSTANCE.report(new CollisionEvent(entity, e)));
	}

	private Optional<Entity> isOverlapping(Entity entityToCheck) {

		Vector2D entityToCheckPos = ((Position)entityToCheck.getComponent(Position.BIT_PATTERN)).getVector();
		Rectangle entityToCheckCollission = ((Collision)entityToCheck.getComponent(Collision.BIT_PATTERN)).getRect();

		float aLeft = (float)entityToCheckPos.getX();
		float aRight = aLeft + entityToCheckCollission.width;
		float aBot = (float)entityToCheckPos.getY();
		float aTop = aBot + entityToCheckCollission.height;

		for (Entity entity : entitiesWithCollision) {
			if (entityToCheck == entity) {
				continue;
			}
			Vector2D position = ((Position)entity.getComponent(Position.BIT_PATTERN)).getVector();
			Rectangle collision = ((Collision)entity.getComponent(Collision.BIT_PATTERN)).getRect();
			float bLeft = (float)position.getX();
			float bRight = bLeft + collision.width;
			float bBot = (float)position.getY();
			float bTop = bBot + collision.height;

			float aLeft_To_bRight = bRight - aLeft;
			float bLeft_To_aRight = aRight - bLeft;
			float bBot_To_aTop = aTop - bBot;
			float aBot_To_bTop = bTop - aBot;


			//TODO räkna ut ints för denna kollen och gör kollen genom att jämföra med noll.
			//skicka sedan med ints i collisionEventet som säger hur långt in i varandra entitysarna är.
			//sen är det bara kolla vilken av dem som är störst.

			if (aLeft_To_bRight > 0 && bLeft_To_aRight > 0 && bBot_To_aTop > 0 && aBot_To_bTop > 0)
				return Optional.of(entity);
		}
		return Optional.empty();
	}
}
