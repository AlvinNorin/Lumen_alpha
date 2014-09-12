/**
 *	**	**	**	**	**	**	**	**
 * 	Texture.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		17:04:01
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.util.ResourceLoader;


/**
 * @author Alvin
 */
public class Texture {
	static String[] tex_name = new String[128];
	static org.newdawn.slick.opengl.Texture[] texture_index = new org.newdawn.slick.opengl.Texture[128];
	
	static int textures = 0;
	
	public static org.newdawn.slick.opengl.Texture find(String name) {
		int counter = 0;
		org.newdawn.slick.opengl.Texture Tex = null;
		while (name!=tex_name[counter]&&counter<=textures) {
			counter++;
		} if (texture_index[counter] != null) {
			Tex=texture_index[counter];
		} else {
			System.out.println("Texture "+name+" not found!");
		}
		return Tex;
	}
	
	public static void load(String name, String format, String location) {
		System.out.println("[GUI[Texture]] Loading texture "+location+" from disk, with name "+name+" and id ["+textures+"]..");
		try {
			texture_index[textures] = org.newdawn.slick.opengl.TextureLoader.getTexture(format, ResourceLoader.getResourceAsStream(location), true, GL11.GL_NEAREST);
		} catch (IOException e) {
			e.printStackTrace();
		}tex_name[textures] = name;
		textures++;
		System.out.println("Ok!");
	}
	
	public static void draw(String name, Color c, int x, int y, int width, int height) {
		int x2, y2 = 0;
			x2 = x+width;
			y2 = y+height;
		Texture.find(name).bind();
		c.bind();
		if (height == 0) y2 = y+Texture.find(name).getImageHeight();
		if (width == 0) x2 = x+Texture.find(name).getImageWidth();
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(0, 0);
	    	GL11.glVertex2f(x, y);
	    	GL11.glTexCoord2f(0, 1);
	    	GL11.glVertex2f(x, y2);
	    	GL11.glTexCoord2f(1, 1);
	    	GL11.glVertex2f(x2, y2);
	    	GL11.glTexCoord2f(1, 0);
	    	GL11.glVertex2f(x2, y);
		GL11.glEnd();
	}
}
