
public class Triangle extends Shape{
	
	Point p1, p2, p3 = new Point();
	
	Triangle() {}
	Triangle(String color, Point p1,Point p2, Point p3){
		super(color);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public Triangle(String color, int p1, int p2, int p3, int p4, int p5, int p6) {
		// TODO Auto-generated constructor stub
		super(color);
		this.p1.x=p1;
		this.p1.y=p2;
		this.p2.x=p3;
		this.p2.y=p4;
		this.p3.x=p5;
		this.p3.y=p6;
	}
	
	@Override
	public String shape(){
		return "삼각형";
	}

}
