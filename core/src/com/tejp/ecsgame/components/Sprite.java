package com.tejp.ecsgame.components;

/**
 * Created by Tejpbit on 2014-07-07.
 */
public class Sprite implements Component {

	public static final long BIT_PATTERN = 0b00000000000000000000000000001000;

	private String[] texturePathArr;

	public Sprite(String... texturePaths) {
		texturePathArr = texturePaths;
	}

	@Override
	public long getBitPattern() {
		return BIT_PATTERN;
	}
}
