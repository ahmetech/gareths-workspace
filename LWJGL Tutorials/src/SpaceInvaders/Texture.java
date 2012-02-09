package SpaceInvaders;

import static org.lwjgl.opengl.GL11.*;

public class Texture {
	private int target;
	private int textureID;
	private int height;
	private int width;
	private int texHeight;
	private int texWidth;
	private float widthRatio;
	private float heightRatio;
	
	
	//Create a new texture
	//@param target The GL target
	//@param textureID The GL texture ID
	public Texture(int paramTarget, int paramID){
		target=paramTarget;
		textureID=paramID;
	}
	
	//Bind the specified GL context to a texture
	public void bind(){
		glBindTexture(target, textureID);
	}
	
	//Set the height of the image
	public void setHeight(int paramHeight){
		height=paramHeight;
		setHeight();
	}
	
	//Set the width of the image
	public void setWidth(int paramWidth){
		width=paramWidth;
		setWidth();
	}
	
	//Get the height of the original image
	public int getImageHeight(){
		return height;
	}
	
	//Get the width of the original image
	public int getImageWidth(){
		return width;
	}
	
	//Get the height of the physical texture
	public float getHeight(){
		return heightRatio;
	}
	
	//Get the width of the physical texture
	public float getWidth(){
		return widthRatio;
	}
	
	//Set the height of the texture
	public void setTextureHeight(int paramHeight){
		texHeight=paramHeight;
	}
	
	//Set the width of the texture
	public void setTextureWidth(int paramWidth){
		texWidth=paramWidth;
	}
	
	//Set the height of the texture. This will update the ratio also.
	private void setHeight(){
		if (texHeight != 0) {
			heightRatio = ((float) height) / texHeight;
		}
	}
	
	//Set the width of the texture. This will update the ratio also.
	private void setWidth(){
		if(texWidth !=0){
			widthRatio=((float)width)/texWidth;
		}
	}
}
