package SlickLibraryEx1;




import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
public class TextureExample {
	private Texture texture;
	private Texture shotTexture;
	
	public void start(){
		initGL(800, 600);
		init();
		
		while(true){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			render();
			
			Display.update();
			Display.sync(60);
			
			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}
		
	}
	
	private void initGL(int paramWidth, int paramHeight){
		try {
			Display.setDisplayMode(new DisplayMode(paramWidth, paramHeight));
			Display.create();
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		GL11.glEnable(GL11.GL_TEXTURE_2D);               
        
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
        
        // enable alpha blending
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        GL11.glViewport(0,0,paramWidth,paramHeight);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, paramWidth, paramHeight, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void init(){
		try {
			texture=TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/youwin.gif"));
			shotTexture=TextureLoader.getTexture("GIF", ResourceLoader.getResourceAsStream("res/shot.gif"));
			
			System.out.println("Texture loaded: "+texture);
			System.out.println("Texture loaded: "+shotTexture);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void render(){
		Color.white.bind();
		texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(100,100);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(100+texture.getTextureWidth(),100);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(100+texture.getTextureWidth(),100+texture.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(100,100+texture.getTextureHeight());
		GL11.glEnd();
		
		
		Color.white.bind();
		shotTexture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(300,0);
			GL11.glVertex2f(400,100);
			GL11.glTexCoord2f(301,0);
			GL11.glVertex2f(400+shotTexture.getTextureWidth(),100);
			GL11.glTexCoord2f(301,1);
			GL11.glVertex2f(400+shotTexture.getTextureWidth(),100+shotTexture.getTextureHeight());
			GL11.glTexCoord2f(300,1);
			GL11.glVertex2f(400,100+shotTexture.getTextureHeight());
		GL11.glEnd();
	}
	
	public static void main(String[] args){
		TextureExample example=new TextureExample();
		example.start();
	}
}
