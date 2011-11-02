package Breakout;

import javax.swing.ImageIcon;

public class Brick extends Sprite{
	boolean destroyed;
	
	public Brick(int xcoord, int ycoord){
		this.x=xcoord;
		this.y=ycoord;
		ImageIcon ii=new ImageIcon(getClass().getResource("brickie.png"));
		image=ii.getImage();
		width=image.getWidth(null);
		height=image.getHeight(null);
		destroyed=false;
	}
	public boolean isDestroyed(){
		return destroyed;
	}
	public void setDestroyed(boolean destroyed){
		this.destroyed=destroyed;
	}
}
