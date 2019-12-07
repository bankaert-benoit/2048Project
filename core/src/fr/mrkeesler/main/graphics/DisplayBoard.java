package fr.mrkeesler.main.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.mrkeesler.main.game.game.board.Board;

public class DisplayBoard {

    private ShapeRenderer renderer;
    private final int SIZE;
    private Board board;
    private final double SPEED = 0.5;

    public DisplayBoard(Board board){
        renderer = new ShapeRenderer();
        this.board = board;
        SIZE = Gdx.graphics.getHeight()/this.board.getHeight();
    }

    public void printBoard(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i < board.getHeight(); i++){
            for(int j = 0; j < board.getWidth(); j++){
                if(board.getBoard()[i][j] != null){
                    renderer.setColor(board.getBoard()[i][j].getValue().getColor());
                    renderer.rect(board.getBoard()[i][j].getPos().getX()*SIZE,board.getBoard()[i][j].getPos().getY()*SIZE,SIZE,SIZE);
                }else {
                    renderer.setColor(Color.CLEAR);
                    renderer.rect(i*SIZE,j*SIZE,SIZE,SIZE);
                }
            }
        }
        renderer.end();
    }

}
