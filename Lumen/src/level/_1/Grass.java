/**
 *	**	**	**	**	**	**	**	**
 * 	Grass.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		08:28:04
 * 
 *	**	**	**	**	**	**	**	**
 */
package level._1;

import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;
import game.Screen;

/**
 * @author Alvin
 */
public class Grass {
	
	public static void update() {
		
	}
	
	static void draw(int x1, int y1, int x2, int y2) {
		int bx = 0;
		int by = 0;
		int bx2 = 0;
		int by2 = 0;
		
		//color variables((!R)G(!B));
		float g = 0.4901960784313725f;
		
		int lx = x1;
		int ly = y1;
		
		while (bx<=x2) {
			bx+=4;
		}
		while (by<=y2) {
			by+=4;
		}
		while (bx2<=bx && by2<=by) {
			Screen.color(0f, g, 0f);
			glBegin(GL_POLYGON);
				glVertex2i(lx, ly);
				glVertex2i(lx+4, ly);
				glVertex2i(lx, ly+4);
			glEnd();glBegin(GL_POLYGON);
				glVertex2i(lx+4, ly+4);
				glVertex2i(lx+4, ly);
				glVertex2i(lx, ly+4);
			glEnd();
			bx2+=4;
			lx+=4;
			
			if (g == 0.4901960784313725f) {
				g = 0.392156862745098f;
			}else{
				g = 0.4901960784313725f;
			}if (bx2>=bx) {
				bx2 = 0;
				by2+=4;
				ly+=4;
				lx = x1;
			}
		}
	}
}
