
public class Circle extends Shape {

	Point center = new Point();
	int radius;

	Circle() {
	}

	public Circle(String color, int center1, int center2, int radius) {
		// TODO Auto-generated constructor stub
		super(color);
		this.center.x = center1;
		this.center.y = center2;
		this.radius = radius;
	}

	public Circle(String color, Point point, int radius) {
		// TODO Auto-generated constructor stub
		super(color);
		this.center = point;
		this.radius = radius;
	}
	
	@Override
	public String shape(){
		return "원";
	}
	@Override
	public String allShapeDraw() {
		return shape()+ ", 색 : "+ color + "중심점(" + center.getX()+ "," + center.getY() +"반지름(" + radius + ")";
	}

}
