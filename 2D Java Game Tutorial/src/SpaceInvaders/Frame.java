package SpaceInvaders;

import javax.swing.JFrame;

public class Frame extends JFrame implements Commons{
	public Frame(){
		add(new Board());
		setTitle("Space Invaders");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Board_Width, Board_Height);
		setLocation(null);
		setVisible(true);
		setResizable(false);
	}
}
