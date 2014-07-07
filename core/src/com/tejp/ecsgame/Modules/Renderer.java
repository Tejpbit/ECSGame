package com.tejp.ecsgame.Modules;

import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Sprite;
import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class Renderer implements Module {


	@Override
	public long getBitPattern() {
		return Sprite.BIT_PATTERN | Position.BIT_PATTERN;
	}

	@Override
	public void doAction(Entity entity) {
		Sprite sprite = entity.getComponent(Sprite.BIT_PATTERN);
		Position pos = entity.getComponent(Position.BIT_PATTERN);


		//TextureRegion frame = sprite.getAnimation().
	}
}
