package com.tejp.ecsgame.entitys;

import com.tejp.ecsgame.Modules.InputHandler;
import com.tejp.ecsgame.Modules.Module;
import com.tejp.ecsgame.Modules.Move;
import com.tejp.ecsgame.components.Input;

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

	public Game(Input input) {
		entities.add(entityFactory.getPlayer(input));
		modules.add(new Move());
		modules.add(new InputHandler());
	}

	public void update() {
		modules.forEach(m -> getMatchingEntitys(m.getBitPattern()).forEach(e -> m.doAction(e)));
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
