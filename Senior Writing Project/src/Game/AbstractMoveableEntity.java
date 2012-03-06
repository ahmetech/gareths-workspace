package Game;


public abstract class AbstractMoveableEntity extends AbstractEntity implements MoveableEntity{
	protected double dx, dy;
	
	protected boolean rotating=false;
	
	
	public boolean isRotating() {
		return rotating;
	}
	public void setRotating(boolean rotating) {
		this.rotating = rotating;
	}
	
	
	
	public AbstractMoveableEntity(double x, double y, double width,
			double height) {
		super(x, y, width, height);
		this.dx=0;
		this.dy=0;
	}
	public AbstractMoveableEntity(double x, double y, double width,
			double height, double rotation) {
		super(x, y, width, height, rotation);
		this.dx=0;
		this.dy=0;
	}
	
	@Override
	public void update(int delta){
		if(rotating)rotation += 0.15f * delta;
		if(rotation>360)rotation=0;
		
		this.x+=delta*dx;
		this.y+=delta*dy;
	}
	
	public double getDX(){
		return dx;
	}
	public double getDY(){
		return dy;
	}
	public void setDX(double dx){
		this.dx=dx;
	}
	public void setDY(double dy){
		this.dy=dy;
	}
}
