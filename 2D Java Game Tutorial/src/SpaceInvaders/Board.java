package SpaceInvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, Commons{
	private Dimension d;
	private ArrayList aliens;
	private Player player;
	private Shot shot;
	
	private int alienX=150;
	private int alienY=5;
	private int direction= -1;
	private int deaths=0;
	
	private boolean ingame=true;
	private String message="Game Over";
	
	private Thread animator;
	
	public Board(){
		addKeyListener(new TAdapter());
		setFocusable(true);
		d=new Dimension(Board_Width, Board_Height);
		setBackground(Color.black);
		
		gameInit();
		setDoubleBuffered(true);
	}
	
	public void addNotify(){
		super.addNotify();
		gameInit();
	}
	
	public void gameInit(){
		aliens=new ArrayList();
		ImageIcon ii=new ImageIcon(this.getClass().getResource("alien.png"));
		for(int i=0; i<4; i++){
			for(int j=0; j<6; j++){
				Alien alien=new Alien(alienX+18*j, alienY+18*i);
				alien.setImage(ii.getImage());
				aliens.add(alien);
			}
		}
		player=new Player();
		shot=new Shot();
		
		if(animator==null||!ingame){
			animator=new Thread(this);
			animator.start();
		}
	}
	
	public void drawAliens(Graphics g){
		Iterator it=aliens.iterator();
		while(it.hasNext()){
			Alien alien=(Alien) it.next();
			if(alien.isVisible()){
				g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
			}
			if(alien.isDying()){
				alien.die();
			}
		}
	}
	
	public void drawPlayer(Graphics g){
		if(player.isVisible()){
			g.drawImage(player.getImage(), player.getX(), player.getY(), this);
		}
		if(player.isDying()){
			player.die();
			ingame=false;
		}
	}
	
	public void drawShot(Graphics g){
		if(shot.isVisible()){
			g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
		}
	}
	
	public void drawBombing(Graphics g){
		Iterator i3=aliens.iterator();
		
		while(i3.hasNext()){
			Alien alien=(Alien) i3.next();
			Alien.Bomb b=alien.getBomb();
			
			if(!b.isDestroyed()){
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.green);
		
		if(ingame){
			g.drawLine(0, Ground, Board_Width, Board_Height);
			drawAliens(g);
			drawPlayer(g);
			drawShot(g);
			drawBombing(g);
		}
		Toolkit.getDefaultToolkit().sync();
	    g.dispose();
	}
	
	public void gameOver(){
		Graphics graphics =this.getGraphics();
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, Board_Width, Board_Height);
		
		graphics.setColor(new Color(0, 32, 48));
		graphics.fillRect(50, Board_Width/2-30, Board_Width-100, 50);
		graphics.setColor(Color.white);
		graphics.drawRect(50, Board_Width/2-30, Board_Width/2-100, 50);
		
		Font small=new Font("Helvetica", Font.BOLD,14);
		FontMetrics metric=this.getFontMetrics(small);
		
		graphics.setColor(Color.white);
		graphics.setFont(small);
		graphics.drawString(message, (Board_Width - metric.stringWidth(message))/2, Board_Width/2);
	}
	
	public void animationCycle(){
		if (deaths==Aliens_To_Destroy) {
			ingame=false;
			message="You Won";
		}
		
		//player
		player.act();
		
		//shot
		if(shot.isVisible()){
			Iterator it=aliens.iterator();
			int shotX=shot.getX();
			int shotY=shot.getY();
			
			while (it.hasNext()) {
				Alien alien=(Alien)it.next();
				int alienX=alien.getX();
				int alienY=alien.getY();
				
				if(alien.isVisible()&&shot.isVisible()){
					
				}
			}
		}
	}
}
