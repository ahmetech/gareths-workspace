package Game;

public class BlockEntity extends Entity{
	private Game game;
	
	public BlockEntity(Game game, String ref, int x, int y){
		super(game.getSprite(ref), x, y);
		this.game=game;
	}

	@Override
	public void collidedWith(Entity other) {
	
	}
}
