package com.tejp.ecsgame.modules;

import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.MoveEvent;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Move implements Module {

	@Override
	public long getBitPattern() {
		return Velocity.BIT_PATTERN | Position.BIT_PATTERN;
	}

	@Override
	public void doAction (Entity entity) {
		Velocity velocity = entity.getComponent(Velocity.BIT_PATTERN);
		Position position = entity.getComponent(Position.BIT_PATTERN);

		if (velocity.getVector().getMagnitude() < 0.001) {
			return;
		}
		position.setPosition(
				position.getVector().add(velocity.getVector())
		);

		

		EventHandler.INSTANCE.report(new MoveEvent(entity));
		//TODO När ett event skickas från CollisionModule så kan Move ( eller annan modul lyssna)
		// den ska sedan skaffa en vektor för att korrigera rätt det objekt som är fel. så att det tar kortastevägen ut från det objekt det har åkt in i.
	}
}
