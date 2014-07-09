package com.tejp.ecsgame.entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.components.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public enum EntityFactory {
	INSTANCE;

	public EntityFactory getInstance() {
		return INSTANCE;
	}

	public Player getPlayer(Input input) {


		return new Player(new Health(), new Position(), new Velocity(), new Sprite(getCreatureAnimation("phoenix.png")), input); //TODO MAGIC STRING?
	}

	private Map<Direction, Animation>getCreatureAnimation(String src) {
		Texture walkSheet = new Texture(Gdx.files.internal(src));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/12, walkSheet.getHeight()); //TODO MAGIC NUMBERS

		Map<Direction, Animation> animDirectionMap = new HashMap<>();

		TextureRegion[][] walkRegions = new TextureRegion[8][3];

		walkRegions[0] = Arrays.copyOfRange(tmp[0], 0, 3);
		IntStream.rangeClosed(1, 3).forEach(i -> walkRegions[i] = Arrays.copyOfRange(tmp[0], 3, 6));
		walkRegions[4] = Arrays.copyOfRange(tmp[0], 6, 9);
		IntStream.rangeClosed(5, 7).forEach(i -> walkRegions[i] = Arrays.copyOfRange(tmp[0], 9, 12));

		//The directios need to be in this order to be correctly matched with the image. That's why Direction.Values isn't used.
		Direction[] orderToReadWalkingDirections =
				{Direction.SOUTH, Direction.NORTHEAST, Direction.EAST, Direction.SOUTHEAST,
				Direction.NORTH, Direction.SOUTHWEST, Direction.WEST, Direction.NORTHWEST};



		for (int i = 0; i < walkRegions.length; i++) {
			animDirectionMap.put(orderToReadWalkingDirections[i], new Animation(0.1f, walkRegions[i])); //TODO BAD BAD TEJP MAGIC NUMBERS
		}

		return animDirectionMap;
	}
}
