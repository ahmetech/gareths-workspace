package Tutorial5Fullscreen;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class FullscreenExample {
	//position of quad
	float x=400, y=300;
	//angle of quad rotation
	float rotation=0;

	//time at last frame
	long lastFrame;

	//current FPS
	int FPS;
	//last FPS time
	long lastFPS;

	boolean vsync;

	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		initGL();//init OpenGL
		getDelta();//call once before loop to initialize lastFrame
		lastFPS=getTime();//call before loop to initialize FPS timer

		while (!Display.isCloseRequested()) {
			int delta=getDelta();

			update(delta);
			renderGL();

			Display.update();
			Display.sync(60);//cap FPS to 60
		}
		Display.destroy();
	}

	public int update(int delta){
		rotation+=0.15f*delta;

		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) y+=0.35f*delta;
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))y-=0.35f*delta;

		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))x-=0.35f*delta;
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))x+=0.35f*delta;

		while (Keyboard.next()) {
			if(Keyboard.getEventKeyState()){
				if(Keyboard.getEventKey()==Keyboard.KEY_K){
					setDisplayMode(800, 600, !Display.isFullscreen());
				}
				else if(Keyboard.getEventKey()==Keyboard.KEY_V){
					vsync=!vsync;
					Display.setVSyncEnabled(vsync);
				}
			}

		}

		//keep quad on screen
		if(x<0)x=0;
		if(x>800)x=800;
		if(y<0)y=0;
		if(y>600)y=600;

		updateFPS();
	}

	public void setDisplayMode(int height, int width, boolean fullScreen){
		// return if requested DisplayMode is already set
		if ((Display.getDisplayMode().getWidth() == width) &&(Display.getDisplayMode().getHeight() == height) &&(Display.isFullscreen() == fullScreen)) {
			return;
		}
		try {
			DisplayMode targetDisplayMode=null;

			if(fullScreen){
				DisplayMode[] modes=Display.getAvailableDisplayModes();
				int freq=0;

				for (int i = 0; i < modes.length; i++) {
					DisplayMode current=modes[i];

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
			}
			else{
				targetDisplayMode=new DisplayMode(width, height);
			}
			
			if(targetDisplayMode==null){
				System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullScreen);
				return;
			}
			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullScreen);
		} catch (LWJGLException e) {
			System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullScreen + e);
		}
	}
	
	public int getDelta(){
		long time=getTime();
		int delta=(int) (time-lastFrame);
		lastFrame=time;
		
		return delta;
	}
}
