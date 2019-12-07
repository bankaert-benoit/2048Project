package fr.mrkeesler.main.game.game.block;

import java.awt.Graphics;

import fr.mrkeesler.main.game.game.board.Board;
import fr.mrkeesler.main.game.utils.BlockValue;
import fr.mrkeesler.main.game.utils.Position;

public class Block {

	private BlockValue val;
	private Position pos;
	
	public Block(BlockValue val, int x, int y) {
		this.val = val;
		this.pos = new Position(x, y);
	}
	
	public Position getPos() {
		return pos;
	}
	
	public BlockValue getValue() {
		return val;
	}
	
	public void setValue(BlockValue val) {
		this.val = val;
	}
	
	public void fuseBlock(Block b,Board board) {
		if(!b.getValue().equals(BlockValue.VAL2048) || !this.getValue().equals(BlockValue.VAL2048)){
			board.getBoard()[pos.getX()][pos.getY()] = null;
			b.setValue(b.getValue().getNextVal());
			board.getBoard()[b.getPos().getX()][b.getPos().getY()] = b;
		}
	}

	public String toString() {
		return this.getClass().getSimpleName()+"[pos("+pos.getX()+","+pos.getY()+"),val="+val.getValue()+"]";
	}
	
	
}
