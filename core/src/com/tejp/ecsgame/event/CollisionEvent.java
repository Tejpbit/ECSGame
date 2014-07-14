package com.tejp.ecsgame.event;

import com.tejp.ecsgame.entitys.Entity;

/**
 * Created by Tejpbit on 2014-07-11.
 */
public class CollisionEvent implements Event {

	private final Entity entity1;
	private final Entity entity2;
	private float aLeftTobRight, bLeftToaRight, bBot_To_aTop, aBot_To_bTop;

	public CollisionEvent(Entity entity1, Entity entity2, float aLeftTobRight, float bLeftToaRight, float bBot_To_aTop, float aBot_To_bTop) {
		this.entity1 = entity1;
		this.entity2 = entity2;
		this.aLeftTobRight = aLeftTobRight;
		this.bLeftToaRight = bLeftToaRight;
		this.bBot_To_aTop = bBot_To_aTop;
		this.aBot_To_bTop = aBot_To_bTop;
	}

	public Entity getEntity1() {
		return entity1;
	}

	public Entity getEntity2() {
		return entity2;
	}

	public float getaLeftTobRight() {
		return aLeftTobRight;
	}

	public float getbLeftToaRight() {
		return bLeftToaRight;
	}

	public float getbBot_To_aTop() {
		return bBot_To_aTop;
	}

	public float getaBot_To_bTop() {
		return aBot_To_bTop;
	}
}
