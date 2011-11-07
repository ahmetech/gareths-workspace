package Breakout;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Paddle extends Sprite implements Commons {
	boolean l;
	boolean r;
	public Paddle(){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("paddle.png"));
        image = ii.getImage();
        width=image.getWidth(null);
        height=image.getHeight(null);
        resetState();
	}
	public void move(){
		if(l){
			x+=-3;
		}
		if(r){
			x+=3;
		}
		if(x<=2){
			x=2;
		}
		if(x>= Commons.Paddle_Right){
			x=Commons.Paddle_Right;
		}
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
			l=true;
		}
		if(key==KeyEvent.VK_RIGHT){
			r=true;
		}
	}
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
			l=false;
		}
		if(key==KeyEvent.VK_RIGHT){
			r=false;
		}
	}
	public void resetState(){
		x=200;
		y=360;
	}
}
