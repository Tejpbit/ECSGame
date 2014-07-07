package com.tejp.ecsgame.Modules;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Sprite;
import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class Renderer implements Module {

	private SpriteBatch spriteBatch;
	private float stateTime;

	public Renderer(SpriteBatch spriteBatch) {
		this.spriteBatch = spriteBatch;
	}

	@Override
	public void doAction(Entity entity) {
		Sprite sprite = entity.getComponent(Sprite.BIT_PATTERN);
		Position pos = entity.getComponent(Position.BIT_PATTERN);

		stateTime += Gdx.graphics.getDeltaTime();

		TextureRegion frame = sprite.getAnimation().getKeyFrame(stateTime, true);
		spriteBatch.draw(frame, (int)pos.getVector().getX(), (int)pos.getVector().getY());
	}

	@Override
	public long getBitPattern() {
		return Sprite.BIT_PATTERN | Position.BIT_PATTERN;
	}
}
