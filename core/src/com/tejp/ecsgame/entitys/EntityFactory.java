package com.tejp.ecsgame.entitys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.Direction;
import com.tejp.ecsgame.components.*;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public enum EntityFactory {
	INSTANCE;

	public EntityFactory getInstance() {
		return INSTANCE;
	}

	public List<Entity> getRandomTestEntities() {
		List<Entity> entities = new ArrayList<>();

		entities.add(new Entity(new Position(-96, -32), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(-64, -32), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(-32, -32), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(32, 32), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(64, 64), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(64, 96), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(128, 32), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(128, 64), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));
		entities.add(new Entity(new Position(128, 96), new Collision(new Rectangle(0, 0, 32, 32)), new StaticSprite(new TextureRegion(new Texture("bedrock.png"))) ));

		return entities;
	}

	public Entity getPlayer() {
		return new Entity(new Health(), new Position(), new Velocity(), new Collision(new Rectangle(0, 0, 32, 32)), new Sprite(getCreatureAnimation("phoenix.png")), new PlayerInput()); //TODO MAGIC STRING?
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
