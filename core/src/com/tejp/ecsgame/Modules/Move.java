package com.tejp.ecsgame.Modules;

import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;

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

		position.setPosition(
				position.getVector().add(velocity.getVector())
		);

		System.out.println(position.getVector().getX() + " " + position.getVector().getY());
	}
}
