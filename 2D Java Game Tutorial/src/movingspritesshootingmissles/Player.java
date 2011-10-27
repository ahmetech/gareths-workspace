package movingspritesshootingmissles;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	
	private int dx,dy, x, y;
	boolean l, r, u, d;
	private ArrayList missiles;
	private final int craftsize=20;
	public Player(int xcoord, int ycoord){
		ImageIcon ii=new ImageIcon(this.getClass().getResource("craft.png"));
		image=ii.getImage();
		x=xcoord;
		y=ycoord;
		missiles=new ArrayList();
		width=image.getWidth(null);
		height=image.getHeight(null);
		visible=true;
	}
	
	public void move(){
		if(u){
			y+=dy;
		}
		if(d){
			y+=dy;
		}
		if(r){
			x+=dx;
		}
		if(l){
			x+=dx;
		}
		if(x<1){
			x=1;
		}
		if(x>400-width-5){
			x=400-width-5;
		}
		if(y<1){
			y=1;
		}
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public Image getimage(){
		return image;
	}
	public ArrayList getMissiles(){
		return missiles;
	}
	public Rectangle getRect(){
		return new Rectangle(x, y, width, height);
	}
	public void keyPressed(KeyEvent e){
		int key= e.getKeyCode();
		if(key==KeyEvent.VK_SPACE){
			fire();
		}
		if(key==KeyEvent.VK_LEFT){
			l=true;
			dx=-1;
		}
		if(key==KeyEvent.VK_RIGHT){
			r=true;
			dx=1;
		}
		if(key==KeyEvent.VK_UP){
			u=true;
			dy=-1;
		}
		if(key==KeyEvent.VK_DOWN){
			d=true;
			dy=1;
		}
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            l=false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            r=false;
        }

        if (key == KeyEvent.VK_UP) {
            u=false;
        }

        if (key == KeyEvent.VK_DOWN) {
            d=false;
        }
	}
	public void fire(){
		missiles.add(new Missile(x+width, y+height/2));
	}
}
