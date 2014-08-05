package com.tejp.ecsgame.modules;

		import com.tejp.ecsgame.components.Component;
		import com.tejp.ecsgame.components.PlayerInput;
		import com.tejp.ecsgame.components.Velocity;
		import com.tejp.ecsgame.entitys.Entity;

		import java.util.Arrays;
		import java.util.Collection;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class InputHandler implements Module {

	@Override
	public Collection<Class<? extends Component>> getRequiredComponents() {
		return Arrays.asList(Velocity.class, PlayerInput.class);
	}

	@Override
	public void doAction(Entity entity) {
		PlayerInput input = entity.getComponent(PlayerInput.class);
		Velocity velocity = entity.getComponent(Velocity.class);

		velocity.setVelocity(input.getMoveInput());

		if (input.isAttacking()) {
			// TODO get attack from weapon component
		}
	}
}
