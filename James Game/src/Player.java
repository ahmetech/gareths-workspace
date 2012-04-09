import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Player extends AbstractMoveableEntity{
	String type="Default";
	String character = "MegaMan";

	String sprite="stand";
	int anim=0;
	int frame=0;
	static double scale=1;

	double speed = .175;

	double jump = 4.5;
	double maxFall = 1;
	double gravity = .15;
	double vspeed = 0;
	boolean falling=false;


	String dir="r";
	//r (right), l (left)


	String aim="f";
	//u (up), f (forward), d (down)



	boolean u=false,d=false,l=false,r=false;

	double hspeed=0;
	double maxRun = .5;

	private Texture Texture;

	public Player(double x, double y) {
		super(x, y, 16*scale, (23-1)*scale);
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


	public void update(int delta, ArrayList<Block> blocks, ArrayList<Scroll> scrolls){
		super.update(delta);

		for (int i = 0; i < scrolls.size(); i++) {
			Scroll temp=scrolls.get(i);
			hitbox.setBounds((int) ((int) x), (int) ((int) y), (int) width, (int) height);
			if (hitbox.intersects(temp.getX(),temp.getY(),24,24)) {
				temp.setVisible(false);
			}
		}

		//if(u==true)y=y-delta*.1;
		//if(d==true)y=y+delta*.1;


		if(l==true){
			if(!checkCollisions(blocks, "l", delta))x=x-delta*speed;
		}
		if(r==true){
			if(!checkCollisions(blocks, "r", delta))x=x+delta*speed;
		}


		//+ = r
		//- = l
		//x+=hspeed*delta;


		if(l&&!r&&!dir.equals("l")){
			anim=0;
			frame=0;
			dir="l";
		}
		if(r&&!l&&!dir.equals("r")){
			anim=0;
			frame=0;
			dir="r";
		}


		//check fall & jump
		//dy>0, falling
		//dy<0, jumping
		//if(checkCollisions(blocks,"u",delta)){
		//	y+=.3;
		//}
		if(!checkCollisions(blocks,"d",delta)){
			falling=true;
			vspeed-=gravity;
			if(vspeed<0){
				for(double i = 0;i>vspeed;i-=.01){
					if(!checkCollisions(blocks,"d",1)){
						y+=.01;
					}else{
						y-=.01;
						vspeed=0;
						falling=false;
					}
				}
			}else{
				for(double i = 0;i<vspeed;i+=.01){
					if(!checkCollisions(blocks,"u",1)){
						y-=.01;
					}else{
						y+=.01;
						vspeed=0;
					}

				}
			}
		}
		if(!falling){
			if(u){
				vspeed+=jump;
			}
		}



		/**
		if(!checkCollisions(blocks,"d",delta)){
				dy+=gravity*delta;
				if(dy>maxFall)dy=maxFall;

				if(dy<0){
					if(checkCollisions(blocks,"u",delta)){
						dy=0;
					}
				}

				y=y-dy;
		}else{
				dy=0;
		}
		 **/

		animate(delta,blocks);
	}


	public void animate(int delta,ArrayList<Block> blocks){
		anim+=delta;
		if(dy>=0&&falling){
			frame=0;
			sprite="fall";
		}else if(dy<0&&falling){
			frame=0;
			sprite="jump";
		}else{
			if(l&&!r||r&&!l){
				sprite="walk";
				if(anim>75*3)anim=1;
				if(anim>=1)frame=0;
				if(anim>=75)frame=1;
				if(anim>=75*2)frame=2;
			}else{
				sprite="stand";
				Random random = new Random();
				int r = random.nextInt(10);
				int r2 = random.nextInt(50);

				if(anim>75*(50+r))anim=0;
				if(anim>=0)frame=0;
				if(anim>=(75*(50+r))-(30+r2))frame=1;
			}
		}
	}




	@Override
	public void draw() {

		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		try {
			//right now only works with compy files
			//fix later plz thx :3
			Texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("E:/Adrift/Sprites/Gareth/Player2/"/*+type+"/"*/+character+"_"+sprite+"_"+dir.toUpperCase()+frame+".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Texture.bind();

		GL11.glTexParameterf(GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);


		GL11.glTranslated(x, y, 0);
		GL11.glRotatef((float)rotation, 0f, 0f, 1f);
		GL11.glTranslated(-x, -y, 0);


		GL11.glBegin(GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2d((int)x-9, (int)y-2); // Upper-left
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2d((int)x+32*scale-9, (int)y-2); // Upper-right
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2d((int)x+32*scale-9, (int)y-2+32*scale); // Bottom-right
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2d((int)x-9, (int)y-2+32*scale); // Bottom-left
		GL11.glEnd();



		//glRectd(x,y,x+width,y+height);
	}






	public boolean checkCollisions(ArrayList<Block> blocks, String d, int delta){
		for (Block tempEntity : blocks) {
			if(collides(tempEntity, d, delta))
				return true;
		}
		return false;
	}
	public void checkScrolls(ArrayList<Word> words, String d, int delta){
		for (Word tempEntity : words) {
			if(collides(tempEntity, d, delta))
				tempEntity.setVisible(false);
		}
	}



	public boolean collides(Entity other, String d, int delta){
		//s = self -> unchanged position in check
		if(d.equals("l"))hitbox.setBounds((int) ((int) x-speed*delta-8.25), (int) ((int) y+scale), (int) width, (int) height);
		if(d.equals("r"))hitbox.setBounds((int) ((int) x+speed*delta+1), (int) ((int) y+scale), (int) width, (int) height);


		if(d.equals("u"))hitbox.setBounds((int) ((int) x-8.25), (int) ((int) y+scale-.01*delta), (int) width, (int) height);
		if(d.equals("d"))hitbox.setBounds((int) x, (int) ((int) y+scale+.01*delta), (int) width, (int) height);

		return hitbox.intersects(other.getX(),other.getY(),other.getWidth(),other.getHeight());
	}




}
