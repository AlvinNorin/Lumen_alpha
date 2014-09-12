package level;
/**
 *	**	**	**	**	**	**	**	**
 * 	GUI.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		16:39:48
 * 
 *	**	**	**	**	**	**	**	**
 */


import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import java.io.IOException;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author Alvin
 */
public class GUI {
	
	public static int safex = Display.getWidth()-264;
	public static int safey = Display.getHeight();

	public static int x = 0;
	public static int y = 0;
	public static int id = 0;
	static int maxId = 2;
	public static int area16x;
	public static int area16y;
	
	static int r1 = -1;
	static int r2 = -1;
	
	static Texture[] textureId = new Texture[1024];
	static Texture[] textureMenuId = new Texture[128];
	
	public static boolean buttonAction = false;
	public static boolean safeArea_action = false;
	
	static int panorama_Speed = 1;
	static int panorama_SSalue = 0;
	
	static Random r = new Random();
	
	public static void update(){
		menuWork();
		while (area16x <= safex) {
			area16x+=16;
		}
		while (area16y <= safey) {
			area16y+=16;
		}
	}
	
	public static void menuWork(){
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			id++;
			game.Main.Sleep(256);
			if (id > maxId) {
				id = 0;
			}else if (id < 1) {
				id = maxId;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			id--;
			game.Main.Sleep(256);
			if (id < 0) {
				id = maxId;
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
			id++;
			game.Main.Sleep(256);
			if (id > maxId) {
				id = 0;
			}else if (id < 1) {
				id = maxId;
			}
		}
		id -= (Mouse.getDWheel()*0.009);
	}
	
	public static void drawButton(String text, String action, int x1, int y1, int localID) {
		int cx = x1+128/18;
		int cy = y1+64/18;
		int size = 3;
		cx = 124/2-text.length()*size+x1;
		glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+0, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+60, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+124, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[1], Color.lightGray, x1+188, y1-16, 64, 64);
		glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
		game.Text.draw(text, cx, cy, size, Color.lightGray);
		if (localID == id) {
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+0, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+60, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+124, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[1], Color.lightGray, x1+188, y1-16, 64, 64);
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
			GUI.drawTextureId(textureMenuId[2], Color.lightGray, x1+188, y1-16, 64, 64);
			game.Text.draw(text, cx, cy, size, Color.white);
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
				game.Text.draw(text, cx, cy, size, Color.white);
				buttonAction = true;
				
			}else{
				buttonAction = false;
			}
		}else{
			
		}
		
	}
	
	public static void drawToggle(String text, String action, int x1, int y1, int localID, boolean toggle) {
		int cx = x1+128/18;
		int cy = y1+64/18;
		int size = 3;
		cx = 124/2-text.length()*size+x1;
		glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+0, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+60, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[0], Color.gray, x1+124, y1-16, 64, 64);
		GUI.drawTextureId(textureMenuId[1], Color.lightGray, x1+188, y1-16, 64, 64);
		glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
		if (toggle) {
			GUI.drawTextureId(textureMenuId[2], Color.lightGray, x1+188, y1-16, 64, 64);
		}
		game.Text.draw(text, cx, cy, size, Color.lightGray);
		if (localID == id) {
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+0, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+60, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[0], Color.lightGray, x1+124, y1-16, 64, 64);
			GUI.drawTextureId(textureMenuId[1], Color.lightGray, x1+188, y1-16, 64, 64);
			glBlendFunc(GL_SRC_ALPHA, GL11.GL_ONE);
			if (toggle) {
				GUI.drawTextureId(textureMenuId[2], Color.lightGray, x1+188, y1-16, 64, 64);
			}
			game.Text.draw(text, cx, cy, size, Color.white);
			if (Keyboard.isKeyDown(Keyboard.KEY_RETURN)) {
				game.Text.draw(text, cx, cy, size, Color.white);
				buttonAction = true;
				
			}else{
				buttonAction = false;
			}
		}else{
			
		}
		
	}
	
	static void safeArea() {
		int _x = 0;
		int _y = Mouse.getY();
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			_y++;
		}
		game.Screen.color(0.5f, 0.0f, 0.0f);
		game.Main.DrawCube(_x, _y, _x+10000, _y+16);
		if (Mouse.isButtonDown(0)) {
			_y = safey+16;
		}
	}
	
	public static void menu() {
		menu.Menu.update();
	}
	
	public static void loadTexture(String format, String location, int id) {
		Texture Tex = null;
		System.out.println("Writing texture to textureId["+id+"]...");
		try {
			Tex = TextureLoader.getTexture(format, ResourceLoader.getResourceAsStream(location), true,GL11.GL_NEAREST);
		} catch (IOException e) {
			e.printStackTrace();
		}textureId[id] = Tex;
		System.out.println("Successfully loaded texture ("+location+"("+Tex.getImageWidth()+", "+Tex.getImageHeight()+") to textureId["+id+"]!");
	}
	
	public static void loadTextureMenu(String format, String location, int id) {
		Texture Tex = null;
		System.out.println("Writing texture to textureMenuId["+id+"]...");
		try {
			Tex = TextureLoader.getTexture(format, ResourceLoader.getResourceAsStream(location), true, GL11.GL_NEAREST);
		} catch (IOException e) {
			e.printStackTrace();
		}textureMenuId[id] = Tex;
		System.out.println("Successfully loaded texture ("+location+"("+Tex.getImageWidth()+", "+Tex.getImageHeight()+") to textureMenuId["+id+"]!");
	}
	
	public static void drawTextureId(Texture Tex, Color c, int x, int y, int width, int height) {
		int x2, y2 = 0;
			x2 = x+width;
			y2 = y+height;
		Tex.bind();
		c.bind();
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
	
	public static void drawTexture(int id, Color c, int x, int y, int width, int height) {
		int x2, y2 = 0;
			x2 = x+width;
			y2 = y+height;
		textureId[id].bind();
		c.bind();
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
	
	public static void testTextureGUI() {
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		texture.bind();
		Color.white.bind();
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(0,0);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(100,0);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(0,100);
			
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(100,100);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(100,0);
		GL11.glEnd();
	}
	
	public static void mouse() {
		Mouse.setCursorPosition(GUI.area16x*2, GUI.area16y*2);
	}
	
	public static void drawBackground(int id) {
		int x = 0;
		int y = 0;
		if (GUI.textureId[id].getImageWidth()<=GUI.area16x && GUI.textureId[id].getImageHeight()<=GUI.area16y) {
		while (y<=GUI.area16y) {
			while (x<=GUI.area16x) {
				GUI.drawTexture(id, Color.darkGray, x, y, 64, 64);
				x+=64;
			}
			x = 0;
			y+=64;
		}
		}else{
			System.out.println("Background Image is to big!");
		}
	}
	
	public static void drawRandomBackground(int id0, int id1, int id2) {
		int x0 = 0, y0 = 0;
		int x1 = 0, y1 = 0;
		int x2 = 0, y2 = 0;
		int x = 0;
		int y = 0;
		while (y0<=GUI.area16y) {
			while (x0<=GUI.area16x) {
				GUI.drawTexture(id0, Color.darkGray, x0, y0, 64, 64);
				x0+=64;
			}
			x0 = 0;
			y0+=64;
		}if (r1 == -1) {
			r1 = r.nextInt(64);
			x = r1;
			x1 = r.nextInt(64);
			y1 = r.nextInt(64);
		}
		while (y<=x) {
			GUI.drawTexture(id1, Color.darkGray, x1, y1, 64, 64);
			y++;
		}
		if (r2 == -1) {
			r2 = r.nextInt(64);
			x = r1;
			x1 = r.nextInt(64);
			y1 = r.nextInt(64);
		}
		while (y<=x) {
			x1 = r.nextInt(64);
			y1 = r.nextInt(64);
			GUI.drawTexture(id2, Color.darkGray, x2, y2, 64, 64);
			y++;
		}
	}
	
	public static void panorama() {
		int x = GUI.panorama_SSalue;
		GUI.drawTexture(3, Color.darkGray, x, 0, x+area16x, area16y);
		GUI.drawTexture(3, Color.darkGray, x+area16x, 0, area16x*2+x, area16y);
		GUI.panorama_SSalue-=GUI.panorama_Speed;
	}
	
	public static void panoramaLoad() {
		GUI.loadTexture("PNG", "res/background/panorama_0.png", 3);
		GUI.loadTexture("PNG", "res/background/panorama_1.png", 4);
		GUI.loadTexture("PNG", "res/background/panorama_2.png", 5);
		GUI.loadTexture("PNG", "res/background/panorama_3.png", 6);
	}
	
	public static void menuDestroy(boolean Music) {
		menu.Menu.destroy(Music);
		menu.JukeBox.destroy(Music);
		menu.Settings.destroy(Music);
	}
	
	public static boolean isButtonClicked(int id) {
		boolean returnValue;
		if (GUI.buttonAction == true && GUI.id == id) {
			returnValue = true;
		}else{
			returnValue = false;
		}
		return returnValue;
	}
	
	public static void loada() {
		//Button Texture;
	}
	
}