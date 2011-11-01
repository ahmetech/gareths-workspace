package Breakout;

import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected Image image;
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
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	Image getImage() {
		return image;
	}
	Rectangle getRect(){
		return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
	}
}