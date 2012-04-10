import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.omg.CORBA.Current;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class Board {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board();
		board.start();
	}

	Player player;
	boolean made=false;
	Dummy light;
	ArrayList<Block> blocks = new ArrayList<Block>();
	ArrayList<Scroll> scrolls=new ArrayList<Scroll>();
	
	
	long lastFrame;
	int fps;
	long lastFPS;
	
	int FULLSCREEN = 2;
	int windowed640x480=1;
	int windowed320x240=0;

	int mode=FULLSCREEN;
	
	public void start(){
		Mouse.setGrabbed(true);
		
		
		//createLevel1();
		createLevel2();
		//createLevel3();
		//createLevel4();
		
		try{
			if(mode==windowed640x480 || mode==FULLSCREEN)Display.setDisplayMode(new DisplayMode(1920,1080));
			else Display.setDisplayMode(new DisplayMode(1024, 768));
			Display.create();
		}catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		initGL();
		getDelta();
		lastFPS = getTime();
		
		if(mode==FULLSCREEN){
			setDisplayMode(1920,1080,true);
			Display.setVSyncEnabled(true);
		}else if(mode==windowed640x480){
			setDisplayMode(1024,768,false);
			Display.setVSyncEnabled(false);
		}else if(mode==windowed320x240){
			setDisplayMode(320,240,false);
			Display.setVSyncEnabled(false);
		}
		
		
		
		while(!Display.isCloseRequested()){
			int delta = getDelta();
			update(delta);
			
			renderGL();
			Display.update();
			Display.sync(60); // cap fps to 60fps
		}
		Display.destroy();
		
	}
	
	
	
	public void setDisplayMode(int width, int height, boolean fullscreen) {

		// return if requested DisplayMode is already set
                if ((Display.getDisplayMode().getWidth() == width) && 
			(Display.getDisplayMode().getHeight() == height) && 
			(Display.isFullscreen() == fullscreen)) {
			return;
		}
		
		try {
			DisplayMode targetDisplayMode = null;
			
			if (fullscreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;
				
				for (int i=0;i<modes.length;i++) {
					DisplayMode current = modes[i];
					
					if ((current.getWidth() == width) && (current.getHeight() == height)) {
						if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
							if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
								targetDisplayMode = current;
								freq = targetDisplayMode.getFrequency();
							}
						}

						// if we've found a match for bpp and frequence against the 
						// original display mode then it's probably best to go for this one
						// since it's most likely compatible with the monitor
						if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
						    (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
							targetDisplayMode = current;
							break;
						}
					}
				}
			} else {
				targetDisplayMode = new DisplayMode(width,height);
			}
			
			if (targetDisplayMode == null) {
				System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
				return;
			}

			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullscreen);
			
		} catch (LWJGLException e) {
			System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
		}
	}



	public long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	
	public void update(int delta){
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
        	player.l=true;
        }else{
        	player.l=false;
        }

		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
        	player.r=true;
        }else{
        	player.r=false;
        }
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			player.u=true;
        }else{
        	player.u=false;
        }
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			player.z=true;
		}else {
			player.z=false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
			made=true;
			light=new Dummy(1200, 994, 25, 24);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_O)) {
			player.o=true;
		}else {
			player.o=false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			try {
				Display.setFullscreen(false);
			} catch (LWJGLException e) {
				e.printStackTrace();
			}
        	Display.destroy();
        	System.exit(0);
        }
		
		player.update(delta,blocks, scrolls);
		if (made) {
			light.update(delta, player);
		}
	}
	
	

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 1920, 1080, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL_TEXTURE_2D);
		GL11.glEnable(GL_BLEND);
	}
	
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
 
	    return delta;
	}
	
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	
	
	
	public void renderGL() {
		// Clear The Screen And The Depth Buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			player.draw();
			if (made) {
				light.draw();
			}
			for(int i = 0; i < blocks.size(); i++){
				blocks.get(i).draw();
			}
			for (int i = 0; i < scrolls.size(); i++) {
				scrolls.get(i).draw();
			}
	
	}
	
	
	public void createLevel1(){
		player = new Player(10, 1000);
		for(int i =0; i<50; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
		blocks.add(new Block(32*8, 988, "air"));
		scrolls.add(new Scroll(32*8+8, 968, 48, 48, "01", "1",true));
		
		blocks.add(new Block(32*20, 988, "air"));
		blocks.add(new Block(32*24, 928, "air"));
		blocks.add(new Block(32*27, 868, "air"));
		scrolls.add(new Scroll(32*27+8, 848, 48, 48, "01", "1",true));
		
		blocks.add(new Block(32*39, 1048, "floor"));
		blocks.add(new Block(32*44, 1048, "floor"));
		blocks.add(new Block(32*49, 1048, "floor"));
		blocks.add(new Block(32*54, 1048, "floor"));
		scrolls.add(new Scroll(32*54+8, 1028, 48, 48, "01", "1",true));
		
		
	}
	
	public void createLevel2(){
		player = new Player(0, 170);
		blocks.add(new Block(0, 200, "air"));
		blocks.add(new Block(64, 140, "air"));
		blocks.add(new Block(32*5, 80, "air"));
		scrolls.add(new Scroll(32*5+8, 60, 48, 48, "01", "1",true));
		blocks.add(new Block(32*9, 160, "air"));
		blocks.add(new Block(32*5, 300, "air"));
		blocks.add(new Block(15, 500, "air"));
		blocks.add(new Block(32*2.5, 800, "air"));
		scrolls.add(new Scroll(32*2.5+8, 780, 48, 48, "01", "1",true));
		blocks.add(new Block(32*6, 800, "air"));
		blocks.add(new Block(32*9, 800, "air"));
		blocks.add(new Block(32*12, 800, "air"));
		blocks.add(new Block(32*14.5, 750, "air"));
		blocks.add(new Block(32*17, 700, "air"));
		blocks.add(new Block(32*19.5, 650, "air"));
		blocks.add(new Block(32*22, 700, "air"));
		blocks.add(new Block(32*25.5, 750, "air"));
		scrolls.add(new Scroll(32*25.5+8, 730, 48, 48, "01", "1",true));
		
	}
	
	public void createLevel3(){
		player = new Player(10, 1000);
		player.speed=.15;
		for(int i =0; i<6; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
		blocks.add(new Block(32*6.25, 988, "air"));
		blocks.add(new Block(32*7.25, 988, "air"));
		blocks.add(new Block(32*4, 928, "air"));
		blocks.add(new Block(32*3.5, 928, "air"));
		blocks.add(new Block(32, 868, "air"));
		scrolls.add(new Scroll(40, 848, 48, 48, "01", "1",true));
		
		for(double i =16; i<28.5; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
		blocks.add(new Block(32*30, 988, "air"));
		blocks.add(new Block(32*31, 928, "air"));
		blocks.add(new Block(32*32.5, 928-60, "air"));
		blocks.add(new Block(32*46, 998, "air"));
		blocks.add(new Block(32*53, 958, "air"));
		for(int i=0; i<4; i++){
			blocks.add(new Block(32*56, 910-120*i, "air"));
		}
		for(int i=0; i<4; i++){
			blocks.add(new Block(32*54, 850-120*i, "air"));
		}
		scrolls.add(new Scroll(32*54+8, 470, 48, 48, "01", "1",true));
		
		for (int i = 39; i < 47; i++) {
			blocks.add(new Block(32*i, 730, "floor"));
		}
		blocks.add(new Block(30*32, 730, "floor"));
		blocks.add(new Block(20*32, 730, "floor"));
		blocks.add(new Block(10*32, 730, "floor"));
		
		for(int i=0; i<4; i++){
			blocks.add(new Block(32*4, 720-120*i, "air"));
		}
		for(int i=0; i<4; i++){
			blocks.add(new Block(32, 660-120*i, "air"));
		}
		scrolls.add(new Scroll(32*15.5, 500, 48, 48, "01", "1",true));
	}
	
	public void createLevel4(){
		player = new Player(10, 1000);
		for(int i =0; i<80; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
	}
	
	
	
	
	
}
