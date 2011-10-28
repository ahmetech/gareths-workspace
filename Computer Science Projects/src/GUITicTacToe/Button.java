package GUITicTacToe;

import javax.swing.ImageIcon;

public class Button extends Sprite {
	public Button(int xcoord, int ycoord) {
		ImageIcon ii=new ImageIcon(getClass().getResource("Button.png"));
		image=ii.getImage();
		x=xcoord;
		y=ycoord;
		height=image.getHeight(null);
		width=image.getWidth(null);
		totalheight=y+height;
		totalwidth=x+width;
		isVisible=true;
	}
}
