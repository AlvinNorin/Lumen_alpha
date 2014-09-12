/**
 *	**	**	**	**	**	**	**	**
 * 	Floor.java
 * 	object
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2013
 * 	Time		:		7:37:01 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package object;

import org.newdawn.slick.Color;

/**
 * @author alvin
 */
public class Floor {

	public static void draw(int x, int y, int width, int height, String texture, Color color, int texture_size) {
		/*
		int texture_x = 0;
		int texture_y = 0;
		int count_x = 0;
		int count_y = 0;
		while (texture_x<=width) {
			texture_x+=texture_size;
			count_x++;
		}
		while (texture_y<=width) {
			texture_y+=texture_size;
			count_y++;
		}
		int x2, y2 = 0;
		x2 = x+width;
		y2 = y+height;
		Texture.find(texture).bind();
		color.bind();
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(0, 0);
    		GL11.glVertex2f(x, y);
    		GL11.glTexCoord2f(0, count_y);
    		GL11.glVertex2f(x, y2);
    		GL11.glTexCoord2f(count_x, count_y);
    		GL11.glVertex2f(x2, y2);
    		GL11.glTexCoord2f(count_x, 0);
    		GL11.glVertex2f(x2, y);
    	GL11.glEnd();
    	*/
		GUI.Texture.draw(texture, color, x, y, width, height);
	}
	
}
