
public class ShapeSet {
	
	Shape[] shapes = new Shape[100];
	int shaCnt;
	
	public void add(Shape shape) {
		// TODO Auto-generated method stub
		
		
		shapes[shaCnt++] = shape;
	}
	
	String allShapeDraw() {
		return "";
	}
	
}
