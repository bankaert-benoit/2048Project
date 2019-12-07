package fr.mrkeesler.main.game.utils;


import com.badlogic.gdx.graphics.Color;

public enum BlockValue {

	VAL2048(2048,null, Color.BLACK),
	VAL1024(1024,BlockValue.VAL2048,Color.GRAY),
	VAL512(512,BlockValue.VAL1024,Color.LIGHT_GRAY),
	VAL256(256,BlockValue.VAL512,Color.PINK),
	VAL128(128,BlockValue.VAL256,Color.MAGENTA),
	VAL64(64,BlockValue.VAL128,Color.CYAN),
	VAL32(32,BlockValue.VAL64,Color.BLUE),
	VAL16(16,BlockValue.VAL32,Color.GREEN),
	VAL8(8,BlockValue.VAL16,Color.RED),
	VAL4(4,BlockValue.VAL8,Color.ORANGE),
	VAL2(2,BlockValue.VAL4,Color.YELLOW);
	
	private int value;
	private BlockValue nextVal;
	private Color color;
	
	private BlockValue(int i,BlockValue next,Color color) {
		this.value = i;
		this.nextVal = next;
		this.color = color;
		
	}
	
	public int getValue() {
		return value;
	}
	
	public BlockValue getNextVal() {
		return nextVal;
	}
	
	public Color getColor() {
		return color;
	}
	
}
