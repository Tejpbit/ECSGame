package com.tejp.ecsgame.components;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tejp.ecsgame.Direction;

import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class Sprite implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000001000;

	private Map<Direction, Animation> anim;

	private Direction lastMoveDirection = Direction.SOUTH;

	public Sprite(Map<Direction, Animation> anim) {
		this.anim = anim;
	}

	public TextureRegion getTextureToRender(Direction direction, float stateTime) {
		if (direction == Direction.NONE)
			return anim.get(lastMoveDirection).getKeyFrame(0);
		lastMoveDirection = direction;
		return anim.get(direction).getKeyFrame(stateTime, true);
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
