package Game;

public class PlayerEntity extends Entity{
	
	/** The speed at which the Player moves horizontally */
	private float moveSpeed= 75;
	
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
	
	
	/*Make this work with the block instead of the alien
	public void collidedWithBlock(Entity other) {
		// if its an alien, notify the game that the player
		// is dead
		if (other instanceof AlienEntity) {
			game.notifyDeath();
		}
	}*/
}
