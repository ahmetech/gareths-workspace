package Game;

public class PlayerEntity extends Entity{
	
	/** The speed at which the aliens moves horizontally */
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
		super(game.getSprite("walkingRight.gif"), x, y);
	}
}
