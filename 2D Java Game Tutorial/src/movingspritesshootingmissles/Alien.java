package movingspritesshootingmissles;


import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Alien extends Sprite{
	public Alien(int xcoord, int ycoord){
		ImageIcon ii=new ImageIcon(this.getClass().getResource("alien.png"));
		image=ii.getImage();
		width=image.getWidth(null);
		height=image.getHeight(null);
		visible=true;
		x=xcoord;
		y=ycoord;
	}
	public void move() {
        if (x < 0) 
            x = 400;
        x -= 1;
    }
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

