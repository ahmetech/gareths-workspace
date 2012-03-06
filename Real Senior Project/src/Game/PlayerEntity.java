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
	
	public PlayerEntity(Game game, int x, int y){
		super(game.getSprite("standingRight.gif"), x, y);
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
		if(l&&!r&&vspeed){
			if(anim>=0){
				//sprite = walk1
			}
			if(anim>=8){
				//walk2
			}
			if(anim>=16){
				
			}
			if(anim>=24){
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
