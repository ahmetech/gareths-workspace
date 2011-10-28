package GUITicTacToe;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Sprite extends Object{
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	protected int totalheight;
	protected int totalwidth;
	protected Image image;
	protected boolean isVisible;
	
	
	public int getTotalheight() {
		return totalheight;
	}
	public int getTotalwidth() {
		return totalwidth;
	}
	public int getX() {
		return x;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
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
	public void setTotalheight(int totalheight) {
		this.totalheight = totalheight;
	}
	public void setTotalwidth(int totalwidth) {
		this.totalwidth = totalwidth;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}
