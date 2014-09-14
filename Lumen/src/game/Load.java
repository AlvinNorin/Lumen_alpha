/**
 *	**	**	**	**	**	**	**	**
 * 	load.java
 * 	game
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2014
 * 	Time		:		10:26:27 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package game;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import GUI.Button;

/**
 * @author alvin
 */
public class Load {
	
	static boolean load = false;
	static int step = 0;
	static Color step1 = Color.transparent, step2 = Color.transparent, step3 = Color.transparent, step4 = Color.transparent;
	public static String status = "LOADING TEXTURES..";

	public static void startup() {
		time.Time.start();
		if (!load) {
			load_startup();
			load = true;
		} GUI.Background.draw("dirt");
		/*
		GUI.Texture.draw("mojang", Color.white, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()/2)), ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()/2)), 0, 0);
		GUI.Texture.draw("redstone_lamp_off", Color.black, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+128, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_off", Color.white, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+192, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_off", Color.white, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+256, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_off", Color.white, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+320, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_on", step1, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+128, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_on", step2, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+192, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_on", step3, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+256, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		GUI.Texture.draw("redstone_lamp_on", step4, ((Display.getWidth()/2)-(GUI.Texture.find("mojang").getImageWidth()))+320, ((Display.getHeight()/2)-(GUI.Texture.find("mojang").getImageHeight()-64)), 64, 64);
		*/
		game.Text.draw(status, 0, 0, 8, Color.white);
		game.Main.started = true;
	}
	
	public static void load_startup() {
		GUI.Texture.load("stonebrick", "PNG", "res/textures/stonebrick.png");
		GUI.Texture.load("dirt", "PNG", "res/textures/dirt.png");
		GUI.Texture.load("gubbe_front", "PNG", "res/gubbe 1.png");
		GUI.Texture.load("gubbe_side", "PNG", "res/gubbe 2.png");
		GUI.Texture.load("gubbe_back", "PNG", "res/gubbe 3.png");
		GUI.Texture.load("grass", "PNG", "res/grass.png");
		GUI.Texture.load("grass2", "PNG", "res/high_res_grass.png");
		GUI.Texture.load("door1", "PNG", "res/textures/door1.png");
		GUI.Texture.load("font_default", "PNG", "res/font/default.png");
		GUI.Texture.load("vector", "PNG", "res/vector.png");
		GUI.Texture.load("gui_gui", "PNG", "res/textures/gui/gui.png");
		//GUI.Texture.load("mojang", "PNG", "res/textures/mojang.png");
		//GUI.Texture.load("redstone_lamp_off", "PNG", "res/textures/redstone_lamp_off.png");
		//GUI.Texture.load("redstone_lamp_on", "PNG", "res/textures/redstone_lamp_on.png");
		GUI.MenuWork.Load();
		Button.loadTextures();
		Text.load();
	}
	
}
