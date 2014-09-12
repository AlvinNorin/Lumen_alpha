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

import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;

import java.util.Random;
import org.lwjgl.opengl.GL11;
import sound.Sound;
import game.Screen;

/**
 * @author Alvin
 */
public class JukeBox {
	static Random r = new Random();
	static boolean update = false;
	public static void update() {
		if (update) {
			
			Screen.color(0.32f, 0.32f, 0.32f);
			
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
		}
	}
	
	public static void destroy(boolean Music) {
		update = false;
		Sound.stop("bg_music");
	}
	
	public static void start() {
		update = true;
	}
	
	public static void load() {
		
	}
}