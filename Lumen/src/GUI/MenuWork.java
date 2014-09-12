/**
 *	**	**	**	**	**	**	**	**
 * 	MenuWork.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		16:20:50
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import sound.Sound;

/**
 * @author Alvin
 */
public class MenuWork {
	public static int Id=0;
	public static int CurrentId;
	public static int id_total = 0;
	public static void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			Id++;
			game.Main.Sleep(256);
			if (Id > id_total) {
				Id = 0;
			}else if (Id < 1) {
				Id = id_total;
			}
			Sound.stream("wood_click", 0.1f, false);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			Id--;
			game.Main.Sleep(256);
			if (Id < 0) {
				Id = id_total;
			}
			Sound.stream("wood_click", 0.1f, false);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
			Id++;
			game.Main.Sleep(256);
			if (Id > id_total) {
				Id = 0;
			}else if (Id < 1) {
				Id = id_total;
			}
			Sound.stream("wood_click", 0.1f, false);
		}
		Id -= (Mouse.getDWheel()*0.009);
	}
	
	public static void Load() {
		Sound.load("wood_click", "OGG", "res/sound/wood_click.ogg");
	}
}
