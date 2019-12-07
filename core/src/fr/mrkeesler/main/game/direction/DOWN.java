package fr.mrkeesler.main.game.direction;

import fr.mrkeesler.main.game.game.block.Block;
import fr.mrkeesler.main.game.game.board.Board;

public class DOWN extends Direction{

	@Override
	public void moveTo(Board b, Block bck) {
		int newX = bck.getPos().getX();
		boolean find = false;
		int idx = bck.getPos().getX()+1;
		while(!find && idx < b.getHeight()) {
			if(b.getBoard()[idx][bck.getPos().getY()] == null) {
				newX = idx;
				idx++;
			}else {
				find = true;
			}
		}		
		b.getBoard()[bck.getPos().getX()][bck.getPos().getY()] = null;
		bck.getPos().setX(newX);
		b.getBoard()[bck.getPos().getX()][bck.getPos().getY()] = bck ;
		
		if(bck.getPos().getX() != b.getHeight()-1) {
			Block tmp = b.getBoard()[bck.getPos().getX()+1][bck.getPos().getY()];
			if(tmp.getValue().equals(bck.getValue())) {
				bck.fuseBlock(tmp, b);
			}
		}
	}

	@Override
	public void move(Board b) {
		for(int i = b.getWidth()-1; i >= 0; i--) {
			for(int j = 0; j < b.getHeight(); j++) {
				if(b.getBoard()[i][j] != null) {
					moveTo(b, b.getBoard()[i][j]);
				}
			}
		}
		
	}



}
