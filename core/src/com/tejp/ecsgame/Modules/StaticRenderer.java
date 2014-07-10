package com.tejp.ecsgame.modules;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.StaticSprite;
import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class StaticRenderer implements Module {
	@Override
	public long getBitPattern() {
		return Position.BIT_PATTERN | StaticSprite.BIT_PATTERN;
	}

	private SpriteBatch spriteBatch;

	public StaticRenderer(SpriteBatch spriteBatch) {
		this.spriteBatch = spriteBatch;
	}

	@Override
	public void doAction(Entity entity) {
		Position pos = entity.getComponent(Position.BIT_PATTERN);
		StaticSprite sprite = entity.getComponent(StaticSprite.BIT_PATTERN);

		Vector2D posVector = pos.getVector();

		spriteBatch.draw(
				sprite.getTextureRegion(),
				(int)posVector.getX(),
				(int)posVector.getY()
		);

	}
}
