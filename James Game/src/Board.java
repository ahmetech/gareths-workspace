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
		
		player = new Player(10, 1000);
		createLevel1();
		//createLevel2();
		//createLevel3();
		
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
			
			for(int i = 0; i < blocks.size(); i++){
				blocks.get(i).draw();
			}
			for (int i = 0; i < scrolls.size(); i++) {
				scrolls.get(i).draw();
			}
	
	}
	
	
	public void createLevel1(){
		for(int i =0; i<6; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
		blocks.add(new Block(32*6.25, 988, "air"));
		blocks.add(new Block(32*7.25, 988, "air"));
		blocks.add(new Block(32*4, 928, "air"));
		blocks.add(new Block(32*3.5, 928, "air"));
		blocks.add(new Block(32, 888, "air"));
		scrolls.add(new Scroll(40, 868, 48, 48, "01", "1",true));
		
		blocks.add(new Block(32*11.5, 998, "air"));
		blocks.add(new Block(32*12.5, 998, "air"));
		for(double i =16; i<24.5; i++){
			blocks.add(new Block(i*32,1048, "floor"));
		}
	}
	
	public void createLevel2(){
		
	}
	
	public void createLevel3(){
		
	}
	
	public void createLevel4(){
		
	}
	
	
	
	
	
}
