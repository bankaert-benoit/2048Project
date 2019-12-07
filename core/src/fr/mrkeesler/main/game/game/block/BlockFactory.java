package fr.mrkeesler.main.game.game.block;

import java.util.Random;

import fr.mrkeesler.main.game.utils.BlockValue;

public class BlockFactory {

	public static Random rand = new Random();
	
	public static Block createBlock(int h,int w) {
		BlockValue value = BlockValue.values()[rand.nextInt(2)+(BlockValue.values().length-2)];
		return new Block(value,rand.nextInt(h),rand.nextInt(w));
	}
}
