/**
 *	**	**	**	**	**	**	**	**
 * 	Dev.java
 * 	singleplayer
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2013
 * 	Time		:		7:34:48 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package singleplayer;

import game.Main;
import game.Screen;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import sound.Sound;
import time.Time;

/**
 * @author alvin
 */
public class Dev {
	static boolean update = false;
	
	public static void update() {
		if (update) {
			Sound.random("record", 1f, "OGG", "res/sound/music/records", 11);
			GUI.Background.drawAdvanced("grass", 256, 256);
			int x = 0;
			try {
				x = Integer.parseInt(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player.online"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (x == 1) player.Player1.draw();
			else if (x == 2) {	player.Player1.draw(); player.Player2.draw();	}
			else if (x == 3) {	player.Player1.draw(); player.Player2.draw(); player.Player3.draw();	}
			else if (x == 4) {	player.Player1.draw(); player.Player2.draw(); player.Player3.draw(); player.Player4.draw(); }
			GUI.Button.draw("Info", player.Main.Player, 0, (Display.getHeight() - 64), 8, 1, "planks_oak", 3, 64);
			//object.Floor.draw(0, 0, 128, 128, "dirt", Color.white, 64);
			//_3D.Kernel.drawPolygon(256, 256, 0, 256, 512, 0, 512, 512, -16, -0, -0, -0, +1, +1, +1);
			//_3D.Kernel.drawPolygon(512, 512, 0, 512, 256, 0, 256, 256, -16, +1, +1, +1, -0, -0, -0);
			//_3D.Kernel.drawPolygon(x, y, 32, x, y+256, 64, x+256, y+256, 16, -0, -0, -0, -0, +1, +1);
		}
	}
	
	public static void start() {
		update = true;
		Sound.random_begin = false;
	}
	
	public static void destroy() {
		update = false;
	}
	
}
