package com.tejp.ecsgame.components;

import com.tejp.ecsgame.Vector2D;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public interface Input extends Component {
	long BIT_PATTERN = 0b00000000000000000000000000000010;

	@Override
	default long getBitPattern() {
		return BIT_PATTERN;
	}

	Vector2D getInput();
}
