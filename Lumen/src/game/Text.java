package game;
/**
 *	**	**	**	**	**	**	**	**
 * 	Text.java
 * 	net.game.online
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		Alvin
 * 	Year		:		2013
 * 	Time		:		13:59:18
 * 
 *	**	**	**	**	**	**	**	**
 */


import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import _3D.Kernel;

/**
 * @author Alvin
 */
public class Text {
	
	static Texture chars[] = new Texture[127];
	
	static int lx = 0;
	
	public static int lenght(String text, int size) {
		lx = 0;
		int x = 0;
		int y = 0;
		Color co = Color.white;
		for (char c : text.toCharArray()) {
			/*if (c == ' ') {
				drawChar(32, x+lx, y, size, size, co);
			}
			if (c == '!') {
				testChar(33, x+lx, y, size, size, co);
			}
			if (c == '"') {
				testChar(34, x+lx, y, size, size, co);
			}
			if (c == '#') {
				testChar(35, x+lx, y, size, size, co);
			}
			if (c == '$') {
				testChar(36, x+lx, y, size, size, co);
			}
			if (c == '%') {
				testChar(37, x+lx, y, size, size, co);
			}
			if (c == '&') {
				testChar(38, x+lx, y, size, size, co);
			}
			if (c == '\'') {
				testChar(39, x+lx, y, size, size, co);
			}
			if (c == '(') {
				testChar(40, x+lx, y, size, size, co);
			}
			if (c == ')') {
				testChar(41, x+lx, y, size, size, co);
			}
			if (c == '*') {
				testChar(42, x+lx, y, size, size, co);
			}
			if (c == '+') {
				testChar(43, x+lx, y, size, size, co);
			}
			if (c == ',') {
				testChar(44, x+lx, y, size, size, co);
			}
			if (c == '-') {
				testChar(45, x+lx, y, size, size, co);
			}
			if (c == '.') {
				testChar(46, x+lx, y, size, size, co);
			}
			if (c == '/') {
				testChar(47, x+lx, y, size, size, co);
			}
			if (c == '0') {
				testChar(48, x+lx, y, size, size, co);
			}
			if (c == '1') {
				testChar(49, x+lx, y, size, size, co);
			}
			if (c == '2') {
				testChar(50, x+lx, y, size, size, co);
			}
			if (c == '3') {
				testChar(51, x+lx, y, size, size, co);
			}
			if (c == '4') {
				testChar(52, x+lx, y, size, size, co);
			}
			if (c == '5') {
				testChar(53, x+lx, y, size, size, co);
			}
			if (c == '6') {
				testChar(54, x+lx, y, size, size, co);
			}
			if (c == '7') {
				testChar(55, x+lx, y, size, size, co);
			}
			if (c == '8') {
				testChar(56, x+lx, y, size, size, co);
			}
			if (c == '9') {
				testChar(57, x+lx, y, size, size, co);
			}
			if (c == ':') {
				testChar(58, x+lx, y, size, size, co);
			}
			if (c == ';') {
				testChar(59, x+lx, y, size, size, co);
			}
			if (c == '<') {
				testChar(60, x+lx, y, size, size, co);
			}
			if (c == '=') {
				testChar(61, x+lx, y, size, size, co);
			}
			if (c == '>') {
				testChar(62, x+lx, y, size, size, co);
			}
			if (c == '?') {
				testChar(63, x+lx, y, size, size, co);
			}
			if (c == '@') {
				testChar(64, x+lx, y, size, size, co);
			}
			if (c == 'A') {
				testChar(65, x+lx, y, size, size, co);
			}
			if (c == 'B') {
				testChar(66, x+lx, y, size, size, co);
			}
			if (c == 'C') {
				testChar(67, x+lx, y, size, size, co);
			}
			if (c == 'D') {
				testChar(68, x+lx, y, size, size, co);
			}
			if (c == 'E') {
				testChar(69, x+lx, y, size, size, co);
			}
			if (c == 'F') {
				testChar(70, x+lx, y, size, size, co);
			}
			if (c == 'G') {
				testChar(71, x+lx, y, size, size, co);
			}
			if (c == 'H') {
				testChar(72, x+lx, y, size, size, co);
			}
			if (c == 'I') {
				testChar(73, x+lx, y, size, size, co);
			}
			if (c == 'J') {
				testChar(74, x+lx, y, size, size, co);
			}
			if (c == 'K') {
				testChar(75, x+lx, y, size, size, co);
			}
			if (c == 'L') {
				testChar(76, x+lx, y, size, size, co);
			}
			if (c == 'M') {
				testChar(77, x+lx, y, size, size, co);
			}
			if (c == 'N') {
				testChar(78, x+lx, y, size, size, co);
			}
			if (c == 'O') {
				testChar(79, x+lx, y, size, size, co);
			}
			if (c == 'P') {
				testChar(80, x+lx, y, size, size, co);
			}
			if (c == 'Q') {
				testChar(81, x+lx, y, size, size, co);
			}
			if (c == 'R') {
				testChar(82, x+lx, y, size, size, co);
			}
			if (c == 'S') {
				testChar(83, x+lx, y, size, size, co);
			}
			if (c == 'T') {
				testChar(84, x+lx, y, size, size, co);
			}
			if (c == 'U') {
				testChar(85, x+lx, y, size, size, co);
			}
			if (c == 'V') {
				testChar(86, x+lx, y, size, size, co);
			}
			if (c == 'W') {
				testChar(87, x+lx, y, size, size, co);
			}
			if (c == 'X') {
				testChar(88, x+lx, y, size, size, co);
			}
			if (c == 'Y') {
				testChar(89, x+lx, y, size, size, co);
			}
			if (c == 'Z') {
				testChar(90, x+lx, y, size, size, co);
			}*/
		}
		return lx;
	}
	
