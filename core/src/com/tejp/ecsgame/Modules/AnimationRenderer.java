package com.tejp.ecsgame.modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Sprite;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class AnimationRenderer implements Module {

	private SpriteBatch spriteBatch;
	private float stateTime;

	public AnimationRenderer(SpriteBatch spriteBatch) {
		this.spriteBatch = spriteBatch;
	}

	@Override
	public Collection<Class<? extends Component>> getRequiredComponents() {
		return Arrays.asList(Sprite.class, Position.class, Velocity.class);
	}

	@Override
	public void doAction(Entity entity) {
		Sprite sprite = entity.getComponent(Sprite.class);
		Position pos = entity.getComponent(Position.class);
		Vector2D vector = ((Velocity)entity.getComponent(Velocity.class)).getVector();

		stateTime += Gdx.graphics.getDeltaTime();

		Direction direction = Direction.getDirection(vector.getX(), vector.getY(), true);

		spriteBatch.draw(
				sprite.getTextureToRender(direction, stateTime),
				(int) pos.getVector().getX(),
				(int) pos.getVector().getY()
		);
	}
}
