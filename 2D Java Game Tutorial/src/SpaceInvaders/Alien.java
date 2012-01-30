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
	
	public void act(int direction){
		this.x+=direction;
	}
	
	public Bomb getBomb(){
		return bomb;
	}
	
	public class Bomb extends Sprite{
		private boolean destroyed;
		
		public Bomb(int paramX, int paramY){
			setDestroyed(true);
			this.x=paramX;
			this.y=paramY;
			ImageIcon ii= new ImageIcon(this.getClass().getResource("bomb.png"));
			setImage(ii.getImage());
		}

		public boolean isDestroyed() {
			return destroyed;
		}

		public void setDestroyed(boolean destroyed) {
			this.destroyed = destroyed;
		}
		
		
	}
}
