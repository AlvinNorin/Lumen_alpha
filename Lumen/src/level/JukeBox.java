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
package level;

import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;

import java.util.Random;
import org.lwjgl.opengl.GL11;
import game.Check;
import game.Screen;

/**
 * @author Alvin
 */
public class JukeBox {
	static Random r = new Random();
	static boolean update = false;
	public static void update() {
		if (update) {
			bGMusic();
			Screen.color(0.32f, 0.32f, 0.32f);
			
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
			GUI.drawButton("START", null, GUI.x/2-94, GUI.y/2, 0);
			GUI.drawButton("JUKEBOX", null, GUI.x/2-94, GUI.y/2-100, 1);
			GUI.drawButton("SETTINGS", null, GUI.x/2-94, GUI.y/2-200, 2);
			if (GUI.buttonAction == true && GUI.id == 0) {
				Check.io_GUI_mainMenu = false;
				game.Start._0();
			}if (GUI.buttonAction == true && GUI.id == 1) {
				Check.io_GUI_jukeBox = true;
			}
		}
	}
	
	static void bGMusic() {
	}
	
	static void bGMusicLoad() {
		int rand = 1;
		rand = r.nextInt(11);
		System.out.println("[bGMusic] rand = "+rand+"!");
	}
	
	public static void destroy(boolean Music) {
		update = false;
	}
	
	public static void start() {
		update = true;
	}
	
	public static void load() {
		
	}
}