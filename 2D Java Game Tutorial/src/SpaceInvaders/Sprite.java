package SpaceInvaders;

import java.awt.Image;

public class Sprite {
	private boolean visible;
	private Image image;
	protected int x;
	protected int y;
	protected boolean dying;
	protected int dx;
	
	public Sprite(){
		visible=true;
	}
	
	public void die(){
		visible=false;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	protected void setVisible(boolean paramVisible){
		visible=paramVisible;
	}
	
	public void setImage(Image paramImage){
		image=paramImage;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setY(int paramY){
		y=paramY;
	}
	
	public void setX(int paramX){
		x=paramX;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	public void setDying(boolean paramDying){
		dying=paramDying;
	}
	
	public boolean isDying(){
		return dying;
	}
	
	
	
	
}
