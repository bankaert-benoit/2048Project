package fr.mrkeesler.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import fr.mrkeesler.main.game.game.board.Board;
import fr.mrkeesler.main.graphics.DisplayBoard;
import fr.mrkeesler.main.graphics.hud.Score;
import fr.mrkeesler.main.graphics.input.HandleInput;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	DisplayBoard display;
	Board board;
	Score score;
	double SPEED = 0.5;

	@Override
	public void create () {
		batch = new SpriteBatch();
		board = new Board(10,10);
		display = new DisplayBoard(board);
		score = new Score(batch,board);
	}

	public void update(){
		HandleInput.handleInput(board);
		for(int i = 0; i < board.getHeight(); i++){
			for(int j = 0; j < board.getWidth(); j++){
				if(board.getBoard()[i][j] != null){
					board.getBoard()[i][j].getPos().setX((int)(board.getBoard()[i][j].getPos().getX()+SPEED));
					board.getBoard()[i][j].getPos().setY((int)(board.getBoard()[i][j].getPos().getY()+SPEED));
				}
			}
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		display.printBoard();
		batch.end();
		/*
		batch.setProjectionMatrix(score.stage.getCamera().combined);
		score.stage.draw();
		*/
		System.out.println(board.calculateScore());
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
