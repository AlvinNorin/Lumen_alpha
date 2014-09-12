/**
 *	**	**	**	**	**	**	**	**
 * 	Start.java
 * 	game
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		08:26:59
 * 
 *	**	**	**	**	**	**	**	**
 */
package game;

import org.lwjgl.LWJGLException;

/**
 * @author Alvin
 */
public class Start {
	
	static boolean started = false;
	
	public static void main(String[] args) throws InterruptedException, LWJGLException{
		if (!started) {
			GUI.Texture.load("dirt", "PNG", "");
		}
	}
	
	public static void _0() {
		Check.io_Level_1_start = true;
		Check.io_Level_1_update = true;
	}
	
}