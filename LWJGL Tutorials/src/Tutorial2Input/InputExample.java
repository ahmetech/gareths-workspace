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
		while(Mouse.next()){
			if(Mouse.getEventButtonState()){
				if(Mouse.getEventButton()==0){
					int mouseX=Mouse.getX();
					int mouseY=Mouse.getY();
					System.out.println("Mouse Down @ X: "+mouseX+" Y: "+mouseY);
				}
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			System.out.println("Space Key Is Down");
		}

		while (Keyboard.next()) {
			if(Keyboard.getEventKeyState()){
				if(Keyboard.getEventKey()==Keyboard.KEY_A){
					System.out.println("A Key Pressed");
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_S){
					System.out.println("S Key Pressed");
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_D){
					System.out.println("D Key Pressed");
				}
			} else{
				if(Keyboard.getEventKey()==Keyboard.KEY_A){
					System.out.println("A Key Released");
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_S){
					System.out.println("S Key Released");
				}
				if(Keyboard.getEventKey()==Keyboard.KEY_D){
					System.out.println("D Key Released");
				}
			}
		}
	}

}
