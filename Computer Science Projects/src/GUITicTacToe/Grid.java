package GUITicTacToe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Grid extends JPanel implements ActionListener{
	Image grid;
	Image check;
	Image circle;
	JButton main; 
	public Grid(){
		ImageIcon ii=new ImageIcon(getClass().getResource("TicTacToeGrid.png"));
		ImageIcon iii=new ImageIcon(getClass().getResource("check.png"));
		ImageIcon iiii=new ImageIcon(getClass().getResource("circle.png"));
		grid=ii.getImage();
		check=iii.getImage();
		circle=iiii.getImage();
		main=new JButton();
	}
	public void paint(Graphics g){
		super.paint(g);
		
	}
}
