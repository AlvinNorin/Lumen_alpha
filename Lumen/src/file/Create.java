/**
 *	**	**	**	**	**	**	**	**
 * 	Create.java
 * 	file
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2013
 * 	Time		:		9:22:46 PM
 * 
 *	**	**	**	**	**	**	**	**
 */
package file;

import java.util.Formatter;

/**
 * @author alvin
 */
public class Create {
	
	private static Formatter f;
	
	public static void createFile(String file) {

		try {
			f = new Formatter(file);
			System.out.println("Successfully created file : \""+file+"\"");
		} catch (Exception e) {
			System.out.println("Error: could not create file : \""+file+"\"!");
		}
	}
	
	public static void write(String text) {
		f.format("%s", text);
	}
	
	public static void closeFile() {
		f.close();
	}

}
