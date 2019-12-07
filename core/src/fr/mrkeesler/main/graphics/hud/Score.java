package fr.mrkeesler.main.graphics.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.mrkeesler.main.game.game.board.Board;

public class Score {

    public Stage stage;
    Label score;
    private FitViewport viewport;
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private Board board;

    public Score(SpriteBatch batch, Board board){
        this.batch = batch;
        this.cam = new OrthographicCamera();
        this.viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),cam);
        this.board = board;
        this.stage = new Stage(viewport,batch);
        initStage();
    }

    private void initStage(){
        Table table = new Table();
        table.right();

        score = new Label("Score = "+board.calculateScore(),new Label.LabelStyle(new BitmapFont(), Color.BLACK));

        table.add(score).expandX().pad(10);

        this.stage.addActor(table);
    }

}
