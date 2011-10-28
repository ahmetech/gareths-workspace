package GUITicTacToe;

import javax.swing.JFrame;


public class Frame extends JFrame{
	public Frame(){
		Grid blah=new Grid();
		add(blah);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(616, 640);
		setLocationRelativeTo(null);
		setTitle("Tic Tac Toe");
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] Args){
		new Frame();
	}
}
