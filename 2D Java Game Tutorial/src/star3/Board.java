package star3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable{
	private Image mario;
	private Thread animation;
	private int x,y;
	
	private final int DELAY=50;
	
	public Board(){
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		ImageIcon ii=new ImageIcon("C:/Users/Gareth/workspace/my-project-dudesadventures/Pictures/Mariorr.png");
		mario=ii.getImage();
		x=y=10;
	}
	public void addNotify(){
		super.addNotify();
		animation=new Thread(this);
		animation.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d=(Graphics2D)g;
		g2d.drawImage(mario, x, y, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	public void cycle(){
		 x += 1;
	     y += 1;

	     if (y > 240) {
	    	 y = -45;
	    	 x = -45;
	     }
	}
	public void run(){
		long timebefore, timediff, sleep;
		timebefore=System.currentTimeMillis();
		while(true){
			cycle();
			repaint();
			timediff=System.currentTimeMillis()-timebefore;
			sleep=DELAY-timediff;
			if(sleep<0) sleep=2;
			try{
				Thread.sleep(sleep);
			} catch(InterruptedException e){
				System.out.println("interrupted");
			}
			timebefore = System.currentTimeMillis();
		}
	}
	
}
