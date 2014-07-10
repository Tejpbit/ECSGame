package com.tejp.ecsgame.modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Sprite;
import com.tejp.ecsgame.components.Velocity;
import com.tejp.ecsgame.entitys.Entity;

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
	public void doAction(Entity entity) {
		Sprite sprite = entity.getComponent(Sprite.BIT_PATTERN);
		Position pos = entity.getComponent(Position.BIT_PATTERN);
		Vector2D vector = ((Velocity)entity.getComponent(Velocity.BIT_PATTERN)).getVector();

		stateTime += Gdx.graphics.getDeltaTime();

		Direction direction = Direction.getDirection(vector.getX(), vector.getY(), true);

		spriteBatch.draw(
				sprite.getTextureToRender(direction, stateTime),
				(int) pos.getVector().getX(),
				(int) pos.getVector().getY()
		);
	}

	@Override
	public long getBitPattern() {
		return Sprite.BIT_PATTERN | Position.BIT_PATTERN | Velocity.BIT_PATTERN;
	}
}
