package SpaceInvaders;

import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {
	private Texture texture;
	private int width;
	private int height;
	
	//Create a new sprite from a specified image.
	//@param loader the texture loader to use
	//@param ref A reference to the image on which this sprite should be based
	public Sprite(TextureLoader loader, String ref){
		try{
			texture = loader.getTexture("spaceinvaders/" + ref);
		    width = texture.getImageWidth();
		    height = texture.getImageHeight();
		}catch(IOException ioe){
			ioe.printStackTrace();
			System.exit(-1);
		}
	}
	
	//Get the width of this sprite in pixels
	public int width(){
		return texture.getImageWidth();
	}
	
	//Get the height of this sprite in pixels
	public int height(){
		return texture.getImageHeight();
	}
	
	//Draw the sprite at the specified location
	public void draw(int x, int y){
		//store the current Martix mode
		glPushMatrix();
		
		//bind the appropriate texture for this sprite
		texture.bind();
		
		// translate to the right location and prepare to draw
		glTranslatef(x, y, 0);
		
		// draw a quad textured to match the sprite
		glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0);
				glVertex2f(0, 0);

				glTexCoord2f(0, texture.getHeight());
				glVertex2f(0, height);

				glTexCoord2f(texture.getWidth(), texture.getHeight());
				glVertex2f(width, height);

				glTexCoord2f(texture.getWidth(), 0);
				glVertex2f(width, 0);
			}
		glEnd();
		
		// restore the model view matrix to prevent contamination
		glPopMatrix();
	}
}
