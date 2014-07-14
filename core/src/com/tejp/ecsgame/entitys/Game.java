package com.tejp.ecsgame.entitys;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.modules.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Game {

	private Set<Entity> entities = new HashSet<>();
	private Set<Module> activeModules = new HashSet<>();
	private Set<Module> passiveModules = new HashSet();

	private EntityFactory entityFactory = EntityFactory.INSTANCE;

	private Position cameraPosition;

	public Game(SpriteBatch spriteBatch) {
		activeModules.add(new Move());
		activeModules.add(new InputHandler());
		activeModules.add(new AnimationRenderer(spriteBatch));
		activeModules.add(new StaticRenderer(spriteBatch));

		CollisionModule cm = new CollisionModule();
		passiveModules.add(cm);

		List<Entity> entitiesToAdd = entityFactory.getRandomTestEntities();
		Entity player = entityFactory.getPlayer();
		cameraPosition = player.getComponent(Position.BIT_PATTERN);
		entitiesToAdd.add(player);

		for (Entity entity : entitiesToAdd) {
			if (entity.hasComponent(Position.BIT_PATTERN | Collision.BIT_PATTERN)) {
				cm.addCollisionEntity(entity);
			}
		}

		entities.addAll(entitiesToAdd);
	}

	public void update() {
		activeModules.forEach(m -> getMatchingEntitys(m.getBitPattern()).forEach(e -> m.doAction(e)));
	}

	public Vector2D getCameraPosition() {
		return cameraPosition.getVector();
	}

	public Collection<Entity> getAllEntitys() {
		return entities;
	}

	public Collection<Entity> getMatchingEntitys(long bitPattern) {
		Set<Entity> matchingEntities = new HashSet<>();
		for (Entity entity : entities) {
			if ((entity.getBitPattern() & bitPattern) == bitPattern)
				matchingEntities.add(entity);
		}
		return matchingEntities;
	}

}
