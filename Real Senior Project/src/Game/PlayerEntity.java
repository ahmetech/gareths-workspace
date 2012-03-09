package Game;

import java.util.ArrayList;

public class PlayerEntity extends Entity{
	int anim=0;
	
	private Game game;

	private boolean jumping=false;
	
	private boolean Left=false;
	
	private boolean Right=false;
	
	
	public PlayerEntity(Game game, int x, int y){
		super(game.getSprite("Player/standingRight.gif"), x, y);
		gravity=0;
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
			sprite=game.getSprite("Player/standingLeft.gif");
		}
		if(dx==0&&!Left&&Right&&!jumping){
			sprite=game.getSprite("Player/standingRight.gif");
		}
		if(Left&&!Right&&(dx!=0)&&!jumping){
			if(anim>=0){
				sprite = game.getSprite("Player/left1.gif");
			}
			if(anim>=80){
				sprite = game.getSprite("Player/left2.gif");
			}
			if(anim>=160){
				sprite = game.getSprite("Player/left3.gif");
			}
			if(anim>=240){
				sprite = game.getSprite("Player/left4.gif");
			}
			if(anim>=320){
				sprite = game.getSprite("Player/left5.gif");
			}
			if(anim>=400){
				sprite = game.getSprite("Player/left6.gif");
			}
			if(anim>=480){
				sprite = game.getSprite("Player/left7.gif");
			}
			if(anim>=570){
				sprite = game.getSprite("Player/left8.gif");
			}
			if(anim>=650){
				sprite = game.getSprite("Player/left9.gif");
			}
			if(anim>=730){
				sprite = game.getSprite("Player/left10.gif");
				anim-=730;
			}
		}
		if(!Left&&Right&&(dx!=0)&&!jumping){
			if(anim>=0){
				sprite = game.getSprite("Player/right1.gif");
			}
			if(anim>=80){
				sprite = game.getSprite("Player/right2.gif");
			}
			if(anim>=160){
				sprite = game.getSprite("Player/right3.gif");
			}
			if(anim>=240){
				sprite = game.getSprite("Player/right4.gif");
			}
			if(anim>=320){
				sprite = game.getSprite("Player/right5.gif");
			}
			if(anim>=400){
				sprite = game.getSprite("Player/right6.gif");
			}
			if(anim>=480){
				sprite = game.getSprite("Player/right7.gif");
			}
			if(anim>=570){
				sprite = game.getSprite("Player/right8.gif");
			}
			if(anim>=650){
				sprite = game.getSprite("Player/right9.gif");
			}
			if(anim>=730){
				sprite = game.getSprite("Player/right10.gif");
				anim-=730;
			}
		}
		if(jumping&&Right&&!Left){
			if(anim>=0){
				sprite=game.getSprite("Player/jumpingRight1.gif");
			}
			if (anim>=80) {
				sprite=game.getSprite("Player/jumpingRight2.gif");
			}
			if (anim>=160) {
				sprite=game.getSprite("Player/jumpingRight3.gif");
			}
			if (anim>=240) {
				sprite=game.getSprite("Player/jumpingRight4.gif");
			}
			if (anim>=320) {
				sprite=game.getSprite("Player/jumpingRight5.gif");
				anim-=320;
			}
		}
		if(jumping&&!Right&&Left){
			if(anim>=0){
				sprite=game.getSprite("Player/jumpingLeft1.gif");
			}
			if (anim>=80) {
				sprite=game.getSprite("Player/jumpingLeft2.gif");
			}
			if (anim>=160) {
				sprite=game.getSprite("Player/jumpingLeft3.gif");
			}
			if (anim>=240) {
				sprite=game.getSprite("Player/jumpingLeft4.gif");
			}
			if (anim>=320) {
				sprite=game.getSprite("Player/jumpingLeft5.gif");
			}
		}
		
	}
	
	public boolean collidedWith(Entity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof BlockEntity) {
			
		}
	}
}
