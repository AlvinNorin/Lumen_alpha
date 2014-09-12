/**
 *	**	**	**	**	**	**	**	**
 * 	Cable.java
 * 	items
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		15:52:57
 * 
 *	**	**	**	**	**	**	**	**
 */
package items;

/**
 * @author Alvin
 */
public class Cable {
	
	static int x;
	static int y;
	static int id;
	static int[] ids = new int[999999];
	static float[] idPower = new float[999999];
	static int pointerx;
	static int pointery;
	static char pointerPos;
	static boolean isPointer;
	static char pointerDir;
	
	public static void update() {
		
	}
	
	static void design() {
		
	}
	
	static void add(int x, int y) {
		pointer();
	}
	
	//Check if another cable is powered and returns true if it is;
	static boolean checkPower() {
		if (pointerx>x && pointerx<x+16 && pointery>y && pointery<y+16) {
			if (idPower[ids[id]]>0) {
				isPointer=true;
			}else{
				isPointer=false;
			}
		}
		return isPointer;
	}
	
	static void pointer() {
		
	}
	
}