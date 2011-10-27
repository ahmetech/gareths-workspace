package Skeleton;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel{
	Image blah;
	
	public Board(){
		ImageIcon ii=new ImageIcon("C:/Users/Gareth/workspace/Dudes Adventures - Copy/Pictures/Level1.png");
		blah=ii.getImage();
	}
	public void paint(Graphics g){
		Graphics g2d= (Graphics2D) g;
		g2d.drawImage(blah, 10, 10, null);
	}
	
}
