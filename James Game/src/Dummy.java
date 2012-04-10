import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Dummy extends AbstractEntity{
	private Texture Texture;
	int anim;
	String frameString="0";
	public Dummy(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void draw() {
		try {
			//right now only works with compy files
			//fix later plz thx :3
			Texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("E:/Adrift/Sprites/Gareth/Player2/Light"+frameString+".png")));
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
		GL11.glVertex2i((int)x+(int)width*3, (int)y); // Upper-right
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2i((int)x+(int)width*3, (int)y+(int)height*3); // Bottom-right
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2i((int)x, (int)y+(int)height*3); // Bottom-left
		GL11.glEnd();
	}



	public void update(int delta, Player player) {
		if (player.isO()) {
			anim+=delta;
			if (anim>=1) {
				frameString="1";
			}
			if(anim>=100){
				frameString="2";
			}
			if (anim>120) {
				anim=100;
			}
		}else {
			if (anim>=1) {
				frameString="1";
				anim-=delta;
			}else {
				frameString="0";
			}
		}
	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

}
