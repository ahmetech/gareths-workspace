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
import org.newdawn.slick.util.ResourceLoader;


public class Player extends AbstractMoveableEntity{
	String facingLeft="/res/Player/standingLeft";
	String facingRight="/res/Player/standingRight";
	String startingLeft="/res/Player/walkingRight";
	String startingRight="/res/Player/walkingRight";
	String runningLeft= "/res/Player/runningLeft";
	String runningRight="/res/Player/runningRight";
	String jumpingLeft= "/res/Player/jumpingLeft";
	String jumpingRight="/res/Player/jumpingRight";


	boolean left, right;
	boolean standing, running1, running2, jumping;
	boolean u=false,d=false,l=false,r=false;

	private Texture facingLeftT;
	private Texture facingRightT;
	private Texture startingLeftT;
	private Texture startingRightT;
	private Texture runningLeftT;
	private Texture runningRightT;
	private Texture jumpingLeftT;
	private Texture jumpingRightT;

	public Player(double x, double y, boolean facing) {
		super(x, y, 32, 32);
		right=facing;
		left=!facing;
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
		if(u==true){
			y=y-delta*.1;
		}
		if(d==true){
			y=y+delta*.1;
		}
		if(l==true){
			right=false;
			left=true;
			x=x-delta*.1;
		}
		if(r==true){
			left=false;
			right=true;
			x=x+delta*.1;
		}

		//animate();
	}

	public void animate(){

	}

	@Override
	public void draw() {
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		try {
			facingLeftT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+facingLeft+".png")));
			facingRightT = TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+facingRight+".png")));
			startingLeftT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+startingLeft+".png")));
			startingRightT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+startingRight+".png")));
			runningLeftT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+runningLeft+".png")));
			runningRightT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+runningRight+".png")));
			jumpingLeftT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+jumpingLeft+".png")));
			jumpingRightT= TextureLoader.getTexture("PNG", new FileInputStream(new File("src"+jumpingRight+".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		if(standing&&left){
			facingLeftT.bind();
			System.out.println("This happened");
			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		if(standing&&right){
			facingRightT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		if(running1&&left){
			startingLeftT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		if(running1&&right){
			startingRightT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}


		if(running2&&left){
			runningLeftT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}


		if(running2&&right){
			runningRightT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		if(jumping&&left){
			jumpingLeftT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		if(jumping&&right){
			jumpingRightT.bind();

			GL11.glBegin(GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2i((int)x, (int)y); // Upper-left
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2i((int)x+16, (int)y); // Upper-right
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2i((int)x+16, (int)y+32); // Bottom-right
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2i((int)x, (int)y+32); // Bottom-left
			GL11.glEnd();
		}

		//glRectd(x,y,x+width,y+height);
	}
}