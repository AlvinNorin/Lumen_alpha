/**
 *	**	**	**	**	**	**	**	**
 * 	Read.java
 * 	file
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2013
 * 	Time		:		9:22:57 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 * @author alvin
 */
public class Read {
	
	private static Scanner s;
	
	public static void setFile(String file) {
		try {
			s = new Scanner(new File(file));
		} catch (Exception e) {
			System.out.println("Error: failed to read file \""+file+"\"!");
		}
	}
	
	public static String readFile() {
		String b = null;
		while (s.hasNext()) {
			b = s.next();
		}
		System.out.println("[File] "+b);
		return b;
	}
	
	public static void closeFile() {
		s.close();
	}
	
}
