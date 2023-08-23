
public class Rectangle extends Shape {

	Point startPos = new Point();
	int width;
	int height;

	Rectangle() {
	}

	

	public Rectangle(String color, int startPosX, int startPosY, int width, int height) {
		// TODO Auto-generated constructor stub
		super(color);
		this.startPos.x=startPosX;
		this.startPos.y=startPosY;
		this.width = width;
		this.height = height;
	}
	
	Rectangle(String color, Point startPos, int width, int height) {
		super(color);
		this.startPos = startPos;
		this.width = width;
		this.height = height;
	}

	@Override
	public String shape(){
		return "사각형";
	}


}
