package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.CollisionEvent;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;
import com.tejp.ecsgame.event.MoveEvent;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Move implements Module, EventListener<CollisionEvent> {

	@Override
	public long getBitPattern() {
		return Velocity.BIT_PATTERN | Position.BIT_PATTERN;
	}

	public Move() {
		EventHandler.INSTANCE.addListener(CollisionEvent.class, this);
	}

	@Override
	public void doAction (Entity entity) {
		Velocity velocity = entity.getComponent(Velocity.BIT_PATTERN);
		Position position = entity.getComponent(Position.BIT_PATTERN);

		if (velocity.getVector().getMagnitude() < 0.00001)
			return;
		position.move(velocity.getVector());


		System.out.println("new pos of dood: " + position.getVector().getX() + " " + position.getVector().getY());
		EventHandler.INSTANCE.report(new MoveEvent(entity));
	}

	@Override
	public void onEvent(CollisionEvent event) {

		Vector2D pos1 = ((Position)event.getEntity1().getComponent(Position.BIT_PATTERN)).getVector();
		Rectangle rect1 = ((Collision)event.getEntity1().getComponent(Collision.BIT_PATTERN)).getRect();

		Vector2D pos2 = ((Position)event.getEntity2().getComponent(Position.BIT_PATTERN)).getVector();
		Rectangle rect2 = ((Collision)event.getEntity2().getComponent(Collision.BIT_PATTERN)).getRect();

		double centerX1 = pos1.getX() + rect1.width/2;
		double centerY1 = pos1.getY() + rect1.height/2;

		double centerX2 = pos2.getX() + rect2.width/2;
		double centerY2 = pos2.getY() + rect2.height/2;


		double newX = centerX1 - centerX2;
		double newY = centerY1 - centerY2;

		Position position = event.getEntity1().getComponent(Position.BIT_PATTERN);

		position.move(new Vector2D(newX, newY));

	}
}
