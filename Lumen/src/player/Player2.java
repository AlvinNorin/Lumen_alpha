/**
 *	**	**	**	**	**	**	**	**
 * 	player1.java
 * 	player
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2014
 * 	Time		:		19:25:49
 * 
 *	**	**	**	**	**	**	**	**
 */
package player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import player.Player1.dir;
import singleplayer.server;

/**
 * @author Alvin
 */
public class Player2 {
	public static boolean me = false;
	static float deltaTime;
	static float x = 0;
	static float y = 0;
	public static enum dir {
		front,
		back,
		left,
		right
	}
	public static dir direction = dir.front;
	public static void draw() {
		if (me) {
			deltaTime = (float)time.Time.getDelta() / 1000;
			float speed = deltaTime * 128;
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				y+=speed;
				direction = dir.back;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				y-=speed;
				direction = dir.front;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				x+=speed;
				direction = dir.right;
			} else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				x-=speed;
				direction = dir.left;
			}
			
			singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.x&&field2=" + x);
			singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.y&&field2=" + y);
			if (direction == dir.back) singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.direction&&field2=" + 0);
			if (direction == dir.front) singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.direction&&field2=" + 1);
			if (direction == dir.left) singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.direction&&field2=" + 2);
			if (direction == dir.right) singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=SET&&field1=player2.direction&&field2=" + 3);
		} else {
			x =  Float.parseFloat(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player2.x"));
			y =  Float.parseFloat(singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player2.y"));
			
			String sync_direction = singleplayer.server.sendGet("http://" + server.address + "/index.php?field0=GET&&field1=player2.direction");
			if (Integer.parseInt(sync_direction) == 1) {	direction = dir.front;	}
			else if (Integer.parseInt(sync_direction) == 0) {	direction = dir.back;	}
			else if (Integer.parseInt(sync_direction) == 3) {	direction = dir.right;	}
			else if (Integer.parseInt(sync_direction) == 2) {	direction = dir.left;	}
		}
		
		switch (direction) {
		case front:
			_3D.Kernel.drawPolygon(x, y, x, y+64, x+64, y+64, "gubbe_front", 0, 0, 0, 1, 1, 1, Color.white);
			_3D.Kernel.drawPolygon(x+64, y+64, x+64, y, x, y, "gubbe_front", 1, 1, 1, 0, 0, 0, Color.white);
			//_3D.Kernel.drawPolygon(x, y+13, x, y+32, x+64, y+32, "gubbe_front", 0, 0.32f, 0, 0.5f, 1, 0.5f, Color.black);
			//_3D.Kernel.drawPolygon(x+64, y+32, x+64, y+13, x, y+13, "gubbe_front", 1, 0.5f, 1, 0.32f, 0, 0.32f, Color.black);
			break;
			
		case back:
			_3D.Kernel.drawPolygon(x, y, x, y+64, x+64, y+64, "gubbe_back", 0, 0, 0, 1, 1, 1, Color.white);
			_3D.Kernel.drawPolygon(x+64, y+64, x+64, y, x, y, "gubbe_back", 1, 1, 1, 0, 0, 0, Color.white);
			break;
			
		case right:
			_3D.Kernel.drawPolygon(x, y, x, y+64, x+64, y+64, "gubbe_side", 0, 0, 0, 1, 1, 1, Color.white);
			_3D.Kernel.drawPolygon(x+64, y+64, x+64, y, x, y, "gubbe_side", 1, 1, 1, 0, 0, 0, Color.white);
			break;
			
		case left:
			_3D.Kernel.drawPolygon(x, y, x, y+64, x+64, y+64, "gubbe_side", 1, 0, 1, 1, 0, 1, Color.white);
			_3D.Kernel.drawPolygon(x+64, y+64, x+64, y, x, y, "gubbe_side", 0, 1, 0, 0, 1, 0, Color.white);
			break;
			
		}
	}
	
}
