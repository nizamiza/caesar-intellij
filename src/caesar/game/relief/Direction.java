package caesar.game.relief;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public enum Direction {
	
	NORTH("North", 0, 1),
	NORTHWEST("Northwest", -1, 1),
	NORTHEAST("Northeast", 1, 1),
	WEST("West", -1, 0),
	EAST("East", 1, 0),
	SOUTH("South", 0, -1),
	SOUTHWEST("Southwest", -1, -1),
	SOUTHEAST("Southeast", 1, -1);
	
	private final String name;
	private final int x;
	private final int y;
	
	Direction(String name, int x, int y) {
		
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Nullable
	public static Direction valueOf(int x, int y) {
		
		return Arrays.stream(values())
		      .filter(direction -> direction.x == x && direction.y == y)
		      .findFirst().orElse(null);
	}
}