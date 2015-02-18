package com.menu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends Game {

    public static final String TITLE="Game Project";
    public static final int WIDTH=800;
    public static final int HEIGHT=600;

	SpriteBatch batch;
    Splash splash;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        splash = new Splash();
        setScreen(splash);
	}

	@Override
	public void render () {
        super.render();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        splash.render(Gdx.graphics.getDeltaTime());

		batch.begin();

		batch.end();
	}
}
