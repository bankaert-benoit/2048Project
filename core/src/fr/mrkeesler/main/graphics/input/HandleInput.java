package fr.mrkeesler.main.graphics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import fr.mrkeesler.main.game.direction.DirectionType;
import fr.mrkeesler.main.game.game.board.Board;
import fr.mrkeesler.main.game.utils.Position;

public class HandleInput {

    private static DirectionType previous;

    public static void handleInput(Board board){
        /*
        if(Gdx.input.justTouched()){
            System.out.println("TOUCHED");
            getSwipeDirection(new Position(Gdx.input.getX(),Gdx.input.getY()),board);
        }
        */
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP) && previous != DirectionType.RIGHT){
            board.move(DirectionType.RIGHT);
            previous = DirectionType.RIGHT;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && previous != DirectionType.LEFT) {
            board.move(DirectionType.LEFT);
            previous = DirectionType.LEFT;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && previous != DirectionType.UP){
            board.move(DirectionType.UP);
            previous = DirectionType.UP;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && previous != DirectionType.DOWN){
            board.move(DirectionType.DOWN);
            previous = DirectionType.DOWN;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            board.reset();
        }
    }

    public static void getSwipeDirection(Position initPos,Board board){
        System.out.println("GETTING SWIPE DIRECTION");
        int dX = Gdx.input.getX() - initPos.getX();
        int dY = Gdx.input.getY() - initPos.getY();

        if(Math.abs(dX) > Math.abs(dY)){
            if(dX > 0){
                board.move(DirectionType.RIGHT);
            }else if(dX < 0){
                board.move(DirectionType.LEFT);
            }
        }else if(Math.abs(dX) < Math.abs(dY)){
            if(dY > 0){
                board.move(DirectionType.DOWN);
            }else if(dY < 0){
                board.move(DirectionType.UP);
            }
        }
    }
}
