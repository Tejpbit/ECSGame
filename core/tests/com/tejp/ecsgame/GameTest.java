package com.tejp.ecsgame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

	private Game game;

	@Before
	public void setUp() {
		game = new Game(new SpriteBatch());
	}

	@Test
	public void testUpdate() throws Exception {

	}

	@Test
	public void testGetAllEntitys() {
		assertFalse(game.getAllEntitys().isEmpty());
	}
}