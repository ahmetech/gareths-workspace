package Tutorial4Timing;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class TimerExample {
	
	//Position of quad
	float x=400, y=300;
	//Angle of quad rotation
	float rotation=0;
	
	//time at lastFrame
	long lastFrame;
	
	//frames per second
	long fps;
	//last fps time
	long lastFPS;
	
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		initGL();
		getDelta();//call once before loop to initialize lastFrame
		lastFPS=getTime();//call before loop to initialize fps timer
		
		while(!Display.isCloseRequested()){
			int delta=getDelta();
			update(delta);
			renderGL();
			
			Display.update();
			Display.sync(60);//cap fps to 60fps
		}
		Display.destroy();
	}
	
	public void update(int delta){
		//rotate quad
		rotation+=0.1f * delta;
		
		while(Keyboard.next()){
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) x-=0.1f*delta;
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))x+=0.1f*delta;
			if(Keyboard.isKeyDown(Keyboard.KEY_UP))y+=0.1f*delta;
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))y-=0.1f*delta;
		}
		
		//keep quad on screen
		if(x<0)x=0;
		if(x>800)x=800;
		if(y<0)y=0;
		if(y>600)y=600;
		
		updateFPS();//update FPS counter
	}
	
	/**
	Calculate how many milliseconds have passed
	since last frame.
	@return milliseconds passed since last frame
	*/
	public int getDelta(){
		long time=getTime();
		int delta=(int) (time-lastFrame);
		lastFrame=delta;
		
		return delta;
	}
	
	/**
	Get the accurate system time
	@return The system time in milliseconds
	*/
	public long getTime(){
		return (Sys.getTime()*1000)/Sys.getTimerResolution();
	}
	
	/**
	Calculate the FPS and set it in the title bar
	*/
	public void updateFPS(){
		if(getTime()-lastFPS>1000){
			Display.setTitle("FPS: "+fps);
			fps=0;
			lastFPS+=1000;
		}
		fps++;
	}
	
	public void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void renderGL(){
		//Clear the screen and the depth double buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		//R,G,B,A Set the color to Blue one time only
		glColor3f(0.5f, 0.5f, 1.0f);
		
		//draw quad
		glPushMatrix();
			glTranslatef(x, y, 0);
			glRotatef(rotation, 0f, 0f, 1f);
			glTranslatef(-x, -y, 0);
			glBegin(GL_QUADS);
				glVertex2f(x - 50, y - 50);
				glVertex2f(x + 50, y - 50);
				glVertex2f(x + 50, y + 50);
				glVertex2f(x - 50, y + 50);
			glEnd();
		glPopMatrix();	
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		TimerExample timerExample=new TimerExample();
		timerExample.start();
	}
	
	
}
