package Breakout;

import javax.swing.ImageIcon;


public class Ball extends Sprite implements Commons {
   private int xdir;
   private int ydir;
   
   
   public Ball() {

     xdir = 1;
     ydir = -1;

     ImageIcon ii = new ImageIcon(this.getClass().getResource("ball.png"));
     image = ii.getImage();

     width = image.getWidth(null);
     height = image.getHeight(null);

     resetState();
    }


    public void move()
    {
      x += xdir;
      y += ydir;

      if (x == 0) {
        setXdir(1);
      }

      if (x == Ball_Right) {
        setXdir(-1);
      }

      if (y == 0) {
        setYdir(1);
      }
    }

    public void resetState() 
    {
      x = 230;
      y = 355;
    }

	public void setXdir(int xdir) {
		this.xdir = xdir;
	}
	public int getYdir() {
		return ydir;
	}
	public void setYdir(int ydir) {
		this.ydir = y;
	}
	
}