	public static void draw(String s, int x, int y, int size, Color co) {
		lx = 0;
		for (char c : s.toCharArray()) {
			/*if (c == ' ') {
				drawChar(32, x+lx, y, size, size, co);
			}
			if (c == '!') {
				drawChar(33, x+lx, y, size, size, co);
			}
			if (c == '"') {
				drawChar(34, x+lx, y, size, size, co);
			}
			if (c == '#') {
				drawChar(35, x+lx, y, size, size, co);
			}
			if (c == '$') {
				drawChar(36, x+lx, y, size, size, co);
			}
			if (c == '%') {
				drawChar(37, x+lx, y, size, size, co);
			}
			if (c == '&') {
				drawChar(38, x+lx, y, size, size, co);
			}
			if (c == '\'') {
				drawChar(39, x+lx, y, size, size, co);
			}
			if (c == '(') {
				drawChar(40, x+lx, y, size, size, co);
			}
			if (c == ')') {
				drawChar(41, x+lx, y, size, size, co);
			}
			if (c == '*') {
				drawChar(42, x+lx, y, size, size, co);
			}
			if (c == '+') {
				drawChar(43, x+lx, y, size, size, co);
			}
			if (c == ',') {
				drawChar(44, x+lx, y, size, size, co);
			}
			if (c == '-') {
				drawChar(45, x+lx, y, size, size, co);
			}
			if (c == '.') {
				drawChar(46, x+lx, y, size, size, co);
			}
			if (c == '/') {
				drawChar(47, x+lx, y, size, size, co);
			}
			if (c == '0') {
				drawChar(48, x+lx, y, size, size, co);
			}
			if (c == '1') {
				drawChar(49, x+lx, y, size, size, co);
			}
			if (c == '2') {
				drawChar(50, x+lx, y, size, size, co);
			}
			if (c == '3') {
				drawChar(51, x+lx, y, size, size, co);
			}
			if (c == '4') {
				drawChar(52, x+lx, y, size, size, co);
			}
			if (c == '5') {
				drawChar(53, x+lx, y, size, size, co);
			}
			if (c == '6') {
				drawChar(54, x+lx, y, size, size, co);
			}
			if (c == '7') {
				drawChar(55, x+lx, y, size, size, co);
			}
			if (c == '8') {
				drawChar(56, x+lx, y, size, size, co);
			}
			if (c == '9') {
				drawChar(57, x+lx, y, size, size, co);
			}
			if (c == ':') {
				drawChar(58, x+lx, y, size, size, co);
			}
			if (c == ';') {
				drawChar(59, x+lx, y, size, size, co);
			}
			if (c == '<') {
				drawChar(60, x+lx, y, size, size, co);
			}
			if (c == '=') {
				drawChar(61, x+lx, y, size, size, co);
			}
			if (c == '>') {
				drawChar(62, x+lx, y, size, size, co);
			}
			if (c == '?') {
				drawChar(63, x+lx, y, size, size, co);
			}
			if (c == '@') {
				drawChar(64, x+lx, y, size, size, co);
			}
			if (c == 'A') {
				drawChar(65, x+lx, y, size, size, co);
			}
			if (c == 'B') {
				drawChar(66, x+lx, y, size, size, co);
			}
			if (c == 'C') {
				drawChar(67, x+lx, y, size, size, co);
			}
			if (c == 'D') {
				drawChar(68, x+lx, y, size, size, co);
			}
			if (c == 'E') {
				drawChar(69, x+lx, y, size, size, co);
			}
			if (c == 'F') {
				drawChar(70, x+lx, y, size, size, co);
			}
			if (c == 'G') {
				drawChar(71, x+lx, y, size, size, co);
			}
			if (c == 'H') {
				drawChar(72, x+lx, y, size, size, co);
			}
			if (c == 'I') {
				drawChar(73, x+lx, y, size, size, co);
			}
			if (c == 'J') {
				drawChar(74, x+lx, y, size, size, co);
			}
			if (c == 'K') {
				drawChar(75, x+lx, y, size, size, co);
			}
			if (c == 'L') {
				drawChar(76, x+lx, y, size, size, co);
			}
			if (c == 'M') {
				drawChar(77, x+lx, y, size, size, co);
			}
			if (c == 'N') {
				drawChar(78, x+lx, y, size, size, co);
			}
			if (c == 'O') {
				drawChar(79, x+lx, y, size, size, co);
			}
			if (c == 'P') {
				drawChar(80, x+lx, y, size, size, co);
			}
			if (c == 'Q') {
				drawChar(81, x+lx, y, size, size, co);
			}
			if (c == 'R') {
				drawChar(82, x+lx, y, size, size, co);
			}
			if (c == 'S') {
				drawChar(83, x+lx, y, size, size, co);
			}
			if (c == 'T') {
				drawChar(84, x+lx, y, size, size, co);
			}
			if (c == 'U') {
				drawChar(85, x+lx, y, size, size, co);
			}
			if (c == 'V') {
				drawChar(86, x+lx, y, size, size, co);
			}
			if (c == 'W') {
				drawChar(87, x+lx, y, size, size, co);
			}
			if (c == 'X') {
				drawChar(88, x+lx, y, size, size, co);
			}
			if (c == 'Y') {
				drawChar(89, x+lx, y, size, size, co);
			}
			if (c == 'Z') {
				drawChar(90, x+lx, y, size, size, co);
			}*/
			drawChar(c, x+8, y, size, size, co);
		}
		lx=0;
	}
	   
