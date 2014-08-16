package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.components.InteractLogic;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;
import com.tejp.ecsgame.event.MoveEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class CollisionModule implements Module, EventListener<MoveEvent> {

	private final List<Entity> entitiesWithCollision = new ArrayList<>();

	public CollisionModule() {
		EventHandler.INSTANCE.addListener(MoveEvent.class, this);
	}

	public void addCollisionEntity(Entity entity) {
		entitiesWithCollision.add(entity);
	}

	@Override
	public void onEvent(MoveEvent event) {
		doAction(event.getEntity());
	}

	@Override
	public Collection<Class<? extends Component>> getRequiredComponents() {
		return Arrays.asList(Position.class, Collision.class);
	}

	@Override
	public void doAction(Entity entity) {

		Vector2D posEntityToCheck = ((Position)entity.getComponent(Position.class)).getVector();
		Rectangle collisionEntityToCheck = ((Collision)entity.getComponent(Collision.class)).getRect();



		for (Entity entityWithCollision : entitiesWithCollision) {

			float aLeft = (float)posEntityToCheck.getX();
			float aRight = aLeft + collisionEntityToCheck.width;
			float aBot = (float)posEntityToCheck.getY();
			float aTop = aBot + collisionEntityToCheck.height;

			if (entity == entityWithCollision) {
				continue;
			}

			fireEventIfCollision(
					entity,
					entityWithCollision,
					aLeft,
					aTop,
					aRight,
					aBot
			);

		}
	}

	private void fireEventIfCollision(Entity entityA, Entity entityB, float aLeft, float aTop, float aRight, float aBot) {
		Vector2D position = ((Position)entityB.getComponent(Position.class)).getVector();
		Rectangle collision = ((Collision)entityB.getComponent(Collision.class)).getRect();
		float bLeft = (float)position.getX();
		float bRight = bLeft + collision.width;
		float bBot = (float)position.getY();
		float bTop = bBot + collision.height;

		float aLeft_To_bRight = bRight - aLeft;
		float bLeft_To_aRight = aRight - bLeft;
		float bBot_To_aTop = aTop - bBot;
		float aBot_To_bTop = bTop - aBot;

		if (aLeft_To_bRight > 0 && bLeft_To_aRight > 0 && bBot_To_aTop > 0 && aBot_To_bTop > 0) {
			runInteractLogic(entityA, entityB);
			runInteractLogic(entityB, entityA);
		}
			//EventHandler.INSTANCE.report(new CollisionEvent(entityA, entityB, aLeft_To_bRight, bLeft_To_aRight, bBot_To_aTop, aBot_To_bTop));
	}

	private void runInteractLogic(Entity interactor, Entity interactee) {
		InteractLogic logic = interactor.getComponent(InteractLogic.class);
		if (logic != null) {
			logic.getLogic().perform(interactor, interactee);
		}
	}
}
