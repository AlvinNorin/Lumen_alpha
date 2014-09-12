/**
 *	**	**	**	**	**	**	**	**
 * 	Time.java
 * 	time
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		nool13
 * 	Year		:		2014
 * 	Time		:		13:19:45
 * 
 *	**	**	**	**	**	**	**	**
 */
package time;

import org.lwjgl.opengl.Display;

/**
 * @author nool13
 */
public class Time {

	/**
	 * @param args
	 */
	static double lastFPS;
	static double fps;
    static double lastFrame;
	
	public static void start() {
	    lastFPS = getTime(); //initialise lastFPS by setting to current Time
	}
	 
	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public static void updateFPS() {
	    if (getTime() - lastFPS > 1000) {
		fps = 0;
		lastFPS += 1000;
	    }
	    fps++;
	}
	
	public static long getTime() {
	    return System.nanoTime() / 1000000;
	}
	
	public static int getDelta() {
	    long time = getTime();
		int delta = (int) (time - lastFrame);
	    lastFrame = time;
	    return delta;
	}
	
	public static String delta() {
		float lastFPS = System.nanoTime() / 1000000;
		updateFPS();
		float FPS = (float) (System.nanoTime() / 1000000 + fps - lastFPS);
		return lastFPS + ", " + fps + ", " + FPS + "\n";
	}

}
