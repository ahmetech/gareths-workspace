package SpaceInvaders;

import java.util.ArrayList;

import org.lwjgl.Sys;



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
	
	
	
	
}
