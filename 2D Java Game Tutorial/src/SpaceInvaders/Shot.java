package SpaceInvaders;

import javax.swing.ImageIcon;

public class Shot extends Sprite{
	private final int H_Space=6;
	private final int V_Space=1;
	
	public Shot(){
		
	}
	
	public Shot(int paramX, int paramY){
		ImageIcon ii= new ImageIcon(this.getClass().getResource("shot.png"));
		setImage(ii.getImage());
		setX(x+H_Space);
		setY(y-V_Space);
	}
	
}
