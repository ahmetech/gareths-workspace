package movingspritesshootingmissles;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
	private Timer timer;
	private Player mario;
	private ArrayList aliens;
	private boolean ingame;
	private int intwidth;
	private int intheight;
	private boolean youwin;
	private int[][] pos = { 
	        {2380, 29}, {2500, 59}, {1380, 89},
	        {780, 109}, {580, 139}, {680, 239}, 
	        {790, 259}, {760, 50}, {790, 150},
	        {980, 209}, {560, 45}, {510, 70},
	        {930, 159}, {590, 80}, {530, 60},
	        {940, 59}, {990, 30}, {920, 200},
	        {900, 259}, {660, 50}, {540, 90},
	        {810, 220}, {860, 20}, {740, 180},
	        {820, 128}, {490, 170}, {700, 30}
	     };
	public Board(){
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		setBackground(Color.BLACK);
		ingame=true;
		
		setSize(1600, 900);
		
		initAleins();
		
		mario=new Player(45, 45);
		timer=new Timer(10, this);
		timer.start();
	}
	public void addNotify(){
		super.addNotify();
        intwidth = getWidth();
        intheight = getHeight();
	}
	public void initAleins(){
		aliens=new ArrayList();
		for(int i=0; i<pos.length; i++)aliens.add(new Alien(pos[i][0], pos[i][1]));
	}
	public void paint(Graphics g){
		super.paint(g);
		if(ingame){
				Graphics2D g2d= (Graphics2D) g;
				if(mario.isVisible()) g2d.drawImage(mario.getImage(), mario.getx(), mario.gety(), this);
				ArrayList ms=mario.getMissiles();
				g2d.drawImage(mario.getImage(),(int) mario.getx(),(int) mario.gety(), null);
				for (int i = 0; i < ms.size(); i++) {
					Missile m= (Missile) ms.get(i);
					g2d.drawImage(m.getImage(), m.getx(), m.gety(), this);
				}
				for (int i = 0; i < aliens.size(); i++) {
					Alien m= (Alien) aliens.get(i);
					g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
				}
				g2d.setColor(Color.WHITE);
				g2d.drawString("Aliens left "+aliens.size(), 5, 15);
		}else{
			if(!youwin){
			String msg="You Suck";
			Font small=new Font("Helvetica", Font.BOLD,14);
			FontMetrics metr=this.getFontMetrics(small);
			g.setColor(Color.white);
			g.setFont(small);
			g.drawString(msg, ((intwidth-metr.stringWidth(msg))/2),intheight/2 );
			}else{
				String msg="You Win";
				Font small=new Font("Helvetica", Font.BOLD,14);
				FontMetrics metr=this.getFontMetrics(small);
				g.setColor(Color.white);
	            g.setFont(small);
	            g.drawString(msg, ((intwidth-metr.stringWidth(msg))/2),intheight/2 );
			}
		}	
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	public void actionPerformed(ActionEvent e){
		if(aliens.size()==0){
			ingame=false;
			youwin=true;
		}
		ArrayList ms=mario.getMissiles();
		for (int i = 0; i < ms.size(); i++) {
			Missile m= (Missile) ms.get(i);
			if(m.isVisible()){
				m.move();
			}else ms.remove(i);
		}
		for (int i = 0; i < aliens.size(); i++) {
			Alien a = (Alien) aliens.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens.remove(i);
		}
		mario.move();
		checkCollision();
		repaint();
	}
	public void checkCollision(){
		Rectangle character=mario.getRect();
		for (int i = 0; i < aliens.size(); i++) {
			Alien a= (Alien) aliens.get(i);
			Rectangle alien=a.getRect();
			if(character.intersects(alien)){
				mario.setVisible(false);
				a.setVisible(false);
				ingame=false;
			}
		}
		ArrayList ms=mario.getMissiles();
		 for (int i = 0; i < ms.size(); i++) {
	            Missile m = (Missile) ms.get(i);

	            Rectangle r1 = m.getBounds();

	            for (int j = 0; j<aliens.size(); j++) {
	                Alien a = (Alien) aliens.get(j);
	                Rectangle r2 = a.getBounds();

	                if (r1.intersects(r2)) {
	                    m.setVisible(false);
	                    a.setVisible(false);
	                }
	            }
	        }
	    }
	private class TAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
            mario.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            mario.keyPressed(e);
        }
	}

	
}

