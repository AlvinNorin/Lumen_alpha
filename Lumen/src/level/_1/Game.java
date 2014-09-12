/**
 *	**	**	**	**	**	**	**	**
 * 	Game.java
 * 	level._1
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		08:21:25
 * 
 *	**	**	**	**	**	**	**	**
 */
package level._1;

import java.util.Random;

/**
 * @author Alvin
 */
public class Game {

	static Random r = new Random();
	
	public static void update() {
		game.Check.io_Tower_update = false;
		bGMusic();
	}
	
	public static void start() {
		game.Check.io_Level_1_start = false;
		bGMusicLoad();
	}
	
	public static void destroy() {
		game.Check.io_Level_1_update = false;
	}
	
	static void bGMusicLoad() {
		int rand = 1;
		rand = r.nextInt(11);
		System.out.println("[bGMusic] rand = "+rand+"!");
	}
	
	static void bGMusic() {
	}
}
