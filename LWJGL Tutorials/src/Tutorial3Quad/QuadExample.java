package Tutorial3Quad;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;

public class QuadExample {
	public static void main(String[] args){
		QuadExample quadExample=new QuadExample();
		quadExample.start();
	}
	
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//Initialize OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()){
			//Clear the screen and the depth buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			//Set the color of the quad(R,G,B,A)
			glColor3f(0.5f, 0.5f, 1.0f);
			
			//draw quad
			glBegin(GL_QUADS);
				glVertex2f(100, 100);
				glVertex2f(100+200, 100);
				glVertex2f(100+200, 100+200);
				glVertex2f(100, 100+200);
			glEnd();
			
			Display.update();
		}
		Display.destroy();
	}
}
