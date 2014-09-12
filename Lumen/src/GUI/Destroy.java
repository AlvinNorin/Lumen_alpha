/**
 *	**	**	**	**	**	**	**	**
 * 	Destroy.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		18:25:22
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

/**
 * @author Alvin
 */
public class Destroy {

	public static void menus(boolean music) {
		menu.Menu.destroy(music);
		menu.Settings.destroy(music);
		menu.FB.destroy(true);
		sound.Sound.stop("random");
	}
	
}