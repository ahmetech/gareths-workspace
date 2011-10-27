package GUITicTacToe;

import javax.swing.JFrame;


public class Frame extends JFrame{
	public Frame(){
		add(new Grid());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setTitle("Tic Tac Toe");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] Args){
		new Frame();
	}
}
