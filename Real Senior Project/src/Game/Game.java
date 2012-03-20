package Game;

import java.awt.Graphics;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import static org.lwjgl.opengl.GL11.*;


public class Game {

	private String WINDOW_TITLE= "Senior Writing Project";
	private int	width= 800;
	private int height= 600;
	private TextureLoader textureLoader;
	/**The list of all the entities that exist in our game**/
	private ArrayList<Entity> entities= new ArrayList<Entity>();
	/** The list of entities that need to be removed from the game this loop */
	private ArrayList<Entity> removeList= new ArrayList<Entity>();
	
	private ArrayList<BlockEntity> blocks=new ArrayList<BlockEntity>();
	/** The entity representing the player */
	private PlayerEntity player;
	/** The speed at which the player's ship should move (pixels/sec) */
	private float moveSpeed= 150;
	/** True if we're holding up game play until a key has been pressed */
	private boolean waitingForKeyPress= false;
	/** True if game logic needs to be applied this loop, normally as a result of a game event */
	private boolean	logicRequiredThisLoop;
	/** The time at which the last rendering looped started from the point of view of the game logic */
	private long lastLoopTime= getTime();
	/** The time since the last record of fps */
	private long lastFpsTime;
	/** The recorded fps */
	private int fps;
	private static long	timerTicksPerSecond= Sys.getTimerResolution();
	/** True if the game is currently "running", i.e. the game loop is looping */
	public static boolean gameRunning= true;
	/** Whether we're running in fullscreen mode */
	private boolean fullscreen;
	/** Is this an application or applet */
	private static boolean isApplication;

	private boolean jumpHasBeenReleased=false;


	//Might use these for the words
	/** The message to display which waiting for a key press */
	private Sprite				message;

	/** The sprite containing the "Press Any Key" message */
	private Sprite				pressAnyKey;

	/** The sprite containing the "You win!" message */
	private Sprite				youWin;

	/** The sprite containing the "You lose!" message */
	private Sprite				gotYou;

	public static void main(String[] args) {
		isApplication = true;
		System.out.println("Use -fullscreen for fullscreen mode");
		new Game((args.length > 0 && "-fullscreen".equalsIgnoreCase(args[0]))).execute();
		System.exit(0);
	}

	public Game(boolean fullscreen) {
		this.fullscreen = fullscreen;
		initialize();
	}

	public static long getTime() {
		// we get the "timer ticks" from the high resolution timer
		// multiply by 1000 so our end result is in milliseconds
		// then divide by the number of ticks in a second giving
		// us a nice clear time in milliseconds
		return (Sys.getTime() * 1000) / timerTicksPerSecond;
	}

	public static void sleep(long duration) {
		try {
			Thread.sleep((duration * timerTicksPerSecond) / 1000);
		} catch (InterruptedException inte) {
		}
	}

	public void initialize() {
		// initialize the window beforehand
		try {
			setDisplayMode();
			Display.setTitle(WINDOW_TITLE);
			Display.setFullscreen(fullscreen);
			Display.create();

			// grab the mouse, dont want that hideous cursor when we're playing!
			if (true) {
				Mouse.setGrabbed(true);
			}

			// enable textures since we're going to use these for our sprites
			glEnable(GL_TEXTURE_2D);

			// disable the OpenGL depth test since we're rendering 2D graphics
			glDisable(GL_DEPTH_TEST);

			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();

			glOrtho(0, width, height, 0, -1, 1);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glViewport(0, 0, width, height);

			textureLoader = new TextureLoader();

		} catch (LWJGLException le) {
			System.out.println("Game exiting - exception in initialization:");
			le.printStackTrace();
			Game.gameRunning = false;
			return;
		}

		//get our sprites
		//gotYou = getSprite("gotyou.gif");
		//pressAnyKey = getSprite("walkingLeft.gif");
		//youWin = getSprite("youwin.gif");


		message = pressAnyKey;


		// setup the initial game state
		startGame();
	}


