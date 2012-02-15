package Game;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glRectd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;


public class Player extends AbstractMoveableEntity{
	String facingLeft="res/player/facingLEft";
	String facingRight="res/player/facingRight";
	String startingLeft="res/player/startingRight";
	String startingRight="res/player/startingRight";
	String runningLeft= "res/player/runningLeft";
	String runningRight="res/player/runningRight";
	String jumpingLeft= "res/player/jumpingLeft";
	String jumpingRight="res/player/jumpingRight";
	
	
	
	
	int color;
	int skin;
	
	
	
	
	
	boolean u=false,d=false,l=false,r=false;

	private Texture facingLeftT;
	private Texture facingRightT;
	private Texture startingLeftT;
	private Texture startingRightT;
	private Texture runningLeftT;
	private Texture runningRightT;
	private Texture jumpingLeftT;
	private Texture jumpingRightT;
	
	public Player(double x, double y, int c, int s) {
		super(x, y, 32, 32);
		color=c;
		skin=s;
	}
	
	public boolean isU() {
		return u;
	}

	public void setU(boolean u) {
		this.u = u;
	}

	public boolean isD() {
		return d;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public boolean isL() {
		return l;
	}

	public void setL(boolean l) {
		this.l = l;
	}

	public boolean isR() {
		return r;
	}

	public void setR(boolean r) {
		this.r = r;
	}

	public void update(int delta){
		if(u==true)y=y-delta*.1;
		if(d==true)y=y+delta*.1;
		if(l==true)x=x-delta*.1;
		if(r==true)x=x+delta*.1;
		
		//animate();
	}
	
	public void animate(){
		
	}
	
	@Override
	public void draw() {
		 GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		try {
			headT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+head+".png")));
			shirtT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+shirt+".png")));
			handsT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+hands+".png")));
			feetT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+feet+".png")));
			eyesT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+eyes+".png")));
			bodyT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+body+".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		headT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		

		shirtT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		

		handsT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		

		feetT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		
		
		

		eyesT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		
		

		bodyT.bind();
		
		GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+32, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+32, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
		GL11.glEnd();
		
		//glRectd(x,y,x+width,y+height);
	}
}
