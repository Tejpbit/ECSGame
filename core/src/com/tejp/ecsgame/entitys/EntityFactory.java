package com.tejp.ecsgame.entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.components.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public enum EntityFactory {
	INSTANCE;

	public EntityFactory getInstance() {
		return INSTANCE;
	}

	public Player getPlayer(Input input) {


		return new Player(new Health(), new Position(), new Velocity(), new Sprite(getCreatureAnimation("slicer.png")), input); //TODO MAGIC STRING?
	}

	private Map<Direction, Animation>getCreatureAnimation(String src) {
		Texture walkSheet = new Texture(Gdx.files.internal(src));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/3, walkSheet.getHeight()/8); //TODO MAGIC NUMBERS

		Map<Direction, Animation> walkMap = new HashMap<>();

		//The directios need to be in this order to be correctly matched with the image. That's why Direction.Values isn't used.
		Direction[] orderToReadWalkingDirections =
				{Direction.WEST, Direction.NORTHWEST, Direction.NORTH, Direction.NORTHEAST,
				Direction.EAST, Direction.SOUTHEAST, Direction.SOUTH, Direction.SOUTHWEST};

		for (int i = 0; i < tmp.length; i++) {
			walkMap.put(orderToReadWalkingDirections[i], new Animation(0.1f, tmp[i])); //TODO BAD BAD TEJP MAGIC NUMBERS
		}

		return walkMap;
	}
}
