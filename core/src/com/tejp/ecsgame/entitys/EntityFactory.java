package com.tejp.ecsgame.entitys;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tejp.ecsgame.components.*;

/**
 * Created by Tejpbit on 2014-07-05.
 */
public enum EntityFactory {
	INSTANCE;

	public EntityFactory getInstance() {
		return INSTANCE;
	}

	public Player getPlayer(Input input) {
		FileHandle  file1 = new FileHandle("monsters-32x32.png");
		TextureRegion spriteTexture1 = new TextureRegion(new Texture(file1));
		FileHandle  file2 = new FileHandle("badlogic.jpg");
		TextureRegion spriteTexture2 = new TextureRegion(new Texture(file2));

		Animation anim = new Animation(0.1f, spriteTexture1, spriteTexture2);

		return new Player(new Health(), new Position(), new Velocity(), new Sprite(anim), input);
	}
}
