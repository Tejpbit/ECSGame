package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.CollisionEvent;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;
import com.tejp.ecsgame.event.MoveEvent;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Move implements Module, EventListener<CollisionEvent> {

	public Move() {
		EventHandler.INSTANCE.addListener(CollisionEvent.class, this);
	}

	@Override
	public Collection<Class<? extends Component>> getRequiredComponents() {
		return Arrays.asList(Velocity.class, Position.class);
	}

	@Override
	public void doAction (Entity entity) {
		Velocity velocity = entity.getComponent(Velocity.class);
		Position position = entity.getComponent(Position.class);

		if (velocity.getVector().getMagnitude() < 0.00001)
			return;
		position.move(velocity.getVector());

		EventHandler.INSTANCE.report(new MoveEvent(entity));
	}

	@Override
	public void onEvent(CollisionEvent event) {

		Vector2D pos1 = ((Position)event.getEntity1().getComponent(Position.class)).getVector();
		Rectangle rect1 = ((Collision)event.getEntity1().getComponent(Collision.class)).getRect();

		Vector2D pos2 = ((Position)event.getEntity2().getComponent(Position.class)).getVector();
		Rectangle rect2 = ((Collision)event.getEntity2().getComponent(Collision.class)).getRect();

		double centerX1 = pos1.getX() + rect1.width/2;
		double centerY1 = pos1.getY() + rect1.height/2;

		double centerX2 = pos2.getX() + rect2.width/2;
		double centerY2 = pos2.getY() + rect2.height/2;

		double newX = centerX1 - centerX2;
		double newY = centerY1 - centerY2;

		Position position = event.getEntity1().getComponent(Position.class);
		Direction direction = Direction.getDirection(newX, newY);

		float smallestX = Math.abs(event.getaLeftTobRight()) < Math.abs(event.getbLeftToaRight()) ? event.getaLeftTobRight() : event.getbLeftToaRight();
		float smallestY = Math.abs(event.getaBot_To_bTop()) < Math.abs(event.getbBot_To_aTop()) ? event.getaBot_To_bTop() : event.getbBot_To_aTop();

		if (Math.abs(smallestX) < Math.abs(smallestY))
			position.move(direction.getX() * smallestX, 0);
		else
			position.move(0, direction.getY() * smallestY);

	}
}
