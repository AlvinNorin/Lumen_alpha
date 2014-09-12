/**
 *	**	**	**	**	**	**	**	**
 * 	Cube.java
 * 	_3D
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2014
 * 	Time		:		5:23:46 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package _3D;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import GUI.Texture;

/**
 * @author alvin
 */
public class Cube {
	
	public static void draw() {
		float x1 = 0;
		float x2 = 256;
		
		float y1 = 0;
		float y2 = 256;
		
		float z1 = 0;
		float z2 = 256;
		
		Texture.find("dirt").bind();
		GL11.glBegin(GL11.GL_QUADS);
        {
            //front face
        	/*GL11.glNormal3f(0f, 0f, -32f);
        	GL11.glTexCoord2f(0f, 1f);
        	GL11.glVertex3f(256f, 0f, -16f); //1
        	GL11.glTexCoord2f(1f, 1f);
        	GL11.glVertex3f(0f, 0f, -16f); // 2
        	GL11.glTexCoord2f(1f, 0f);
        	GL11.glVertex3f(0f, 256f, -16f); // 3
        	GL11.glTexCoord2f(0f, 0f);
        	GL11.glVertex3f(256f, 256f, -16f); // 4*/
        	
			GL11.glTexCoord2f(0, 0);
	    	GL11.glVertex3f(x1, y1, 16);
	    	GL11.glTexCoord2f(0, 1);
	    	GL11.glVertex3f(x1, y2, 0);
	    	GL11.glTexCoord2f(1, 1);
	    	GL11.glVertex3f(x2, y2, 64);
	    	GL11.glTexCoord2f(1, 0);
	    	GL11.glVertex3f(x2, y1, 0);
        }
        GL11.glEnd();
		//GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		//GL11.glLoadIdentity();
		/*Texture.find("dirt").bind();
		GL11.glTranslatef(0f,0.0f,-7f);
			GL11.glRotatef(45f,0.0f,1.0f,0.0f);
			GL11.glColor3f(0.5f,0.5f,1.0f);
			GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f(x2, y2, z1);
			GL11.glTexCoord3f(0, 1, 0);
				GL11.glVertex3f(x1, y2, z1);
			GL11.glTexCoord3f(0, 1, 1);
				GL11.glVertex3f(x1, y2, z2);
			GL11.glTexCoord3f(1, 1, 1);
				GL11.glVertex3f(x2, y2, z2);
			
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
				
			GL11.glTexCoord3f(1, 1, 1);
				GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
			GL11.glTexCoord3f(0, 1, 1);
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glTexCoord3f(0, 0, 1);
				GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
			GL11.glTexCoord3f(1, 0, 1);
				GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
				
			GL11.glTexCoord3f(1, 0, 0);
				GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
			GL11.glTexCoord3f(0, 0, 0);
				GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
			GL11.glTexCoord3f(0, 1, 0);
				GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
				
			GL11.glTexCoord3f(0, 1, 1);
				GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
			GL11.glTexCoord3f(0, 1, 0);
				GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
			GL11.glTexCoord3f(0, 0, 0);
				GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
			GL11.glTexCoord3f(0, 0, 1);
				GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
				
			GL11.glTexCoord3f(1, 1, 0);
				GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
			GL11.glTexCoord3f(1, 1, 1);
				GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
			GL11.glTexCoord3f(1, 0, 1);
				GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
			GL11.glTexCoord3f(1, 0, 0);
				GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
		GL11.glEnd();*/
	}

}
