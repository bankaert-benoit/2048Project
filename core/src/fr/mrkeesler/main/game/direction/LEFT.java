package fr.mrkeesler.main.game.direction;

import fr.mrkeesler.main.game.game.block.Block;
import fr.mrkeesler.main.game.game.board.Board;

public class LEFT extends Direction{

	@Override
	public void moveTo(Board b,Block bck) {
		int newY = bck.getPos().getY();
		boolean find = false;
		int idx = bck.getPos().getY()-1;
		while(!find && idx >= 0) {
			if(b.getBoard()[bck.getPos().getX()][idx] == null) {
				newY = idx;
				idx--;
			}else {
				find = true;
			}
		}		
		b.getBoard()[bck.getPos().getX()][bck.getPos().getY()] = null;
		bck.getPos().setY(newY);
		b.getBoard()[bck.getPos().getX()][bck.getPos().getY()] = bck ;
		
		if(bck.getPos().getY() != 0) {
			Block tmp = b.getBoard()[bck.getPos().getX()][bck.getPos().getY()-1];
			if(tmp.getValue().equals(bck.getValue())) {
				bck.fuseBlock(tmp, b);
			}
		}
		
	}

	@Override
	public void move(Board b) {
		for(int i = 0; i < b.getHeight(); i++) {
			for(int j = 0; j < b.getWidth(); j++) {
				if(b.getBoard()[j][i] != null) {
					moveTo(b, b.getBoard()[j][i]);
				}
			}
		}
		
	}

}
