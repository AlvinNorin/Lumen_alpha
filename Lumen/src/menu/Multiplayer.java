/**
 *	**	**	**	**	**	**	**	**
 * 	Multiplayer.java
 * 	menu
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2014
 * 	Time		:		19:52:51
 * 
 *	**	**	**	**	**	**	**	**
 */
package menu;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import _3D.Cube;
import player.Player1;
import player.Player2;
import player.Player3;
import player.Player4;
import player.Player1.dir;
import singleplayer.server;
import sound.Sound;

/**
 * @author Alvin
 */
public class Multiplayer {
	static boolean update = true;
	static Random r = new Random();
	static boolean connected = false;
	static boolean connection_init = false;
	static int connection_path = 0;
	public static void update() {
		if (update) {
			Sound.random("random", 1f, "OGG", "res/sound/music", 11);
			//Sound.random("random", 1f, "OGG", "res/sound/music/records", 11);
			GUI.Background.draw("dirt");
			int x = 0;
			if (GUI.Button.draw("Join", "JOIN_SERVER " + Integer.parseInt(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player.online")) + "/" + 4 + " ONLINE", Display.getWidth()/2-64*3, Display.getHeight()/2-64, 3, 1, "planks_oak", 3, 128)) {
				try {
					x = Integer.parseInt(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player.online"));
					/* int y = StringUtils.substring(x, 1); */
					if (x == 0) Player1.me = true;
					if (x == 1) Player2.me = true;
					if (x == 2) Player3.me = true;
					if (x == 3) Player4.me = true;
					player.Main.Player = "YOU ARE: PLAYER " + (x + 1);
					try {
						Integer.parseInt(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player.online&&field2=" + (x + 1)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (x > 3) {
					GUI.Button.draw("Info", "SERVER IS FULL", Display.getWidth()/2-64*3, Display.getHeight()/2-64, 3, 1, "planks_oak", 3, 128);
				} else {
					GUI.Destroy.menus(true);
					singleplayer.Dev.start();
				}
			}
			
			if (GUI.Button.draw("Clear", "CLEAR SERVER", Display.getWidth()/2-64 * 3, Display.getHeight()/2 - 246, 3, 1, "stonebrick", 3, 128)) {
				//Cube.draw();
				singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player.online&&field2=" + 0);
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_F1)) {
				System.out.print("[singleplayer.server.address]: ");
				singleplayer.server.address = "hej";
				System.out.println(singleplayer.server.address);
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