package Pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;;

public class Board extends JPanel implements ActionListener{
	Dimension d;
	Font smallFont=new Font("Helvetica", Font.BOLD, 14);
	
	FontMetrics fmsmall, fmlarge;
	Image ii;
	Color dotcolot= new Color(192, 192, 0);
	Color mazeColor;
	
	boolean ingame=false;
	boolean dying=false;
	
	final int blocksize=24;
	final int nrofblocks=15;
	final int scrsize=nrofblocks*blocksize;
	final int pacanindelay=2;
	final int pacmananimcount=4;
	final int maxghosts=12;
	final int pacmanspeed=6;
	
	int pacanimcount=pacanindelay;
	int pacanimdir=1;
	int pacmananimpos=0;
	int nrofghosts=6;
	int pacsleft, score;
	int deathcounter;
	int[] dx, dy;
	int[] ghostx, ghosty, ghostdx, ghostdy, ghostspeed;
	
	Image ghostImage;
	Image pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
	Image pacman3up, pacman3down, pacman3left, pacman3right;
	Image pacman4up, pacman4down, pacman4left, pacman4right;
	
	int pacmanx, pacmany, pacmandx, pacmandy;
	int reqdx, reqdy, viewdx, viewdy;
	
	final short leveldata[]={ 19, 26, 26, 26, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
		      21, 0,  0,  0,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
		      21, 0,  0,  0,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 
		      21, 0,  0,  0,  17, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20, 
		      17, 18, 18, 18, 16, 16, 20, 0,  17, 16, 16, 16, 16, 16, 20,
		      17, 16, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 16, 24, 20, 
		      25, 16, 16, 16, 24, 24, 28, 0,  25, 24, 24, 16, 20, 0,  21, 
		      1,  17, 16, 20, 0,  0,  0,  0,  0,  0,  0,  17, 20, 0,  21,
		      1,  17, 16, 16, 18, 18, 22, 0,  19, 18, 18, 16, 20, 0,  21,
		      1,  17, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 20, 0,  21, 
		      1,  17, 16, 16, 16, 16, 20, 0,  17, 16, 16, 16, 20, 0,  21,
		      1,  17, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 20, 0,  21,
		      1,  17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  21,
		      1,  25, 24, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 18, 20,
		      9,  8,  8,  8,  8,  8,  8,  8,  8,  8,  25, 24, 24, 24, 28 };
	
	final int validspeeds[]={1, 2, 3, 4, 6, 8};
	final int maxspeed;
	int currentspeed=3;
	short[] screendata;
	Timer timer;
	
	
	public Board(){
		GetImages();
		
		addKeyListener(new TAdapter());
		
		screendata=new short[nrofblocks*nrofblocks];
		mazeColor=new Color(5, 100, 5);
		setFocusable(true);
		
		d=new Dimension(400, 400);
		
		setBackground(Color.black);
		setDoubleBuffered(true);
		
		ghostx=new int[maxghosts];
		ghostdx=new int[maxghosts];
		ghosty=new int[maxghosts];
		ghostdy=new int[maxghosts];
		ghostspeed=new int[maxghosts];
		dx=new int[4];
		dy=new int[4];
		timer=new Timer(40, this);
		timer.start();
	}
	
	public void addNotify(){
		super.addNotify();
		GameInit();
	}
	
	public void DoAnim(){
		pacanimcount--;
		if(pacanimcount<=0){
			pacanimcount=pacanindelay;
			pacmananimpos=pacmananimpos+pacanimdir;
			if(pacmananimpos==(pacmananimcount-1)||pacmananimpos == 0){
				pacanimdir= -pacanimdir;
			}
		}
	}
	
	public void PlayGame(Graphics2D g2d){
		if(dying){
			Death();
		}else{
			MovePacman();
			DrawPacMan(g2d);
			moveGhosts(g2d);
			CheckMaze();
		}
	}
	
	public void ShotIntroScreen(Graphics2D g2d){
		g2d.setColor(new Color (0, 32 ,48));
		g2d.fillRect(50, scrsize/2-30, scrsize-100, 50);
		g2d.setColor(Color.white);
		g2d.drawRect(50, scrsize/2-30, scrsize-100, 50);
		
		String s="Press s to start";
		Font small=new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr=this.getFontMetrics(small);
		
		g2d.setColor(Color.white);
		g2d.setFont(small);
		g2d.drawString(s, (scrsize-metr.stringWidth(s))/2, scrsize/2);
	}
	
	public void DrawScore(Graphics2D g){
		int i;
		String s;
		
		g.setFont(smallFont);
		g.setColor(new Color(96, 128 ,255));
		s="Score: "+score;
		g.drawString(s, scrsize/2+96, scrsize+16);
		for(i=0; i<pacsleft;i++){
			g.drawImage(pacman3left, i*28+8, scrsize+1, this);
		}
	}
	
	public void CheckMaze(){
		short i=0;
		boolean finished=true;
		
		while (i<nrofblocks*nrofblocks&&finished) {
			if((screendata[i]&48)!=0)finished=false;
			i++;
		}
		
		if(finished){
			score+=50;
			
			if(nrofblocks<maxghosts)nrofghosts++;
			if(currentspeed<maxspeed)currentspeed++;
			LevelInit();
		}
	}
	
	public void Death(){
		pacsleft--;
		if(pacsleft==0)ingame=false;
		LevelContinue();
	}
	
	public void moveGhosts(Graphics2D g2d){
		short i;
		int pos;
		int count;
		
		for(i=0; i<nrofghosts; i++){
			if(){
				
			}
		}
	}
}
