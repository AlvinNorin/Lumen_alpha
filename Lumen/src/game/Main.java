package game;
/**
 *	**	**	**	**	**	**	**	**
 * 	Main.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		20:42:26
 * 
 *	**	**	**	**	**	**	**	**
 */


import java.util.Scanner;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLU.*;

/**
 * @author Alvin
 */
public class Main {
	
	static boolean started = false;
	
	public static void p(String arg0){
		System.out.println(arg0);
	}

	public static Scanner s = new Scanner(System.in);
	
	static void initGL(){
		glMatrixMode(GL_PROJECTION);
		//glOrtho(-1, 1, -1, 1, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glOrtho(-1, Display.getWidth(), -1, Display.getHeight(), 1, -1);
		//GLU.gluPerspective(90, 90, 0, 1000);
		//glTranslatef(0, 0, 0);
		
		glShadeModel(GL_SMOOTH);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_ALPHA);
		glEnable(GL_BLEND);
		glEnable(GL_DEPTH);
		glDepthFunc(GL_EQUAL);
		glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glClearDepth(1.0f);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		glScalef(1f, 1f, 1f);
		glColor3f(1f, 1f, 1f);
	}

	public static void DrawCube(int x1, int y1, int x2, int y2){
		glBegin(GL_POLYGON);
			glVertex2i(x1, y1);
			glVertex2i(x1, y2);
			glVertex2i(x2, y1);
			glVertex2i(x2, y2);
			glVertex2i(x1, y2);
			glVertex2i(x1, y1);
		glEnd();
	}
	
	public static void Sleep(double d){
		try {
			Thread.sleep((long) d);
		} catch (InterruptedException e) {
			p("Failed to sleep " + d + " seconds. :(");
		}
	}
		
	public static void main(String[] args) {
		Screen.create("Lumen", 100, 100, false);
		try {
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		Screen.update(60);
		
		Action();

	}
	
	public static void Action(){
		Screen.clear();
		initGL();
		Screen.color(1f, 1f, 1f);
		
		//GUI.MenuWork.update();
		if (!started) {
			game.Load.startup();
		} else {
			menu.Main.update();
			time.Time.updateFPS();
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			System.exit(1);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)){
			Screen.full(true);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_E)){
			Screen.full(false);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_HOME)){
			GUI.Destroy.menus(false);
			menu.Menu.start();
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_END)){
			started = false;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_F11)) {
			if (Display.isFullscreen()) {
				Screen.full(true);
			}else{
				Screen.full(false);
			}
		}
	}

}
