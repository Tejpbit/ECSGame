package com.tejp.ecsgame.components.interactionlogic;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-08-06.
 */
public class NoOverlap implements Logic {

	@Override
	public void perform(Entity interactor, Entity interactee) {
		Position posInteractor = interactor.getComponent(Position.class);
		Rectangle rect = ((Collision)interactor.getComponent(Collision.class)).getRect();


		System.out.println("overlapping occurs");
	}
}
