package com.tejp.ecsgame;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectionTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetX() throws Exception {

	}

	@Test
	public void testGetY() throws Exception {

	}

	@Test
	public void testGetBitPattern() throws Exception {

	}

	@Test
	public void testGetVector() throws Exception {

	}

	@Test
	public void testGetDirection() throws Exception {
		assertEquals(Direction.NONE, Direction.getDirection(0,0));
		assertEquals(Direction.NORTH, Direction.getDirection(0,-1));
		assertEquals(Direction.NORTHEAST, Direction.getDirection(1,-1));
		assertEquals(Direction.EAST, Direction.getDirection(1,0));
		assertEquals(Direction.SOUTHEAST, Direction.getDirection(1,1));
		assertEquals(Direction.SOUTH, Direction.getDirection(0,1));
		assertEquals(Direction.SOUTHWEST, Direction.getDirection(-1,1));
		assertEquals(Direction.WEST, Direction.getDirection(-1,0));
		assertEquals(Direction.NORTHWEST, Direction.getDirection(-1,-1));
	}

	@Test
	public void testGetDirection1() throws Exception {
		assertEquals(Direction.getDirection(true, true, true, true), Direction.NONE);
		assertEquals(Direction.getDirection(true, false, true, false), Direction.NORTHWEST);
		assertEquals(Direction.getDirection(false, true, false, true), Direction.SOUTHEAST);
		assertEquals(Direction.getDirection(false, true, true, false), Direction.NORTHEAST);
		assertEquals(Direction.getDirection(true, false, false, true), Direction.SOUTHWEST);
		assertEquals(Direction.getDirection(true, true, true, false), Direction.NORTH);
		assertEquals(Direction.getDirection(false, true, true, true), Direction.EAST);
		assertEquals(Direction.getDirection(true, false, false, false), Direction.WEST);
	}

	@Test
	public void testGetDirectionFromBitPattern() throws Exception {

	}
}