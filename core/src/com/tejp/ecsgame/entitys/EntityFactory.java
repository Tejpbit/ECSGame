package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.components.Health;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.components.Velocity;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public enum EntityFactory {
	INSTANCE;

	public EntityFactory getInstance() {
		return INSTANCE;
	}

	public static Player getPlayer() {
		return new Player(new Health(), new Position(), new Velocity());
	}
}
