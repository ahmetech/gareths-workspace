package Game;


public interface Entity {
	
	public void draw();
	
	//see episode 7 http://www.youtube.com/watch?v=-LwBWysU-FY&feature=related
	public void update(int delta);
	
	public void setLocation(double x, double y);
	
	public void setRotation(double r);
	public void setX(double x);
	public void setY(double y);
	public void setWidth(double width);
	public void setHeight(double height);
	public double getRotation();
	public double getX();
	public double getY();
	public double getHeight();
	public double getWidth();
	
	public boolean intersects(Entity other);

}
