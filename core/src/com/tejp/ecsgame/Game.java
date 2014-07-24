package com.tejp.ecsgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Component;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.entitys.EntityFactory;
import com.tejp.ecsgame.modules.*;

import java.util.*;
import java.util.stream.Collectors;

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
		cameraPosition = player.getComponent(Position.class);
		entitiesToAdd.add(player);

		for (Entity entity : entitiesToAdd) {
			if (entity.hasComponents(Position.class, Collision.class)) {
				cm.addCollisionEntity(entity);
			}
		}

		entities.addAll(entitiesToAdd);
	}

	public void update() {

		activeModules.forEach(m -> getMatchingEntitys(m.getRequiredComponents())
				//.stream().peek(System.out::println)
				.forEach(m::doAction));
	}

	public Vector2D getCameraPosition() {
		return cameraPosition.getVector();
	}

	public Collection<Entity> getAllEntitys() {
		return entities;
	}

	public Collection<Entity> getMatchingEntitys(Collection<Class<? extends Component>> classes) {
		return entities.stream()
				//.peek(System.out::println)
				.filter(e -> e.hasComponents(classes))
				//.peek(o -> System.out.print("Filterd entity: " + o))
				.collect(Collectors.toList());
	}

}
