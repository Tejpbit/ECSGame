package com.tejp.ecsgame.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class StaticSprite implements Component {

	private TextureRegion textureRegion;

	public StaticSprite(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;
	}

	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

}
