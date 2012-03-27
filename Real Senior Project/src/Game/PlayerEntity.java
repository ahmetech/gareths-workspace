package Game;

import java.util.ArrayList;

public class PlayerEntity extends Entity{
	int anim=0;
	private Game game;
	private boolean jumping=false;
	boolean falling=false;
	private boolean Left=false;
	private boolean Right=false;
	private boolean grounded=true;
	float vspeed=0;
	float changeInDy=0;
	protected boolean lastLook=true;

	public PlayerEntity(Game game, int x, int y){
		super(game.getSprite("Player/standingRight.gif"), x, y);
		gravity=0;
		this.game=game;
	}
	public void move(long delta, ArrayList<BlockEntity> blocks) {
		// update the location of the entity based on move speeds
		//x += (delta * dx) / 1000;
		//y += (delta * (dy)) / 1000;
		update(delta, blocks);
	}

	//Getters and Setters
	public boolean isLeft() {return Left;}
	public void setLeft(boolean left) {Left = left;}
	public boolean isRight() {return Right;}
	public void setRight(boolean right) {Right = right;}
	public boolean isJumping() {return jumping;}
	public void setJumping(boolean Jumping){jumping=Jumping;}
	public boolean isGrounded() {return grounded;}
	public void setGrounded(boolean grounded) {this.grounded = grounded;}

	public void update(long delta, ArrayList<BlockEntity> blocks){
		y += (delta * vspeed)/1000;
		boolean test=checkCollisions(blocks, "l", delta);
		boolean test2=checkCollisions(blocks, "r", delta);
		System.out.println(test+" "+test2+" "+x+" "+lastLook);
		
		if(Left==true||lastLook==true){
			if(!checkCollisions(blocks, "l", delta)) x += (delta * dx) / 1000;
			else {
				while (checkCollisions(blocks, "l", delta)) {
					x+=1.5;
				}
			}
		}
		if(Right==true||lastLook==false){
			if(!checkCollisions(blocks, "r", delta)) x += (delta * dx) / 1000;
			else {
				while (checkCollisions(blocks, "r", delta)) {
					x-=1.5;
				}
			}
		}
		if(!checkCollisions(blocks,"d",delta)){
				vspeed+=gravity;
			if(vspeed>0){
				if(!checkCollisions(blocks,"d",delta)){
				
				}else{
					while(checkCollisions(blocks,"d",delta)){
						y-=	1;
						grounded=true;
						vspeed=0;	
					}
				}

			}else{
				if(!checkCollisions(blocks,"u",delta)){
				}else{
					y+=1;
					vspeed=0;
				}

			}
		}
		animate(delta);	
	}
	public void setVerticalMovement(float changeInDy){
		vspeed=(vspeed+changeInDy);
	}
	public void animate(long delta){
		anim+=delta;
		if(!lastLook&&(dx==0)&&!jumping)	{sprite=game.getSprite("Player/standingLeft.gif"); anim=0;}
		if(lastLook&&(dx==0)&&!jumping)	{sprite=game.getSprite("Player/standingRight.gif"); anim=0;}
		if(Left&&!Right&&(dx!=0)&&!jumping){
			if(anim>=0)		sprite = game.getSprite("Player/left1.gif");
			if(anim>=80)	sprite = game.getSprite("Player/left2.gif");
			if(anim>=160)	sprite = game.getSprite("Player/left3.gif");
			if(anim>=240)	sprite = game.getSprite("Player/left4.gif");
			if(anim>=320)	sprite = game.getSprite("Player/left5.gif");
			if(anim>=400)	sprite = game.getSprite("Player/left6.gif");
			if(anim>=480)	sprite = game.getSprite("Player/left7.gif");
			if(anim>=570)	sprite = game.getSprite("Player/left8.gif");
			if(anim>=650)	sprite = game.getSprite("Player/left9.gif");
			if(anim>=730){
				sprite = game.getSprite("Player/left10.gif");
				anim-=730;
			}
		}
		if(!Left&&Right&&(dx!=0)&&!jumping){
			if(anim>=0)		sprite = game.getSprite("Player/right1.gif");
			if(anim>=80)	sprite = game.getSprite("Player/right2.gif");
			if(anim>=160)	sprite = game.getSprite("Player/right3.gif");
			if(anim>=240)	sprite = game.getSprite("Player/right4.gif");
			if(anim>=320)	sprite = game.getSprite("Player/right5.gif");
			if(anim>=400)	sprite = game.getSprite("Player/right6.gif");
			if(anim>=480)	sprite = game.getSprite("Player/right7.gif");
			if(anim>=570)	sprite = game.getSprite("Player/right8.gif");
			if(anim>=650)	sprite = game.getSprite("Player/right9.gif");
			if(anim>=730){
				sprite = game.getSprite("Player/right10.gif");
				anim-=730;
			}
		}
		if(jumping&&lastLook){
			if(anim>=0)		sprite=game.getSprite("Player/jumpingRight1.gif");
			if (anim>=150)	sprite=game.getSprite("Player/jumpingRight2.gif");
			if (anim>=300) 	sprite=game.getSprite("Player/jumpingRight3.gif");
			if (anim>=450)	sprite=game.getSprite("Player/jumpingRight4.gif");
			if (anim>=600) {
				sprite=game.getSprite("Player/jumpingRight5.gif");
				while(!grounded){
					anim-=600;
					jumping=false;
				}
			}
		}
		if(jumping&&!lastLook){
			if(anim>=0)		sprite=game.getSprite("Player/jumpingLeft1.gif");
			if (anim>=150)	sprite=game.getSprite("Player/jumpingLeft2.gif");
			if (anim>=300) 	sprite=game.getSprite("Player/jumpingLeft3.gif");
			if (anim>=450)	sprite=game.getSprite("Player/jumpingLeft4.gif");
			if (anim>=600) {
				sprite=game.getSprite("Player/jumpingLeft5.gif");
				while(!grounded){
					anim-=600;
					jumping=false;
				}
			}
		}
	}

	public boolean checkCollisions(ArrayList<BlockEntity> blocks, String d, long delta){
		for (BlockEntity tempEntity : blocks) {
			if(collides(tempEntity, d, delta))return true;
		}
		return false;
	}

	public boolean collides(BlockEntity other, String d, long delta){
		//s = self -> unchanged position in check
		if(d.equals("l"))hitbox.setBounds((int) (getX()-((dx*delta)/1000)), (int) (getY()), 44, 55);
		if(d.equals("r"))hitbox.setBounds((int) (getX()+((dx*delta)/1000)), (int) (getY()), 44, 55);


		if(d.equals("u"))hitbox.setBounds((int) (getX()+((dx*delta)/1000)), (int) (getY()-((delta*vspeed)/1000)), 44, 55);
		if(d.equals("d"))hitbox.setBounds((int) (getX()+((dx*delta)/1000)), (int) (getY()+((delta*vspeed)/1000)), 44, 55);
		return hitbox.intersects(other.getX(),other.getY(),32,32);
	}
	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub

	}

}
