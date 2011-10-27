package movingspritesshootingmissles;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends Sprite{
	private final int boardwidth=1600;
	private final int missilespeed=2;
	public Missile(int xcoord, int ycoord){
		ImageIcon ii= new ImageIcon(this.getClass().getResource("missile.png"));
		image=ii.getImage();
		visible=true;
		x=xcoord;
		y=ycoord;
		width=image.getWidth(null);
		height=image.getHeight(null);
	}
	public Image getImage(){
		return image;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	public void move(){
		x+=missilespeed;
		if(x>boardwidth){
			visible=false;
		}
	}
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
