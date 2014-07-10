package com.tejp.ecsgame.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class StaticSprite implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000001000000;

	private TextureRegion textureRegion;

	public StaticSprite(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
