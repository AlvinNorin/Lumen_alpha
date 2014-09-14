/**
 *	**	**	**	**	**	**	**	**
 * 	Button.java
 * 	GUI
 *	**	**	**	**	**	**	**	**
 *
 * 	Author		:		alvin
 * 	Year		:		2013
 * 	Time		:		8:39:46 AM
 * 
 *	**	**	**	**	**	**	**	**
 */
package GUI;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

/**
 * @author alvin
 */
public class Button {

	static String button_name[] = new String[100];
	static boolean button_index[] = new boolean[100];
	static int button_total = 0;
	
	public static boolean isButtonClicked(String button) {
		int count = 0;
		while (button!=button_name[count]&&count<button_total) {
			count++;
		}return button_index[count];
	}
	
	public static boolean draw(String name, String text, int x, int y, int size_x, int size_y, String texture, int font_size, int block_size) {
		int count_x = 1;
		int count_y = 1;
		int lx=x;
		int ly=y;
		int state = 0;
		if (/*Code to check mouse x position*/Mouse.getX()>=x&&Mouse.getX()<=(x+(block_size*size_x))&&/*Code to check mouse y position*/Mouse.getY()>=y&&Mouse.getY()<=(y+(block_size*size_y))) {
			if (Mouse.isButtonDown(0)) {
				state = 2;
			}else{
				state = 1;
			}
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		while (count_y<=size_y) {
			while (count_x<=size_x) {
				//Code to draw a non highlighted button
				if (state == 0) {
					Texture.draw(texture, Color.gray, lx, ly, block_size, block_size);
				//Code to draw a highlighted button
				}else if (state == 1) {
					Texture.draw(texture, Color.lightGray, lx, ly, block_size, block_size);
				//Code to draw a clicked button
				}else if (state == 2) {
					Texture.draw(texture, Color.white, lx, ly, block_size, block_size);
				}
				count_x++;
				lx+=block_size;
			}
			count_x=1;
			ly+=block_size;
			lx=x;
			count_y++;
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		game.Text.draw(text, x+((block_size*size_x/2)-(game.Text.lenght(text, font_size)/2))/2, y+(block_size*size_y/2)-(font_size/2), font_size, Color.white);
		/**
		 * Add or keep button in memory
		*/
		int count = 0;
		boolean isButtonDown = false;
		while (name!=button_name[count]&&count<=button_total) {
			count++;
		}
		if (name!=button_name[count]) {
			button_name[count] = name;
			System.out.println("Adding button: "+name+" to id "+count);
			button_total++;
		}
		if (state == 2) {
			isButtonDown = true;
		}
		button_index[count] = isButtonDown;
		int count_0 = 0;
		while (name!=button_name[count_0]&&count_0<button_total) {
			count_0++;
		}return button_index[count_0];
	}
	
	@SuppressWarnings("unused")
	public static void draw3d(String name, String text, int x, int y, int z,int size_x, int size_y, String texture, int font_size, int block_size) {
		int count_x = 1;
		int count_y = 1;
		
		int zvector111 = x;
		int zvector112 = x+(block_size*size_y);
		
		int zvector121 = x+(block_size*size_x);
		int zvector122 = x+(block_size*size_y);
		
		int zvector131 = x;
		int zvector132;
		
		int zvector141;
		int zvector142;
		
		int lx=x;
		int ly=y;
		int state = 0;
		if (/*Code to check mouse x position*/(Mouse.getX()/1.250)>=x&&(Mouse.getX()/1.250)<=(x+(block_size*size_x))&&/*Code to check mouse y position*/(Mouse.getY()/1/1.04)>=y&&(Mouse.getY()/1.04)<=(y+(block_size*size_y))) {
			if (Mouse.isButtonDown(0)) {
				state = 2;
			}else{
				state = 1;
			}
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		while (count_y<=size_y) {
			while (count_x<=size_x) {
				//Code to draw a non highlighted button
				if (state == 0) {
					Texture.draw(texture, Color.gray, lx, ly, block_size, block_size);
				//Code to draw a highlighted button
				}else if (state == 1) {
					Texture.draw(texture, Color.lightGray, lx, ly, block_size, block_size);
				//Code to draw a clicked button
				}else if (state == 2) {
					Texture.draw(texture, Color.white, lx, ly, block_size, block_size);
				}
				count_x++;
				lx+=block_size;
			}
			count_x=1;
			ly+=block_size;
			lx=x;
			count_y++;
		}
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		game.Text.draw(text, x+(block_size*size_x/2)-(game.Text.lenght(text, font_size)/2), y+(block_size*size_y/2)-(8*font_size/2), font_size, Color.white);
		/**
		 * Add or keep button in memory
		*/
		int count = 0;
		boolean isButtonDown = false;
		while (name!=button_name[count]&&count<=button_total) {
			count++;
		}
		if (name!=button_name[count]) {
			button_name[count] = name;
			System.out.println("Adding button: "+name+" to id "+count);
			button_total++;
		}
		if (state == 2) {
			isButtonDown = true;
		}
		button_index[count] = isButtonDown;
	}
	
	public static void loadTextures() {
		Texture.load("planks_oak", "PNG", "res/textures/planks_oak.png");
	}
	
}
