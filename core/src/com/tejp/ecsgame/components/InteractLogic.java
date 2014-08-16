package com.tejp.ecsgame.components;

import com.tejp.ecsgame.components.interactionlogic.Logic;

/**
 * Created by Tejpbit on 2014-08-16.
 */
public class InteractLogic implements Component{

	private final Logic logic;

	public InteractLogic(Logic logic) {
		this.logic = logic;
	}

	public Logic getLogic() {
		return logic;
	}
}
