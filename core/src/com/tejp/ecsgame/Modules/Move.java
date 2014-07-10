package com.tejp.ecsgame.modules;

import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.Event;
import com.tejp.ecsgame.event.EventHandler;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Move implements Module {

	@Override
	public long getBitPattern() {
		return Velocity.BIT_PATTERN | Position.BIT_PATTERN;
	}

	public void doAction (Entity entity) {
		Velocity velocity = entity.getComponent(Velocity.BIT_PATTERN);
		Position position = entity.getComponent(Position.BIT_PATTERN);

		if (velocity.getVector().getMagnitude() < 0.001) {
			return;
		}
		position.setPosition(
				position.getVector().add(velocity.getVector())
		);

		EventHandler.INSTANCE.report(Event.MOVE, entity);
	}
}
