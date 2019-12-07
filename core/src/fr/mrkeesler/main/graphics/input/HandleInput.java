package fr.mrkeesler.main.graphics.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import fr.mrkeesler.main.game.direction.DirectionType;
import fr.mrkeesler.main.game.game.board.Board;

public class HandleInput {

    public static void handleInput(Board board){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            board.move(DirectionType.RIGHT);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            board.move(DirectionType.LEFT);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            board.move(DirectionType.UP);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            board.move(DirectionType.DOWN);
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            board.reset();
        }
    }
}
