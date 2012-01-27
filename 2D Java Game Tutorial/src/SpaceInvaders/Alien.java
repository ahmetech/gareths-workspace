package SpaceInvaders;

import javax.swing.ImageIcon;

public class Alien extends Sprite{
	private Bomb bomb;
	
	public Alien(int paramX, int paramY){
		x=paramX;
		y=paramY;
		
		bomb=new Bomb(x, y);
		ImageIcon ii=new ImageIcon(this.getClass().getResource("alien.png"));
		setImage(ii.getImage());
	}
	
	
}
