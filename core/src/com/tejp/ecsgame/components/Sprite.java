package com.tejp.ecsgame.components;

import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class Sprite implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000001000;

	private Animation anim;

	public Sprite(Animation anim) {
		this.anim = anim;
	}

	public Animation getAnimation() {
		return anim;
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
