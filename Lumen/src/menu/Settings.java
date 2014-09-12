/**
 *	**	**	**	**	**	**	**	**
 * 	Menu.java
 * 	mainMenu
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		20:27:18
 * 
 *	**	**	**	**	**	**	**	**
 */
package menu;

import game.Text;

import java.util.Random;
import org.newdawn.slick.Color;

import GUI.Button;

import sound.Sound;

import file.*;

/**
 * @author Alvin
 */
public class Settings {
	static Random r = new Random();
	static boolean update = false;
	
	static boolean toggle_sounds = true;
	static String GUIScale = null;
	
	public static void update() {
		if (update) {
			Sound.random("random", 1f, "OGG", "res/sound/music", 11);
			GUI.Background.draw("dirt");
			Text.draw("SETTINGS", GUI.Coordinates.x/2-94, GUI.Coordinates.y/4*3, 6, Color.white);
			GUI.Button.draw("Music", GUIScale.toUpperCase(), GUI.Coordinates.x/2-94, GUI.Coordinates.y/2, 1, 1, "planks_oak", 2, 128);
			if (Button.isButtonClicked("Music")) {
				if (GUIScale.length()==6) {
					GUIScale="Auto";
					Create.createFile("Settings/GUIScale");
					Create.write("Auto");
					Create.closeFile();
				}else{
					GUIScale="Normal";
					Create.createFile("Settings/GUIScale");
					Create.write("Normal");
					Create.closeFile();
					game.Main.Sleep(256);
				}
			}  
		}
	}
	
	public static void destroy(boolean Music) {
		update = false;
	}
	
	public static void start() {
		update = true;
		Read.setFile("Settings/GUIScale");
		GUIScale = Read.readFile();
		Read.closeFile();
	}
	
}