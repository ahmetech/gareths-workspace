package Tutorial2Input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class InputExample {
	public static void main(String[] argv){
		InputExample inputExample=new InputExample();
		inputExample.start();
	}
	
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(400, 400));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// init OpenGL here
		
		while(!Display.isCloseRequested()){
			
			//render OpenGL here
			
			pollInput();
			Display.update();
		}
		Display.destroy();
	}
	
	public void pollInput(){
		if(Mouse.isButtonDown(0)){
			int mouseX=Mouse.getX();
			int mouseY=Mouse.getY();
			System.out.println("Mouse Down @ X: "+mouseX+" Y: "+mouseY);
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			System.out.println("Space Key Is Down");
		}
		
		while (Keyboard.next()) {
			
		}
	}
	
}
