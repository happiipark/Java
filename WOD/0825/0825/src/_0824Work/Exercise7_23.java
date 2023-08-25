package _0824Work;

abstract class Shape {
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Circle extends Shape {
	double r;

	Circle() {
	}
	
	Circle(double r) {
		this.r = r;
	}

	Circle(Point p, double r) {
		super(p);
		this.r = r;
	}

	@Override
	double calcArea() {
		return Math.PI * r * r; // final 변수는 대문자
		// 두 단어 이상의 조합으로 생성한 final 변수는 MAX_NUMBER
	}
}

class Rectangle extends Shape {
	int width;
	int height;

	public Rectangle() {
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point p, int width, int height) {
		super(p);
		this.width = width;
		this.height = height;
	}

	public boolean isSquare() {
		return width == height;
	}

	@Override
	double calcArea() {
		return width * height;
	}

}

public class Exercise7_23 {
	/*
	 * (1) sumArea메서드를 작성하시오.
	 */
	
	public static double sumArea(Shape[] shape) {
		double sum = 0;
		for(int i = 0; i <shape.length; i++) {
			sum += shape[i].calcArea();
		}
		return sum;
	}
	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
		System.out.println("면적의 합:" + sumArea(arr));
	}
}
