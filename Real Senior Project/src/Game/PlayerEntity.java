package Game;

import java.util.ArrayList;

public class PlayerEntity extends Entity{
	int anim=0;
	
	private Game game;

	private boolean jumping=false;
	
	private boolean Left=false;
	
	private boolean Right=false;
	
	
	public PlayerEntity(Game game, int x, int y){
		super(game.getSprite("right1.gif"), x, y);
		gravity=2;
		this.game=game;
	}
	public void move(long delta) {
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000;
		dy+=gravity;
		y += (delta * (dy)) / 1000;
		update(delta);
	}
	
	public boolean isLeft() {
		return Left;
	}

	public void setLeft(boolean left) {
		Left = left;
	}

	public boolean isRight() {
		return Right;
	}

	public void setRight(boolean right) {
		Right = right;
	}
	
	public void setJumping(boolean Jumping){
		jumping=Jumping;
	}
	
	public void update(long delta){
		animate(delta);	
		
		
		
		
	}
	public void animate(long delta){
		anim+=delta;
		if(dx==0&&Left&&!Right&&!jumping){
			sprite=game.getSprite("standingLeft.gif");
		}
		if(dx==0&&!Left&&Right&&!jumping){
			sprite=game.getSprite("standingRight.gif");
		}
		if(Left&&!Right&&(dx!=0)&&!jumping){
			if(anim>=0){
				sprite = game.getSprite("left1.gif");
			}
			if(anim>=80){
				sprite = game.getSprite("left2.gif");
			}
			if(anim>=160){
				sprite = game.getSprite("left3.gif");
			}
			if(anim>=240){
				sprite = game.getSprite("left4.gif");
			}
			if(anim>=320){
				sprite = game.getSprite("left5.gif");
			}
			if(anim>=400){
				sprite = game.getSprite("left6.gif");
			}
			if(anim>=480){
				sprite = game.getSprite("left7.gif");
			}
			if(anim>=570){
				sprite = game.getSprite("left8.gif");
			}
			if(anim>=650){
				sprite = game.getSprite("left9.gif");
			}
			if(anim>=730){
				sprite = game.getSprite("left10.gif");
				anim-=730;
			}
		}
		if(!Left&&Right&&(dx!=0)&&!jumping){
			if(anim>=0){
				sprite = game.getSprite("right1.gif");
			}
			if(anim>=80){
				sprite = game.getSprite("right2.gif");
			}
			if(anim>=160){
				sprite = game.getSprite("right3.gif");
			}
			if(anim>=240){
				sprite = game.getSprite("right4.gif");
			}
			if(anim>=320){
				sprite = game.getSprite("right5.gif");
			}
			if(anim>=400){
				sprite = game.getSprite("right6.gif");
			}
			if(anim>=480){
				sprite = game.getSprite("right7.gif");
			}
			if(anim>=570){
				sprite = game.getSprite("right8.gif");
			}
			if(anim>=650){
				sprite = game.getSprite("right9.gif");
			}
			if(anim>=730){
				sprite = game.getSprite("right10.gif");
				anim-=730;
			}
		}
	}
	
	public void collidedWith(Entity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof BlockEntity) {
			game.notifyDeath();
		}
	}
}
