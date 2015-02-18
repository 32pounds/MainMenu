package com.menu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.menu.game.Menu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = Menu.WIDTH;
        config.height = Menu.HEIGHT;
        config.title = Menu.TITLE;

		new LwjglApplication(new Menu(), config);
	}
}
