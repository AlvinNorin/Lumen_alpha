/**
 *	**	**	**	**	**	**	**	**
 * 	Sound.java
 * 	game
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		17:06:41
 * 
 *	**	**	**	**	**	**	**	**
 */
package sound;

import java.io.IOException;
import java.util.Random;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author Alvin
 */
public class Sound {
	
	private static String[] audio_name = new String[127];
	private static Audio[] audio_index = new Audio[127];
	private static int audio_total;
	static boolean mute = true;
	
	static Random r = new Random();
	
	public static Audio find(String name) {
		int counter = 0;
		while (name!=audio_name[counter]&&counter<=audio_total) {
			counter++;
		} if (name!=audio_name[counter]) {
			audio_index[counter]=audio_index[audio_total];
		}
		return audio_index[counter];
	}
	
	public static int find_int(String name) {
		int counter = 0;
		while (name!=audio_name[counter] && counter<=audio_total) {
			counter++;
		}return counter;
	}
	
	public static boolean find_boolean(String name) {
		int counter = 0;
		while (name!=audio_name[counter] && counter<=audio_total) {
			counter++;
		}if (name!=audio_name[counter]) {
			return false;
		}else{
			return true;
		}
	}
	
	public static void load0(String name, String type, String location) {
		try {
			if (AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream(location))!=null) {
				try {
					audio_index[audio_total] = AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream(location));
				} catch (IOException e) {e.printStackTrace();}
				audio_name[audio_total] = name;
				audio_total++;
			}else{
				System.out.println("Sound not found!");
			}
		}catch (IOException e1) {e1.printStackTrace();}
	}
	
	public static void load(String name, String format, String location) {
		int id;
		if (Sound.find_boolean(name)) {
			id = Sound.find_int(name);
			System.out.println("[Audio[Loader] Loading audio "+location+" from disk, with name \""+name+"\" to existing Audio["+id+"]");
		}else{
			id = audio_total;
			System.out.println("[Audio[Loader] Loading audio "+location+" from disk, with name \""+name+"\" to new Audio["+id+"]");
		}
		try {
			audio_index[id] = AudioLoader.getAudio(format, ResourceLoader.getResourceAsStream(location));
		} catch (IOException e) {
			e.printStackTrace();
		}audio_name[id] = name;
		if (id==audio_total) {
			audio_total++;
		}
		System.out.println("Ok!");
	}
	
	public static void load_int(int id, String type, String location) {
		Audio audio = null;
		try {
			audio = AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream(location));
		} catch (IOException e) {e.printStackTrace();}
		Sound.audio_index[id] = audio;
	}
	
	public static void stream(String name, float speed, boolean loop) {
		if (!mute) {
			find(name).playAsSoundEffect(speed, speed, loop);
		}
	}
	
	public static void stop(String name) {
		if (Sound.find_boolean(name)) {
			if (find(name).isPlaying()) {
				find(name).stop();
			}
		}else{
			System.out.println("[Audio[Stop]] Audio \""+name+"\" not found!");
		}
	}
	
	public static int rand(int max) {
		return r.nextInt(max);
	}
	
	public static boolean random_begin = false;
	public static void random(String name, float speed, String type, String location, int max) {
		//try {
		if (!random_begin) {
			Sound.load(name, type, location+"/"+rand(max)+".ogg");
			Sound.stream(name, speed, false);
			random_begin = true;
		}
		if (!Sound.find(name).isPlaying()) {
			if (Sound.find_boolean(name)) {
				Sound.stream(name, speed, false);
			}else{
				Sound.load(name, type, location+"/"+rand(max)+".ogg");
			}
		}
		//} catch (NullPointerException e) {
			//System.out.print("Reloading..");
			boolean random_begin = false;
		//}
	}
	
}
