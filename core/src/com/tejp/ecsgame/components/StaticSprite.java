package com.tejp.ecsgame.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Tejpbit on 2014-07-10.
 */
public class StaticSprite implements Component {

	private Sprite sprite;


	public StaticSprite(String imgPath, int width, int height) {
		Texture texture = new Texture(imgPath);
		this.sprite = new Sprite(texture);
		sprite.setSize(width, height);
	}

	public StaticSprite(String imgPath) {
		sprite = new Sprite(new Texture(imgPath));
	}

	public Sprite getSprite() {
		return sprite;
	}

}