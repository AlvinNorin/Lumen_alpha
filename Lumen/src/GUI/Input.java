/**
 *	**	**	**	**	**	**	**	**
 * 	Input.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2014
 * 	Time		:		14:34:00
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author Alvin
 */
public class Input {
	static String name[] = new String[128];
	public static String value[] = new String[128];
	static boolean focus[] = new boolean[128];
	static int total = 0;
	static long c = '*';
	
	public static int find(String name) {
		int count = 0;
		int rrn = -1;
		while (count < total) {
			if (Input.name[count] == name) rrn = count;
			count ++;
		}
		return rrn;
	}
	
	public static String draw(String name, int x, int y, int block_width, int block_height, int blocks, String comment) {
		while (find(name) == -1) {
			Input.name[total] = name;
			Input.focus[total] = false;
			value[total] = comment;
			total ++;
		}
		int count = 0;
		int bx = x;
		//GUI.Button.draw("INPUT", null, x, y, block_width, block_height, "brick", font_size, block_size)
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		GUI.Texture.drawAdvanced(x, y, x+block_width, y+block_height, "gui_gui", 0, 0.875f, 0.125f, 1, Color.gray);
		bx += block_width;
		while (count < blocks-2) {
			GUI.Texture.drawAdvanced(bx, y, bx+block_width, y+block_height, "gui_gui", 0.125f, 0.875f, 0.250f, 1, Color.gray);

			bx += block_width;
			count ++;
		}
		
		GUI.Texture.drawAdvanced(bx, y, bx+block_width, y+block_height, "gui_gui", 0.250f, 0.875f, 0.375f, 1, Color.gray);
		if (focus[find(name)] == false) game.Text.draw(value[find(name)], x+(block_width/4), y+((block_width/2)-16), 16, Color.gray);
		if (focus[find(name)] == true) game.Text.draw(value[find(name)], x+(block_width/4), y+((block_width/2)-16), 16, Color.white);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		if (Mouse.isButtonDown(0)) {
			if (Mouse.getX() >= x && Mouse.getX() <= x+(block_width*blocks) && Mouse.getY() >= y && Mouse.getY() <= y+block_height) {
				if (value[find(name)] == comment) value[find(name)] = "";
				focus[find(name)] = true;
			} else {
				focus[find(name)] = false;
			}
		}
		
		if (focus[find(name)]) {
			if (Keyboard.isKeyDown(14) && System.currentTimeMillis() >= c) {value[find(name)] = value[find(name)].substring(0,value[find(name)].length()-1);; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(52) && System.currentTimeMillis() >= c) {value[find(name)] += '.'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_0) && System.currentTimeMillis() >= c) {value[find(name)] += '0'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_1) && System.currentTimeMillis() >= c) {value[find(name)] += '1'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_2) && System.currentTimeMillis() >= c) {value[find(name)] += '2'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_3) && System.currentTimeMillis() >= c) {value[find(name)] += '3'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_4) && System.currentTimeMillis() >= c) {value[find(name)] += '4'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_5) && System.currentTimeMillis() >= c) {value[find(name)] += '5'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_6) && System.currentTimeMillis() >= c) {value[find(name)] += '6'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_7) && System.currentTimeMillis() >= c) {value[find(name)] += '7'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_8) && System.currentTimeMillis() >= c) {value[find(name)] += '8'; c = System.currentTimeMillis()+128;}
			if (Keyboard.isKeyDown(Keyboard.KEY_9) && System.currentTimeMillis() >= c) {value[find(name)] += '9'; c = System.currentTimeMillis()+128;}
		}
		return value[find(name)];
	}
}
