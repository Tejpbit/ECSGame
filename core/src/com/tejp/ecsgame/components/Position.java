package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public class Position implements Component {

	private Vector2D posVector;

	public Position (int x, int y) {
		this(new Vector2D(x, y));
	}

	public Position(Vector2D posVector) {
		this.posVector = posVector;
	}

	public Position() {
		posVector = new Vector2D(0, 0);
	}

	public void setPosition(int x, int y) {
		posVector = new Vector2D(x, y);
	}

	public void setPosition(Vector2D posVector) {
		this.posVector = posVector;
	}

	public void move(Vector2D vector) {
		this.posVector.add(vector);
	}

	public void move(double x, double y) {
		this.posVector.add(x, y);
	}

	public double getX() {
		return posVector.getX();
	}

	public double getY() {
		return posVector.getY();
	}

	public Vector2D getVector() {
		return posVector;
	}
}
