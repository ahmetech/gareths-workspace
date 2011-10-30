package Snake;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public Frame(){
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 380);
		setLocationRelativeTo(null);
		setTitle("Snake Game");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args){
		new Frame();
	}
}
