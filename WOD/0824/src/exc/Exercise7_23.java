package exc;

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

class Circle extends Shape {
	double r; // 반지름

	Circle() {}

	Circle(double r) {
		this.r = r;
	}

	double calcArea() {
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape {
	int width;
	int height;

	Rectangle() {
	}

	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	double calcArea() {
		return width * height;
	}

	boolean isSquare(int width, int height) {
		boolean res = false;
		if (width == height) {
			res = true;
		}
		return res;
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

class Exercise7_23 {
	/*
	 * (1) sumArea메서드를 작성하시오.
	 */
	static double sumArea(Shape[] arr) {
		double res = 0;
		for(int i = 0; i < arr.length; i++) {
			res += arr[i].calcArea();
		}
		return res;
	}

	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Rectangle(3, 4), new Circle(1) };
		System.out.println("면적의 합:" + sumArea(arr));
	}
}
