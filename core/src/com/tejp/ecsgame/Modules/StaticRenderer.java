package com.tejp.ecsgame.modules;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.StaticSprite;
import com.tejp.ecsgame.entitys.Entity;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class StaticRenderer implements Module {

	private SpriteBatch spriteBatch;

	public StaticRenderer(SpriteBatch spriteBatch) {
		this.spriteBatch = spriteBatch;
	}

	@Override
	public Collection<Class<? extends Component>> getRequiredComponents() {
		return Arrays.asList(Position.class, StaticSprite.class);
	}

	@Override
	public void doAction(Entity entity) {

		Position pos = entity.getComponent(Position.class);
		StaticSprite sprite = entity.getComponent(StaticSprite.class);

		Vector2D posVector = pos.getVector();

		spriteBatch.draw(
				sprite.getTextureRegion(),
				(int)posVector.getX(),
				(int)posVector.getY()
		);

	}
}
