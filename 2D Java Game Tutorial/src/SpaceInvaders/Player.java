package SpaceInvaders;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class Player extends Sprite implements Commons{
	private final int Start_Y= 280;
	private final int Start_X= 270;
	
	private int width;
	boolean l, r;
	
	public Player(){
		ImageIcon ii= new ImageIcon(this.getClass().getResource("player.png"));
		width=ii.getImage().getWidth(null);
		
		setImage(ii.getImage());
		setX(Start_X);
		setY(Start_Y);
	}
	
	public void act(){
		if(l){
			x+=dx;
		}
		if(r){
			x+=dx;
		}
		if(x<=2){
			x=2;
		}
		if (x>= Board_Width-2*width) {
			x=Board_Width-2*width;
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT){
			l=true;
			dx=-2;
		}
		if(key==KeyEvent.VK_RIGHT){
			r=true;
			dx=2;
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
	
	
}
