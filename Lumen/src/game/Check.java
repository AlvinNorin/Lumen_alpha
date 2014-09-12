package game;
/**
 *	**	**	**	**	**	**	**	**
 * 	Check.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		17:51:44
 * 
 *	**	**	**	**	**	**	**	**
 */

/**
 * @author Alvin
 */
public class Check {
	
	public static boolean io_GUI_mainMenu = true;
	public static boolean io_GUI_jukeBox = false;
	static boolean io_GUI_update = true;
	public static boolean io_Tower_update = false;
	public static boolean io_Level_1_update = false;
	public static boolean io_Level_1_start = false;
	public static boolean io_Level_1_ready = false;
	public static boolean io_Menu_Load = true;
	public static boolean io_Splash_Show = false;
	public static boolean io_GUI_Settings = false;
	
	public static void update() {
		if (io_Tower_update == true) {
			level._1.Tower.update();
		}
		if (io_Level_1_update == true && io_Level_1_ready == true) {
			level._1.Game.update();
		}
		if (io_Level_1_start == true) {
			level._1.Game.start();
			io_Level_1_ready = true;
		}
	}

}
