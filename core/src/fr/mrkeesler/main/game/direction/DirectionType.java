package fr.mrkeesler.main.game.direction;

public enum DirectionType {
	UP(UP.class),
	RIGHT(RIGHT.class),
	DOWN(DOWN.class),
	LEFT(LEFT.class);
	
	private Class<? extends Direction> c;
	
	private DirectionType(Class<? extends Direction> c) {
		this.c = c;
	}
	
	public Class<? extends Direction> getDirectionClass() {
		return c;
	}
}
