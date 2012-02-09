package SpaceInvaders;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;


import static org.lwjgl.opengl.GL11.*;


public class Game {
	private String windowTitle="Space Invaders";
	private int width =800;
	private int height=600;
	private TextureLoader textureLoader;
	private ArrayList<Entity> entities=new ArrayList<Entity>();
	private ArrayList<Entity> removeList=new ArrayList<Entity>();
	private ShipEntity ship;
	private ShotEntity[] shots;
	private Sprite message;
	private Sprite pressAnyKey;
	private Spirte youWin;
	private Sprite gotYou;
	private int shotIndex;
	private float moveSpeed=300;
	private long lastFire;
	private long fireInterval=500;
	private int alienCount;
	private boolean waitingForKeyPress;
	private boolean logicRequiredThisLoop;
	private long lastLoopTime=getTime();
	private boolean fireHasBeenReleased;
	private long lastFPSTime;
	private int FPS;
	private static long timerTicksPerSecond = Sys.getTimerResolution();
	public static boolean gameRunning=true;
	private SoundManager soundManager;
	private boolean fullscreen;
	private int SOUND_SHOT;
	private int SOUND_HIT;
	private int SOUND_START;
	private int SOUND_WIN;
	private int SOUND_LOSE;
	private int mouseX;
	private static boolean isApp;
	
	public Game(boolean paramFullscreen){
		fullscreen=paramFullscreen;
		initialize();
	}
	
	//Get the high resolution time in milliseconds
	//@return The high resolution time in milliseconds
	public static long getTime(){
		return (Sys.getTime() * 1000) / timerTicksPerSecond;
	}
	
	//Sleep for a fixed number of milliseconds.
	//@param duration The amount of time in milliseconds to sleep for
	public static void sleep(long duration){
		try {
			Thread.sleep((duration*timerTicksPerSecond)/1000);
		} catch (InterruptedException inte) {
		}
	}
	
	//Intialize the common elements for the game
	public void initialize(){
		//Initialize the window beforehand
		try {
			setDisplayMode();
			Display.setTitle(windowTitle);
			Display.setFullscreen(fullscreen);
			Display.create();
			
			//grab the mouse, dont want that hideous cursor when we're playing!
			if (isApp) {
				Mouse.isGrabbed();
			}
			
			//enable textures since we're going to use these for our sprites
			glEnable(GL_TEXTURE_2D);
			//disable the OpenGL depth test since we're rendering 2D graphics
			glDisable(GL_DEPTH_TEST);
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			
			glOrtho(0, width, height, 0, -1, 1);
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glViewport(0, 0, width, height);
			
			textureLoader=new TextureLoader();
			
			// create our sound manager, and initialize it with 7 channels
		    // 1 channel for sounds, 6 for effects - this should be enough
		    // since we have a most 4 shots on screen at any one time, which leaves
		     // us with 2 channels for explosions.
			soundManager=new SoundManager();
			soundManager.initialize(8);
			
			// load our sound data
			SOUND_SHOT   = soundManager.addSound("shot.wav");
			SOUND_HIT    = soundManager.addSound("hit.wav");
			SOUND_START  = soundManager.addSound("start.wav");
			SOUND_WIN    = soundManager.addSound("win.wav");
			SOUND_LOSE  = soundManager.addSound("loose.wav");
		} catch (LWJGLException e) {
			System.out.println("Game exiting - problem in initialization:");
			e.printStackTrace();
			Game.gameRunning=false;
			return;
		}
	}
	
	
	
	
}
