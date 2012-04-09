import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class Word extends AbstractEntity{
	private  String level;
	private String part;
	private Texture Texture;
	protected boolean visible=true;
	public Word(double x, double y, double width, double height, String level, String part, boolean visible) {
		super(x, y, width, height);
		this.setLevel(level);
		this.setPart(part);
		this.visible=visible;
	}
	public boolean isVisible() {
		return visible;
	}


	public void setVisible(boolean visible) {
		this.visible = visible;
	}


	@Override
	public void draw() {
		if(visible){
			// TODO Auto-generated method stub
			try {
				//right now only works with compy files
				//fix later plz thx :3
				setTexture(TextureLoader.getTexture("PNG", new FileInputStream(new File("E:/Adrift/Sprites/Gareth/Words/"+getLevel()+getPart()+".png"))));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		getTexture().bind();
		

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
	}
	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}
	public Texture getTexture() {
		return Texture;
	}
	public void setTexture(Texture texture) {
		Texture = texture;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
}
