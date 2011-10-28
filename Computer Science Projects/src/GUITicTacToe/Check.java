package GUITicTacToe;

import javax.swing.ImageIcon;

public class Check extends Sprite{
	public Check(int xcoord, int ycoord) {
		ImageIcon ii=new ImageIcon(getClass().getResource("check.png"));
		image=ii.getImage();
		x=xcoord;
		y=ycoord;
	}
}
