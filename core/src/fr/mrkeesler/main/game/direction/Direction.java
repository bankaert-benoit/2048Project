package fr.mrkeesler.main.game.direction;

import fr.mrkeesler.main.game.game.block.Block;
import fr.mrkeesler.main.game.game.board.Board;

public abstract class Direction {
	
	public abstract void moveTo(Board b,Block bck);
	public abstract void move(Board b);

}
