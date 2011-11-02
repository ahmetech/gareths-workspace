package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Board extends JPanel implements Commons{
	Image ii;
	Timer timer;
	Ball ball;
	Paddle paddle;
	Brick[] bricks;
	boolean ingame=true;
	int timerId;
	int Score;
	int NumberofLives;
	
	public Board(){
		NumberofLives=3;
		Score=0;
		addKeyListener(new TAdapter());
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
		if(!(NumberofLives==0)){
			g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this);
			g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(), this);
			for (int i = 0; i < bricks.length; i++) {
				if(!bricks[i].isDestroyed()){
					g.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), bricks[i].getWidth(), bricks[i].getHeight(), this);
				}
			}
			int tempscore=0;
			for (int i = 0; i < bricks.length; i++) {
				if(bricks[i].isDestroyed()){
					tempscore++;
				}
				if(Score<tempscore){
					Score=tempscore;
				}
			}
			ReportScore(g);
			ReportLives(g);
		}else{
			Font font = new Font("Verdana", Font.BOLD, 18);
            FontMetrics metr = this.getFontMetrics(font);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString("You Lose",(Commons.Width - metr.stringWidth("Game Over")) / 2, Commons.Width / 2);
		}
		Toolkit.getDefaultToolkit().sync();
        g.dispose();
	}
	private class TAdapter extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			paddle.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			paddle.keyPressed(e);
		}
	}
	class ScheduleTask extends TimerTask{
		public void run() {
			ball.move();
			paddle.move();
			checkCollision();
			repaint();
		}
	}
	public void stopGame(){
		ingame=false;
		timer.cancel();
	}
	public void ReportScore(Graphics g){
		g.drawString("Your score is: "+Score, 1, 10);
	}
	public void ReportLives(Graphics g){
		g.drawString("LIves left: "+NumberofLives, 225, 10);
	}
	public void checkCollision(){
		if(ball.getRect().getMaxY()>Commons.Bottom){
			NumberofLives-=1;
			ball.resetState();
			paddle.resetState();
		}
		for (int i = 0, j=0; i < bricks.length; i++) {
			if(bricks[i].isDestroyed()){
				j++;
			}
			if(j==30){
				stopGame();
			}
		}
		if((ball.getRect()).intersects(paddle.getRect())){
			int paddleLPos = (int)paddle.getRect().getMinX();
            int ballLPos = (int)ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ball.setXdir(-1);
                ball.setYdir(-1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ball.setXdir(-1);
                ball.setYdir(-1 * ball.getYdir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ball.setXdir(0);
                ball.setYdir(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ball.setXdir(1);
                ball.setYdir(-1 * ball.getYdir());
            }

            if (ballLPos > fourth) {
                ball.setXdir(1);
                ball.setYdir(-1);
            }


        }


        for (int i = 0; i < 30; i++) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int)ball.getRect().getMinX();
                int ballHeight = (int)ball.getRect().getHeight();
                int ballWidth = (int)ball.getRect().getWidth();
                int ballTop = (int)ball.getRect().getMinY();

                Point pointRight =
                    new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom =
                    new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ball.setXdir(-1);
                    }

                    else if (bricks[i].getRect().contains(pointLeft)) {
                        ball.setXdir(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ball.setYdir(1);
                    }

                    else if (bricks[i].getRect().contains(pointBottom)) {
                        ball.setYdir(-1);
                    }
                    bricks[i].setDestroyed(true);
                }
            }
        }
		}
		
	}

