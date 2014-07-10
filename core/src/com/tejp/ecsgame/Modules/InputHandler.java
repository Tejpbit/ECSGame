package com.tejp.ecsgame.modules;

		import com.tejp.ecsgame.components.Input;
		import com.tejp.ecsgame.components.Velocity;
		import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class InputHandler implements Module {
	@Override
	public long getBitPattern() {
		return Input.BIT_PATTERN | Velocity.BIT_PATTERN;
	}

	@Override
	public void doAction(Entity entity) {
		Input input = entity.getComponent(Input.BIT_PATTERN);
		Velocity velocity = entity.getComponent(Velocity.BIT_PATTERN);

		velocity.setVelocity(input.getInput());
	}
}
