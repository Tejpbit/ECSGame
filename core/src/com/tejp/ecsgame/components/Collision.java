package com.tejp.ecsgame.components;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tejpbit on 2014-07-09.
 */
public class Collision implements Component {

	private Rectangle rect;

	public Collision(Rectangle rect) {
		this.rect = rect;
	}

	public Rectangle getRect() {
		return rect;
	}
}
