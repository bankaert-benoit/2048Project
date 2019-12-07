package fr.mrkeesler.main.game.game.board;

import java.lang.reflect.InvocationTargetException;


import fr.mrkeesler.main.game.direction.DirectionType;
import fr.mrkeesler.main.game.game.block.Block;
import fr.mrkeesler.main.game.game.block.BlockFactory;
import fr.mrkeesler.main.game.utils.BlockValue;

public class Board {
	
	private Block[][] board;
	private int height,width,score;

	public Board(int h,int w) {
		this.height = h;
		this.width = w;
		this.board = new Block[w][h];
		this.score = 0;
		addNewBlock();
		addNewBlock();
		addNewBlock();
	}
	
	public Board() {
		this(4,4);
	}
	
	public void move(DirectionType d) {
		try {
			d.getDirectionClass().getConstructor().newInstance().move(this);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return;
		}finally {
			addNewBlock();
		}
	}
	
	public Block[][] getBoard() {
		return board;
	}

	public void setBoard(Block[][] board) {
		this.board = board;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void addNewBlock() {
		Block tmp = BlockFactory.createBlock(height,width);
		if(!boardFull()){
			if(board[tmp.getPos().getX()][tmp.getPos().getY()] == null) {
				board[tmp.getPos().getX()][tmp.getPos().getY()] = tmp;
			}else {
				addNewBlock();
			}
		}
	}

	public int calculateScore(){
		score = 0;
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] != null){
					score += board[i][j].getValue().getValue();
				}
			}
		}
		return score;
	}

	private boolean boardFull(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(board[i][j] == null) return false;
			}
		}
		return true;
	}

	public void reset(){
		this.board = new Block[width][height];
		addNewBlock();
		addNewBlock();
		addNewBlock();
	}

	public Block getMaxBlock() {
		Block b = null;
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++)
				if(board[i][j] != null)
					if(b == null)
						b = board[i][j];
					else if(board[i][j].getValue().getValue() > b.getValue().getValue())
						b = board[i][j];
		return b;
	}
	
	public boolean victory() {
		if(getMaxBlock().getValue().equals(BlockValue.VAL2048)) {
			return true;
		}
		return false;
	}
	

	public String display() {
		String res = "Max brick : "+getMaxBlock().getValue().getValue()+"\n";
		for(int i = 0; i < this.width ; i++) {
			for(int j = 0 ; j < this.height ; j++) {
				if(board[i][j] != null) {
					res+= board[i][j].getValue().getValue()+"\t";
				}else {
					res+= ".\t";
				}
			}
			res+= "\n\n";
		}
		return res;		
	}



}
