import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class Block extends AbstractEntity{
	String type="block";
	String sprite="0";
	private Texture Texture;
	
	
	public Block(double x, double y) {
		super(x, y, 48, 48);
		
	}

	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
			try {
				//right now only works with compy files
				//fix later plz thx :3
				Texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("E:/Adrift/Sprites/blocks/"+type+sprite+".png")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		Texture.bind();
		

		GL11.glTexParameterf(GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+(int)width, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+(int)width, (int)y+(int)height); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+(int)height); // Bottom-left
		GL11.glEnd();
	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		//will add stuff later
	}
}
