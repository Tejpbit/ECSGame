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

	public Collision (int width, int height){
		this.rect = new Rectangle(0, 0, width, height);
	}

	public Rectangle getRect() {
		return rect;
	}
}
