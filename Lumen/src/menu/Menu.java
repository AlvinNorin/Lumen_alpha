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

import java.util.Random;
import sound.Sound;

/**
 * @author Alvin
 */
public class Menu {
	static boolean update = true;
	static Random r = new Random();
	public static void update() {
		if (update) {
			Sound.random("random", 1f, "OGG", "res/sound/music", 11);
			//Sound.random("random", 1f, "OGG", "res/sound/music/records", 11);
			GUI.Background.draw("dirt");
			GUI.Button.draw("Main_Multiplayer", "MULTIPLAYER", GUI.Coordinates.x/2-96, GUI.Coordinates.y/2-100, 3, 1, "planks_oak", 3, 64);
			GUI.Button.draw("Main_Settings", "SETTINGS", GUI.Coordinates.x/2-96, GUI.Coordinates.y/2-200, 3, 1, "planks_oak", 3, 64);
			if (GUI.Button.draw("Main_Singleplayer", "PLAY!", GUI.Coordinates.x/2-96, GUI.Coordinates.y/2, 3, 1, "planks_oak", 3, 64)) {
				GUI.Destroy.menus(true);
				singleplayer.Dev.start();
			}if (GUI.Button.isButtonClicked("Main_Multiplayer")) {
				GUI.Destroy.menus(false);
				JukeBox.start();
			}if (GUI.Button.isButtonClicked("Main_Settings")) {
				GUI.Destroy.menus(false);
				Settings.start();
			}
		}
	}
	
	public static void destroy(boolean Music) {
		update = false;
		
	}
	
	public static void start() {
		update = true;
	}
	
}