	public static void load() {
		System.out.println("Loading chars..");
		loadChar("32", 32);
		loadChar("33", 33);
		loadChar("34", 34);
		loadChar("35", 35);
		loadChar("36", 36);
		loadChar("37", 37);
		loadChar("38", 38);
		loadChar("39", 39);
		loadChar("40", 40);
		loadChar("41", 41);
		loadChar("42", 42);
		loadChar("43", 43);
		loadChar("44", 44);
		loadChar("45", 45);
		loadChar("46", 46);
		loadChar("48", 47);
		loadChar("48", 48);
		loadChar("49", 49);
		loadChar("50", 50);
		loadChar("51", 51);
		loadChar("52", 52);
		loadChar("53", 53);
		loadChar("54", 54);
		loadChar("55", 55);
		loadChar("56", 56);
		loadChar("57", 57);
		loadChar("58", 58);
		loadChar("59", 59);
		loadChar("60", 60);
		loadChar("61", 61);
		loadChar("62", 62);
		loadChar("63", 63);
		loadChar("64", 64);
		loadChar("65", 65);
		loadChar("66", 66);
		loadChar("67", 67);
		loadChar("68", 68);
		loadChar("69", 69);
		loadChar("70", 70);
		loadChar("71", 71);
		loadChar("72", 72);
		loadChar("73", 73);
		loadChar("74", 74);
		loadChar("75", 75);
		loadChar("76", 76);
		loadChar("77", 77);
		loadChar("78", 78);
		loadChar("79", 79);
		loadChar("80", 80);
		loadChar("81", 81);
		loadChar("82", 82);
		loadChar("83", 83);
		loadChar("84", 84);
		loadChar("85", 85);
		loadChar("86", 86);
		loadChar("87", 87);
		loadChar("88", 88);
		loadChar("89", 89);
		loadChar("90", 90);
	}
	   
