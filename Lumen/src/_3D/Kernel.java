/**
 *	**	**	**	**	**	**	**	**
 * 	Kernel.java
 * 	_3D
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2014
 * 	Time		:		5:25:05 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package _3D;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import GUI.Texture;

/**
 * @author alvin
 */

public class Kernel {
	
	static boolean enabled = false;
	static boolean update = false;
	//static int[] polygon = new int[1000];
	

	public static void init() {
		System.out.print("Initializing 3D..");
		enabled = true;
		update = true;
		System.out.print("[OK]\n");
	}
	
	public static void drawPolygon(float x, float y, float x2, float f, float g, float h, String tex, float hc1, float vc1, float hc2, float d, float hc3, float vc3, Color color) {
		Texture.find(tex).bind();
		color.bind();
		GL11.glBegin(GL11.GL_POLYGON);
			/*GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x1, y1);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x1, y2);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x2, y2);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x2, y1);*/
			GL11.glTexCoord2f(hc1, vc1);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(hc2, d);
			GL11.glVertex2f(x2, f);
			GL11.glTexCoord2f(hc3, vc3);
			GL11.glVertex2f(g, h);
		GL11.glEnd();
	}
	
	public static void update(int state) {
		boolean True = false;
		if (enabled) {
			if (state == 1) {
				update = true;
				True = true;
			} else if (state == 2) {
				if (update == true) {
					True = true;
				}
			} else if (state == 0) {
				update = false;
			} if (True) {
				
			}
		} else {
			System.err.print("3D kernel was used before it was initialized..\n");
			System.exit(1);
		}
	}
	
}
