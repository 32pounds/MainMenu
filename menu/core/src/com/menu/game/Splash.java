package com.menu.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class Splash implements Screen {

    private Texture texture = new Texture(Gdx.files.internal("sky.jpg"));
    private Image splashImage = new Image(texture);
    private Stage stage = new Stage();
    private Skin skin;


    @Override
    public void show() {
        stage.addActor(splashImage);

        splashImage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(0.5f), Actions.delay(2), Actions.run(new Runnable() {
            @Override
            public void run() {
                ((Game) Gdx.app.getApplicationListener()).setScreen(new Splash());
            }
        })));

        Gdx.input.setInputProcessor(stage);

        skin = new Skin();
        Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin.add("blue", new Texture("button.png"));

        // Store the default libgdx font under the name "default".
        BitmapFont bfont = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        bfont.setColor(Color.WHITE);
        skin.add("default", bfont);

        // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("blue", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("blue", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("blue", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("blue", Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);


        TextButton buttonNewGame = new TextButton("New Game", textButtonStyle);
        TextButton buttonLoadGame = new TextButton("Load Game", textButtonStyle);
        TextButton buttonSaveGame = new TextButton("Save Game", textButtonStyle);
        TextButton buttonOption = new TextButton("Option", textButtonStyle);
        TextButton buttonAbout = new TextButton("About", textButtonStyle);
        TextButton buttonExit = new TextButton("Exit", textButtonStyle);

        buttonNewGame.setPosition(Gdx.graphics.getWidth() / 2 - buttonNewGame.getWidth() / 2, Gdx.graphics.getHeight() - 75);
        buttonLoadGame.setPosition(Gdx.graphics.getWidth() / 2 - buttonLoadGame.getWidth() / 2, Gdx.graphics.getHeight() - 150);
        buttonSaveGame.setPosition(Gdx.graphics.getWidth() / 2 - buttonSaveGame.getWidth() / 2, Gdx.graphics.getHeight() - 225);
        buttonOption.setPosition(Gdx.graphics.getWidth() / 2 - buttonOption.getWidth() / 2, Gdx.graphics.getHeight() - 300);
        buttonAbout.setPosition(Gdx.graphics.getWidth() / 2 - buttonAbout.getWidth() / 2, Gdx.graphics.getHeight() - 375);
        buttonExit.setPosition(Gdx.graphics.getWidth() / 2 - buttonExit.getWidth() / 2, Gdx.graphics.getHeight() - 450);

        stage.addActor(buttonNewGame);
        stage.addActor(buttonLoadGame);
        stage.addActor(buttonSaveGame);
        stage.addActor(buttonOption);
        stage.addActor(buttonAbout);
        stage.addActor(buttonExit);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        ;
    }

    @Override
    public void dispose() {

        //stage.dispose();
        //texture.dispose();
    }
}
