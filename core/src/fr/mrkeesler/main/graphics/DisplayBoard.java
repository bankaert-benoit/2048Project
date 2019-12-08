package fr.mrkeesler.main.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import fr.mrkeesler.main.game.game.board.Board;

public class DisplayBoard {

    private ShapeRenderer renderer;
    private final int SIZEX, SIZEY;
    private Board board;
    private final double SPEED = 0.5;
    private final int PADDING = 100;

    public DisplayBoard(Board board){
        renderer = new ShapeRenderer();
        this.board = board;
        SIZEY = (Gdx.graphics.getHeight()-PADDING)/this.board.getHeight();
        SIZEX = Gdx.graphics.getWidth()/this.board.getWidth();
    }

    public void printBoard(){
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        for(int i = 0; i < board.getHeight(); i++){
            for(int j = 0; j < board.getWidth(); j++){
                if(board.getBoard()[i][j] != null){
                    renderer.setColor(board.getBoard()[i][j].getValue().getColor());
                    renderer.rect(board.getBoard()[i][j].getPos().getX()*SIZEX,board.getBoard()[i][j].getPos().getY()*SIZEY,SIZEX,SIZEY);
                }else {
                    renderer.setColor(0.93f, 0.81f, 0.69f,1);
                    renderer.rect(i*SIZEX,j*SIZEY,SIZEX,SIZEY);
                }
            }
        }
        renderer.end();
    }

}