	private boolean setDisplayMode() {
		try {
			// get modes
			DisplayMode[] dm = org.lwjgl.util.Display.getAvailableDisplayModes(width, height, -1, -1, -1, -1, 60, 60);

			org.lwjgl.util.Display.setDisplayMode(dm, new String[] {
					"width=" + width,
					"height=" + height,
					"freq=" + 60,
					"bpp=" + org.lwjgl.opengl.Display.getDisplayMode().getBitsPerPixel()
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to enter fullscreen, continuing in windowed mode");
		}

		return false;
	}

	private void startGame() {
		// clear out any existing entities and intialise a new set
		entities.clear();
		initEntities();
	}

	private void initEntities() {
		// create the player ship and place it roughly in the center of the screen
		player = new PlayerEntity(this, 370, 500);
		entities.add(player);
		//entities.add(new BlockEntity(this, "Blocks/floor1.gif", 370, 560));
		//entities.add(new BlockEntity(this, "Blocks/floor1.gif", 338, 560));
		//entities.add(new BlockEntity(this, "Blocks/floor1.gif", 402, 500));
		// Add all of the blocks at a later time
		blocks.add(new BlockEntity(this, "Blocks/floor1.gif", 370, 560));
		blocks.add(new BlockEntity(this, "Blocks/floor1.gif", 338, 560));
		blocks.add(new BlockEntity(this, "Blocks/floor1.gif", 450, 500));
	}

	/**
	 * Notification from a game entity that the logic of the game
	 * should be run at the next opportunity (normally as a result of some
	 * game event)
	 */
	public void updateLogic() {
		logicRequiredThisLoop = true;
	}

	/**
	 * Remove an entity from the game. The entity removed will
	 * no longer move or be drawn.
	 *
	 * @param entity The entity that should be removed
	 */
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}

	/**
	 * Notification that the player has died.
	 */
	public void notifyDeath() {
		message = gotYou;
		waitingForKeyPress = true;
	}



	/**
	 * Notification that the player has won since all the statements
	 * have been collected.
	 */
	public void notifyWin() {
		message = youWin;
		waitingForKeyPress = true;
	}


	private void gameLoop() {
		while (Game.gameRunning) {
			// clear screen
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();

			// let subsystem paint
			frameRendering();

			// update window contents
			Display.update();
		}

		// clean up
		Display.destroy();
	}

	/**
	 * Notification that a frame is being rendered. Responsible for
	 * running game logic and rendering the scene.
	 */
	public void frameRendering() {
		//SystemTimer.sleep(lastLoopTime+10-SystemTimer.getTime());
		Display.sync(60);

		// work out how long its been since the last update, this
		// will be used to calculate how far the entities should
		// move this loop
		long delta = getTime() - lastLoopTime;
		lastLoopTime = getTime();
		lastFpsTime += delta;
		fps++;

		// update our FPS counter if a second has passed
		if (lastFpsTime >= 1000) {
			Display.setTitle(WINDOW_TITLE + " (FPS: " + fps + ")");
			lastFpsTime = 0;
			fps = 0;
		}

		// cycle round asking each entity to move itself
		if (!waitingForKeyPress) {
			player.move(delta, blocks);
		}

		// cycle round drawing all the entities we have in the game
		for ( Entity entity : entities ) {
			entity.draw();
		}
		for(BlockEntity block: blocks){
			block.draw();
		}

		// brute force collisions, compare every entity against
		// every other entity. If any of them collide notify
		// both entities that the collision has occured
		/*
		for (int p = 0; p < entities.size(); p++) {
			for (int s = p + 1; s < entities.size(); s++) {
				Entity me = entities.get(p);
				Entity him = entities.get(s);

				if (me.collidesWith(him)) {
					me.collidedWith(him);
					him.collidedWith(me);
				}
			}
		}*/

		// remove any entity that has been marked for clear up
		entities.removeAll(removeList);
		removeList.clear();

		// if a game event has indicated that game logic should
		// be resolved, cycle round every entity requesting that
		// their personal logic should be considered.
		if (logicRequiredThisLoop) {
			for ( Entity entity : entities ) {
				entity.doLogic();
			}

			logicRequiredThisLoop = false;
		}

		// if we're waiting for an "any key" press then draw the
		// current message

		// resolve the movement of the ship. First assume the ship
		// isn't moving. If either cursor key is pressed then
		// update the movement appropriately
		player.setHorizontalMovement(0);

		// get mouse movement on x axis. We need to get it now, since
		// we can only call getDX ONCE! - secondary calls will yield 0, since
		// there haven't been any movement since last call.

		// we delegate input checking to submethod since we want to check
		// for keyboard, mouse & controller
		boolean leftPressed   = hasInput(Keyboard.KEY_LEFT);
		boolean rightPressed  = hasInput(Keyboard.KEY_RIGHT);
		boolean spacePressed   = hasInput(Keyboard.KEY_SPACE);


		if ((leftPressed) && (!rightPressed)) {
			player.setHorizontalMovement(-150);
			player.setLeft(true);
			player.setRight(false);
		} else if ((rightPressed) && (!leftPressed)) {
			player.setHorizontalMovement(150);
			player.setLeft(false);
			player.setRight(true);
		}
		if (spacePressed) {
			player.setJumping(true);
			player.setVerticalMovement(-40);
		}
		else {
			if (!spacePressed) {
				jumpHasBeenReleased=true;
			}
			if (spacePressed && jumpHasBeenReleased) {
				jumpHasBeenReleased=false;
			}
		}
		// if escape has been pressed, stop the game
		if ((Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) && isApplication) {
			Game.gameRunning = false;
		}
	}

	/**
	 * @param direction
	 * @return
	 */
	private boolean hasInput(int direction) {
		switch(direction) {
		case Keyboard.KEY_LEFT:
			return
			Keyboard.isKeyDown(Keyboard.KEY_LEFT);

		case Keyboard.KEY_RIGHT:
			return
			Keyboard.isKeyDown(Keyboard.KEY_RIGHT);

		case Keyboard.KEY_SPACE:
				return
				Keyboard.isKeyDown(Keyboard.KEY_SPACE);
		}
		return false;
	}



	public void execute() {
		gameLoop();
	}

	public Sprite getSprite(String ref) {

		return new Sprite(textureLoader, ref);
	}


}
