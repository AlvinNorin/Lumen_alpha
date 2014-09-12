package game;
/**
 *	**	**	**	**	**	**	**	**
 * 	Screen.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		13:26:54
 * 
 *	**	**	**	**	**	**	**	**
 */


import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;

/**
 * @author Alvin
 */
public class Screen {
	
	public static boolean isFullScreen = false;

	public static void title(String Title){
		Display.setTitle(Title);
	}
	
	public static void full(boolean Toggle){
		try {
			Display.setResizable(true);
			Display.setFullscreen(Toggle);
		} catch (LWJGLException e) {
			System.out.println("Failed to go set displaymode to fullscreen!");
		}
		if (!Toggle&&Display.isFullscreen()) {
			Display.setResizable(false);
		}
	}

	public static void clear(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void update(int fps){
		//While close not requested and display is active, screen will continue update.
		while (!Display.isCloseRequested()){
			Main.Action();
			Display.update();
			Display.sync(60);
		}
		//If close requested, game will quit.
		if (Display.isCloseRequested()){
			Display.destroy();
			AL.destroy();
			System.exit(0);
		}
	}
	
	public static void create(String title, int arg0, int arg1, boolean full) {
		
		Display.setTitle(title);
		
		Display.setResizable(true);
		
		if (full == true) {
			try {
				Display.setFullscreen(true);
				Display.create();
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
		}else{

		Display.getDesktopDisplayMode();
		
		try {
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		Display.setResizable(true);
		
		System.out.println(Display.getWidth() + ", ");
		System.out.println(Display.getHeight());
		}
	}

	public static void color(float A, float B, float C){
		glColor3f(A,B,C);
	}
	
	public static void fps() {
		Display.update();
	}
	
}
