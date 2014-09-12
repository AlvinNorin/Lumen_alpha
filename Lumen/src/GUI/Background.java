/**
 *	**	**	**	**	**	**	**	**
 * 	Background.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		18:59:37
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

/**
 * @author Alvin
 */
public class Background {
	
	public static void draw(String name) {
		int x = 0;
		int y = 0;
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		if (GUI.Texture.find(name).getImageWidth()<=GUI.Coordinates.x && GUI.Texture.find(name).getImageHeight()<=GUI.Coordinates.y) {
			while (y<=GUI.Coordinates.y) {
				while (x<=GUI.Coordinates.x) {
					GUI.Texture.draw(name, Color.darkGray, x, y, 64, 64);
					x+=64;
				}
				x = 0;
				y+=64;
			}
		}else{
			GUI.Texture.draw(name, Color.darkGray, 0, 0, 64, 64);
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
	}
	
	public static void drawAdvanced(String name, int width, int height) {
		int x = 0;
		int y = 0;
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		if (GUI.Texture.find(name).getImageWidth()<=GUI.Coordinates.x && GUI.Texture.find(name).getImageHeight()<=GUI.Coordinates.y) {
			while (y<=Display.getHeight()) {
				while (x<=Display.getWidth()) {
					GUI.Texture.draw(name, Color.darkGray, x, y, width, height);
					x+=width;
				}
				x = 0;
				y+=height;
			}
		}else{
			GUI.Texture.draw(name, Color.darkGray, 0, 0, width, height);
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
	}
	
}
