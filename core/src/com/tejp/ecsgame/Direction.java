package com.tejp.ecsgame;

public enum Direction {
    NONE(0,0, 0b0000, 0b1111, 0b1010, 0b0101), WEST(-1,0, 0b0001, 0b1011), NORTH(0, -1, 0b0010, 0b0111),
    NORTHWEST(-1,-1, 0b0011), EAST(1,0, 0b0100, 0b1110), NORTHEAST(1,-1, 0b0110),
    SOUTH(0, 1, 0b1000, 0b1101), SOUTHWEST(-1,1, 0b1001),SOUTHEAST(1,1, 0b1100);

    private int[] bitPatternArr;
    private final int x;
    private final int y;

    private Direction(int x, int y, int... bitPattern) {
        this.bitPatternArr = bitPattern;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBitPattern() {
        return bitPatternArr[0];
    }

    public Vector2D getVector() {
        return new Vector2D(x, y);
    }

	/**
	 *
	 * @param invertY (if y is up instead of the default down)
	 */
	public static Direction getDirection(double x, double y, boolean invertY) {
		return getDirection(x, invertY ? -y : y);
	}

	public static Direction getDirection(double x, double y) {
		boolean goingLeft = x < 0;
		boolean goingRight = x > 0;
		boolean goingUp = y < 0;
		boolean goingDown = y > 0;

		return getDirection(goingLeft, goingRight, goingUp, goingDown);
	}

	public static Direction getDirection(boolean left, boolean right, boolean up, boolean down) {
		int pattern = 0;
		if (left) pattern += WEST.getBitPattern();
		if (right) pattern += EAST.getBitPattern();
		if (up) pattern += NORTH.getBitPattern();
		if (down) pattern += SOUTH.getBitPattern();

		return getDirectionFromBitPattern(pattern);
	}

    public static Direction getDirectionFromBitPattern(int bitPattern) {
	    /*
	    return Arrays.stream(values())
			.filter(direction -> Arrays.stream(direction.bitPatternArr).anyMatch(pattern -> pattern == bitPattern))
	        .findFirst().orElse(Direction.NONE);
	    */
	    for (Direction direction : values()) {
            for (int pattern : direction.bitPatternArr) {
                if (pattern == bitPattern)
                    return direction;
            }
        }
        return Direction.NONE;
    }
}
