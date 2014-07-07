package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.Modules.InputHandler;
import com.tejp.ecsgame.Modules.Module;
import com.tejp.ecsgame.Modules.Move;
import com.tejp.ecsgame.Modules.Renderer;
import com.tejp.ecsgame.Vector2D;
import com.tejp.ecsgame.components.Input;
import com.tejp.ecsgame.components.Position;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tejpbit on 2014-07-06.
 */
public class Game {

	private Set<Entity> entities = new HashSet<>();
	private Set<Module> modules = new HashSet<>();

	private EntityFactory entityFactory = EntityFactory.INSTANCE;

	private Position cameraPosition;

	public Game(Input input) {
		Player player = entityFactory.getPlayer(input);
		cameraPosition = player.getComponent(Position.BIT_PATTERN);
		entities.add(player);
		modules.add(new Move());
		modules.add(new InputHandler());
		modules.add(new Renderer());
	}

	public void update() {
		modules.forEach(m -> getMatchingEntitys(m.getBitPattern()).forEach(e -> m.doAction(e)));
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
