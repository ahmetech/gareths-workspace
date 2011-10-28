package GUITicTacToe;

import javax.swing.ImageIcon;

public class Circle extends Sprite{
	public Circle(int xcoord, int ycoord) {
		ImageIcon ii=new ImageIcon(getClass().getResource("circle.png"));
		image=ii.getImage();
		x=xcoord;
		y=ycoord;
	}
}
