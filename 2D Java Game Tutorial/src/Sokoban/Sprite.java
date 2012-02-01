package Sokoban;

import java.awt.Image;

public class Sprite {
	private final int SPACE=20;
	
	private int x, y;
	private Image image;
	
	public Sprite(int paramX, int paramY){
		this.x=paramX;
		this.y=paramY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public boolean ifLeftCollision(Actor a){
		
	}
	
}
