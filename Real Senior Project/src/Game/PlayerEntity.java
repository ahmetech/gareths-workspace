package Game;

import java.util.ArrayList;

public class PlayerEntity extends Entity{
	
	/** The speed at which the Player moves horizontally */
	private float moveSpeed= 75;
	
	int anim=0;
	
	private Game game;
	
	/** The animation frames */
	private Sprite[] frames= new Sprite[4];
	
	/** The time since the last frame change took place */
	private long lastFrameChange;

	/** The frame duration in milliseconds, i.e. how long any given frame of animation lasts */
	private long frameDuration= 250;
	 
	/** The current frame of animation being displayed */
	private int frameNumber;
	
	private boolean jumping=false;
	
	private boolean movingLeft=false;
	
	private boolean movingRight=false;
	
	public PlayerEntity(Game game, int x, int y){
		super(game.getSprite("standingRight.gif"), x, y);
		gravity=10;
		this.game=game;
	}

	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void update(ArrayList blocks, long delta){
		animate(delta);	
		
		
		
		
	}
	public void animate(long delta){
		anim+=delta;
		if(movingLeft&&!movingRight&&(dx!=0)){
			if(anim>=0){
				sprite = game.getSprite("walkingLeft.gif");
			}
			if(anim>=8){
				sprite = game.getSprite("runningLeft.gif");
			}
			if(anim>=16){
				sprite = game.getSprite("walkingLeft.gif");
			}
			if(anim>=24){
				sprite = game.getSprite("runningLeft.gif");
				anim-=24;
			}
		}
		if(!movingLeft&&movingRight&&(dx!=0)){
			if(anim>=0){
				sprite = game.getSprite("walkingRight.gif");
			}
			if(anim>=8){
				sprite = game.getSprite("runningRight.gif");
			}
			if(anim>=16){
				sprite = game.getSprite("walkingRight.gif");
			}
			if(anim>=24){
				sprite = game.getSprite("runningRight.gif");
				anim-=24;
			}
		}
		
		
	}
	
	
	
	/*Make this work with the block instead of the alien
	public void collidedWithBlock(Entity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof AlienEntity) {
			game.notifyDeath();
		}
	}*/
}
