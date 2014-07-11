package com.tejp.ecsgame.modules;

import com.badlogic.gdx.math.Rectangle;
import com.tejp.ecsgame.components.Collision;
import com.tejp.ecsgame.components.Position;
import com.tejp.ecsgame.entitys.Entity;
import com.tejp.ecsgame.event.CollisionEvent;
import com.tejp.ecsgame.event.EventHandler;
import com.tejp.ecsgame.event.EventListener;
import org.junit.Before;
import org.junit.Test;

public class CollisionModuleTest {

	CollisionModule cm;

	@Before
	public void setUp() throws Exception {
		cm = new CollisionModule();
		cm.addCollisionEntity(new Entity(new Position(1, 8), new Collision(new Rectangle(0, 0, 3, 4))));
	}

	@Test
	public void testDoAction() throws Exception {
		final Entity e = new Entity(new Position(3, 5), new Collision(new Rectangle(0, 0, 4, 4)));

		boolean collision = false;

		EventHandler.INSTANCE.addListener(CollisionEvent.class, new EventListener<CollisionEvent>() {
			@Override
			public void onEvent(CollisionEvent event) {
				System.out.println("Yeeep!");
			}
		});

		cm.doAction(e);
	}
}