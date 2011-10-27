package Skeleton;

import javax.swing.JFrame;

public class Skeleton extends JFrame{
	public Skeleton(){
		add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280,240);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Image");
	}
	public static void main(String args[]){
		new Skeleton();
	}
}
