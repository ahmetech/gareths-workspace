package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JPanel;

public class Board extends JPanel implements Commons{
	Image ii;
	Timer timer;
	Ball ball;
	Paddle paddle;
	Brick[] bricks;
	boolean ingame=true;
	int timerId;
	
	public Board(){
		addKeyListener(new TAdpater());
		setFocusable(true);
		bricks=new Brick[30];
		setDoubleBuffered(true);
		timer=new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
	}
	public void addNotify(){
		super.addNotify();
		gameInit();
	}
	public void gameInit(){
		ball=new Ball();
		paddle=new Paddle();
		int k=0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				bricks[k]=new Brick(j*40+30,i*10+50);
				k++;
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		if(ingame){
			g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this);
			g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), this);
			for (int i = 0; i < bricks.length; i++) {
				if(!bricks[i].isDestroyed()){
					g.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), bricks[i].getWidth(), bricks[i].getHeight(), this);
				}
			}
		}else{
			Font font = new Font("Verdana", Font.BOLD, 18);
            FontMetrics metr = this.getFontMetrics(font);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("Game Over",(Commons.Width - metr.stringWidth("Game Over")) / 2, Commons.Width / 2);
		}
		Toolkit.getDefaultToolkit().sync();
        g.dispose();
	}
	private class TAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			Paddle.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			Paddle.keyPressed(e);
		}
	}
}