	public static void loadChar(String location, int id) {
		try {
			chars[id] = TextureLoader.getTexture("PNG",  ResourceLoader.getResourceAsStream("res/Ascii/"+id+".png"), GL11.GL_NEAREST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testChar(int id, int x, int y, int width, int height, Color c) {
		if (chars[id] == null) {
			lx = 16;
		}else{
			lx += chars[id].getImageWidth()*width;
		}
	}
	public static void drawChar(char id, int x, int y, int width, int height, Color c) {
		int x2, y2 = 0;
		float px1 = 0.0625f, py1 = 0.9375f, px2 = 0.125f, py2 = 1f;
		if ((int) id < 16) {
			py1 = 1/16*15;
			py2 = 1/16*16;
			if ((int) id == 0) px1 = 1/16*0;
		}
		px2 = px1+(1/16);
		
		float xc11 = (float) px1;
		float yc11 = (float) py1;
		float xc21 = (float) px2;
		float yc21 = (float) py1;
		float xc31 = (float) px1;
		float yc31 = (float) py2;
		float xc12 = (float) px2;
		float yc12 = (float) py2;
		float xc22 = (float) px1;
		float yc22 = (float) py2;
		float xc32 = (float) px2;
		float yc32 = (float) py1;
		
		if (chars[id] == null) {
			x2 = 16;
			y2 = 16;
			lx = 16;
		}else{
			x2 = chars[id].getImageWidth()*width;
			y2 = chars[id].getImageHeight()*height;
			lx += chars[id].getImageWidth()*width;
		}
		GUI.Texture.find("font_default").bind();
		c.bind();
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(xc11, yc11);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(xc21, yc21);
			GL11.glVertex2f(x+x2, y);
			GL11.glTexCoord2f(xc31, yc31);
			GL11.glVertex2f(x, y+y2);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glTexCoord2f(xc12, yc12);
			GL11.glVertex2f(x+x2, y+y2);
			GL11.glTexCoord2f(xc22, yc22);
			GL11.glVertex2f(x, y+y2);
			GL11.glTexCoord2f(xc32, yc32);
			GL11.glVertex2f(x+x2, y);
	GL11.glEnd();
		//Kernel.drawPolygon(x, y, x, y+height, x2+width, y2+height, "dirt", xc1, yc1, xc2, yc2, xc3, yc3, Color.white);
	}
	
}
